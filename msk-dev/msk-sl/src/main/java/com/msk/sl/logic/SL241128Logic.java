package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.PdClassestree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * PD141101Logic
 * @author pxg
 */
@Service
public class SL241128Logic extends BaseLogic {

    /**
     * SQL Map 中SQL ID定义
     * @author pxg
     */
    interface SqlId {
        String SQL_ID_FIND_FIND_ONE_CLASS = "findOneClass";
        String SQL_ID_FIND_FIND_TWO_CLASS = "findTWOClass";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 获取第一级分类
     * @return
     */
    public List<PdClassestree> queryOneClassify(){
        BaseParam param=new BaseParam();
        param.setFilter("treeLevel","1");
        List<PdClassestree> list=new ArrayList<>();
        list=super.findList(SqlId.SQL_ID_FIND_FIND_ONE_CLASS,param);
        return list;
    }
    /**
     * 获取第二级分类
     * @return
     */
    public List<PdClassestree> queryTwoClassify(String treeLevel,String parentCode){
        BaseParam param=new BaseParam();
        param.setFilter("treeLevel",treeLevel);
        param.setFilter("parentCode",parentCode);
        List<PdClassestree> list=new ArrayList<>();
        list=super.findList(SqlId.SQL_ID_FIND_FIND_TWO_CLASS,param);
        return list;
    }

}
