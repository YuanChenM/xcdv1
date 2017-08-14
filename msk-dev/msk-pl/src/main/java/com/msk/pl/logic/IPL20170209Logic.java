package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.pl.bean.IPL20170209Param;
import com.msk.pl.bean.IPL20170209Result;
import com.msk.pl.bean.PLInfo;
import com.msk.pl.bean.PLInfoPd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xuhongyang on 2017/2/8.
 * 进货单产品保存接口
 */
@Service
public class IPL20170209Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    interface SqlId {
        static final String PL_SQL_ID_FIND_MAX_PD_ID = "findMaxPdId";
        static final String PL_SQL_ID_FIND_PL_INFO_STATUS = "findPlInfoStatus";
        static final String PL_SQL_ID_SAVE_PD_INFO = "savePdInfo";
        static final String PL_SQL_ID_MODIFY_PD_INFO = "modifyPdInfo";
        static final String PL_SQL_ID_MODIFY_PL_INFO = "modifyPlInfo";
        static final String PL_SQL_ID_MODIFY_PL_TASK = "modifyPlTask";
        static final String PL_SQL_ID_FIND_PD_EXIST = "findPdExist";
    }

    /**
     * 进货单产品新增
     *
     * @param param
     * @return int
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public IPL20170209Result savePlPdInfo(IPL20170209Param param) {
        //校验输入的产品名称是否存在
        String pdNameAndFea[] = param.getPdName().split(" ");
        if (pdNameAndFea.length == 1) {
            pdNameAndFea = param.getPdName().split("　");
        }
        for (int i = 0; i < pdNameAndFea.length; i++) {
            if (i == 0) {
                param.setFilter("pdName",pdNameAndFea[0].trim());
            } else if (i == 1) {
                param.setFilter("featureName", pdNameAndFea[1].trim());
            }
        }
        if(param.getPdNameType() == NumberConst.IntDef.INT_ZERO){
            //平台是否存在该名称产品
            PLInfoPd pdInfo = super.findOne(SqlId.PL_SQL_ID_FIND_PD_EXIST,param);
            if(pdInfo!=null){
                param.setPdCode(pdInfo.getPdCode());
            }else{
                throw new BusinessException("输入的产品在本平台中不存在,请修改后添加！");
            }
        }

        /*新增强制设置产品编码为null*/
        IPL20170209Result result = new IPL20170209Result();
        PLInfoPd pd =  super.findOne(SqlId.PL_SQL_ID_FIND_MAX_PD_ID,param);
        param.setPlPdId(pd.getPlPdId());
        super.save(SqlId.PL_SQL_ID_SAVE_PD_INFO, param);
        //查看当前进货单是否是生效状态
        PLInfo info = super.findOne(SqlId.PL_SQL_ID_FIND_PL_INFO_STATUS,param);
        if(null == info) throw new BusinessException("进货单数据异常，请联系管理员设置对应信息！");
        if(info.getStatus()!=1) {
            super.modify(SqlId.PL_SQL_ID_MODIFY_PL_INFO, param);
            //查询进货单状态后新增产品改变task每日任务表数据
            param.setFilter("taskId", info.getTaskId().toString());
            super.modify(SqlId.PL_SQL_ID_MODIFY_PL_TASK, param);
        }
        result.setPlPdId(pd.getPlPdId());
        return result;
    }

    /**
     * 进货单产品修改
     *
     * @param param
     * @return int
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public IPL20170209Result updatePlPdInfo(IPL20170209Param param) {
        IPL20170209Result result = new IPL20170209Result();
        super.modify(SqlId.PL_SQL_ID_MODIFY_PD_INFO, param);
        result.setPlPdId(param.getPlPdId());
        return result;
    }
}


