package com.msk.ds.logic;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.msk.common.utils.PriceCycleUtils;
import com.msk.common.bean.PriceCycle;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.DsSlPdLot;
import com.msk.core.entity.PdNormsStd;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pd.logic.ProductLogic;

/**
 * DS174101Logic.
 *
 * @author yuan_chen
 * @version 1.0
 **/
@Service
public class DS174103Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DS174103Logic.class);

    @Autowired
    private DS174101Logic ds174101Logic;
    @Autowired
    private ProductLogic productLogic;

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
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_FIND_LGCS_INFO = "findLgcsInfo";
    }

    /**
     * 设定dsSlPdLot中的值
     * 
     * @param dsSlPdLot dsSlPdLot
     */
    public void setDsSlPdLot(DsSlPdLot dsSlPdLot) {
        logger.debug("设定dsSlPdLot中的值");

        // 生成周期
        Date dateNow = DateTimeUtil.getCustomerDate();
        PriceCycle cycle = PriceCycleUtils.getPriceCycle(dateNow, NumberConst.IntDef.INT_ZERO);

        // 生成批次号
        dsSlPdLot.setPdCode(ds174101Logic.getpdCode(dsSlPdLot));
        dsSlPdLot.setPdName(dsSlPdLot.getClassesName() + dsSlPdLot.getBreedName());

        String slCode = dsSlPdLot.getSlCode();
        String districtCode = slCode.substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_FIVE);
        BaseParam param = new BaseParam();
        param.setFilter("districtCode", districtCode);
        DsSlPdLot ds = this.findOne(SqlId.SQL_ID_FIND_LGCS_INFO, param);
        // 区域编码
        if (ds == null) {
            dsSlPdLot.setLgcsCode("01");
            dsSlPdLot.setLgcsName("上海");
            dsSlPdLot.setProdcingarea("上海浦东新区");
            dsSlPdLot.setOrigin("上海浦东新区");
        } else {
            dsSlPdLot.setLgcsCode(ds.getLgcsCode());
            dsSlPdLot.setLgcsName(ds.getLgcsName());
            // 原产地
            dsSlPdLot.setProdcingarea(ds.getProdcingarea());
            // 产地
            dsSlPdLot.setOrigin(ds.getProdcingarea());
        }

        dsSlPdLot.setPdStatus("上线");

        dsSlPdLot.setDateCode(cycle.getCycleCode());
        dsSlPdLot.setPdTime(DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, dateNow));

        param.setFilter("classesCode", dsSlPdLot.getClassesCode());
        param.setFilter("breedCode", dsSlPdLot.getBreedCode());
        param.setFilter("featureCode", dsSlPdLot.getFeatureCode());
        param.setFilter("normsCode", dsSlPdLot.getPkgCode());
        List<PdNormsStd> pdNormsStds = productLogic.findPdNormsStd(param);
        if (!CollectionUtils.isEmpty(pdNormsStds)) {
            PdNormsStd nr = pdNormsStds.get(0);
            // 净重
            dsSlPdLot.setNetweight(nr.getNormsSuttle());
            // 外包装规格
            dsSlPdLot.setPkgSpec(nr.getNormsOut());
            dsSlPdLot.setPkgWay("箱装");
        }
        dsSlPdLot.setShelfLife("一个月");
        dsSlPdLot.setDelFlg("0");
        dsSlPdLot.setCrtId("admin");
        dsSlPdLot.setCrtTime(DateTimeUtil.getCustomerDate());
        dsSlPdLot.setUpdId("admin");
        dsSlPdLot.setUpdTime(DateTimeUtil.getCustomerDate());
        dsSlPdLot.setActId("admin");
        dsSlPdLot.setActTime(DateTimeUtil.getCustomerDate());
        dsSlPdLot.setVer(NumberConst.IntDef.INT_ONE);
    }
}
