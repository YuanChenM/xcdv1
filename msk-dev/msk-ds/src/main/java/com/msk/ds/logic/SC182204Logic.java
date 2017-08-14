package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.ds.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * SC182203Logic.
 *
 * @author yi_qixiang
 * @version 1.0
 **/
@Service
public class SC182204Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC182204Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_yajun
     */
    interface SqlId {
        // 所有产品的合计用
        String SQL_GET_VIRTUAL_STOCK_ACTUAL_LIST = "getVirtualStockActualList";  // 实际
        String SQL_GET_LGCS_AND_SUPP = "getLgcsAndSupp";  // 实际
        String SQL_GET_MANUFACTURE_AND_BRAND = "getManufactureAndBrand";  // 实际
        String SQL_GET_DS_PRODUCT_LOT = "getDsProductLot";  // 实际
        String SQL_GET_MD_LOGISTICS_AERA = "getMdLogisticsArea";  // 实际
        String SQL_GET_SL_ENTERPRISE= "getSlEnterprise";  // 实际

    }


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 获取产品虚拟库存实际表数据
     *
     * @return DS173306Param
     */
    @Transactional
    public List<SC182204Bean> getStockActual(SC182204Param sc182204Param) {

        // 产品虚拟库存实际表数据查询
        String lgcsCode = "";
        String suppCode = "";
        if(sc182204Param.getLgcsCode()==null){
            List<SC182204Bean> lgcsList = this.findList(SqlId.SQL_GET_MD_LOGISTICS_AERA, new SC182204Param());
            lgcsCode = lgcsList.get(0).getLgcsCode();
            SC182204Param param = new SC182204Param();
            param.setLgcsCode(lgcsCode);
            List<SC182204Bean> suppList = this.findList(SqlId.SQL_GET_SL_ENTERPRISE, param);
            suppCode = suppList.get(0).getSuppCode();
            sc182204Param.setSuppCode(suppCode);
            sc182204Param.setLgcsCode(lgcsCode);
        }
        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("distMonth", sc182204Param.getDistMonth());
//        baseParam.getFilterMap().put("lgcsCode",lgcsCode);
        baseParam.getFilterMap().put("lgcsCode",sc182204Param.getLgcsCode());
        baseParam.getFilterMap().put("halfCode", sc182204Param.getHalfCode());
        baseParam.getFilterMap().put("pdStockType", sc182204Param.getPdStockType());
//        baseParam.getFilterMap().put("suppCode", suppCode);
        baseParam.getFilterMap().put("suppCode", sc182204Param.getSuppCode());

        List<SC182204Bean> stockActualList = new ArrayList<SC182204Bean>();
        stockActualList = this.findList(SqlId.SQL_GET_VIRTUAL_STOCK_ACTUAL_LIST, baseParam);
        //List<SC182204Bean> stockActualList = new ArrayList<SC182204Bean>();
        return stockActualList;


    }



    /**
     * 根据用户账户查到供应商和销售区域
     *
     * @return suppName
     */
    @Transactional
    public SC182204Bean getLgcsAndSupp(SC182204Param sc182204Param) {

        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("slAccount", sc182204Param.getSlAccount());

        List<SC182204Bean> list = new ArrayList<SC182204Bean>();
        list = this.findList(SqlId.SQL_GET_LGCS_AND_SUPP, sc182204Param);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }



    /**
     * 保存产品批次数据表
     *
     * @return result
     */
    @Transactional
    public void saveProductLot(SC182204Param param) {

        for (SC182204ProductParam entity : param.getProductParamList()) {
            if(entity.getCheckbox()!=null&&entity.getCheckbox().equals("1")){
                SC182204Param param1 = new SC182204Param();
                param1.setLgcsCode(entity.getLgcsCode());
                param1.setSuppCode(entity.getSuppCode());
                param1.setMachiningCode(entity.getMachiningCode());
                param1.setFeatureCode(entity.getFeatureCode());
                param1.setWeightCode(entity.getWeightCode());
                param1.setGradeCode(entity.getGradeCode());
                param1.setManuDate(entity.getManuDate());
                param1.setShelfLife(entity.getShelfLife());
                param1.setStorCondition(entity.getStorCondition());
                param1.setProStanCode(entity.getProStanCode());
                param1.setFoodManuLicen(entity.getFoodManuLicen());
                param1.setClient(entity.getClient());
                param1.setUnClient(entity.getUnClient());
                param1.setClientAddr(entity.getClientAddr());
                param1.setUnClientAddr(entity.getUnClientAddr());
                param1.setClientPhone(entity.getClientPhone());
                param1.setUnClientPhone(entity.getUnClientPhone());
                param1.setManuOrigin(entity.getManuOrigin());
                param1.setBrandLogo(entity.getBrandLogo());
                param1.setProLotNum(entity.getProLotNum());
                param1.setSumNewActNum(entity.getSumNewActNum());
                param1.setClassesCode(entity.getClassesCode());
                param1.setBreedCode(entity.getBreedCode());
                param1.setNormsCode(entity.getNormsCode());
                param1.setReadProLotNum(entity.getReadProLotNum());
                param1.setHalfPeriod(param.getHalfPeriod());

                if(super.save(param1)!=NumberConst.IntDef.INT_ONE){
                    throw new BusinessException("保存失败，请和管理员联系");
                }
            }
        }
    }


    /**
     * 根据条形主码判断ds_product_lot表是否有新增的数据
     *
     * @return suppName
     */
    @Transactional
    public SC182204Bean getDsProductLot(SC182204Param sc182204Param) {

        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("proLotNum", sc182204Param.getProLotNum());

        List<SC182204Bean> list = new ArrayList<SC182204Bean>();
        list = this.findList(SqlId.SQL_GET_DS_PRODUCT_LOT, sc182204Param);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }


    /**
     * 根据区域和供应商得到SC182204Bean
     *
     * @return suppName
     */
    @Transactional
    public SC182204Bean getSC182204Bean(SC182204Param sc182204Param) {

        SC182204Bean sc182204Bean = new SC182204Bean();
        List<SC182204Bean> lgcsList = new ArrayList<SC182204Bean>();
        List<SC182204Bean> suppList = new ArrayList<SC182204Bean>();
        if(sc182204Param.getLgcsCode()==null||sc182204Param.getSuppCode()==null){
            lgcsList = this.findList(SqlId.SQL_GET_MD_LOGISTICS_AERA, new SC182204Param());
            String lgcsCode = (lgcsList.get(0)).getLgcsCode();
            SC182204Param param = new SC182204Param();
            param.setLgcsCode(lgcsCode);
            suppList = this.findList(SqlId.SQL_GET_SL_ENTERPRISE, param);
            sc182204Bean.setLgcsCode(lgcsCode);
            sc182204Bean.setSuppCode(suppList.get(0).getSuppCode());
            sc182204Bean.setLgcsAreaList(lgcsList);
            sc182204Bean.setSupplyList(suppList);
        }else{
            lgcsList = this.findList(SqlId.SQL_GET_MD_LOGISTICS_AERA, new SC182204Param());
            sc182204Bean.setLgcsCode(sc182204Param.getLgcsCode());
            sc182204Bean.setSuppCode(sc182204Param.getSuppCode());
            sc182204Bean.setLgcsAreaList(lgcsList);
            suppList = this.findList(SqlId.SQL_GET_SL_ENTERPRISE, sc182204Param);
            sc182204Bean.setSupplyList(suppList);
        }
        return sc182204Bean;
    }



    /**
     * 根据销售区域获得供应商
     *
     * @return List<SC182204Bean>
     */
    @Transactional
    public List<SC182204Bean> getSuppListByLgcs(SC182204Param sc182204Param) {

        // 产品虚拟库存实际表数据查询

        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("lgcsCode", sc182204Param.getLgcsCode());
        List<SC182204Bean> suppList = new ArrayList<SC182204Bean>();
        suppList = this.findList(SqlId.SQL_GET_SL_ENTERPRISE, sc182204Param);
        //List<SC182204Bean> stockActualList = new ArrayList<SC182204Bean>();
        return suppList;


    }




    /**
     * 根据供应商账号查找生产商和品牌
     *
     * @return suppName
     */
    @Transactional
    public SC182204Bean getManuFactureAndBrand(SC182204Param sc182204Param) {

        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("suppCode", sc182204Param.getSuppCode());

        List<SC182204Bean> list = new ArrayList<SC182204Bean>();
        list = this.findList(SqlId.SQL_GET_MANUFACTURE_AND_BRAND, sc182204Param);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }

    }



}

