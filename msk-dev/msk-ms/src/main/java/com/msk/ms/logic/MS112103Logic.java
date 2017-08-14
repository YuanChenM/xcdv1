/**
 * SO151503Logic.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.ms.bean.MS112103Bean;

/**
 * SO151503Logic.
 *
 * @author rwf
 */
@Service
public class MS112103Logic extends BaseLogic {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(MS112103Logic.class);

    /**
     * SqlId.
     * 
     * @author rwf
     */
    interface SqlId {
        String SQL_ID_SELECT_MSCARDNO = "msId";
    }

    /**
     * @param msCardId 会员卡ID
     * @return SO151503Bean 返回SO151503Bean对象
     * @author rwf
     */
    public MS112103Bean findSO151503Bean(String msCardId) {
        BaseParam param = new BaseParam();
        param.setFilter("msId", msCardId);
        MS112103Bean so  = super.findOne(SqlId.SQL_ID_SELECT_MSCARDNO, param);
        return so;
    }

    /**
     *
     *
     * @return SO151503Bean 对象
     * @author rwf
     */
    public MS112103Bean findSO151503Bean() {
        logger.info("假数据");
        MS112103Bean s = new MS112103Bean();
        s.setMsCardno("XXXXXXXXX000001");
        s.setBuyerCode("XXXXXXXXX000001");
        s.setBuyerName("张三");
        s.setIsActivate("是");
        s.setIsProvide("否");
        s.setProvideDate("2015-12-25");
        s.setPurchaseLot("20151224");
        return s;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
