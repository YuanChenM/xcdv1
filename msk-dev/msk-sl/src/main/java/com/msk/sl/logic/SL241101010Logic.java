package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.SlEpAgentAuthBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SL241101010Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_UPDATE_AGENT_DATA = "updateAgentData";
        String SQL_ID_UPDATE_OEM_DATA = "updateOemData";
        String SQL_ID_DELETE_AGENT_DATA = "deleteAgentData";
        String SQL_ID_DELETE_OEM_DATA = "deleteOemData";
    }

    //保存数据
    public int saveData(SlEpAgentAuthBean slEpAgentAuthBean) {
        BaseParam param = new BaseParam();
        int count=0;
        if(null!=slEpAgentAuthBean){
            //判断是生产商添加还是OEM添加
            if(NumberConst.IntDef.INT_ONE==slEpAgentAuthBean.getMarkFlg()){
                count=super.modify(SqlId.SQL_ID_UPDATE_AGENT_DATA, slEpAgentAuthBean);
            }else if(NumberConst.IntDef.INT_TWO==slEpAgentAuthBean.getMarkFlg()){
                count=super.modify(SqlId.SQL_ID_UPDATE_OEM_DATA, slEpAgentAuthBean);
            }
        }
        return count;
    }

    //删除数据
    public int deleteData(String slCode,String epId,String markFlg) {
        BaseParam param = new BaseParam();
        int count=0;
            param.setFilter("slCode",slCode);
            param.setFilter("epId",epId);
            param.setFilter("delFlg","1");
            //判断是生产商添加还是OEM添加
            if("1".equals(markFlg)){
                count=super.modify(SqlId.SQL_ID_DELETE_AGENT_DATA, param);
            }else if("2".equals(markFlg)){
                count=super.modify(SqlId.SQL_ID_DELETE_OEM_DATA, param);
            }
        return count;
    }
}