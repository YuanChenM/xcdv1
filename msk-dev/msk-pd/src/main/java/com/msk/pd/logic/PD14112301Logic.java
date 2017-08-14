package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.PdMachining;
import com.msk.core.exception.BusinessException;
import com.msk.pd.bean.PD141123Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * PD14112301Logic
 *
 * @author xhy
 */

@Service
public class PD14112301Logic extends BaseLogic {

    @Autowired
    private CommonLogic commonLogic;

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(PD14112301Logic.class);



    /**
     * SQL Map 中SQL ID定义
     *
     * @author xhy
     */
    interface SqlId {
        static final String SQL_ID_SAVE_PD_MACHININGREF = "saveMacRef"; // 保存对照表中数据
        static final String SQL_ID_SAVE_PD_MACHINING = "saveMac"; // 保存加工度表数据
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public int saveMacANDMacRef(String classesCode, String machiningName) {


        PD141123Bean bean = new PD141123Bean();
        bean.setMachiningName(machiningName);
        //获取单个类别中的加工最大值
        Long maxId = commonLogic.maxId("PD_MACHININGREF", "MACHINING_CODE");
        bean.setMachiningCode(maxId.toString());
        bean.setClassesCode(classesCode);

        BaseParam param = new BaseParam();
        param.setFilter("machiningName",machiningName);
        param.setFilter("classesCode",classesCode);
        PD141123Bean findBean = this.findOne(param);
        if (findBean!=null) throw new BusinessException("该条数据已经存在!");

        Long macRefMaxId =  this.commonLogic.maxId("PD_MACHININGREF","MACHININGREF_ID");
        bean.setMachiningRefId(macRefMaxId.toString());
        int saveMacRef = this.save(SqlId.SQL_ID_SAVE_PD_MACHININGREF, bean);
        if(saveMacRef<= NumberConst.IntDef.INT_ZERO) throw new BusinessException("插入数据失败!请联系管理员");
        return saveMacRef;
    }

    /**
     * 修改加工类别数据
     * @param bean
     * @return int
     */

    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public int modifyMacRef(PD141123Bean bean) {
        BaseParam param1 = new BaseParam();
        param1.setFilter("machiningName",bean.getMachiningName());
        param1.setFilter("classesCode",bean.getClassesCode());
        PD141123Bean findBean = this.findOne(param1);
        if (findBean!=null) throw new BusinessException("该条数据已经存在!");
        BaseParam param = new BaseParam();
        param.setFilter("machiningName",bean.getMachiningName());
        param.setFilter("classesCode",bean.getClassesCode());
        param.setFilter("machiningRefId",bean.getMachiningRefId());
        int modiOne = this.modify(param);
        if (modiOne<= NumberConst.IntDef.INT_ZERO) throw new BusinessException("修改失败!");
        return modiOne;
    }



}
