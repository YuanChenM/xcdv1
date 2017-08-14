package com.msk.batch.so.logic;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.Date;

import com.msk.core.entity.BaseEntity;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.HttpUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.batch.so.bean.BSO152401Param;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoSalesRanking;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;

/**
 * BSO152401Logic
 * 销售排行
 * @author zhang_xi
 * @version 2.0
 **/
@Service
public class BSO152401Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152401Logic.class);

    /**
     *  Map 中KEY TYPE定义
     *
     * @author zhang_xi
     */
    public interface KeyType {
        //供应商代码+物流区编码+产品编码
        static final int KEY_SUPP_LGC_PD = 0;
        //供应商代码+物流区编码
        static final int KEY_SUPP_LGC = 1;
        //产品编码+销售通道+物流区
        static final int KEY_PD_ORDERLEVEL_LGC = 2;
        //供应商代码+物流区编码+产品编码+銷售通道
        static final int KEY_SUPP_LGC_PD_ORDERLEVEL = 3;
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhang_xi
     */
    public interface SqlId {
        static final String SQLID_COUNT_FREQUENCY = "countFrequency";
        static final String SQLID_UPDATE_FREQUENCY = "updateFrequency";
        static final String SQLID_SEL_NEWSELLER = "selectNewSeller";
        static final String SQLID_SEL_OLDSELLER = "selectOldSeller";
        static final String SQLID_SEL_HAVESTOCKSL = "selectHaveStockSl";
        static final String SQLID_SAVE_COPYRANING = "saveCopyRaning";
        static final String SQLID_SELECT_SUPPNAME = "selectSuppName";

    }

    /**
     * (non-Javadoc)
     *
     * @see com.msk.core.base.BaseLogic#setBaseDao(com.msk.core.base.BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 销售排行作成
     *
     * @param param param
     * @return int
     */
    @Transactional
    public int saveSalesRanking(BaseParam param) {
        logger.debug("销售排行作成");
        int ret = 0;
        Date currentDate = DateTimeUtil.getCustomerDate();
        BSO152401Param bso152401Param = (BSO152401Param) param;

        //本次价盘周期开始，结束时间
        param.setFilter("cycleStart", bso152401Param.getPriceCycle().getStartDateStr());
        param.setFilter("cycleEnd", bso152401Param.getPriceCycle().getEndDateStr());
        //上一价盘周期开始，结束时间
        param.setFilter("preCycleStart", bso152401Param.getPrePriceCycle().getStartDateStr());
        param.setFilter("preCycleEnd", bso152401Param.getPrePriceCycle().getEndDateStr());
        //取得本次排行的所有数据，保存到排行表中
        //0.获取库存大于0的全部卖家
        List<SoSalesRanking> allSeller = super.findList(SqlId.SQLID_SEL_HAVESTOCKSL, param);
        //1.新卖家用户
        List<SoSalesRanking> newSellerL = super.findList(SqlId.SQLID_SEL_NEWSELLER, param);
        Map<String, SoSalesRanking> newSellMap = list2Map(newSellerL,KeyType.KEY_SUPP_LGC_PD);
        //2.获取有销售额的旧卖家用户
        List<SoSalesRanking> oldSellerL = super.findList(SqlId.SQLID_SEL_OLDSELLER, param);
        Map<String, List<SoSalesRanking>> oldSellMap = list2MapL(oldSellerL, KeyType.KEY_SUPP_LGC_PD);
        Map<String, SoSalesRanking> oldSellByOrderLeverMap = list2Map(oldSellerL, KeyType.KEY_SUPP_LGC_PD_ORDERLEVEL);
        //3.百酷接口 获取本次价盘周期中标卖家
        //List<SoSalesRanking> okSellerL = analysisJsonData();
        //Map<String, SoSalesRanking> okSellByOrderLeverMap = list2Map(okSellerL, KeyType.KEY_SUPP_LGC_PD_ORDERLEVEL);
        Map<String, List<SoSalesRanking>> okSellMap = null;
                //list2MapL(okSellerL, KeyType.KEY_SUPP_LGC_PD);

        Map<String, List<SoSalesRanking>> pdOrderLeverMap = new HashMap<String, List<SoSalesRanking>>();

        //匹配销售金额等信息
        for (SoSalesRanking sell : allSeller) {
            //新卖家以外用
            String key = getKey(sell, KeyType.KEY_SUPP_LGC_PD);
            ArrayList<SoSalesRanking> addSellList = new ArrayList<SoSalesRanking>();

            sell.setPriceCycle(bso152401Param.getPriceCycle().getCycleCode());
            //是否新卖家
                    if (newSellMap.containsKey(key)) {
                        //有库存的新卖家，肯定是本次中标卖家。否则就会没有库存
                        for(SoSalesRanking data : okSellMap.get(key)){
                                SoSalesRanking subRank = new SoSalesRanking();
                                subRank = copySoSalesRanking(sell);
                                subRank.setDistQua(data.getDistQua());
                                subRank.setOrderLevel(data.getOrderLevel());
                                //金额设成：-1
                                subRank.setSalesAmount(BigDecimal.ONE.negate());
                                addSellList.add(subRank);
                        }

                    } /*else if (okSellMap.containsKey(key)) {
                        //是否中标卖家
                        for(SoSalesRanking data : okSellMap.get(key)){
                            SoSalesRanking subRank = new SoSalesRanking();
                            subRank = copySoSalesRanking(sell);
                            subRank.setDistQua(data.getDistQua());
                            subRank.setOrderLevel(data.getOrderLevel());
                            //TODO :是否老卖家？是的话把原销售金额设定进去，不是的话销售金额为0
                            String keyLever = key + "|" + data.getOrderLevel();
                            if (oldSellByOrderLeverMap.containsKey(keyLever)) {
                                sell.setSalesAmount(oldSellByOrderLeverMap.get(keyLever).getSalesAmount());
                            } else {
                                sell.setSalesAmount(BigDecimal.ZERO);
                            }
                            addSellList.add(subRank);
                        }

                    }*/ else if(oldSellMap.containsKey(key)) {
                        //是否老卖家
                        for(SoSalesRanking data : oldSellMap.get(key)){
                            SoSalesRanking subRank = new SoSalesRanking();
                            subRank = copySoSalesRanking(sell);
                            subRank.setDistQua(data.getDistQua());
                            subRank.setOrderLevel(data.getOrderLevel());
                            //金额设成：-1
                            subRank.setSalesAmount(data.getSalesAmount());
                            addSellList.add(subRank);
                        }
                    } else {
                        SoSalesRanking subRank = new SoSalesRanking();
                        subRank = copySoSalesRanking(sell);
                        addSellList.add(subRank);
                    }
            //设置系统参数
            modifyEntity(addSellList);
            //按PD，OrderLever分批排序
            splitList(pdOrderLeverMap, addSellList);
        }

        //将销售排行表中的数据 拷贝到销售排行历史表中
        param.setCrtTime(DateTimeUtil.getCustomerDate());
        super.save(SqlId.SQLID_SAVE_COPYRANING, param);
        //清除销售排行表中的所有
        super.remove(param);

        //供应商名称
        /*List<SoSalesRanking> nameList = new ArrayList<SoSalesRanking>();
        nameList=super.findList(SqlId.SQLID_SELECT_SUPPNAME, null);*/

        //销售排行
        for(String sortKey : pdOrderLeverMap.keySet()) {
            List<SoSalesRanking> rankingList = pdOrderLeverMap.get(sortKey);

            //排序
            Collections.sort(rankingList, new MyComparator());

            //设置销售排行
            int salesRanking = 1;
            for (SoSalesRanking ranking : rankingList){
                ranking.setSalesRanking(salesRanking);
                /*for (SoSalesRanking name : nameList){
                    if(ranking.getSuppCode().equals(name.getSuppCode())){
                        ranking.setSuppName(name.getSuppName());
                    }
                }*/
                salesRanking++;
            }
            //批量插入销售排行表
            insertRanking(rankingList);
        }
        return ret;
    }

    /**
     * SoSalesRank copy
     * @param fmSeller
     * @return
     */
    private SoSalesRanking copySoSalesRanking1(SoSalesRanking fmSeller) {
        SoSalesRanking ret = new SoSalesRanking();
        ret.setDistQua(fmSeller.getDistQua());
        Method[] methods = SoSalesRanking.class.getMethods();
        for(Method m : methods){
           // m.getName()
        }
        return ret;
    }

    /**
     * SoSalesRank copy
     * @param fmSeller
     * @return
     */
    private SoSalesRanking copySoSalesRanking(SoSalesRanking fmSeller) {
        SoSalesRanking ret = new SoSalesRanking();
        ret.setDistQua(fmSeller.getDistQua());
        ret.setSuppCode(fmSeller.getSuppCode());
        ret.setPdCode(fmSeller.getPdCode());
        ret.setOrderLevel(fmSeller.getOrderLevel());
        ret.setLgcsCode(fmSeller.getLgcsCode());
        ret.setPriceCycle(fmSeller.getPriceCycle());
        ret.setSalesAmount(fmSeller.getSalesAmount());
        ret.setSalesRanking(fmSeller.getSalesRanking());
        ret.setSuppName(fmSeller.getSuppName());
        ret.setWheelFrequency(fmSeller.getWheelFrequency());
        ret.setDelFlg(fmSeller.getDelFlg());
        ret.setVer(fmSeller.getVer());
        ret.setActId(fmSeller.getActId());
        ret.setCrtId(fmSeller.getCrtId());
        ret.setUpdId(fmSeller.getUpdId());
        ret.setActTime(fmSeller.getActTime());
        ret.setCrtTime(fmSeller.getCrtTime());
        ret.setUpdTime(fmSeller.getUpdTime());

        return ret;
    }

    /**
     * 调用百酷接口，并解析返回的结果
     * @return 中标卖家信息
     */
    private List<SoSalesRanking> analysisJsonData() {
        List<SoSalesRanking> rankList = new ArrayList<>();
        JSONObject json = HttpUtils.post(ConfigManager.getDistributeUrl(), null);
        String status = json.getString("status");
        if ( "S".equals(status)) {
            //查询供应商分销数量 成功
            JSONArray result = json.getJSONArray("result");
            for (int i = 0; i < result.length(); i++) {
                JSONObject bean1 = (JSONObject) result.get(i);
                String areaCode = bean1.getString("areaCode");
                JSONArray supList = bean1.getJSONArray("supList");
                for (int j = 0; j < supList.length(); j++) {
                    JSONObject bean2 = (JSONObject) supList.get(j);
                    String supCode = bean2.getString("supCode");
                    JSONArray productList = bean2.getJSONArray("productList");
                    for (int k = 0; k < productList.length(); k++) {
                        JSONObject bean3 = (JSONObject) productList.get(k);
                        String productCode = bean3.getString("productCode");
                        JSONArray wayList = bean3.getJSONArray("wayList");
                        for (int m = 0; m < wayList.length(); m++) {
                            JSONObject bean4 = (JSONObject) wayList.get(m);
                            Integer wayType = bean4.getInt("wayType");
                            SoSalesRanking rank = new SoSalesRanking();
                            //OrderLevel 等于 分销通道
                            rank.setOrderLevel(wayType);
                            //分销通道
                            rank.setDistQua(wayType);
                            //物流区
                            rank.setLgcsCode(areaCode);
                            //供应商
                            rank.setSuppCode(supCode);
                            //产品Code
                            rank.setPdCode(productCode);
                            rankList.add(rank);
                        }
                    }
                }
            }
        } else {
            //TODO: exception
        }
        return rankList;
    }

    /**
     * 销售排行表（批量插入）
     * @param rankingList
     */
    private void insertRanking(List<SoSalesRanking> rankingList){
        int insert_max = 100;
        //一次只能插入100条数据
        if(rankingList != null && rankingList.size()>0){
            List<SoSalesRanking> insertList =  new ArrayList<SoSalesRanking>();
            int length= rankingList.size();
            int start = 0;
            int end = length > insert_max ? insert_max : length;
            while(start < length){
                insertList = rankingList.subList(start,end);
                super.batchSave(insertList);
                start = end;
                end = length > (end + insert_max) ? (end + insert_max) : length;
            }
        }
    }
    /**
     * 按产品以及订单Lever分List
     * @param pdOrderLeverMap
     * @param sellList
     */
    private void splitList(Map<String, List<SoSalesRanking>> pdOrderLeverMap, List<SoSalesRanking> sellList) {
        //
        for(SoSalesRanking sell: sellList) {
            String key = getKey(sell, KeyType.KEY_PD_ORDERLEVEL_LGC);
            if (pdOrderLeverMap.containsKey(key)) {
                pdOrderLeverMap.get(key).add(sell);
            } else {
                List<SoSalesRanking> l = new ArrayList<SoSalesRanking>();
                l.add(sell);
                pdOrderLeverMap.put(key, l);
            }
        }
    }

    //排序
    class MyComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            SoSalesRanking s1 = (SoSalesRanking) o1;
            SoSalesRanking s2 = (SoSalesRanking) o2;
            int ret = 0;
            if(s2.getSalesAmount() == null){
                s2.setSalesAmount(BigDecimal.ZERO);
            }

            if(s1.getSalesAmount() == null){
                s1.setSalesAmount(BigDecimal.ZERO);
            }

            if(s1.getSalesAmount().compareTo(BigDecimal.ZERO) < 0) {
                if(s1.getSalesAmount().compareTo(BigDecimal.ZERO) < 0) {
                    if(s2.getCrtTime() == null && s1.getCrtTime() == null){
                        ret = 0;
                    } else if (s1.getCrtTime() == null) {
                        ret = 1;
                    } else if (s2.getCrtTime() == null) {
                        ret = -1;
                    } else {
                        ret = s1.getCrtTime().compareTo(s2.getCrtTime());
                    }
                } else {
                    ret = -1;
                }
            }else {
                if(s2.getSalesAmount().compareTo(BigDecimal.ZERO) < 0){
                    ret = 1;
                } else {
                    ret = s2.getSalesAmount().compareTo(s1.getSalesAmount());
                }
            }
            return ret;
        }
    }

    /**
     * List to Map
     * @param sellList sellList
     * @return sellMap
     */
    private Map<String, SoSalesRanking> list2Map(List<SoSalesRanking> sellList, int keyType) {
        Map<String, SoSalesRanking> sellMap = new HashMap<String, SoSalesRanking>();

        if(sellList != null || sellList.size() > 0){
            for(SoSalesRanking sell : sellList){
                String key = getKey(sell, keyType);
                sellMap.put(key, sell);
            }
        }
        return sellMap;
    }

    /**
     * List to Map
     * @param sellList sellList
     * @return sellMap
     */
    private Map<String, List<SoSalesRanking>> list2MapL(List<SoSalesRanking> sellList, int keyType) {
        Map<String,  List<SoSalesRanking>> sellMap = new HashMap<String,  List<SoSalesRanking>>();

        if(sellList != null || sellList.size() > 0){
            for(SoSalesRanking sell : sellList){
                String key = getKey(sell, keyType);
                if(sellMap.containsKey(key)) {
                    sellMap.get(key).add(sell);
                }else {
                    List<SoSalesRanking> sellL = new ArrayList<>();
                    sellL.add(sell);
                    sellMap.put(key, sellL);
                }
            }
        }
        return sellMap;
    }

    /**
     * 返回KEY：供应商代码|物流区编码|产品代码
     * @param sell
     * @return 返回KEY：供应商代码|物流区编码|产品代码
     */
    private String getKey(SoSalesRanking sell, int keyType) {
        String ret = "";
        if(sell != null){
            if(keyType == KeyType.KEY_SUPP_LGC_PD) {
                //供应商代码+物流区编码+产品编码
                ret = sell.getSuppCode() + "|" + sell.getLgcsCode() + "|"
                        + sell.getPdCode();
            } else if (keyType == KeyType.KEY_SUPP_LGC) {
                //供应商代码+物流区编码
                ret = sell.getSuppCode() + "|" + sell.getLgcsCode();
            } else if (keyType == KeyType.KEY_PD_ORDERLEVEL_LGC) {
                //产品编码+销售通道+物流区
                ret = sell.getPdCode() + "|" + sell.getOrderLevel() + "|" + sell.getLgcsCode();
            } else if (keyType == KeyType.KEY_SUPP_LGC_PD_ORDERLEVEL) {
                //供应商代码+物流区编码+产品编码+销售通道
                ret = sell.getSuppCode() + "|" + sell.getLgcsCode() + "|"
                        + sell.getPdCode()+ "|" + sell.getOrderLevel();
            }
        }

        return ret;
    }

    /**
     * modifyEntity
     */
    private void modifyEntity(List<SoSalesRanking> salesRankingList) {
        for(SoSalesRanking salesRanking:salesRankingList) {
            salesRanking.setDelFlg("0");
            salesRanking.setCrtId("admin");
            salesRanking.setCrtTime(DateTimeUtil.getCustomerDate());
            salesRanking.setUpdId("admin");
            salesRanking.setUpdTime(DateTimeUtil.getCustomerDate());
            salesRanking.setActId("admin");
            salesRanking.setActTime(DateTimeUtil.getCustomerDate());
            salesRanking.setWheelFrequency(0);
            salesRanking.setVer(1);
        }
    }

    /**
     * createEntity
     *
     * @param param param
     * @return SoSalesRanking
     */
