package com.msk.ds.logic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.DsSlPdLot;
import com.msk.core.entity.MdLogisticsArea;

/**
 * DS174101Logic.
 *
 * @author yuan_chen
 * @version 1.0
 **/
@Service
public class DS174101Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DS174101Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_FIND_LOGISTICS_AREA = "findLogisticsArea";
        static final String SQL_ID_REMOVE_SERIAL ="removeSerial";
    }
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
     * 删除批次流水
     * @param dsSlPdLot dsSlPdLot
     * @return 结果
     */
    @Transactional(readOnly = false)
    public int removeSerial(DsSlPdLot dsSlPdLot){
        return this.remove(SqlId.SQL_ID_REMOVE_SERIAL,dsSlPdLot);
    }

    /**
     * 取得产品编号(10位)
     * 
     * @param dsSlPdLot DsSlPdLot
     * @return 产品编号(10位)
     */
    public String getpdCode(DsSlPdLot dsSlPdLot) {
        logger.debug("取得批次号(前27位)");

        String pdCode = dsSlPdLot.getClassesCode();
        pdCode = pdCode.concat(dsSlPdLot.getBreedCode());
        pdCode = pdCode.concat(dsSlPdLot.getFeatureCode());
        pdCode = pdCode.concat(dsSlPdLot.getGradeCode());
        pdCode = pdCode.concat(dsSlPdLot.getPkgCode());
        return pdCode;
    }

    /**
     * 取得批次号(前27位)
     * 
     * @param dsSlPdLot DsSlPdLot
     * @return 批次号(前27位)
     */
    public String getLotCode(DsSlPdLot dsSlPdLot) {
        logger.debug("取得批次号(前27位)");

        String lotCode = this.getpdCode(dsSlPdLot);
        lotCode = lotCode.concat(dsSlPdLot.getSlCode());
        lotCode = lotCode.concat(dsSlPdLot.getLgcsCode());
        lotCode = lotCode.concat(dsSlPdLot.getDateCode());
        return lotCode;
    }

    /**
     * 获取区域信息
     * @return 区域
     */
    public List<MdLogisticsArea> findLogisticsArea(){
        return this.findList(SqlId.SQL_ID_FIND_LOGISTICS_AREA,null);
    }
}
