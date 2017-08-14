package com.msk.so.logic;

import com.msk.common.consts.CapitalPoolConst;
import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoReturn;
import com.msk.core.entity.SoReturnStatus;
import com.msk.core.exception.SystemException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO151422ReturnDetail;
import com.msk.so.bean.ISO151422RsResult;
import com.msk.so.bean.rs.ISOReturnOrder;
import com.msk.so.bean.rs.Product;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2016/4/11.
 */
@Service
public class ISO151422Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151422Logic.class);


    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private OrderLogic orderLogic;

    /**
     * 先检查退款单状态   是否是已经收货  如果是   继续运行  不是    返回返回信息 状态不对
     * 修改退货单状态
     * 生成 退款单
     *
     * @param param
     * @return
     */
    @Transactional
    public ISO151422RsResult inbound(ISOReturnOrder param) {
        param.setReturnStatus(StatusConst.SoReturnStatusDef.STORAGE);
        SoReturn soReturn = this.checkSoReturnStatus(param);//检查退货单状态是否 是已收货
        String crtTime = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS, soReturn.getCrtTime());
        String returnCode = soReturn.getReturnCode();
        List<ISO151422ReturnDetail> returnDetails = this.checkSoReturnDetail(param.getProductList(), param.getReturnId());
        // 买家退货
        this.updateSoReturn(param);
        this.insertSoReturnStatus(soReturn);
        for (Product product : param.getProductList()) {
            product.setDetailStatus(StatusConst.SoReturnStatusDef.STORAGE);
            product.setUpdTime(DateTimeUtil.getCustomerDate());
            product.setUpdId(param.getUpdId());
            this.updateSoReturnDetail(product);
        }
        // 买手被动退货
        if (CollectionUtils.isNotEmpty(returnDetails) && OrderConst.ReturnType.LATER != soReturn.getReturnType()) {
            this.buyerReturn(returnDetails, soReturn);
        }

        ISO151422RsResult result = new ISO151422RsResult();
        result.setReturnId(param.getReturnId());
        result.setReturnStatus(StatusConst.SoReturnStatusDef.STORAGE);
        result.setCrtTime(crtTime);
        result.setReturnCode(returnCode);
        result.setVer(soReturn.getVer() + NumberConst.IntDef.INT_ONE);
        return result;
    }

    /**
     * 检查退货单状态
     *
     * @param returnOrder
     */
    public SoReturn checkSoReturnStatus(ISOReturnOrder returnOrder) {
        SoReturn soReturn = super.findOne(SqlId.CHECK_SO_RETURN_STATUS, returnOrder);
        if (soReturn == null) {
            throw new SystemException("退货单id " + returnOrder.getReturnId() + " 错误！");
        }
        // 状态列表  /** PROCESS 处理中*/  如果不是处理中就不能
        if (soReturn.getReturnStatus() != StatusConst.SoReturnStatusDef.PROCESS) {
            throw new SystemException("抱歉！因为退货单状态不是处理中，所以不能进行入库操作");
        }
        return soReturn;
    }

    /**
     * 检查退货明细
     *
     * @param products
     * @param returnId
     */
    public List<ISO151422ReturnDetail> checkSoReturnDetail(List<Product> products, Long returnId) {
        List<ISO151422ReturnDetail> returnDetails = new ArrayList<>();
        for (Product product : products) {
            product.setReturnId(returnId);
            ISO151422ReturnDetail detail = super.findOne(SqlId.FIND_SO_RETURN_DETAIL, product);
            if (detail == null) {
                throw new SystemException("查询对应不到的product");
            } else if (DecimalUtil.isGreater(product.getInboundQty(), detail.getReturnQty())) {
                //  入库量大于退货数量
                throw new SystemException("入库数量大于退货单明细中的数量,退货单明细id:" + product.getDetailId() + " 退货量：" + detail.getReturnQty() + " 入库数量：" + product.getInboundQty() + " 入库批次：" + detail.getInboundBatch());
            }
            if (detail.getBuyerFlg() == 0) {
                returnDetails.add(detail);
            }
        }
        return returnDetails;
    }

    /**
     * @param returnOrder
     */
    public void updateSoReturn(ISOReturnOrder returnOrder) {
        super.modify(SqlId.UPDATE_SO_RETURN, returnOrder);
    }

    /**
     * @param product
     */
    public void updateSoReturnDetail(Product product) {
        super.modify(SqlId.UPDATE_SO_RETURN_DETAIL, product);
    }

    /**
     * @param soReturn
     */
    public void insertSoReturnStatus(SoReturn soReturn) {
        Long maxId = this.commonLogic.maxId("so_return_status", "STATUS_ID");
        SoReturnStatus returnStatus = new SoReturnStatus();
        returnStatus.setStatusId(maxId);
        returnStatus.setReturnStatus(StatusConst.SoReturnStatusDef.STORAGE);// 入库状态
        returnStatus.setReturnCode(soReturn.getReturnCode());
        returnStatus.setReturnId(soReturn.getReturnId());
        returnStatus.setCrtTime(DateTimeUtil.getCustomerDate());
        returnStatus.setCrtId(soReturn.getCrtId());
        super.modify(SqlId.INSERT_SO_RETURN_STATUS, returnStatus);
    }

    /**
     * 买手被动退货
     *
     * @param returnDetails
     * @param soReturn
     */
    public void buyerReturn(List<ISO151422ReturnDetail> returnDetails, SoReturn soReturn) {
        logger.info("买手被动退货开始");
        Long maxId = this.commonLogic.maxId("so_return", "RETURN_ID");
        soReturn.setReturnId(maxId);
        soReturn.setReturnCode(orderLogic.getReturnOrderCode(soReturn.getReturnId()));
        soReturn.setBuyersCode(this.getSellerCodeDisAnShowName(returnDetails.get(0).getSellerCode()).getBuyersCode());
        soReturn.setBuyersName(this.getSellerCodeDisAnShowName(returnDetails.get(0).getSellerCode()).getBuyersName());
        soReturn.setBuyersId(returnDetails.get(0).getSellerCode());       //  买手id   下单时  主子订单 子订单中的 sellerCode                                                             // 买家id
        soReturn.setRoleType(CapitalPoolConst.RoleType.ROLE_BUYERE); // 角色  因买手被动退货是买手
        soReturn.setReturnStatus(StatusConst.SoReturnStatusDef.STORAGE);
        BigDecimal returnAmount = null;
        for (ISO151422ReturnDetail returnDetail : returnDetails) {
            Long detailId = this.commonLogic.maxId("so_return_detail", "DETAIL_ID");
            returnDetail.setDetailId(detailId);
            returnDetail.setReturnId(soReturn.getReturnId());
            returnDetail.setCrtId(soReturn.getCrtId());
            returnDetail.setCrtTime(DateTimeUtil.getCustomerDate());
            returnDetail.setDetailStatus(StatusConst.SoReturnStatusDef.STORAGE);
            returnAmount = DecimalUtil.add(returnDetail.getReturnAmount(), returnAmount);
        }
        soReturn.setReturnAmount(returnAmount);
        soReturn.setCrtTime(DateTimeUtil.getCustomerDate());
        super.save(soReturn);
        this.insertSoReturnStatus(soReturn);
        super.batchSave(returnDetails);
    }

    /**
     * 查询买手名称和CODEDIS
     *
     * @param slCode 买手ID
     */
    @Transactional
    private SoReturn getSellerCodeDisAnShowName(String slCode) {
        SoReturn soReturn = new SoReturn();
        if (!StringUtil.isEmpty(slCode)) {
            BaseParam param = new BaseParam();
            param.setFilterObject("slCode", slCode);
            soReturn = super.findOne(SqlId.GET_SELLERCODEDIS_AND_SHOWNAME, param);
        }
        if (null != soReturn && !StringUtil.isEmpty(soReturn.getBuyersCode()) && !StringUtil.isEmpty(soReturn.getBuyersName())) {
            return soReturn;
        }
        return new SoReturn();
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SqlId. sql定义
     *
     * @author zhang_qiang1
     */
    interface SqlId {
        String CHECK_SO_RETURN_STATUS = "checkSoReturnStatus";
        String FIND_SO_RETURN_DETAIL = "findSoReturnDetail";
        String UPDATE_SO_RETURN = "updateSoReturn";
        String UPDATE_SO_RETURN_DETAIL = "updateSoReturnDetail";
        String INSERT_SO_RETURN_STATUS = "insertSoReturnStatus";
        String GET_SELLERCODEDIS_AND_SHOWNAME = "getSellerCodeDisAnShowName";
    }
}