//    private SoSalesRanking createEntity(BSO152401Param param) {
//        SoSalesRanking salesRanking = new SoSalesRanking();
//        salesRanking.setPriceCycle(param.getPriceCycle().getCycleCode());
//        salesRanking.setDelFlg("0");
//        salesRanking.setCrtId("admin");
//        salesRanking.setCrtTime(DateTimeUtil.getCustomerDate());
//        salesRanking.setUpdId("admin");
//        salesRanking.setUpdTime(DateTimeUtil.getCustomerDate());
//        salesRanking.setActId("admin");
//        salesRanking.setActTime(DateTimeUtil.getCustomerDate());
//        salesRanking.setVer(1);
//        salesRanking.setPriceCycle(PriceCycleUtils.getPriceCycle(new java.util.Date(),10).getCycleCode());
//        return salesRanking;
//    }

    /**
     * 获取当前排行
     *
     * @param param BaseParam
     * @return 当前排行
     */
    @Transactional
    public List<SoSalesRanking> getSalesRanking(BaseParam param) {
        // 判断是否排行中所有供应商都已全部分销结束
        int count = super.getCount(SqlId.SQLID_COUNT_FREQUENCY, param);
        if (count == NumberConst.IntDef.INT_ZERO) {
            // 若全部分销完则初始化排行榜
            SoSalesRanking ranking = new SoSalesRanking();
            ranking.setLgcsCode(param.getFilterMap().get("lgcsCode").toString());
            ranking.setOrderLevel(StringUtil.toInteger(param.getFilterMap().get("orderLevel")));
            ranking.setPdCode(param.getFilterMap().get("pdCode").toString());
            ranking.setWheelFrequency(0);
            ranking.setUpdId("admin");
            ranking.setUpdTime(DateTimeUtil.getCustomerDate());
            super.modify(SqlId.SQLID_UPDATE_FREQUENCY, ranking);
        }

        // 获得当前排行
        return super.findList(param);
    }

    /**
     * 更新排行的分单次数
     *
     * @param entity SoSalesRanking
     * @return 更新结果
     */
    @Transactional
    public int updateOne(SoSalesRanking entity) {
        logger.debug("更新排行的分单次数");
        entity.setUpdTime(DateTimeUtil.getCustomerDate());
        return super.modify(SqlId.SQLID_UPDATE_FREQUENCY, entity);
    }
}
