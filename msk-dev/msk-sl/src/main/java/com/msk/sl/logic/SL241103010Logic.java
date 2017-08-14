package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SlEcTeam;
import com.msk.core.entity.SlEpAgentAuth;
import com.msk.core.entity.SlEpOemAuth;
import com.msk.core.entity.SlSeller;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.ISL231145RsParam;
import com.msk.sl.bean.ISL231145RsResult;
import com.msk.sl.bean.SL241103070Bean;
import com.msk.sl.bean.SlEpAgentAuthBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class SL241103010Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_SAVE_AGENT_DATA = "saveAgentData";
        String SQL_ID_SAVE_OEM_DATA = "saveOemData";
        String SQL_ID_SAVE_FIND_QUERY_AGENT_DATA = "findQueryAgentData";
        String SQL_ID_SAVE_FIND_QUERY_OEM_DATA = "findQuerysaveOemData";
    }

    //保存数据
    public int saveData(String slcode,SlEpAgentAuthBean slEpAgentAuthBean) {
        BaseParam param = new BaseParam();
        int count=0;
        if(null!=slEpAgentAuthBean){
            param.setFilter("slCode",slcode);
            param.setFilter("producerEpId",StringUtil.toSafeString(slEpAgentAuthBean.getProducerEpId()));
            slEpAgentAuthBean.setSlCode(slcode);
            slEpAgentAuthBean.setDelFlg("0");
            //判断是生产商添加还是OEM添加
            if(NumberConst.IntDef.INT_ONE==slEpAgentAuthBean.getMarkFlg()){
                List<SlEpAgentAuthBean> agentNum=queryAgentData(param);
                if(CollectionUtils.isEmpty(agentNum) && agentNum.size()<=0){
                    count=super.save(SqlId.SQL_ID_SAVE_AGENT_DATA,slEpAgentAuthBean);
                }else{
                    throw new BusinessException("卖家ID为:"+slcode+"的,该生产商已存在");
                }
            }else if(NumberConst.IntDef.INT_TWO==slEpAgentAuthBean.getMarkFlg()){
                List<SlEpAgentAuthBean> agentNum=queryOemData(param);
                if(CollectionUtils.isEmpty(agentNum)&&agentNum.size()<=0){
                    count=super.save(SqlId.SQL_ID_SAVE_OEM_DATA,slEpAgentAuthBean);
                }else{
                    throw new BusinessException("卖家ID为:"+slcode+"的,该OEM商已存在");
                }
            }
        }
        return count;
    }

    //查询生产商
    public List<SlEpAgentAuthBean> queryAgentData(BaseParam param){
        return super.findList(SqlId.SQL_ID_SAVE_FIND_QUERY_AGENT_DATA, param);
    }

    //查询OEM
    public List<SlEpAgentAuthBean> queryOemData(BaseParam param){
        return super.findList(SqlId.SQL_ID_SAVE_FIND_QUERY_OEM_DATA, param);
    }
}