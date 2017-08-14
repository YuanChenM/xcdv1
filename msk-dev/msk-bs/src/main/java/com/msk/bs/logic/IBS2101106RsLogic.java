package com.msk.bs.logic;

import com.msk.bs.bean.IBS2101106Bean;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlHouseAccount;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.consts.BusinessConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/3/1.
 */
@Service
public class IBS2101106RsLogic extends BaseLogic {
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private IBS2101102RsLogic ibs2101102RsLogic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public int editExclusive(IBS2101106Bean iBS2101106Bean) {
        String delFlg = iBS2101106Bean.getDelFlg();
        String buyerFlag = iBS2101106Bean.getBuyerFlag();
        String slCode = iBS2101106Bean.getSlCode();
        String houseAccount = iBS2101106Bean.getHouseAccount();
        String buyerId = iBS2101106Bean.getBuyerId();
        String applyStatus = iBS2101106Bean.getApplyStatus();
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("houseAccount", houseAccount);
        baseParam.setFilter("buyerId", buyerId);
        //1.判断buyerFlag  1:专属买家、2：抢单买家
        if (("1").equals(buyerFlag)) {
            int num3 = ibs2101102RsLogic.getCount(IBS2101102RsLogic.SqlId.SQL_ID_FIND_SL_SELLER_YESORNO, baseParam);
            if (num3 <= 0) {
                throw new BusinessException("买手信息不存在，请检查后提交！");
            }
            //2.查询买家是否存在冻品管家
            List<IBS2101106Bean> beans = super.findList(SqlId.SQL_ID_FIND_BS_BUYER, baseParam);
            //2.1如果不存在  执行保存操作
            if (CollectionUtils.isEmpty(beans) || beans.size() < 1) {
                //查询是否存在删除的记录。没有就添加。有就把删除的记录恢复
                int buyerNum = super.getCount(SqlId.SQL_ID_FIND_BUYER_DEL, baseParam);
                //判断是否传入了开始 和申请时间 如果没有传入设置为当前时间
                Date startTime = iBS2101106Bean.getStartTime();
                Date applyTime = iBS2101106Bean.getApplyTime();
                if (null == startTime) {
                    iBS2101106Bean.setStartTime(new Date());
                }
                if (null == applyTime) {
                    iBS2101106Bean.setApplyTime(iBS2101106Bean.getStartTime());
                }
                //保存操作时结束时间加60天
                iBS2101106Bean.setEndTime(DateTimeUtil.addDay(iBS2101106Bean.getStartTime(), BusinessConst.BSCycle.TIMECYCLE));
                if (buyerNum > 0) {//存在删除记录。恢复并更新数据
                    this.modify(SqlId.SQL_ID_UPDATE_BS_BUYER_DEL,iBS2101106Bean);
                } else {
                    int result = super.save(SqlId.SQL_ID_SAVE_BS_BUYER, iBS2101106Bean);
                    if (result < 1) {
                        throw new BusinessException("编辑买手冻品管家的买家信息保存失败，请检查参数是否正确！");
                    }
                }
            } else {
                //存在，查询冻品管家和买家关系是否存在
                baseParam.setFilter("slCode", slCode);
                baseParam.setFilter("houseCode", iBS2101106Bean.getHouseCode());
                List<IBS2101106Bean> ibs2101106Beans = super.findList(SqlId.SQL_ID_FIND_BS_BUYER, baseParam);
                //不存在，证明关系不存在，参数有问题
                if (CollectionUtils.isEmpty(ibs2101106Beans) || ibs2101106Beans.size() < 1) {
                    throw new BusinessException("当前买家已经绑定过冻品管家，不能重复绑定！");
                } else {
                    IBS2101106Bean bean = ibs2101106Beans.get(0);
                    //如果存在 执行更新或者删除 操作
                    //2.2.1如果delFlg = 1 执行删除 操作
                    if ("1".equals(delFlg)) {
                        //2.2.2判断为冻品管家是否为店主 为店主删除买手店管家专属，新增履历表
                        //2.2.3查询sl_house_account表 获取houseClass
                        SlHouseAccount slHouseAccount = super.findOne(SqlId.SQL_ID_FIND_HOUSE_ACCOUNT, baseParam);
                        //'1：店主，2：店员',
                        String houseClass = slHouseAccount.getHouseClass();
                        //2.2.4判断为店长 增加买手店管家到履历表
                        if ("1".equals(houseClass)) {
                            //2.2.5删除操作 物理删除
                            int result = super.remove(SqlId.SQL_ID_DELETE_BS_BUYER, baseParam);
                            if (result < 1) {
                                throw new BusinessException("编辑买手冻品管家的买家信息删除失败，请检查参数是否正确！");
                            }
                            //2.2.6增加买手店管家买家关系履历  表sl_bs_buyer_his
                            bean.setHisId(commonLogic.maxId("sl_bs_buyer_his", "HIS_ID"));
                            super.save(SqlId.SQL_ID_SAVE_BS_BUYER_HIS1, bean);
                        } else {
                            //2.2.7如果为店员
                            //删除操作 物理删除
                            int result = super.remove(SqlId.SQL_ID_DELETE_BS_BUYER, baseParam);
                            if (result < 1) {
                                throw new BusinessException("编辑买手冻品管家的买家信息删除失败，请检查参数是否正确！");
                            }
                            //2.2.8增加买手店管家买家关系履历  表sl_bs_buyer_his
                            bean.setHisId(commonLogic.maxId("sl_bs_buyer_his", "HIS_ID"));
                            super.save(SqlId.SQL_ID_SAVE_BS_BUYER_HIS1, bean);
                            //2.2.9查询此店员对应的店长  增加会员到店主
                            //List<SlHouseAccount> list = super.findList(SqlId.SQL_ID_FIND_SHOP_MANAGER, baseParam);
                            //if (!CollectionUtils.isEmpty(list) && list.size() > 0) {
                            //    for (int i = 0; i < list.size(); i++) {
                            //        SlHouseAccount slHouseAccount1 = list.get(0);
                            //        String slCode1 = slHouseAccount1.getSlCode();
                            //        String houseAccount1 = slHouseAccount1.getHouseAccount();
                            //        iBS2101106Bean.setSlCode(slCode1);
                            //        iBS2101106Bean.setHouseCode(slHouseAccount1.getHouseCode());
                            //        //增加会员到店主
                            //        super.save(SqlId.SQL_ID_SAVE_BS_BUYER, iBS2101106Bean);
                            //    }
                            //}
                        }
                    } else {
                        //更新操作  1.申请中   2.专属会员
                        if (applyStatus != null && !bean.getApplyStatus().equals(applyStatus)) {
                            //新增履历表
                            bean.setHisId(commonLogic.maxId("sl_bs_buyer_his", "HIS_ID"));
                            super.save(SqlId.SQL_ID_SAVE_BS_BUYER_HIS1, bean);
                            //修改状态更新的时间，及开始和结束日期
                            iBS2101106Bean.setStartTime(new Date());
                            iBS2101106Bean.setApplyTime(iBS2101106Bean.getStartTime());
                            //修改结束时间为当前日期+周期时间
                            iBS2101106Bean.setEndTime(DateTimeUtil.addDay(iBS2101106Bean.getStartTime(), BusinessConst.BSCycle.TIMECYCLE));
                            int result = super.modify(SqlId.SQL_ID_UPDATE_BS_BUYER, iBS2101106Bean);
                            if (result < 1) {
                                throw new BusinessException("编辑买手冻品管家的买家信息更新申请状态失败，请检查参数是否正确！");
                            }
                        }
                    }
                }
            }
        } else {
           /* // 2.3抢单买家
            //2.3.1查询买手店管家抢单会员是否存在
            int num2 = super.getCount(SqlId.SQL_ID_FIND_BS_BUYER_GET, baseParam);
            if (num2 == 0) {
                //2.3.2保存操作
                //保存操作时结束时间加60天
                iBS2101106Bean.setStartTime(DateTimeUtil.addDay(iBS2101106Bean.getEndTime(), 60));
                super.save(SqlId.SQL_ID_SAVE_BS_BUYER_GET, iBS2101106Bean);
            } else {
                //2.3.3如果存在 执行更新或者删除 操作
                //如果delFlg = 1 执行删除 操作
                if ("1".equals(delFlg)) {
                    //2.3.4判断为冻品管家是否为店主 为店主删除买手店管家专属，新增履历表
                    //2.3.5查询sl_house_account表 获取houseClass
                    SlHouseAccount slHouseAccount = super.findOne(SqlId.SQL_ID_FIND_HOUSE_ACCOUNT, baseParam);
                    //'1：店主，2：店员',
                    String houseClass = slHouseAccount.getHouseClass();
                    //2.3.6判断为店长 增加买手店管家到履历表
                    if ("1".equals(houseClass)) {
                        //2.3.6删除操作 物理删除
                        super.remove(SqlId.SQL_ID_DELETE_BS_BUYER_GET, baseParam);
                        //2.3.7增加买手店管家抢单会员履历  表sl_bs_buyer_get_his
                        iBS2101106Bean.setHisId(commonLogic.maxId("sl_bs_buyer_get_his", "HIS_ID"));
                        super.save(SqlId.SQL_ID_SAVE_BS_BUYER_GET_HIS, iBS2101106Bean);
                    } else {
                        //2.2.7如果为店员
                        //删除操作 物理删除
                        super.remove(SqlId.SQL_ID_DELETE_BS_BUYER_GET, baseParam);
                        //2.2.8增加买手店管家买家关系履历  表sl_bs_buyer_his
                        iBS2101106Bean.setHisId(commonLogic.maxId("sl_bs_buyer_get_his", "HIS_ID"));
                        super.save(SqlId.SQL_ID_SAVE_BS_BUYER_GET_HIS, iBS2101106Bean);
                        //2.2.9查询此店员对应的店长  增加会员到店主
                        List<SlHouseAccount> list = super.findList(SqlId.SQL_ID_FIND_SHOP_MANAGER, baseParam);
                        for (int i = 0; i < list.size(); i++) {
                            SlHouseAccount slHouseAccount1 = list.get(0);
                            String slCode1 = slHouseAccount1.getSlCode();
                            String houseAccount1 = slHouseAccount1.getHouseAccount();
                            iBS2101106Bean.setSlCode(slCode1);
                            iBS2101106Bean.setHouseAccount(houseAccount1);
                            //增加会员到店主
                            super.save(SqlId.SQL_ID_SAVE_BS_BUYER_GET, iBS2101106Bean);
                        }
                    }
                } else {
                    //更新买手店抢单会员  操作
                    super.modify(SqlId.SQL_ID_UPDATE_BS_BUYER_GET, iBS2101106Bean);
                }
            }*/
        }
        return 1;
    }

