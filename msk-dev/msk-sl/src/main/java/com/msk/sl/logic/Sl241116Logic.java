package com.msk.sl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.SlEnterprise;
import com.msk.core.entity.SlPdBrand;
import com.msk.core.entity.SlPdPkg;
import com.msk.core.entity.SlProduct;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.SL241101Bean;
import com.msk.sl.bean.SL241116Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 卖家产品列表Logic.
 *
 * @author gyh
 */
public class Sl241116Logic extends BaseLogic {
    @Autowired
    private CommonLogic commonLogic;

    /**
     * SQL Map 中SQL ID定义
     * 
     * @author gyh
     */
    interface SqlId {
        final static String SQL_ID_FIND_SL_EP_INFO = "findSlEpInfo";
        final static String SQL_ID_FIND_SL_PD_BRAND = "findSlPdBrand";
        final static String SQL_ID_SAVE_SL_PD_PKG = "saveSlPdPkg";
        static final String SQL_ID_DELETE_SL_Product = "deleteProduct";
        static final String SQL_ID_MODIFY_SL_PKG = "modifySlPdPkg";
        static final String SQL_ID_FIND_SL_PRODUCT_LIST = "findSlProductList";
        static final String SQL_ID_UP_SL_PD_STATUS = "upSlPdStatus";
        static final String SQL_ID_SAVE_SL_PRODUCT_HIS = "saveSlProductHis";
    }

    /**
     * 修改卖家产品状态
     * @param slProduct 参数
     * @return 结果
     */
    @Transactional(readOnly = false)
    public int upSlPdStatus(SlProduct slProduct){
        //每次修改卖家产品，根据id查询卖家产品，并将最新状态存入卖家产品履历表中
        BasePageParam param=new BasePageParam();
        param.setPaging(false);
        param.getFilterMap().put("slPdId", slProduct.getSlPdId());
        List<SL241116Bean> beans= this.findPageList(param, SL241116Bean.class);
        if(!CollectionUtils.isEmpty(beans)&&beans.size()>0){
            SL241116Bean product=beans.get(0);
            if(null!=product.getVer()){
                slProduct.setVer(product.getVer()+1);
            }else{
                slProduct.setVer(1);
            }
            if(!slProduct.getStatus().equals(product.getStatus())){
                product.setStatus(slProduct.getStatus());
                //存卖家产品履历
                product.setHisId(commonLogic.maxId("sl_product_status_his", "HIS_ID"));
                this.modify(SqlId.SQL_ID_SAVE_SL_PRODUCT_HIS,product);
            }
        }else{
            throw new BusinessException("卖家产品ID不存在，请检查后提交！");
        }
        return this.modify(SqlId.SQL_ID_UP_SL_PD_STATUS,slProduct);
    }

    /**
     * 单查卖家产品表
     * @param param 参数
     * @return 结果
     */
    public List<SL241116Bean> findSlProductList(BaseParam param){
        return this.findList(SqlId.SQL_ID_FIND_SL_PRODUCT_LIST,param);
    }
    /**
     * 修改卖家包装
     * @param slPdPkg 参数
     * @return 结果
     */
    public Integer modifySlPdPkg(SlPdPkg slPdPkg){
        return this.modify(SqlId.SQL_ID_MODIFY_SL_PKG,slPdPkg);
    }

    /**
     * 删除卖家产品
     * @param product 参数
     * @return 结果
     */
    public Integer deleteProduct(SlProduct product){
        return this.modify(SqlId.SQL_ID_DELETE_SL_Product,product);
    }

    /**
     * 根据卖家编码查询卖家供应商
     * @param param 参数
     * @return 卖家供应商信息
     */
    public List<SlEnterprise> findEpInfo(BaseParam param){
        return super.findList(SqlId.SQL_ID_FIND_SL_EP_INFO,param);
    }
    /**
     * 根据卖家编码查询卖家品牌
     * @param param 参数
     * @return 卖家品牌
     */
    public List<SlPdBrand> findSlPdBrand(BaseParam param){
        return super.findList(SqlId.SQL_ID_FIND_SL_PD_BRAND,param);
    }

    /**
     * 保存规格信息
     * @param slPdPkg 参数
     * @return 结果
     */
    @Transactional(readOnly = false)
    public int saveSlPdPkg(SlPdPkg slPdPkg){
        return super.save(SqlId.SQL_ID_SAVE_SL_PD_PKG,slPdPkg);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
