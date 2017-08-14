package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.PdClassestree;
import com.msk.core.entity.PdClassestreeMat;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * PD141101Logic
 *
 * @author pxg
 */
@Service
public class SL24112801Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author pxg
     */
    interface SqlId {
        String SQL_ID_FIND_FIND_CLASS_DATA = "findClassData";
        String SQL_ID_FIND_FIND_THREE_CODE_DATA = "findThreeCodeData";
        String SQL_ID_FIND_FIND_DATA = "findData";
        String SQL_ID_FIND_FIND_MARKET = "findMarket";
        String SQL_ID_FIND_QUERY_PROVIDER = "queryProvider";
        String SQL_ID_FIND_QUERT_ONLINE = "queryOnLine";
        String SQL_ID_FIND_QUERY_PROVIDER_CONTENT = "queryProviderContent";
        String SQL_ID_FIND_QUERY_ONLINE_OEM = "queryOnlineOem";
        String SQL_ID_FIND_LEVEN4_LIST= "findListLevel4List";
        String SQL_ID_FIND_LEVEN5_LIST= "findListLevel5List";
        String SQL_ID_FIND_LEVEN6_LIST= "findListLevel6List";
        String SQL_ID_FIND_QUERY_PDTCFORBID = "queryTcForBid";
        String SQL_ID_FIND_QUERY_SLPRODUTC = "querySlProduct";
        String SQL_ID_FIND_QUERY_REGION = "queryRegion";
    }


    /**
     * 获取原料描述信息
     *
     * @return
     */
    public PdClassestreeMat queryClassData(String classCode) {
        BaseParam param = new BaseParam();
        param.setFilter("classCode", classCode);
        param.setFilter("delFlg", "0");
        PdClassestreeMat pdClassestreeMat = super.findOne(SqlId.SQL_ID_FIND_FIND_CLASS_DATA, param);
        return pdClassestreeMat;
    }

    /**
     * 选择二级分类获取三级分类Code
     *
     * @return
     */
    public List<PdClassestree> queryThreeCodeData(String classCodeTwo) {
        BaseParam param = new BaseParam();
        param.setFilter("classCode", classCodeTwo);
        param.setFilter("treeLevel", "3");
        param.setFilter("delFlg", "0");
        List<PdClassestree> list = super.findList(SqlId.SQL_ID_FIND_FIND_THREE_CODE_DATA, param);
        return list;
    }

    /**
     * 选择二级分类获取产品总控目录数据
     *
     * @return
     */
    public List<SL24112801Param> queryTwoData(String classCodeTwo) {
        List<SL24112801Param> listMat = new ArrayList<>();
        List<SL241128Param> listMarket = new ArrayList<>();
        List<PdTcProviderPackageParam> listProvider = new ArrayList<>();
        List<PdTcOnlineParam> listOnline = new ArrayList<>();
        List<PdTcProviderContentParam> listProviderContent = new ArrayList<>();
        List<PdTcOnlineOemParam> pdTcOnlineOems = new ArrayList<>();
        List<PdClassestree> list = this.queryThreeCodeData(classCodeTwo);
        List<String> listDataSalesTargetRemove = new ArrayList<>();
        List<String> listDataMachiningWayRemove = new ArrayList<>();
        List<SL24112801Bean> level4BeanList=new ArrayList<>();
        List<PdTcForbidParam> pdTcForbidParamArrayList = new ArrayList<>();
        List<SL24112801Bean> sl24112801List=new ArrayList<>();
        SL24112801Param sl24112801Param=null;
        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                PdClassestree pdClassestree = list.get(i);
                BaseParam param = new BaseParam();
                param.setFilter("classestreeCode", pdClassestree.getClassestreeCode());
                param.setFilter("delFlg", "0");
                sl24112801Param = super.findOne(SqlId.SQL_ID_FIND_FIND_DATA, param);
                if (null != sl24112801Param) {
                    listMarket = this.queryMarketData(pdClassestree.getClassestreeCode());
                    if (!CollectionUtils.isEmpty(listMarket)) {
                        sl24112801Param.setPdTcMarketList(listMarket);
                    }
                    listProvider = this.queryProviderData(pdClassestree.getClassestreeCode());
                    if (!CollectionUtils.isEmpty(listProvider)) {
                        sl24112801Param.setPdTcProvider(listProvider);
                    }
                    listOnline = this.queryOnLineData(pdClassestree.getClassestreeCode(), null);
                    if (!CollectionUtils.isEmpty(listOnline)) {
                        sl24112801Param.setPdTcOnline(listOnline);
                    }
                    listProviderContent = this.queryProviderContent(pdClassestree.getClassestreeCode(), null);
                    if (!CollectionUtils.isEmpty(listProviderContent)) {
                        for (int a = 0; a < listProviderContent.size(); a++) {
                            PdTcProviderContentParam pdTcProviderContentParam = listProviderContent.get(a);
                            listDataSalesTargetRemove.add(pdTcProviderContentParam.getSalesTarget());
                            listDataMachiningWayRemove.add(pdTcProviderContentParam.getMachiningWay());
                        }
                        StringBuffer setSalesTarget = new StringBuffer();
                        StringBuffer setMachiningWay = new StringBuffer();
                        listDataSalesTargetRemove = new ArrayList<>(new HashSet(listDataSalesTargetRemove));
                        listDataMachiningWayRemove=new ArrayList<>(new HashSet(listDataMachiningWayRemove));
                        for (int j = 0; j < listDataSalesTargetRemove.size(); j++) {
                            String SalesTarget = listDataSalesTargetRemove.get(j);
                            if(j+1==listDataSalesTargetRemove.size()){
                                setSalesTarget.append(SalesTarget);
                            }else{
                                setSalesTarget.append(SalesTarget + ",");
                            }
                        }
                        for (int j = 0; j < listDataMachiningWayRemove.size(); j++) {
                            String machiningWay = listDataMachiningWayRemove.get(j);
                            if(j+1==listDataMachiningWayRemove.size()){
                                setMachiningWay.append(machiningWay);
                            }else{
                                setMachiningWay.append(machiningWay + ",");
                            }
                        }
                        sl24112801Param.setPdTcProviderContents(listProviderContent);
                        sl24112801Param.setSalesTargetTwo(StringUtil.toSafeString(setSalesTarget));
                        sl24112801Param.setMachiningWayTwo(StringUtil.toSafeString(setMachiningWay));
                    }
                    pdTcOnlineOems = this.queryOnlineOem(pdClassestree.getClassestreeCode(), null);
                    if (!CollectionUtils.isEmpty(pdTcOnlineOems)) {
                        sl24112801Param.setPdTcOnlineOem(pdTcOnlineOems);
                    }
                    level4BeanList=this.queryClassInfo(pdClassestree.getClassestreeCode());
                    if(!CollectionUtils.isEmpty(level4BeanList)){
                        sl24112801Param.setPd141124Level4Beans(level4BeanList);
                    }
                    pdTcForbidParamArrayList=this.queryTcForbid(pdClassestree.getClassestreeCode());
                    if(!CollectionUtils.isEmpty(pdTcForbidParamArrayList)){
                        sl24112801Param.setPdTcForbidParams(pdTcForbidParamArrayList);
                    }
                }
                listMat.add(sl24112801Param);
            }
            sl24112801List=this.querySlProduct(classCodeTwo);
            if(!CollectionUtils.isEmpty(sl24112801List)){
                sl24112801Param.setSl24112801Beans(sl24112801List);
            }
        }
        return listMat;
    }

    /**
     * 选择三级分类获取产品总控目录数据
     *
     * @return
     */
    public List<SL24112801Param> queryThreeData(String classCodeThree) {
        BaseParam param = new BaseParam();
        List<SL24112801Param> listMat = new ArrayList<>();
        List<SL241128Param> listMarket = new ArrayList<>();
        List<PdTcProviderPackageParam> listProvider = new ArrayList<>();
        List<PdTcOnlineParam> listOnline = new ArrayList<>();
        List<PdTcProviderContentParam> listProviderContent = new ArrayList<>();
        SL24112801Param sl24112801Param = new SL24112801Param();
        List<PdTcOnlineOemParam> pdTcOnlineOems = new ArrayList<>();
        List<SL24112801Bean> level4BeanList=new ArrayList<>();
        List<String> listDataSalesTargetRemove = new ArrayList<>();
        List<String> listDataMachiningWayRemove = new ArrayList<>();
        List<PdTcForbidParam> pdTcForbidParamArrayList = new ArrayList<>();
        List<SL24112801Bean> sl24112801List=new ArrayList<>();
        param.setFilter("classestreeCode", classCodeThree);
        param.setFilter("delFlg", "0");
        sl24112801Param = super.findOne(SqlId.SQL_ID_FIND_FIND_DATA, param);
        if (null != sl24112801Param) {
            listMarket = this.queryMarketData(classCodeThree);
            if (!CollectionUtils.isEmpty(listMarket)) {
                sl24112801Param.setPdTcMarketList(listMarket);
            }
            listProvider = this.queryProviderData(classCodeThree);
            if (!CollectionUtils.isEmpty(listProvider)) {
                sl24112801Param.setPdTcProvider(listProvider);
            }
            listOnline = this.queryOnLineData(classCodeThree, null);
            if (!CollectionUtils.isEmpty(listOnline)) {
                sl24112801Param.setPdTcOnline(listOnline);
            }
            listProviderContent = this.queryProviderContent(classCodeThree, null);
            if (!CollectionUtils.isEmpty(listProviderContent)) {
                for (int a = 0; a < listProviderContent.size(); a++) {
                    PdTcProviderContentParam pdTcProviderContentParam = listProviderContent.get(a);
                    listDataSalesTargetRemove.add(pdTcProviderContentParam.getSalesTarget());
                    listDataMachiningWayRemove.add(pdTcProviderContentParam.getMachiningWay());
                }
                StringBuffer setSalesTarget = new StringBuffer();
                StringBuffer setMachiningWay = new StringBuffer();
                listDataSalesTargetRemove = new ArrayList<>(new HashSet(listDataSalesTargetRemove));
                listDataMachiningWayRemove=new ArrayList<>(new HashSet(listDataMachiningWayRemove));
                for (int j = 0; j < listDataSalesTargetRemove.size(); j++) {
                    String SalesTarget = listDataSalesTargetRemove.get(j);
                    if(j+1==listDataSalesTargetRemove.size()){
                        setSalesTarget.append(SalesTarget);
                    }else{
                        setSalesTarget.append(SalesTarget + ",");
                    }
                }
                for (int j = 0; j < listDataMachiningWayRemove.size(); j++) {
                    String machiningWay = listDataMachiningWayRemove.get(j);
                    if(j+1==listDataMachiningWayRemove.size()){
                        setMachiningWay.append(machiningWay);
                    }else{
                        setMachiningWay.append(machiningWay + ",");
                    }
                }
                sl24112801Param.setSalesTargetTwo(StringUtil.toSafeString(setSalesTarget));
                sl24112801Param.setMachiningWayTwo(StringUtil.toSafeString(setMachiningWay));
                sl24112801Param.setPdTcProviderContents(listProviderContent);
            }
            pdTcOnlineOems = this.queryOnlineOem(classCodeThree, null);
            if (!CollectionUtils.isEmpty(pdTcOnlineOems)) {
                sl24112801Param.setPdTcOnlineOem(pdTcOnlineOems);
            }
            level4BeanList=this.queryClassInfo(classCodeThree);
            if(!CollectionUtils.isEmpty(level4BeanList)){
                sl24112801Param.setPd141124Level4Beans(level4BeanList);
            }
            pdTcForbidParamArrayList=this.queryTcForbid(classCodeThree);
            if(!CollectionUtils.isEmpty(pdTcForbidParamArrayList)){
                sl24112801Param.setPdTcForbidParams(pdTcForbidParamArrayList);
            }
            sl24112801List=this.querySlProduct(classCodeThree);
            if(!CollectionUtils.isEmpty(sl24112801List)){
                sl24112801Param.setSl24112801Beans(sl24112801List);
            }
        }
        listMat.add(sl24112801Param);
        return listMat;
    }

    /**
     * 获取分类编码获取市场需求编码注册
     *
     * @return
     */
    public List<SL241128Param> queryMarketData(String classCodeTwo) {
        BaseParam param = new BaseParam();
        String classesCode =classCodeTwo.substring(0, 2);
        String machiningCode=classCodeTwo.substring(2, 3);
        String breedCode=classCodeTwo.substring(3, 5);;
        param.setFilter("classesCode", classesCode);
        param.setFilter("machiningCode", machiningCode);
        param.setFilter("breedCode", breedCode);
        /*String code = null;
        if (classCodeTwo.length() == 5) {
            code = classCodeTwo.substring(3, 5);
            param.setFilter("breedCode", code);
        } else {
            code = classCodeTwo.substring(2, 3);
            param.setFilter("machiningCode", code);
        }*/
        param.setFilter("delFlg", "0");
        List<SL241128Param> listMat = super.findList(SqlId.SQL_ID_FIND_FIND_MARKET, param);
        /*for (int i = 0; i < listMat.size(); i++) {
            SL241128Param sl241128Param = listMat.get(i);
            sl241128Param.setGetDivId(getDivId);
            listMatNew.add(sl241128Param);
        }*/
        return listMat;
    }





    /**
     * @param classCode classCode
     *                  查询卖家供应备案注册
     * @return
     */
    public List<PdTcProviderPackageParam> queryProviderData(String classCode) {
        BaseParam param = new BaseParam();
        String classesCode =classCode.substring(0, 2);
        String machiningCode=classCode.substring(2, 3);
        String breedCode=classCode.substring(3, 5);;
        param.setFilter("classesCode", classesCode);
        param.setFilter("machiningCode", machiningCode);
        param.setFilter("breedCode", breedCode);
       /* if (classCode.length() == 5) {
            code = classCode.substring(3, 5);
            param.setFilter("breedCode", code);
        } else {
            code = classCode.substring(2, 3);
            param.setFilter("machiningCode", code);
        }*/
        param.setFilter("delFlg", "0");
        List<PdTcProviderPackageParam> list = super.findList(SqlId.SQL_ID_FIND_QUERY_PROVIDER, param);
        return list;
    }





    /**
     * 查询正式上线数据
     *
     * @param classestreeCode classestreeCode
     * @return
     */
    public List<PdTcOnlineParam> queryOnLineData(String classestreeCode, String getDivId) {
        BaseParam param = new BaseParam();
        String classesCode =classestreeCode.substring(0, 2);
        String machiningCode=classestreeCode.substring(2, 3);
        String breedCode=classestreeCode.substring(3, 5);;
        param.setFilter("classesCode", classesCode);
        param.setFilter("machiningCode", machiningCode);
        param.setFilter("breedCode", breedCode);
        /*String code = null;
        if (classestreeCode.length() == 5) {
            code = classestreeCode.substring(3, 5);
            param.setFilter("breedCode", code);
        } else {
            code = classestreeCode.substring(2, 3);
            param.setFilter("machiningCode", code);
        }*/
        param.setFilter("delFlg", "0");
        List<PdTcOnlineParam> list = new ArrayList<>();
        List<PdTcOnlineParam> listOnLine = super.findList(SqlId.SQL_ID_FIND_QUERT_ONLINE, param);
        /*if (!CollectionUtils.isEmpty(listOnLine)) {
            for (int i = 0; i < listOnLine.size(); i++) {
                PdTcOnlineParam pdTcOnlineParam = listOnLine.get(i);
                pdTcOnlineParam.setGetDivId(getDivId);
                list.add(pdTcOnlineParam);
            }
        }*/
        return listOnLine;
    }


    /**
     * 查询卖家供应备案注册标准目录
     *
     * @param classestreeCode classestreeCode
     * @return
     */
    public List<PdTcProviderContentParam> queryProviderContent(String classestreeCode, String getDivId) {
        BaseParam param = new BaseParam();
        String classesCode =classestreeCode.substring(0, 2);
        String machiningCode=classestreeCode.substring(2, 3);
        String breedCode=classestreeCode.substring(3, 5);;
        param.setFilter("classesCode", classesCode);
        param.setFilter("machiningCode", machiningCode);
        param.setFilter("breedCode", breedCode);
        /*String code = null;
        if (classestreeCode.length() == 5) {
            code = classestreeCode.substring(3, 5);
            param.setFilter("breedCode", code);
        } else {
            code = classestreeCode.substring(2, 3);
            param.setFilter("machiningCode", code);
        }*/
/*        param.setFilter("breedCode", code);
        param.setFilter("machiningCode", code);*/
        param.setFilter("delFlg", "0");
        List<PdTcProviderContentParam> list = new ArrayList<>();
        List<PdTcProviderContentParam> listOnLine = super.findList(SqlId.SQL_ID_FIND_QUERY_PROVIDER_CONTENT, param);
        /*if (!CollectionUtils.isEmpty(listOnLine)) {
            for (int i = 0; i < listOnLine.size(); i++) {
                PdTcProviderContentParam pdTcProviderContent = listOnLine.get(i);
                pdTcProviderContent.setGetDivId(getDivId);
                list.add(pdTcProviderContent);
            }
        }*/
        return listOnLine;
    }


    /**
     * 查询OEM上线产品
     *
     * @param classestreeCode classestreeCode
     * @return
     */
    public List<PdTcOnlineOemParam> queryOnlineOem(String classestreeCode, String getDivId) {
        BaseParam param = new BaseParam();
        String classesCode =classestreeCode.substring(0, 2);
        String machiningCode=classestreeCode.substring(2, 3);
        String breedCode=classestreeCode.substring(3, 5);;
        param.setFilter("classesCode", classesCode);
        param.setFilter("machiningCode", machiningCode);
        param.setFilter("breedCode", breedCode);
       /* String code = null;
        if (classestreeCode.length() == 5) {
            code = classestreeCode.substring(3, 5);
            param.setFilter("breedCode", code);
        } else {
            code = classestreeCode.substring(2, 3);
            param.setFilter("machiningCode", code);
        }*/
        param.setFilter("delFlg", "0");
        List<PdTcOnlineOemParam> list = new ArrayList<>();
        List<PdTcOnlineOemParam> listOnLine = super.findList(SqlId.SQL_ID_FIND_QUERY_ONLINE_OEM, param);
        /*if (!CollectionUtils.isEmpty(listOnLine)) {
            for (int i = 0; i < listOnLine.size(); i++) {
                PdTcOnlineOemParam pdTcOnlineOemParam = listOnLine.get(i);
                pdTcOnlineOemParam.setGetDivId(getDivId);
                list.add(pdTcOnlineOemParam);
            }
        }*/
        return listOnLine;
    }



    /**
     * 查询产品特征净重包装
     *
     * @param classestreeCode classestreeCode
     * @return
     */
    public List<SL24112801Bean> queryClassInfo(String classestreeCode) {
        BaseParam param = new BaseParam();
        param.setFilter("parentCode", classestreeCode);
        param.setFilter("treeLevel","4");
        List<SL24112801Bean> level4BeanList = super.findList(SqlId.SQL_ID_FIND_LEVEN4_LIST, param);
        /*if(!CollectionUtils.isEmpty(level4BeanList)){
            for (PD141124Level4Bean level4Bean :level4BeanList) {
                BaseParam param2=new BaseParam();
                param2.setFilter("parentCode",level4Bean.getClassesTreeCode());
                param.setFilter("treeLevel","5");
                List<PD141124Level5Bean> level5BeanList=super.findList(SqlId.SQL_ID_FIND_LEVEN5_LIST,param2);
                for(PD141124Level5Bean level5Bean :level5BeanList){
                    BaseParam param3=new BaseParam();
                    param3.setFilter("parentCode",level5Bean.getClassesTreeCode());
                    param3.setFilter("treeLevel","6");
                    List<PD141124Level6Bean> level6BeanList=super.findList(SqlId.SQL_ID_FIND_LEVEN6_LIST,param3);
                    level5Bean.setLevel6Beans(level6BeanList);
                }
                level4Bean.setLevel5Beans(level5BeanList);
            }
        }*/
        return level4BeanList;
    }

    /**
     * 查询禁止准入产品
     * @param classestreeCode classestreeCode
     * @return
     */
    public List<PdTcForbidParam> queryTcForbid(String classestreeCode) {
        BaseParam param = new BaseParam();
            String classesCode = classestreeCode.substring(0, 2);
            String machiningCode = classestreeCode.substring(2, 3);
            String breedCode = classestreeCode.substring(3, 5);
            param.setFilter("classesCode", classesCode);
            param.setFilter("machiningCode", machiningCode);
            param.setFilter("breedCode", breedCode);
       /* String code = null;
        if (classestreeCode.length() == 5) {
            code = classestreeCode.substring(3, 5);
            param.setFilter("breedCode", code);
        } else {
            code = classestreeCode.substring(2, 3);
            param.setFilter("machiningCode", code);
        }*/
        param.setFilter("delFlg", "0");
        List<PdTcForbidParam> list = new ArrayList<>();
        List<PdTcForbidParam> listOnLine = super.findList(SqlId.SQL_ID_FIND_QUERY_PDTCFORBID,param);
       /* if (!CollectionUtils.isEmpty(listOnLine)) {
            for (int i = 0; i < listOnLine.size(); i++) {
                PdTcForbidParam pdTcForbidParam = listOnLine.get(i);
                pdTcForbidParam.setGetDivId(getDivId);
                list.add(pdTcForbidParam);
            }
        }*/
        return listOnLine;
    }

    /**
     * 查询省级卖家池卖家目录
     * @param classestreeCode classestreeCode
     * @return
     */
    public List<SL24112801Bean> querySlProduct(String classestreeCode) {
        BaseParam param = new BaseParam();
        if(!StringUtil.isNullOrEmpty(classestreeCode)){
            if (classestreeCode.length() == 5) {
                String classCode=classestreeCode.substring(0, 2);
                String machingCode=classestreeCode.substring(2,3);
                String breedCode = classestreeCode.substring(3, 5);
                param.setFilter("classCode", classCode);
                param.setFilter("machingCode", machingCode);
                param.setFilter("breedCode", breedCode);
            }else{
                String classCode=classestreeCode.substring(0, 2);
                String machingCode=classestreeCode.substring(2,3);
                param.setFilter("classCode", classCode);
                param.setFilter("machingCode", machingCode);
            }
            param.setFilter("status","4");
            param.setFilter("statusTwo","5");
        }
        List<SL24112801Bean> sl24112801List=new ArrayList<>();
        List<SL24112801Bean> sl24112801BeanList = super.findList(SqlId.SQL_ID_FIND_QUERY_SLPRODUTC,param);
        if (!CollectionUtils.isEmpty(sl24112801BeanList)) {
            for (int i = 0; i < sl24112801BeanList.size(); i++) {
                SL24112801Bean sl24112801Bean = sl24112801BeanList.get(i);
                BaseParam paramTwo=new BaseParam();
                paramTwo.setFilter("cityCode",sl24112801Bean.getCityCode());
                paramTwo.setFilter("provinceCode",sl24112801Bean.getProvinceCode());
                SL24112801Bean sl24112801BeanTwo=super.findOne(SqlId.SQL_ID_FIND_QUERY_REGION, paramTwo);
                if(null!=sl24112801BeanTwo){
                    sl24112801Bean.setCityName(sl24112801BeanTwo.getCityName());
                    sl24112801Bean.setProvinceName(sl24112801BeanTwo.getProvinceName());
                }
                sl24112801List.add(sl24112801Bean);
            }
        }
        return sl24112801List;
    }

   /* *//**
     * 查询省级卖家池卖家目录
     * @param pageParam pageParam
     * @return
     *//*
    public PageResult<SL24112801Bean> queryData(BasePageParam pageParam){
        return super.findPage(pageParam, SL24112801Bean.class);
    }
*/
}
