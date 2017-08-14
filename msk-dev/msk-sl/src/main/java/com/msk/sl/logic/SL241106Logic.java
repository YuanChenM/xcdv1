package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.SlPdPkg;
import com.msk.core.entity.SlProduct;
import com.msk.sl.bean.ISL231109RsSlPdPkg;
import com.msk.sl.bean.SL24110502Bean;
import com.msk.sl.bean.SL241105Bean;
import com.msk.sl.bean.SL241106Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * SL241105Logic
 *
 * @author GYH
 * @version 1.0
 */
@Service
public class SL241106Logic extends BaseLogic {
    private static Logger logger = LoggerFactory.getLogger(SL241106Logic.class);
    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_MODIFY_AUDIT_RESULT = "modifyAuditResult";
        static final String SQL_ID_MODIFY_MONITOR_RESULT = "modifyMonitorResult";
        static final String SQL_ID_GET_PD_PKG_COUNT = "getCount";
        static final String SQL_ID_FIND_SL_PD_PKG_INFO = "findSlPdPkgInfo";
    }

    /**
     * 查询卖家产品包装信息
     * @param param 参数
     * @return 结果
     */
    public List<ISL231109RsSlPdPkg> findSlPdPkgInfo(BaseParam param){
        return super.findList(SqlId.SQL_ID_FIND_SL_PD_PKG_INFO,param);
    }

    /**
     * 查询卖家产品包装记录数
     * @param param 参数
     * @return 结果
     */
    public Integer getCount(BaseParam param){
        return this.getCount(SqlId.SQL_ID_GET_PD_PKG_COUNT,param);
    }
    public PageResult<SL241106Bean> getInfo(){
        PageResult<SL241106Bean> pr=new PageResult<SL241106Bean>();
        pr.setRecordsTotal(5);
        List<SL241106Bean> sl241106Beans=new ArrayList<SL241106Bean>();
        SL241106Bean sl241106Bean=new SL241106Bean();
        sl241106Bean.setClassesName("鸡产品");
        sl241106Bean.setBreedName("单冻琵琶腿");
        sl241106Bean.setFeatureName("大边腿");
        sl241106Bean.setPkgCode("001");
        sl241106Bean.setEpName("莱阳春雪食品有限公司");
        sl241106Bean.setBrandName("金达客");
        sl241106Bean.setInSglNw("100g");
        sl241106Bean.setNormsSuttle("100g");
        sl241106Bean.setInSglNwRange("0.5-0.7");
        sl241106Bean.setNormsError("0.5-0.7");
        sl241106Bean.setNormsNumber("5");
        sl241106Bean.setInNumber("5");
        sl241106Bean.setNormsSize("10*5*20");
        sl241106Bean.setInSize("10*5*20");
        sl241106Bean.setNormsTexture("12*44g");
        sl241106Bean.setInMts("12*44g");
        sl241106Bean.setNormsOut("11*2g");
        sl241106Bean.setOutSpec("11*2g");
        sl241106Bean.setNormsKg("21");
        sl241106Bean.setOutGw("21");
        sl241106Bean.setNormsOutSize("43");
        sl241106Bean.setOutSize("43");
        sl241106Bean.setNormsOutTexture("21");
        sl241106Bean.setOutMts("21");
        sl241106Beans.add(sl241106Bean);
        pr.setData(sl241106Beans);
        return pr;
    }

    /**
     *  包装标准审核
     * @param slPdPkg slPdPkg
     * @return 结果
     */
    public int modifyAuditResult(SlPdPkg slPdPkg){
        return super.modify(SqlId.SQL_ID_MODIFY_AUDIT_RESULT,slPdPkg);
    }
    /**
     *  审核人审核
     * @param slPdPkg slPdPkg
     * @return 结果
     */
    public int modifyMonitorResult(SlPdPkg slPdPkg){
        return super.modify(SqlId.SQL_ID_MODIFY_MONITOR_RESULT,slPdPkg);
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}