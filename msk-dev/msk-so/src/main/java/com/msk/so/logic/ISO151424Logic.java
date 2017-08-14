package com.msk.so.logic;

import com.msk.common.consts.StatusConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO151424ProductResult;
import com.msk.so.bean.ISO151424RsParam;
import com.msk.so.bean.ISO151424RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang_jianzhou on 2016/4/18.
 */
@Service
public class ISO151424Logic extends BaseLogic {

    public ISO151424RsResult findProduct(RsRequest<ISO151424RsParam> param) {

        ISO151424RsResult rsResult = new ISO151424RsResult();
        ISO151424RsParam iSO151424RsParam = param.getParam();
        iSO151424RsParam.setSupplyPlatform(1);
        String siteCode = param.getSiteCode();
        String auth = param.getAuth();

        if (StringUtil.isEmpty(iSO151424RsParam.getSellerCode())) {
            throw new BusinessException("F000001","参数不正确");
        }

        if(StringUtil.isEmpty(iSO151424RsParam.getSupplierCode())){
            throw new BusinessException("F000001","参数不正确");
        }

        if(StringUtil.isEmpty(siteCode)){
            throw new BusinessException("F000001","参数不正确");
        }

        if(StringUtil.isEmpty(auth)){
            throw new BusinessException("F000001","参数不正确");
        }

        Integer totalCount = super.getPageCount(iSO151424RsParam);
        rsResult.setTotalCount(totalCount);
        rsResult.setTotalPage(totalCount, iSO151424RsParam.getPageCount());
        rsResult.setPageNo(iSO151424RsParam.getPageNo());

        if (NumberConst.IntDef.INT_ZERO != iSO151424RsParam.getPageCount() &&
                NumberConst.IntDef.INT_ZERO != iSO151424RsParam.getPageNo()) {
            iSO151424RsParam.setPaging(true);
        } else {
            iSO151424RsParam.setPaging(false);
        }
        /*switch (siteCode){
            //神农客平台
            case "101" :
                iSO151424RsParam.setSupplyPlatform(1);
                break;
            //美侍客平台
            case "102" :
                iSO151424RsParam.setSupplyPlatform(2);
                break;
            //大促会平台
            case "103" :
                iSO151424RsParam.setSupplyPlatform(3);
                break;
            default:
                break;
        }*/
        iSO151424RsParam.setStatus(StatusConst.OrderDetailAvailabilityStatusDef.CANCEL);
        iSO151424RsParam.setCrtTime(DateTimeUtil.getCustomerDate());
        List<ISO151424ProductResult> list = super.findPageList(iSO151424RsParam);
        rsResult.setProducts(list);

        if (totalCount == null || totalCount == 0) {
            throw new BusinessException("F000002","未查询到符合条件的数据");
        }
        return rsResult;
    }


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
