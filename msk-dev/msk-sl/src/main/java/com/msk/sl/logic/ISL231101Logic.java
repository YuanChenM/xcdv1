package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.sl.bean.ISL231101RsParam;
import com.msk.sl.bean.ISL231101RsResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyh on 2016/1/14.
 */
public class ISL231101Logic extends BaseLogic {
    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
          static final String SQL_ID_FIND_SL_IFNO = "findSlInfo";
    }

    /**
     * 获得卖家信息（真数据）
     * @param param param
     * @return 卖家信息
     */
    public List<ISL231101RsResult> findSlInfo(ISL231101RsParam param){
        return this.findList(SqlId.SQL_ID_FIND_SL_IFNO, param);
    }
    /**
     * 获得卖家信息（假数据）
     * @return 卖家信息
     */
    public List<ISL231101RsResult> findSlInfo(){
        List<ISL231101RsResult> isl231101RsResults=new ArrayList<ISL231101RsResult>();
        ISL231101RsResult isl231101RsResult=new ISL231101RsResult();
        isl231101RsResult.setSlAccount("1");
        isl231101RsResult.setSlTel("13658796584");
        isl231101RsResult.setSlShowName("上海浦东新区公司");
        isl231101RsResult.setSlContact("李先生");
        isl231101RsResult.setAccountPsd("123");
        isl231101RsResult.setSlAreaCode("640507");
        isl231101RsResult.setEpId(1l);
        isl231101RsResult.setEpName("神农客");
        isl231101RsResults.add(isl231101RsResult);
        return isl231101RsResults;
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
