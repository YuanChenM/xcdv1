package com.msk.sl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlDistReguSug;
import com.msk.core.entity.SlDistSugHis;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231201RsResult;
import com.msk.sl.bean.ISL231202RsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ISL231202Logic.
 *
 * @author gyh
 */
@Service
public class ISL231202Logic extends BaseLogic {
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
        static final String SQL_ID_ADD_SL_DIST_REGU_SUG = "addSlDistReguSug";
        static final String SQL_ID_ADD_SL_DIST_SUG_HIS = "addSlDistSugHis";
    }
    public RsResponse addSlDistSug(RsRequest<ISL231202RsParam> param){
        RsResponse rs=new RsResponse();
        for(SlDistReguSug slDistReguSug:param.getParam().getSlSugs()){
            //保存之前先移除
            super.remove(slDistReguSug);
            slDistReguSug.setCrtId(param.getLoginId());
            slDistReguSug.setVer(1);
            //保存到章程卖家意见表
            int result=super.save(SqlId.SQL_ID_ADD_SL_DIST_REGU_SUG,slDistReguSug);
            if(result>0){
                SlDistSugHis sug=new SlDistSugHis();
                sug.setCrtId(param.getLoginId());
                sug.setSlSugHisId(commonLogic.maxId("sl_dist_sug_his","SL_SUG_HIS_ID"));
                sug.setSlSug(slDistReguSug.getSlSug());
                sug.setChapId(slDistReguSug.getChapId());
                sug.setAgreeFlg(slDistReguSug.getAgreeFlg());
                sug.setChapClass(slDistReguSug.getChapClass());
                sug.setSlCode(slDistReguSug.getSlCode());
                //保存到章程卖家意见履历表
                int result1=super.save(SqlId.SQL_ID_ADD_SL_DIST_SUG_HIS,sug);
                if(result1<1){
                    rs.setStatus(BusinessConst.RsStatus.FAIL);
                    rs.setMessage("创建分销章程卖家意见失败！卖家编码为"+slDistReguSug.getSlCode()+"章节为"+slDistReguSug.getChapId());
                    return rs;
                }
            }else{
                rs.setStatus(BusinessConst.RsStatus.FAIL);
                rs.setMessage("创建分销章程卖家意见失败！卖家编码为"+slDistReguSug.getSlCode()+"章节为"+slDistReguSug.getChapId());
                return rs;
            }
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("创建分销章程卖家意见成功！");
        return rs;
    }
}
