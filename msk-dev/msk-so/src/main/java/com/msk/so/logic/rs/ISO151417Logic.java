package com.msk.so.logic.rs;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.SoEvaluate;
import com.msk.core.entity.SoEvaluateDetail;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO151417RsParam;
import com.msk.so.bean.ISO151417RsProductParam;
import com.msk.so.bean.ISO151417RsResult;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liutao on 2016/10/11.
 */
@Service
public class ISO151417Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    private static Logger logger = LoggerFactory.getLogger(ISO151417Logic.class);

    @Autowired
    private CommonLogic commonLogic;

    /**
     * 创建订单评价
     *
     * @param param
     * @return
     */
    @Transactional
    public ISO151417RsResult createEvaluate(ISO151417RsParam param) {
        checkParam(param);
        SoEvaluate soEvaluate = dealEvaluateInfo(param);
        logger.info("插入评价表");
        this.save(SqlId.SQL_ID_SAVE_EVALUATE_INFO, soEvaluate);
        logger.info("插入评价明细表");
        for (ISO151417RsProductParam productParam : param.getProducts()) {
            SoEvaluateDetail soEvaluateDetail = dealEvaluateDetailInfo(productParam, soEvaluate);
            this.save(SqlId.SQL_ID_SAVE_EVALUATE_DETAIL_INFO, soEvaluateDetail);
        }

        return getResult(soEvaluate);
    }

    /**
     * 得到返回结果
     *
     * @param soEvaluate
     * @return
     */
    @Transactional
    public ISO151417RsResult getResult(SoEvaluate soEvaluate) {
        ISO151417RsResult result = new ISO151417RsResult();
        result.setOrderId(soEvaluate.getOrderId());
        result.setEvaluateId(soEvaluate.getEvaluateId());
        return result;
    }

    /**
     * 遍历评价明细信息
     *
     * @param productParam
     * @param soEvaluate
     * @return
     */
    @Transactional
    private SoEvaluateDetail dealEvaluateDetailInfo(ISO151417RsProductParam productParam, SoEvaluate soEvaluate) {
        SoEvaluateDetail soEvaluateDetail = new SoEvaluateDetail();
        BeanUtils.copyProperties(soEvaluate, soEvaluateDetail);
        soEvaluateDetail.setEvaluateDesc(productParam.getEvaluateDesc());
        soEvaluateDetail.setEvaluateRemark(productParam.getRemark());
        soEvaluateDetail.setProDate(DateTimeUtil.parseDate(productParam.getProDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDD));
        soEvaluateDetail.setPdCode(productParam.getPdCode());
        soEvaluateDetail.setEvaluateImg(productParam.getEvaluateImg());
        soEvaluateDetail.setEvaluateScore(productParam.getScore());
        soEvaluateDetail.setDetailId(commonLogic.maxId("SO_EVALUATE_DETAIL", "DETAIL_ID"));
        return soEvaluateDetail;
    }

    /**
     * 遍历评价信息
     *
     * @param param
     * @return
     */
    @Transactional
    public SoEvaluate dealEvaluateInfo(ISO151417RsParam param) {
        SoEvaluate soEvaluate = new SoEvaluate();
        BeanUtils.copyProperties(param, soEvaluate);
        soEvaluate.setEvaluateDate(DateTimeUtil.parseDate(param.getEvaluateDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
        soEvaluate.setDelFlg(SystemConst.DelFlg.ENABLE);
        soEvaluate.setEvaluateId(commonLogic.maxId("SO_EVALUATE", "EVALUATE_ID"));
        return soEvaluate;
    }

    /**
     * 检查传入参数
     *
     * @param param
     */
    @Transactional
    public void checkParam(ISO151417RsParam param) {
        logger.info("检查传入参数");
        if (!StringUtil.isEmpty(param.getEvaluateDate())
                && null == DateTimeUtil.parseDate(param.getEvaluateDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS)) {
            throw new BusinessException("评价时间格式不正确");
        }
        List<ISO151417RsProductParam> products = param.getProducts();

        if (CollectionUtils.isEmpty(products)) {
            throw new BusinessException("产品列表不能为空");
        }

        //检查对于这个买家下的这个订单是否存在
        Integer orderCount = (Integer)this.findObject(SqlId.SQL_ID_GET_ORDER_COUNT, param);
        if(orderCount <= NumberConst.IntDef.INT_ZERO){
            throw new BusinessException("买家为：" + param.getUserId() + "，订单号为：" + param.getOrderId() +"的订单不存在");
        }

        for (ISO151417RsProductParam productParam : products) {
            if (!StringUtil.isEmpty(productParam.getProDate())) {
                if (null == DateTimeUtil.parseDate(productParam.getProDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDD)) {
                    throw new BusinessException("配送日期格式不正确");
                }
            }
            productParam.setOrderId(param.getOrderId());
            Integer detailCount = (Integer)this.findObject(SqlId.SQL_ID_GET_ORDER_DETAIL_COUNT, productParam);
            if(detailCount <= NumberConst.IntDef.INT_ZERO){
                throw new BusinessException("产品编码为：" + productParam.getPdCode() + "的产品信息不正确");
            }
        }
    }

    interface SqlId {
        String SQL_ID_SAVE_EVALUATE_INFO = "saveEvaluateInfo";
        String SQL_ID_SAVE_EVALUATE_DETAIL_INFO = "saveEvaluateDetailInfo";
        String SQL_ID_GET_ORDER_COUNT = "getOrderCount";
        String SQL_ID_GET_ORDER_DETAIL_COUNT = "getOrderDetailCount";
    }
}
