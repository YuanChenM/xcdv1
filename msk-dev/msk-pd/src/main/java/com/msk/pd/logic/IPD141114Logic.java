package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.pd.bean.IPD14111401RsResult;
import com.msk.pd.bean.IPD141114RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author  rwf
 * Created by Administrator on 2016/1/26.
 */
@Service
public class IPD141114Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    /**
     * 查询物流区sqlId
     */
    interface SqlId {
        static final String SQL_ID_FIND_ALL_LOGIAREA_INFO = "findAllLogiarea";
    }
    /**
     * @return IPD141114RsResult 返回物流区集合
     * 查询数据库中所有的物流区编号和物流区名称
     */
    @Transactional(readOnly = true)
    public IPD141114RsResult findAllRecordList() {
        IPD141114RsResult ipd141114RsResult= new IPD141114RsResult();
        List<IPD14111401RsResult> list=super.findList(SqlId.SQL_ID_FIND_ALL_LOGIAREA_INFO,null);
        ipd141114RsResult.setLogiAreaList(list);
        return ipd141114RsResult;
    }
}
