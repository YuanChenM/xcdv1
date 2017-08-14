package com.msk.by.logic;

import java.util.List;

import com.msk.core.entity.ByMarketFood;
import com.msk.core.entity.ByMarketTerminal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.by.bean.IBY121202RsParam;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.entity.ByBuyerBasicInfo;
import com.msk.core.entity.CommConstant;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.consts.BusinessConst;
import com.msk.md.utils.DistrictAreaUtils;

/**
 * IBY121202Logic.
 *
 * @author zhou_yajun
 */
@Service
public class IBY121202Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121202Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_yajun
     */
    interface SqlId {
        // 买家基本信息更新
        static String SQL_BUYERINFO_MODIFY = "buyerInfoModify";
        static String SQL_BUYER_DETAIL_INFO_FIND = "buyerDetailInfoFind";
        static String SQL_TERMINAL_CONDITION_INFO_FIND = "terminalConditionInfoFind";
        static String SQL_FOOD_CONDITION_INFO_FIND = "foodConditionInfoFind";
        static String SQL_BUYER_CONDITION_INFO_FIND = "buyerConditionInfoFind";
        static String SQL_COUNT_BUYER_BY_TYPE = "countBuyerByType";
        static String SQL_GET_BUYER_BY_ID = "getBuyerById";
        static String SQL_GET_BUYER_BY_MARKET_ID = "getBuyerByMarketId";
        // 批发市场信息更新
        static String SQL_BY_MARKET_TER_MODIFY = "byMarketTerModify";
        // 菜场信息更新
        static String SQL_BY_MARKET_FOOD_MODIFY = "byMarketFoodModify";
    }

    /**
     * (non-Javadoc)
     *
     * @see BaseLogic#setBaseDao(BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private CommonLogic commonLogic;

    /**
     * 买家基本信息更新接口
     *
     * @param param
     * @return
     */
    @Transactional
    public int buyerInfoModify(IBY121202RsParam param) {
        // 更新买家基本信息表
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        param = setBuyerDefaultInfo(param);
        int modifyCount = super.modify(SqlId.SQL_BUYERINFO_MODIFY, param);
        return modifyCount;
    }

    /**
     * 买家基本信息更新接口
     *
     * @param param
     * @return
     */
    @Transactional
    public int buyerInfoModify(ByBuyerBasicInfo param) {
        // 更新买家基本信息表
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        int modifyCount = super.modify(SqlId.SQL_BUYERINFO_MODIFY, param);
        return modifyCount;
    }

    /**
     * 买家基本信息查询接口
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public IBY121202RsParam findBuyerDetailInfo(IBY121202RsParam param) {
        BasePageParam inParam = new BasePageParam();
        inParam.setFilter("buyerId", param.getBuyerId());
        inParam.setPaging(false);
        IBY121202RsParam buyerDetail = super.findOne(SqlId.SQL_BUYER_DETAIL_INFO_FIND, inParam);
        return buyerDetail;
    }

    /**
     * 根据区域编码获取买家
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<IBY121202RsParam> findBuyerList(IBY121202RsParam param) {
        BasePageParam inParam = new BasePageParam();
        inParam.setFilter("provinceCode", param.getProvinceCode());
        inParam.setFilter("lgcsCode", param.getLgcsAreaCode());
        inParam.setFilter("cityCode", param.getCityCode());
        inParam.setFilter("districtCode", param.getDistrictCode());
        int pageNo = param.getPageNo();
        int pageSize = 10;
        int startPos = (pageNo - NumberConst.IntDef.INT_ONE) * pageSize;
        inParam.setPageSize(pageSize);
        inParam.setStartPos(startPos);
        inParam.setPaging(param.getPaging());
        List<IBY121202RsParam> buyerList = super.findList(SqlId.SQL_BUYER_DETAIL_INFO_FIND, inParam);
        return buyerList;
    }

    /**
     * 根据指定条件获取买家
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<IBY121202RsParam> findConditionBuyerList(IBY121202RsParam param) {
        BasePageParam inParam = new BasePageParam();
        if(!StringUtil.isNullOrEmpty(param.getBuyerName())){
            inParam.setFilter("buyerName", param.getBuyerName() + StringConst.PRE);
        }else{
            inParam.setFilter("buyerName", param.getBuyerName());
        }
        inParam.setFilter("lgcsAreaCode", param.getLgcsAreaCode());
        inParam.setFilter("cityCode", param.getCityCode());
        inParam.setFilter("districtCode", param.getDistrictCode());
        List<IBY121202RsParam> buyerList = super.findList(SqlId.SQL_BUYER_CONDITION_INFO_FIND, inParam);
        return buyerList;
    }
    /**
     * 根据指定条件获取批发市场
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<ByMarketTerminal> findConditionMarketTerminalList(ByMarketTerminal param){
        BasePageParam inParam = new BasePageParam();
        inParam.setFilter("terMarketId",param.getTerMarketId());
        if(!StringUtil.isNullOrEmpty(param.getMarketName())){
            inParam.setFilter("marketName", param.getMarketName() + StringConst.PRE);
        }else{
            inParam.setFilter("marketName", param.getMarketName());
        }
        inParam.setFilter("lgcsAreaCode", param.getLgcsAreaCode());
        inParam.setFilter("cityCode", param.getCityCode());
        inParam.setFilter("districtCode", param.getDistrictCode());
        List<ByMarketTerminal> marketTerminalList = super.findList(SqlId.SQL_TERMINAL_CONDITION_INFO_FIND, inParam);
        return marketTerminalList;
    }
    /**
     * 根据指定条件获取菜场
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<ByMarketFood> findConditionMarketFoodList(ByMarketFood param){
        BasePageParam inParam = new BasePageParam();
        inParam.setFilter("fodMarketId",param.getFodMarketId());
        if(!StringUtil.isNullOrEmpty(param.getMarketName())){
            inParam.setFilter("marketName", param.getMarketName() + StringConst.PRE);
        }else{
            inParam.setFilter("marketName", param.getMarketName());
        }
        inParam.setFilter("lgcsAreaCode", param.getLgcsAreaCode());
        inParam.setFilter("cityCode", param.getCityCode());
        inParam.setFilter("districtCode", param.getDistrictCode());
        List<ByMarketFood> marketFoodList = super.findList(SqlId.SQL_FOOD_CONDITION_INFO_FIND, inParam);
        return marketFoodList;
    }

    /**
     * 查询批发市场或菜场中的买家信息
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<IBY121202RsParam> findBuyerByMarketId(IBY121202RsParam param){
        BasePageParam inParam = new BasePageParam();
        inParam.setFilter("marketId",param.getMarketId());
        List<IBY121202RsParam> buyerList = super.findList(SqlId.SQL_GET_BUYER_BY_MARKET_ID,inParam);
        return buyerList;
    }
    /**
     * 根据id获取买家
     *
     * @param buyerId
     * @return
     */
    @Transactional(readOnly = true)
    public ByBuyerBasicInfo findBuyerById(String buyerId) {
        // 取得该买家的信息
        ByBuyerBasicInfo buyerInfo = new ByBuyerBasicInfo();
        buyerInfo.setBuyerId(buyerId);
        buyerInfo = super.findOne(SqlId.SQL_GET_BUYER_BY_ID, buyerInfo);
        return buyerInfo;
    }

    /**
     * 设置买家基本信息中的默认信息
     *
     * @param param
     * @return
     */
    private IBY121202RsParam setBuyerDefaultInfo(IBY121202RsParam param) {
        // 取得该买家的信息
        ByBuyerBasicInfo buyerInfo = super.findOne(SqlId.SQL_GET_BUYER_BY_ID, param);

        if (StringUtil.isNullOrEmpty(param.getSuperiorType())) {
            if (StringUtil.isNullOrEmpty(buyerInfo.getSuperiorType())) {
                // 如果未设置买家类型,默认设置为分销买家
                List<CommConstant> buyerTypes = commonLogic.findConstantList(BusinessConst.BuyerType.Type);
                String buyerTypeName = StringConst.EMPTY;
                for (CommConstant buyerType : buyerTypes) {
                    if (BusinessConst.BuyerType.Distribution.equals(buyerType.getConstantValue())) {
                        buyerTypeName = buyerType.getConstantName();
                        break;
                    }
                }
                param.setSuperiorType(BusinessConst.BuyerType.Distribution);
                param.setSuperiorName(buyerTypeName);
            } else {
                // 若该买家设置了类型,则不改变该值
                param.setSuperiorType(buyerInfo.getSuperiorType());
            }
        }else{
            if(StringUtil.isNullOrEmpty(param.getSuperiorIdName())){
                List<CommConstant> buyerTypes = commonLogic.findConstantList(BusinessConst.BuyerType.Type);
                String buyerTypeName = StringConst.EMPTY;
                for (CommConstant buyerType : buyerTypes) {
                    if (param.getSuperiorType().equals(buyerType.getConstantValue())) {
                        buyerTypeName = buyerType.getConstantName();
                        break;
                    }
                }
                param.setSuperiorName(buyerTypeName);
            }
        }

        if(!StringUtil.isNullOrEmpty(param.getCityName())){
            param.setCityCode(DistrictAreaUtils.getCityCodeByName(param.getCityName()));
        }
        if(!StringUtil.isNullOrEmpty(param.getDistrictName())){
            param.setDistrictCode(DistrictAreaUtils.getDistrictCodeByName(param.getCityCode(), param.getDistrictName()));
        }

        if (StringUtil.isNullOrEmpty(param.getCityCode())) {
            if (StringUtil.isNullOrEmpty(buyerInfo.getCityCode())) {
                // 如果未设置城市,则默认设置为999(其他)
                param.setCityCode("999");
                // 并且把省设为01(上海)
                param.setProvinceCode("99");
            } else {
                // 若该买家有城市编码,则不改变该值
                param.setCityCode(buyerInfo.getCityCode());
            }
        } else {
            // 如果设置了城市则根据城市逆向设置物流区和省
            String lgcsAreaCode = DistrictAreaUtils.getLogisticsAreaCodeByCityCode(param.getCityCode());
            String provinceCode = DistrictAreaUtils.getProvinceCodeByCityCode(param.getCityCode());
            if (!StringUtil.isNullOrEmpty(lgcsAreaCode)) {
                param.setLgcsAreaCode(lgcsAreaCode);
            }
            if (!StringUtil.isNullOrEmpty(provinceCode)) {
                param.setProvinceCode(provinceCode);
            }
        }

        if (StringUtil.isNullOrEmpty(param.getDistrictCode())) {
            if (StringUtil.isNullOrEmpty(buyerInfo.getDistrictCode())) {
                // 如果未设置区县,则默认设置为99(其他)
                param.setDistrictCode("99");
            } else {
                // 如果该买家有区县编码,则不改变该值
                param.setDistrictCode(buyerInfo.getDistrictCode());
            }
        }

        if (StringUtil.isNullOrEmpty(param.getLgcsAreaCode())) {
            if (StringUtil.isNullOrEmpty(buyerInfo.getLgcsAreaCode())) {
                // 如果未设置物流区,则默认设置为99(其他)
                param.setLgcsAreaCode("99");
            } else {
                // 若该买家有物流区编码,则不改变该值
                param.setLgcsAreaCode(buyerInfo.getLgcsAreaCode());
            }
        }

        // 生成买家编码
        if (StringUtil.isNullOrEmpty(param.getBuyerCode())) {
            if (StringUtil.isNullOrEmpty(buyerInfo.getBuyerCode())) {
                param.setBuyerCode(getBuyerCode(param));
            } else {
                param.setBuyerCode(buyerInfo.getBuyerCode());
            }
        }

        return param;
    }

    /**
     * 生成默认买家编码
     *
     * @param param
     * @return
     */
    private String getBuyerCode(ByBuyerBasicInfo param) {
        String buyerCode;

        buyerCode = StringUtil.PadLeft(param.getSuperiorType(), NumberConst.IntDef.INT_TWO, "0");
        buyerCode = buyerCode.concat(param.getLgcsAreaCode());
        buyerCode = buyerCode.concat(param.getCityCode());
        buyerCode = buyerCode.concat(param.getDistrictCode());

        // 查看该买家的类型，物流区，城市，区县内已经有多少个买家
        int buyerCount = super.getCount(SqlId.SQL_COUNT_BUYER_BY_TYPE, param);
        buyerCount += NumberConst.IntDef.INT_ONE;
        String buyerCountToString = StringUtil.PadLeft(String.valueOf(buyerCount), NumberConst.IntDef.INT_FOUR, "0");

        buyerCode = buyerCode.concat(buyerCountToString);
        return buyerCode;
    }

    /**
     * 批发市场信息更新接口
     *
     * @param param
     * @return
     */
    @Transactional
    public int byMarketTerModify(ByMarketTerminal param) {
        // 更新批发市场信息表
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        int modifyCount = super.modify(SqlId.SQL_BY_MARKET_TER_MODIFY, param);
        return modifyCount;
    }

    /**
     * 菜场信息更新接口
     *
     * @param param
     * @return
     */
    @Transactional
    public int byMarketFoodModify(ByMarketFood param) {
        // 更新菜场信息表
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        int modifyCount = super.modify(SqlId.SQL_BY_MARKET_FOOD_MODIFY, param);
        return modifyCount;
    }

}
