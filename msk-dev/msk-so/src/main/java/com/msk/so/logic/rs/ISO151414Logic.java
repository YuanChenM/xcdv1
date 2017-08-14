package com.msk.so.logic.rs;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.ByBuyerBasicInfo;
import com.msk.core.entity.SoOrder;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.order.BaseOrderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * *ISO151416Logic
 * *@author liu_tao2
 * *@version 1.0
 **/
public class ISO151414Logic extends BaseLogic{
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 微商城通过手机号找到对应的买家Id、买家Code、买家名称、买家类型
     * @param param tel
     */
    @Transactional(readOnly = true)
    public void dealOrderInfo(BaseOrderParam param){
        if(!StringUtil.isEmpty(param.getReceiverInfo().getReceiverTel())){
            ByBuyerBasicInfo buyerBasicInfo = super.findOne(SqlId.SQL_ID_GET_BY_BASIC_INFO,param);
            if(null != buyerBasicInfo){
                if(StringUtil.isEmpty(buyerBasicInfo.getBuyerId()) && StringUtil.isEmpty(buyerBasicInfo.getBuyerCode()) && StringUtil.isEmpty(buyerBasicInfo.getBuyerName()) && StringUtil.isEmpty(buyerBasicInfo.getSuperiorType())){
                    throw new BusinessException("请核对买家基本信息!");
                }
                param.setBuyersId(buyerBasicInfo.getBuyerId());
                param.setBuyersCode(buyerBasicInfo.getBuyerCode());
                param.setBuyersName(buyerBasicInfo.getBuyerName());
                param.setBuyersType(Integer.valueOf(buyerBasicInfo.getSuperiorType()));
            }else {
                throw new BusinessException("没有该手机号的买家基本信息");
            }
        }else {
            throw new BusinessException("请输入收货人手机号码");
        }
    }

    /**
     * 检查买手信息是否正确 并且查询买手基本信息
     * @param param
     */
    public void checkBuyersInfo(BaseOrderParam param){
        if (StringUtils.isEmpty(param.getBuyersName())){
            throw new BusinessException("买手编码不能为空");
        }

        SoOrder soOrder = super.findOne(SqlId.SQL_ID_GET_BUYER_INFO,param);
        if (null == soOrder){
            throw new BusinessException("这个买手不存在");
        }
        param.setBuyersId(soOrder.getBuyersId());
        param.setBuyersCode(soOrder.getBuyersCode());
    }

    interface SqlId{
        String SQL_ID_GET_BY_BASIC_INFO = "getBasicInfo";
        String SQL_ID_GET_BUYER_INFO = "getBuyerInfo";
    }
}
