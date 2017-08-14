package com.msk.bs.logic;

import com.msk.bs.bean.IBS2101102RsParam;
import com.msk.bs.bean.IBS2101102RsResult;
import com.msk.bs.bean.IBS2101103RsParam;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsPageParam;
import com.msk.core.bean.RsPageResult;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.consts.CodeMasterConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cx on 2016/2/26.
 */
@Service
public class IBS2101102RsLogic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private BS2101101Logic bS2101101Logic;

    interface SqlId {
        /**
         * 更新买手店资质信息
         */
        static final String SQL_ID_MODIFY_OF_SL_BUYERSHOP = "modifyOfSlBuyerShop";
        /**
         * 更新卖家基本信息
         */
        static final String SQL_ID_MODIFY_OF_UPDATE = "modifyOfUpdate";
        /**
         * 更新店铺基本信息
         */
        static final String SQL_ID_MODIFY_OF_SL_SHOP_INFO = "modifyOfSlShopInfo";
        /**
         * 删除账户信息
         */
        static final String SQL_ID_MODIFY_OF_DELFLG = "modifyOfDelFlg";
        /**
         * 删除卖家基本信息
         */
        static final String SQL_ID_MODIFY_OF_DELFLG_AND_SLSELLER = "modifyOfDelFlgAndSlSeller";
        /**
         * 删除卖家基本信息
         */
        static final String SQL_ID_MODIFY_OF_DELFLG_SL_SHOP_INFO = "modifyOfDelFlgAndSlBuyerShop";
        /**
         * 删除店铺基本信息
         */
        static final String SQL_ID_MODIFY_OF_DELFLG_AND_SL_BUYERSHOP = "modifyOfDelFlgDlShopInfo";

        /**
         * 保存卖家基本信息
         */
        static final String SQL_ID_SAVE_SL_BUYERSHOP = "saveSlBuyershop";
        /**
         * 保存卖家基本信息
         */
        static final String SQL_ID_SAVE_SLSELLER = "saveSlSeller";

        /**
         * 保存店铺基本信息
         */
        static final String SQL_ID_SAVE_SL_SHOP_INFO = "saveSlShopInfo";

        /**
         * 查询卖家基本信息
         */
        static final String SQL_ID_FIND_SL_SELLER = "findSlSeller";

        /**
         * 查询卖家基本信息是否存在
         */
        static final String SQL_ID_FIND_SL_SELLER_YES_OR_NO = "findSlSellerYesOrNo";

        /**
         * 查询店铺基本信息
         */
        static final String SQL_ID_FIND_SL_SHOP_INFO = "findSlShopInfo";
        /**
         * 查询买手店资质信息
         */
        static final String SQL_ID_FIND_SL_BUYERSHOP = "findSlBuyershop";
        /**
         * 查询买手账户是否存在
         */
        static final String SQL_ID_FIND_SL_ACCOUNT_YESORNO = "findSlAccountYesOrNO";
        /**
         * 查询买手账户是否存在
         */
        static final String SQL_ID_FIND_SL_ACCOUNT = "findSlAccount";
        /**
         * 查询卖家基本信息是否存在
         */
        static final String SQL_ID_FIND_SL_SELLER_YESORNO = "findSlSellerYesOrNo";
        /**
         * 查询买手店资质信息是否存在
         */
        static final String SQL_ID_FIND_SL_BUYERSHOP_YESORNO = "findSlBuyerShopYesOrNo";
        /**
         * 查询店铺基本信息是否存在
         */
        static final String SQL_ID_FIND_SL_SHOP_INFO_YESORNO = "findSlShopInfoYesOrNo";
        /**
         * 查询买手账户
         */
        static final String SQL_ID_FIND_SL_ACCOUNT_ALL = "findSlAccountAll";

        static final String SQL_ID_FIND_ACCOUNT_LIST = "findAccountList";

        static final String SQL_ID_FIND_SL_CODE_DIS_MAX = "findSlCodeDisMax";
    }

    /**
     * 编辑买手账户
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = false)
    public IBS2101102RsResult editAccount(RsRequest<IBS2101102RsParam> param) {
        IBS2101102RsResult rs = new IBS2101102RsResult();
        IBS2101102RsParam iBS2101102RsParam = param.getParam();
        //买手id
        String slCode = "";
        //获取id
        String loginId = param.getLoginId();
        //获取删除标志
        String delFlg = iBS2101102RsParam.getDelFlg();
        //获取版本好
        Integer ver = iBS2101102RsParam.getVer();
        //获取卖家账户
        SlAccount slAccount = iBS2101102RsParam.getSlAccount();
        //卖家基本信息
        SlSeller slSeller = iBS2101102RsParam.getSlSeller();

        //买手店资质信息
        SlBuyershop slBuyershop = iBS2101102RsParam.getSlBuyerShop();

        //店铺基本信息
        SlShopInfo slShopInfo = iBS2101102RsParam.getSlShopInfo();

        BaseParam baseParam = new BaseParam();
        //认证状态为空默认给他1:认证中
        if (null != slAccount) {
            if (null == slAccount.getAuthStatus() || "".equals(slAccount.getAuthStatus())) {
                slAccount.setAuthStatus(1);
            }
            slAccount.setCrtId(loginId);
            // baseParam.setFilter("delFlg", StringUtil.toSafeString(delFlg));
            //判断是否为删除操作
            if ("1".equals(delFlg)) {
                //删除账户信息(更新删除标志为“1”)
                int result = super.modify(SqlId.SQL_ID_MODIFY_OF_DELFLG, slAccount);
                if (result < 1) {
                    throw new BusinessException("买手账户删除失败，请检查参数是否正确！");
                }
            } else {
                //查询账户是否存在
                baseParam.setFilter("slAccount", StringUtil.toSafeString(slAccount.getSlAccount()));
                int num0 = super.getCount(SqlId.SQL_ID_FIND_SL_ACCOUNT_YESORNO, baseParam);
                //判断账户是否存在  如果不存在 执行保存操作
                if (num0 <= 0) {
                    //保存账户信息
                    int result = super.save(slAccount);
                    if (result < 1) {
                        throw new BusinessException("买手账户保存失败，请检查参数是否正确！");
                    }
                } else {
                    //更新账户信息
                    int result = super.modify(slAccount);
                    if (result < 1) {
                        throw new BusinessException("买手账户修改失败，请检查参数是否正确！");
                    }
                }
            }
        }
        if (null != slSeller) {
            if ("1".equals(delFlg)) {
                //删除账户信息(更新删除标志为“1”)
                int result = super.modify(SqlId.SQL_ID_MODIFY_OF_DELFLG_AND_SLSELLER, slSeller);
                if (result < 1) {
                    throw new BusinessException("买手基本信息删除失败，请检查参数是否正确！");
                }
            } else {
                slSeller.setCrtId(loginId);
                //查询是否有对应的账户
                baseParam.setFilter("slAccount", slSeller.getSlAccount());
                int num2 = super.getCount(SqlId.SQL_ID_FIND_SL_ACCOUNT_YESORNO, baseParam);
                if (num2 <= 0) {
                    throw new BusinessException("您保存的卖家没有对应的账户信息");
                }
                //查询账户基本信息是否存在
                if (slSeller.getSlCode() != null && !"".equals(slSeller.getSlCode())) {
                    baseParam.setFilter("slCode", slSeller.getSlCode());
                    int num3 = super.getCount(SqlId.SQL_ID_FIND_SL_SELLER_YESORNO, baseParam);
                    if (num3 <= 0) {
                        throw new BusinessException("您要修改的买手基本信息slCode:" + slSeller.getSlCode() + "不存在，请检查后提交！");
                    } else {
                        //更新卖家基本信息
                        slCode = slSeller.getSlCode();
                        int result = super.modify(SqlId.SQL_ID_MODIFY_OF_UPDATE, slSeller);
                        if (result < 1) {
                            throw new BusinessException("买手基本信息修改失败，请检查参数是否正确！");
                        }
                    }
                } else {
                    baseParam.setFilter("slMainClass", slSeller.getSlMainClass().toString());
                    baseParam.setFilter("cityCode", slSeller.getCityCode());
                    if (this.getCount(SqlId.SQL_ID_FIND_SL_SELLER_YES_OR_NO, baseParam) > 0) {
                        throw new BusinessException("买手账户已经存在基本信息，不能重复注册");
                    }
                    //保存卖家基本信息
                    //设置SlCode
                    slCode =StringUtil.toSafeString(commonLogic.maxId("sl_seller", "CONVERT(SL_CODE,SIGNED)"));
                    slSeller.setSlCode(slCode);
                    //设置slCodeDis
                    int num_1 = super.getCount(SqlId.SQL_ID_FIND_ACCOUNT_LIST, baseParam);
                    if (num_1 <= 0) {
                        String numbuder = "0001";
                        String slCodeDis = "4" + slSeller.getMemo6() + slSeller.getCityCode() + numbuder;
                        slSeller.setSlCodeDis(slCodeDis);
                    } else {
                        SlSeller slSeller1 = super.findOne(SqlId.SQL_ID_FIND_SL_CODE_DIS_MAX, baseParam);
                        slSeller.setSlCodeDis(slSeller1.getSlCodeDis());
                    }
                    slSeller.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ZERO));
                    slSeller.setCrtId(loginId);
                    slSeller.setVer(NumberConst.IntDef.INT_ONE);
                    int result = super.save(SqlId.SQL_ID_SAVE_SLSELLER, slSeller);
                    if (result < 1) {
                        throw new BusinessException("买手基本信息保存失败，请检查参数是否正确！");
                    }
                }
            }

        }
        if (null != slBuyershop) {
            if ("1".equals(delFlg)) {
                //删除账户信息(更新删除标志为“1”)
                int result = super.modify(SqlId.SQL_ID_MODIFY_OF_DELFLG_AND_SL_BUYERSHOP, slBuyershop);
                if (result < 1) {
                    throw new BusinessException("买手店铺资质信息删除失败，请检查参数是否正确！");
                }
            } else {
                if (slBuyershop.getSlCode() != null && !"".equals(slBuyershop.getSlCode())) {
                    //查询买手店资质信息是否存在 如果SlCode没有传 slSeller必须不为空，--
                    baseParam.setFilter("slCode", slBuyershop.getSlCode());
                    int num4 = super.getCount(SqlId.SQL_ID_FIND_SL_BUYERSHOP_YESORNO, baseParam);
                    if (num4 <= 0) {
                        throw new BusinessException("您要修改的买手店铺资质信息slCode:" + slBuyershop.getSlCode() + "不存在，请检查后提交！");
                    } else {
                        //更新买手店资质信息
                        int result = super.modify(SqlId.SQL_ID_MODIFY_OF_SL_BUYERSHOP, slBuyershop);
                        if (result < 1) {
                            throw new BusinessException("买手店铺资质信息修改失败，请检查参数是否正确！");
                        }
                    }
                } else {
                    if (slCode == "") {
                        throw new BusinessException("买手基本信息id不能为空！");
                    }
                    //保存买手店资质信息
                    slBuyershop.setSlCode(slCode);
                    int result = super.save(SqlId.SQL_ID_SAVE_SL_BUYERSHOP, slBuyershop);
                    if (result < 1) {
                        throw new BusinessException("买手店铺资质信息新增失败，请检查参数是否正确！");
                    }
                }
            }
        }
        if (null != slShopInfo) {
            if ("1".equals(delFlg)) {
                //删除账户信息(更新删除标志为“1”)
                int result = super.modify(SqlId.SQL_ID_MODIFY_OF_DELFLG_SL_SHOP_INFO, slShopInfo);
                if (result < 1) {
                    throw new BusinessException("买手店铺信息删除失败，请检查参数是否正确！");
                }
            } else {
                if (slShopInfo.getShopId() != null && !"".equals(slShopInfo.getShopId())) {
                    baseParam.getFilterMap().put("shopId", slShopInfo.getShopId());
                    int num5 = super.getCount(SqlId.SQL_ID_FIND_SL_SHOP_INFO_YESORNO, baseParam);
                    if (num5 <= 0) {
                        throw new BusinessException("您要修改的买手店铺信息shopId:" + slShopInfo.getShopId() + "不存在，请检查后提交！");
                    } else {
                        //更新店铺基本信息
                        int result = super.modify(SqlId.SQL_ID_MODIFY_OF_SL_SHOP_INFO, slShopInfo);
                        if (result < 1) {
                            throw new BusinessException("买手店铺信息修改失败，请检查参数是否正确！");
                        }
                    }
                } else {
                    if (slShopInfo.getSlCode() == null || "".equals(slShopInfo.getSlCode())) {
                        if (slCode == "") {
                            throw new BusinessException("买手基本信息id不能为空！");
                        }
                        slShopInfo.setSlCode(slCode);
                    }
                    baseParam.getFilterMap().put("slCode", slShopInfo.getSlCode());
                    //验证店铺信息是否存在
                    int num5 = super.getCount(SqlId.SQL_ID_FIND_SL_SHOP_INFO_YESORNO, baseParam);
                    if(num5>0){
                        throw new BusinessException("买手id为"+slShopInfo.getSlCode()+"的买手店铺信息已经存在，不能重复新增！");
                    }
                    //保存店铺基本信息
                    slShopInfo.setShopId(this.commonLogic.maxId("sl_shop_info", "SHOP_ID"));
                    int result = super.save(SqlId.SQL_ID_SAVE_SL_SHOP_INFO, slShopInfo);
                    if (result < 1) {
                        throw new BusinessException("买手店铺信息新增失败，请检查参数是否正确！");
                    }
                }
            }
        }
               /* //保存卖家基本信息
                if(null != slSeller){
                    slSeller.setSlAccount(slAccount.getSlAccount());
                    super.save(SqlId.SQL_ID_SAVE_SLSELLER, slSeller);
                }else {
                    throw new BusinessException("请输入卖家基本信息");
                }
                if(null != slBuyershop){
                    //保存买手店资质信息
                    super.save(SqlId.SQL_ID_SAVE_SL_BUYERSHOP, slBuyershop);
                }else {
                    throw new BusinessException("请输入买手店资质信息");
                }
                //保存店铺基本信息
                    super.save(SqlId.SQL_ID_SAVE_SL_SHOP_INFO, slShopInfo);
                //更新操作
            } else {
                //更新账户信息
                super.modify(slAccount);
                //更新卖家基本信息
                super.modify(SqlId.SQL_ID_MODIFY_OF_UPDATE, slSeller);
                //更新买手店资质信息
                super.modify(SqlId.SQL_ID_MODIFY_OF_SL_BUYERSHOP, slBuyershop);
                //更新店铺基本信息
                super.modify(SqlId.SQL_ID_MODIFY_OF_SL_SHOP_INFO, slShopInfo);
            }
        } else {
            throw new BusinessException("请输入卖家账户");
        }*/


        /*//查询保存的数据是否存在
        int s0 = super.getCount(SqlId.SQL_ID_FIND_SL_SELLER_YES_OR_NO, baseParam);
        if (s0 > 0) {
            throw new BusinessException("您保存的卖家基本信息数据已存在,请确认slAccount或slCode");
        }
        //保存卖家基本信息
        int s2 = super.save(SqlId.SQL_ID_SAVE_SLSELLER, iBS2101102RsParam);
        //保存买手店资质信息
        int s3 = super.save(SqlId.SQL_ID_SAVE_SL_BUYERSHOP, iBS2101102RsParam);
        //保存店铺基本信息
        int s4 = super.save(SqlId.SQL_ID_SAVE_SL_SHOP_INFO, iBS2101102RsParam);
           *//* if (s1 == 0 || s2 == 0 || s3 == 0 || s4 == 0) {
                throw new BusinessException("保存操作失败");
            }*//*
        //如果存在  执行更新或者删除操作
    }

    else

    {
        //删除操作 逻辑删除
        if (delFlg.equals("1")) {
            //删除账户信息(更新删除标志为“1”)
            int s4 = super.modify(SqlId.SQL_ID_MODIFY_OF_DELFLG, iBS2101102RsParam);
            //删除卖家基本信息
            int s5 = super.modify(SqlId.SQL_ID_MODIFY_OF_DELFLG_AND_SLSELLER, iBS2101102RsParam);
            //删除买手店资质信息
            int s6 = super.modify(SqlId.SQL_ID_MODIFY_OF_DELFLG_AND_SL_BUYERSHOP, iBS2101102RsParam);
            //删除店铺基本信息
            int s6_1 = super.modify(SqlId.SQL_ID_MODIFY_OF_DELFLG_SL_SHOP_INFO, iBS2101102RsParam);

               *//* if (s4 == 0 || s5 == 0 || s6 == 0 || s6_1 == 0) {
                    throw new BusinessException("删除操作失败");
                }*//*
            //更新操作
        } else {
            //更新账户信息
            int s7 = super.modify(iBS2101102RsParam);
            //更新卖家基本信息
            int s8 = super.modify(SqlId.SQL_ID_MODIFY_OF_UPDATE, iBS2101102RsParam);
            //更新买手店资质信息
            int s9 = super.modify(SqlId.SQL_ID_MODIFY_OF_SL_BUYERSHOP, iBS2101102RsParam);
            //更新店铺基本信息
            int s9_1 = super.modify(SqlId.SQL_ID_MODIFY_OF_SL_SHOP_INFO, iBS2101102RsParam);
                *//*if (s7 == 0 || s8 == 0 || s9 == 0 || s9_1 == 0) {
                    throw new BusinessException("更新操作失败");
                }*//*
        }
    }*/

        return rs;
    }

    @Override
    public <T extends BaseEntity> List<T> findPageList(RsPageParam param, RsPageResult pageResult) {
        IBS2101103RsParam IBS2101103RsParam = (IBS2101103RsParam) param;
        if (param.getPageCount() == 0 || param.getPageNo() == 0) {
            param.setPaging(false);
        } else {
            param.setPaging(true);
        }
        param.setFilter("slAccount", IBS2101103RsParam.getSlAccount());
        param.setFilter("accountPsd", IBS2101103RsParam.getAccountPsd());
        param.setFilter("slCode", IBS2101103RsParam.getSlCode());
        return this.bS2101101Logic.findPageList(param, pageResult);
    }
}