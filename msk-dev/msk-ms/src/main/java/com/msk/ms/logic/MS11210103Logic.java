package com.msk.ms.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.MsCardmanager;
import com.msk.ms.logic.MS11210102Logic.SqlId;
/**
 * excel下载
 * @author fjm
 *
 */
@Service
public class MS11210103Logic extends BaseLogic{
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }
    
    /**
     * 定义sql语句常量
     * @author fjm
     *
     */
    interface SqlId {
        String SQL_ID_SELECT_MSID = "findOne";
    }
    
    /**
     * 根据传入msId，查询出单个对象返回
     * @param msId 参数msId
     * @return MsCardmanager 返回对象
     */
    @Transactional(readOnly=true)
    public MsCardmanager mS11210103Entity(String msId) {
        BaseParam param = new BaseParam();
        param.setFilter("msId", msId);
        MsCardmanager msCardmanager = super.findOne(SqlId.SQL_ID_SELECT_MSID, param);
        return msCardmanager;
    }
  
}
