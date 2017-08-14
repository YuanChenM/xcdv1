package com.msk.pl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.org.bean.result.BasePageResult;
import com.msk.pl.bean.*;
import com.msk.pl.util.beanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tao_zhifa on 2017/4/17.
 */
@Service
public class IPL20170405Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        static final String SQL_ID_FIND_PL_DECLARE_INFO_LIST = "plDeclareInfoList";
    }


    @Transactional
    public IPL20170405Result  plDeclareInfoPageList(IPL20170405Param ipl20170405Param) {
        IPL20170405Result result = new IPL20170405Result();
        if (ipl20170405Param.isPaging()) {
            ipl20170405Param.getStartPos();
        }
        List<PlDeclareInfo> list = super.findPageList(ipl20170405Param,result);
        result.setDtList(list);
        return result;
    }

    @Transactional(readOnly = true)
    public List<PlDeclareInfo> plDeclareInfoList(IPL20170406Param ipl20170406Param){
        List<PlDeclareInfo> plDeclareInfoList = findList(SqlId.SQL_ID_FIND_PL_DECLARE_INFO_LIST,ipl20170406Param);
        return plDeclareInfoList;
    }

    @Transactional
    public int savePlDeclareInfoPrice(RsRequest<IPL20170407Param> ipl20170407Param){
        int countAll = NumberConst.IntDef.INT_ZERO;
        for(IPL20170407Param param : ipl20170407Param.getParam().getDetailList()){
            param.setUpdId(ipl20170407Param.getLoginId());
            param.setUpdTime(DateTimeUtil.getCustomerDate());
            param.setBsCode(ipl20170407Param.getParam().getBsCode());
            param.setTaskId(ipl20170407Param.getParam().getTaskId());
            param.setPpId(ipl20170407Param.getParam().getPpId());
            int count = modify(param);
            countAll += count;
        }
        return countAll;
    }



}
