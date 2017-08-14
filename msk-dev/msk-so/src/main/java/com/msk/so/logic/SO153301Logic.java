package com.msk.so.logic;

import com.msk.common.consts.StockConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.SO153201Bean;
import com.msk.so.bean.SO153201Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * yang_yang
 */
@Service
public class SO153301Logic extends BaseLogic {

    private static Logger logger = LoggerFactory.getLogger(SO153301Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 买手-交易记录查询
     * @return
     */
        public PageResult<SO153201Param> findSo153301List(BasePageParam pageParam) {
            PageResult<SO153201Bean> result = this.findPage(pageParam, SO153201Bean.class);
            PageResult<SO153201Param> newResult = new PageResult<SO153201Param>();
            int count = this.getPageCount(pageParam);

            logger.info("买手交易记录");

            List<SO153201Bean> list = result.getData();
            List<SO153201Param> newList = new ArrayList<SO153201Param>();
            for(SO153201Bean bean : list){

                SO153201Param so153201Param = new SO153201Param();
                //交易时间
                if(String.valueOf(NumberConst.IntDef.INT_ONE).equals(pageParam.getFilterMap().get("timeType"))){
                    so153201Param.setTranTime(bean.getTranTime());
                }
                if(String.valueOf(NumberConst.IntDef.INT_TWO).equals(pageParam.getFilterMap().get("timeType"))){
                    so153201Param.setTranTime(bean.getCreateTime());
                }

                //订单号
                StringBuffer orderNum = new StringBuffer();

                boolean haveLine = false;
                if(!StringUtil.isNullOrEmpty(bean.getSelectCode()) && String.valueOf(NumberConst.IntDef.INT_ZERO).equals(bean.getSelectType())){
                    orderNum.append("订单号:").append(bean.getSelectCode());
                    so153201Param.setOrderCode(bean.getSelectCode());
                    haveLine = true;
                }
                if(haveLine && !StringUtil.isNullOrEmpty(bean.getPaidSeq())){
                    orderNum.append(" | ");
                }
                if(!StringUtil.isNullOrEmpty(bean.getPaidSeq())){
                    orderNum.append("交易号:").append(bean.getPaidSeq());
                }

                so153201Param.setSelectCode(orderNum.toString());

                //收款方
                switch (Integer.valueOf(bean.getBusinessManRole())){
                    case BusinessConst.TranType.Platform:
                        //平台1
                        if(StockConst.SL_Name.SL_CODE.equals(bean.getBusinessMain())){
                            so153201Param.setBusinessMain(StockConst.SL_Name.SL_NAME);
                        }else{
                            so153201Param.setBusinessMain(bean.getMainSellerName());
                        }
                        break;
                    case BusinessConst.TranType.Buyer:
                        //买家2
                        so153201Param.setBusinessMain(bean.getMainBuyerName());
                        break;
                    case BusinessConst.TranType.Seller:
                        //卖家3
                        so153201Param.setBusinessMain(bean.getMainSellerName());
                        break;
                    case BusinessConst.TranType.BuyMan:
                        //买手4
                        so153201Param.setBusinessMain(bean.getMainSellerName());
                        break;
                    default:
                        break;
                }

                //付款方
                switch (Integer.valueOf(bean.getBusinessAssistantRole())){
                    case BusinessConst.TranType.Platform:
                        //平台1
                        if(StockConst.SL_Name.SL_CODE.equals(bean.getBusinessAssistant())){
                            so153201Param.setBusinessAssistant(StockConst.SL_Name.SL_NAME);
                        }else{
                            so153201Param.setBusinessAssistant(bean.getAssSellerName());
                        }
                        break;
                    case BusinessConst.TranType.Buyer:
                        //买家2
                        so153201Param.setBusinessAssistant(bean.getAssBuyerName());
                        break;
                    case BusinessConst.TranType.Seller:
                        //卖家3
                        so153201Param.setBusinessAssistant(bean.getAssSellerName());
                        break;
                    case BusinessConst.TranType.BuyMan:
                        //买手4
                        so153201Param.setBusinessAssistant(bean.getAssSellerName());
                        break;
                    default:
                        break;
                }

                //金额
                StringBuffer orderAmount = new StringBuffer();
                //当主体角色为4时 +
                if(!StringUtil.isNullOrEmpty(bean.getBusinessManRole()) && String.valueOf(BusinessConst.TranType.BuyMan).equals(bean.getBusinessManRole())){
                    orderAmount.append("+").append(bean.getOrderAmount());
                }
                //当副体角色为4时 -
                if(!StringUtil.isNullOrEmpty(bean.getBusinessAssistantRole()) && String.valueOf(BusinessConst.TranType.BuyMan).equals(bean.getBusinessAssistantRole())){
                    orderAmount.append("-").append(bean.getOrderAmount());
                }

                so153201Param.setOrderAmount(orderAmount.toString());
                so153201Param.setRemark(bean.getRemark());
                so153201Param.setSettlement("待付款");
                if(bean.getSettlement() == 0){
                    so153201Param.setSettlement("已付款");
                }
                newList.add(so153201Param);
            }

            newResult.setData(newList);
            newResult.setRecordsTotal(count);

            return newResult;
    }
}
