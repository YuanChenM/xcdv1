package com.msk.ds.logic;

import java.util.ArrayList;
import java.util.List;

import com.msk.core.entity.DsLotSerial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.ds.bean.DS174102Param;

/**
 * DS174102Logic.
 *
 * @author yuan_chen
 * @version 1.0
 **/
@Service
public class DS174102Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DS174102Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author yuan_chen
     */
    interface SqlId {
        static final String SQLID_MAX_ID = "selectMax";
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

    public int getMaxSerialId(DS174102Param param) {
        return super.getCount(SqlId.SQLID_MAX_ID, param);
    }

    /**
     * 批量插入
     *
     * @param param param
     * @return 插入影响行数
     */
    @Transactional
    public int batchSave(DS174102Param param) {
        logger.debug("批量插入");
        //插入数量计数器
        int resultNum = NumberConst.IntDef.INT_ZERO;

        //定义
        List<DsLotSerial> dsLotSerials = new ArrayList<DsLotSerial>();
        DsLotSerial dsLotSerial;

        //取得数据库重该批次的最大流水号
        int maxId = this.getMaxSerialId(param) + NumberConst.IntDef.INT_ONE;
        //需要生成数量
        int insertCount = StringUtil.toInteger(param.getLotNum());

        insertCount = insertCount + maxId;
        for (int i = maxId; i < insertCount; i++) {
            dsLotSerial = new DsLotSerial();
            dsLotSerial.setLotId(StringUtil.toLong(param.getLotId()));
            dsLotSerial.setSerialId(StringUtil.toSafeString(i));
            String lotCode = StringUtil.PadLeft(String.valueOf(i), NumberConst.IntDef.INT_FIVE,
                    String.valueOf(NumberConst.IntDef.INT_ZERO));
            dsLotSerial.setLotCode(param.getLotCode().concat(lotCode));
            dsLotSerial.setDelFlg("0");
            dsLotSerial.setCrtId("admin");
            dsLotSerial.setCrtTime(DateTimeUtil.getCustomerDate());
            dsLotSerial.setUpdId("admin");
            dsLotSerial.setUpdTime(DateTimeUtil.getCustomerDate());
            dsLotSerial.setActId("admin");
            dsLotSerial.setActTime(DateTimeUtil.getCustomerDate());
            dsLotSerial.setVer(NumberConst.IntDef.INT_ONE);
            dsLotSerials.add(dsLotSerial);

            //性能改善, 每当list中有100条数据,则批量插入一次
            if (i % NumberConst.IntDef.INT_HUNDRED == NumberConst.IntDef.INT_ZERO) {
                //纪录更新数量
                resultNum += super.batchSave(dsLotSerials);
                //更新完清空list
                dsLotSerials = new ArrayList<DsLotSerial>();
            }
        }
        //若list中还有剩余,则批量继续插入
        if (dsLotSerials.size() > NumberConst.IntDef.INT_ZERO) {
            resultNum += super.batchSave(dsLotSerials);
        }
        //返回更新总数量
        return resultNum;
    }
}
