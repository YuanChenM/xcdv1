package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.SC183104Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * SC183104Logic.
 * @author fjm
 * @version 1.0
 **/
@Service
public class SC183104Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC183104Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_DELETE_ACLBEAN="deleteAclBean";

    }
    public int deleteBean(SC183104Bean sc183104Bean){
        return super.remove(SqlId.SQL_ID_DELETE_ACLBEAN,sc183104Bean);
    }

    /*public PageResult<SC183104Bean> findPageList(){
        PageResult<SC183104Bean> pageDs174105Bean=new PageResult<SC183104Bean>();
        List<SC183104Bean> dsList = new ArrayList<SC183104Bean>();
        SC183104Bean s1 = new SC183104Bean();
        SC183104Bean s2 = new SC183104Bean();

        s1.setActualFlowId(11L);

        s2.setOutSpec("02");
        s2.setNewActualNum(14L);
        s2.getAdjustDate();
        s2.setVer(2);

        dsList.add(s1);
        dsList.add(s2);

        pageDs174105Bean.setData(dsList);

        return pageDs174105Bean;
    }*/
}
