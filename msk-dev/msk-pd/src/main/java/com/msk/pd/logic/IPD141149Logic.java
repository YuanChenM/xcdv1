package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.PdAppScrollImg;
import com.msk.core.entity.PdAppScrollImgSetting;
import com.msk.pd.bean.IPD141146RsParam;
import com.msk.pd.bean.IPD141146RsResult;
import com.msk.pd.bean.IPD141149Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yang_chunyan on 2016/4/29.
 */
@Service
public class IPD141149Logic extends BaseLogic {

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
        static final String SQL_ID_QUERY_SCROLL_IMG = "queryScrollImg";
        static final String SQL_ID_QUERY_MODEL_HEIGHT = "queryModelHeight";

    }

    @Transactional(readOnly = true)
    public IPD141149Result queryScrollImgInfo(){
        IPD141149Result ipd141149Result = new IPD141149Result();
        PdAppScrollImgSetting  pdAppScrollImgSetting = new PdAppScrollImgSetting();
        List<PdAppScrollImg> list = new ArrayList<PdAppScrollImg>();
        pdAppScrollImgSetting = this.findOne(SqlId.SQL_ID_QUERY_MODEL_HEIGHT,new BaseParam());
        list = this.findList(SqlId.SQL_ID_QUERY_SCROLL_IMG,new BaseParam());
        ipd141149Result.setImgSetting(pdAppScrollImgSetting);
        ipd141149Result.setScrollImgs(list);
        return  ipd141149Result;
    }



}
