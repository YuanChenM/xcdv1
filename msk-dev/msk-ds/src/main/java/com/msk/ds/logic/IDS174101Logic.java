package com.msk.ds.logic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.DsSlPdLot;
import com.msk.core.utils.StringUtil;
import com.msk.ds.bean.IDS174101RsParam;
import com.msk.ds.bean.IDS174101RsResult;
import com.msk.ds.bean.ProductAttribute;
import com.msk.ds.bean.ProductInfo;

/**
 * IDS174101Logic.
 *
 * @author yuan_chen
 */
@Service
public class IDS174101Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IDS174101Logic.class);

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
     * List页面分页查询
     *
     * @param param param
     * @return 分页结果
     */
    @Transactional(readOnly = true)
    public IDS174101RsResult findRsResult(IDS174101RsParam param) {
        logger.info("List页面分页查询");
        List<ProductInfo> productInfos = new ArrayList<ProductInfo>();
        IDS174101RsResult rsResult = new IDS174101RsResult();
        rsResult.setTotalCount(super.getPageCount(param));
        rsResult.setPageNo(param.getPageNo());
        if (rsResult.getTotalCount() != NumberConst.IntDef.INT_ZERO) {
            rsResult.setTotalPage(rsResult.getTotalCount(), param.getPageCount());
            List<DsSlPdLot> lotList = this.findPageList(param);

            ProductInfo pdInfo;
            List<ProductAttribute> pAttributes;
            ProductAttribute pAttribute;
            for (DsSlPdLot lot : lotList) {
                pdInfo = new ProductInfo();
                pdInfo.setPdtCode(StringUtil.nullToEmpty(lot.getPdCode()));
                pdInfo.setPdtName(StringUtil.nullToEmpty(lot.getPdName()));
                pdInfo.setStockCnt(String.valueOf(100));
                pdInfo.setPdtStatus(StringUtil.nullToEmpty(lot.getPdStatus()));
                pdInfo.setGradeLevel(StringUtil.nullToEmpty(lot.getGradeName()));

                pAttributes = new ArrayList<ProductAttribute>();
                pAttribute = new ProductAttribute();
                pAttribute.setOrigin(StringUtil.nullToEmpty(lot.getOrigin()));
                pAttribute.setProdcingArea(StringUtil.nullToEmpty(lot.getProdcingarea()));
                pAttribute.setManufacturer(StringUtil.nullToEmpty(lot.getManufacturer()));
                pAttribute.setBrand(StringUtil.nullToEmpty(lot.getBrand()));
                pAttribute.setNetWeight(StringUtil.nullToEmpty(lot.getNetweight()));
                pAttribute.setPkgSpecifications(StringUtil.nullToEmpty(lot.getPkgSpec()));
                pAttribute.setPkgWay(StringUtil.nullToEmpty(lot.getPkgWay()));
                pAttribute.setProductionsTime(StringUtil.nullToEmpty(lot.getPdTime()));
                pAttribute.setShelfLife(StringUtil.nullToEmpty(lot.getShelfLife()));
                pAttribute.setProcessingWay(StringUtil.nullToEmpty(lot.getProcessingWay()));
                pAttribute.setStorageWay(StringUtil.nullToEmpty(lot.getStorageWay()));
                pAttributes.add(pAttribute);

                pdInfo.setProductAttributes(pAttributes);
                productInfos.add(pdInfo);
            }
        }
        rsResult.setProductInfos(productInfos);
        return rsResult;
    }
}
