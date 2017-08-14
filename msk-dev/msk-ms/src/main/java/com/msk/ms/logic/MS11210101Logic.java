package com.msk.ms.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.MsCardmanager;

/**
 * @author fjm
 * @MS11210101Logic 业务逻辑层，处理会员卡信息编辑的弹窗页面MS11210101.jsp的初始化，修改等业务
 */
@Service
public class MS11210101Logic extends BaseLogic{
          
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
        String SQL_ID_SELECT_MSCARDNO = "findOne";
        String SQL_ID_MODIFY_ONE = "modifyOne";
    }
 
    
    /**
     * 查询相关对象
     * @param msId 参数
     * @return MsCardmanager 对象返回
     */
    @Transactional(readOnly=true)
    public MsCardmanager mS11210101Entity(String msId) {
        BaseParam param = new BaseParam();
        param.setFilter("msId", msId);
        MsCardmanager msCardmanager = super.findOne(SqlId.SQL_ID_SELECT_MSCARDNO, param);
        return msCardmanager;
    }
    
    /**
     * 根据传入的param，更新对象
     * @param msCardmanager 传入对象参数
     * @return 返回int
     */
    @Transactional
    public int modifyOne(MsCardmanager msCardmanager){
        return super.modify(SqlId.SQL_ID_MODIFY_ONE, msCardmanager);
    }
}