    interface SqlId {
        /**
         * 查询专属会员是否存在
         */
        static final String SQL_ID_FIND_BS_BUYER = "findBsBuyer";
        /**
         * 保存冻品管家专属会员
         */
        static final String SQL_ID_SAVE_BS_BUYER = "saveBsBuyer";
        /**
         * 冻品管家冻品管家账户
         */
        static final String SQL_ID_FIND_HOUSE_ACCOUNT = "findHouseAccount";
        /**
         * 删除冻品管家专属会员
         */
        static final String SQL_ID_DELETE_BS_BUYER = "deleteBsBuyer";
        /**
         * 增加买手店管家买家关系履历sl_bs_buyer_his
         */
        static final String SQL_ID_SAVE_BS_BUYER_HIS = "saveBsBuyerHis";
        /**
         * 增加买手店管家买家关系履历sl_bs_buyer_his  1
         */
        static final String SQL_ID_SAVE_BS_BUYER_HIS1 = "saveBsBuyerHis1";
//        /**
//         * 删除冻品管家专属会员1
//         */
//        static final String SQL_ID_DELETE_BS_BUYER1 = "deleteBsBuyer1";
//
//        /**
//         * 增加买手店管家买家关系履历sl_bs_buyer_his1
//         */
//        static final String SQL_ID_SAVE_BS_BUYER_HIS1= "saveBsBuyerHis1";
        /**
         * 查询此店员对应的店长
         */
        static final String SQL_ID_FIND_SHOP_MANAGER = "findShopManager";
        /**
         * 更新冻品管家专属会员
         */
        static final String SQL_ID_UPDATE_BS_BUYER = "updateBsBuyer";
        /**
         * 根据买家id获取是否存在删除的买家信息
         */
        static final String SQL_ID_FIND_BUYER_DEL = "findBuyerDel";
        static final String SQL_ID_UPDATE_BS_BUYER_DEL = "updateBsBuyerDel";


        /**
         * 查询买手店管家抢单会员是否存在
         */
        static final String SQL_ID_FIND_BS_BUYER_GET = "findBsBuyerGet";
        /**
         * 保存买手店抢单会员
         */
        static final String SQL_ID_SAVE_BS_BUYER_GET = "saveBsBuyerGet";
        /**
         * 买手店抢单会员
         */
        static final String SQL_ID_DELETE_BS_BUYER_GET = "deleteBsBuyerGet";
        /**
         * 增加买手店抢单会员履历sl_bs_buyer_get_his
         */
        static final String SQL_ID_SAVE_BS_BUYER_GET_HIS = "saveBsBuyerGetHis";
        /**
         * 更新买手店抢单会员
         */
        static final String SQL_ID_UPDATE_BS_BUYER_GET = "updateBsBuyerGet";
    }
}

