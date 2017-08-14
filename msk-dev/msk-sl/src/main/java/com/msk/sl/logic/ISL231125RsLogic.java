package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SlEnterprise;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.ISL231125RsParam;
import com.msk.sl.bean.ISL231125RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/15.
 */
@Service
public class ISL231125RsLogic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    /**
     *
     * SqlId.
     *
     * @author cx
     */
    interface SqlId {
        /** 查询所有企业基本资质 */
        static final String SQL_ID_FIND_ALL_SL_ENTERPRISE = "findAllSlEnterprise";
    }

    public ISL231125RsResult findAllList(RsRequest<ISL231125RsParam> param) {
        // 创建输入参数
        ISL231125RsParam iSL231125RsParam = param.getParam();
        // 创建输出参数
        ISL231125RsResult iSL231125RsResult = new ISL231125RsResult();
        BaseParam params = new BaseParam();
        params.setFilter("epId", StringUtil.toSafeString(iSL231125RsParam.getEpId()));
        params.setFilter("epName", StringUtil.toSafeString(iSL231125RsParam.getEpName()));
        List<SlEnterprise> slEnterpriseList = new ArrayList<SlEnterprise>();
        slEnterpriseList = super.findList(SqlId.SQL_ID_FIND_ALL_SL_ENTERPRISE,params);
        iSL231125RsResult.setEpInfoList(slEnterpriseList);
        return iSL231125RsResult;
    }
}
