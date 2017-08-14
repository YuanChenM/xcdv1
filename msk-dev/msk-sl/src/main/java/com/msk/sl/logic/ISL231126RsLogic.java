package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.StringConst;
import com.msk.core.entity.SlMstCertItem;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.ISL231126RsParam;
import com.msk.sl.bean.ISL231126RsResult;
import com.msk.sl.bean.SlMstCert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/15.
 */
@Service
public class ISL231126RsLogic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SqlId.
     *
     * @author cx
     */
    interface SqlId {
        /**
         * 查询证照基础信息
         */
        static final String SQL_ID_FIND_ALL_SL_MSTCERT = "findAllSLMstCert";
        /**
         *  证照项目
         */
        static final String SQL_ID_FIND_ALL_SL_MSTCERTITEM = "findAllSlMstCertItem";
    }

    /**
     * 查询证照基础信息
     * @param param 参数
     * @return 结果
     */
    public List<ISL231126RsResult> search(ISL231126RsParam param) {
        if(param.getCertName()!=null){
            param.setCertName(StringConst.PRE + param.getCertName() + StringConst.PRE);
        }
        //证照信息List
        List<ISL231126RsResult> results = super.findList(SqlId.SQL_ID_FIND_ALL_SL_MSTCERT, param);
        for(ISL231126RsResult slMstCert:results){
            param.setCertId(slMstCert.getCertId());
            //证照项目List
            List<SlMstCertItem> certItemList = super.findList(SqlId.SQL_ID_FIND_ALL_SL_MSTCERTITEM, param);
            slMstCert.setCertItemList(certItemList);
        }
        return results;
    }
}
