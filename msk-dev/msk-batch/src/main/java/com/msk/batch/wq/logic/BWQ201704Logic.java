package com.msk.batch.wq.logic;

import com.msk.batch.wq.bean.BWQ20170201Result;
import com.msk.batch.wq.bean.BWQ201702Result;
import com.msk.batch.wq.bean.BWQ201704Bean;
import com.msk.batch.wq.bean.SlBsAccountParam;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by air on 2017/1/23.
 */
public class BWQ201704Logic extends BaseLogic{

    private static Logger logger = LoggerFactory.getLogger(BWQ201701Logic.class);

    public interface SqlId {
        static final String SQLID_SELECT_TWOTABLEDATA = "queryTwoTableData";
        static final String SQLID_SELECT_CHECKNAME = "checkNameExist";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    public List<BWQ201704Bean> queryTwoBSTable(){
        BaseParam baseParam = new BaseParam();
        List<BWQ201704Bean> bwq201704BeanList = super.findList(SqlId.SQLID_SELECT_TWOTABLEDATA,baseParam);
        return bwq201704BeanList;
    }

    public BWQ201704Bean checkNameExist(String name){
        BaseParam param = new BaseParam();
        param.setFilter("empName",name);
        BWQ201704Bean namecheck = super.findOne(SqlId.SQLID_SELECT_CHECKNAME, param);
        return namecheck;
    }

    public void setExts(BWQ201702Result slBsAccountParam,String msCode,String msId){
        List listExt=new ArrayList();
        BWQ20170201Result bwq20170201Result=new BWQ20170201Result();
        bwq20170201Result.setExtKey("买手ID");
        bwq20170201Result.setExtValue(msId);

        BWQ20170201Result bwq20170201Result2=new BWQ20170201Result();
        bwq20170201Result2.setExtKey("买手编码");
        bwq20170201Result2.setExtValue(msCode);
        listExt.add(bwq20170201Result);
        listExt.add(bwq20170201Result2);
        slBsAccountParam.setExts(listExt);
    }

}
