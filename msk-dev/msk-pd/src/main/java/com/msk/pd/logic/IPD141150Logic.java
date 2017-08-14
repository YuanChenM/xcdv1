package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.pd.bean.IPD141150Bean;
import com.msk.pd.bean.IPD141150Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ren_qiang on 2016/4/29.
 */
@Service
public class IPD141150Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * SQL Map 中SQL ID定义
     *
     * @author xhy
     */
    interface SqlId {
        static final String SQL_ID_QUERY_SCROLL_IMG_BY_PDCODE = "queryScrollImgByPdCode";

    }

    @Transactional(readOnly = true)
    public List<IPD141150Bean> queryScrollImgByPdCode(IPD141150Param param){
        List<IPD141150Bean> list = new ArrayList<IPD141150Bean>();
        list = this.findList(SqlId.SQL_ID_QUERY_SCROLL_IMG_BY_PDCODE, param);
        return  list;
    }



}
