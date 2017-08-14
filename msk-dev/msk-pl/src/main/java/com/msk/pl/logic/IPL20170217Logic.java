package com.msk.pl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.pl.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyh on 2017/2/7.
 * 合伙人进货单查看接口
 */
@Service
public class IPL20170217Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private CommonLogic commonLogic;
    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_FIND_VALID = "findValid";
        static final String SQL_ID_MODIFY_TASK = "modifyTask";
    }
    /**
     * 合伙人进货单分页查看
     * @param param 参数
     * @return 结果
     */
    public IPL20170217RsResult plInfoList(IPL20170217RsParam param){
        IPL20170217RsResult rsResult=new IPL20170217RsResult();
        List<IPL20170217RsResultBean> plInfoList=new ArrayList<IPL20170217RsResultBean>();
        rsResult.setTotalCount(this.getPageCount(param));
        rsResult.setPageNo(param.getPageNo());
        if (rsResult.getTotalCount() != NumberConst.IntDef.INT_ZERO) {
            plInfoList = super.findList(param);
            rsResult.setTotalPage(rsResult.getTotalCount(), param.getPageCount());
        }
        rsResult.setPlInfoList(plInfoList);
        return rsResult;
    }

    /**
     * 合伙人任务审核接口
     * @param plInfo 参数
     * @return 结果
     */
    public int modifyPlInfo(PLInfo plInfo){
        //修改进货单审核状态
        int rs= this.modify(plInfo);
        //检查进货单对应任务单下有效的进货单数量是否超过填报次数，没有超过改任务单为未完成，否则不做修改
        //1、查询任务单
        BaseParam param=new BaseParam();
        param.getFilterMap().put("plId", plInfo.getPlId());
        PlBsTask bsTask=this.findOne(param);
        //2、查询任务单下的有效进货单数
        if(bsTask!=null){
            param.getFilterMap().put("taskId",bsTask.getTaskId());
        }
        IPL20170221RsResultBean bean=this.findOne(SqlId.SQL_ID_FIND_VALID,param);
        //比较，并修改任务单状态
        if(bean!=null){
            if(bean.getValidInfo()<bsTask.getNeedRecordNumber()){
                bsTask.setStatus(0);
            }else{
                bsTask.setStatus(1);
            }
            bsTask.setAlreadyRecordNumber(bean.getValidInfo());
            bsTask.setUpdId(plInfo.getUpdId());
            this.modify(SqlId.SQL_ID_MODIFY_TASK,bsTask);
        }
        return rs;
    }
}
