package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlEcTeam;
import com.msk.sl.bean.SL241103070Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fjm on 2016/1/31.
 */
@Service
public class SL24110109Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }


    interface Sql{
        String SQL_ID_MODIFY_ONE="modifyOne";
        String SQL_ID_DELETE_ETEAM="deleteETeam";
        String SQL_ID_UPDATE_SL_ECTEAM_PORT = "updateSLEcTeamPort";
        String SQL_ID_REMOVE_ETEAM_PORT = "removeETeamPort";
    }

    /**
     * 修改卖家电商团队接口
     * @param slEcTeam
     */
    public int updateSLEcTeamPort(SlEcTeam slEcTeam) {
        return  super.modify(Sql.SQL_ID_UPDATE_SL_ECTEAM_PORT,slEcTeam);
    }
    /**
     * 删除卖家电商团队接口
     * @param slEcTeam
     */
    public int removeETeamPort(SlEcTeam slEcTeam){
        return super.remove(Sql.SQL_ID_REMOVE_ETEAM_PORT,slEcTeam);
    }

    /**
     * 查询传入的iscode是否有对应的SlEcTeam存在接口
     * @param baseParam
     */
    public List<SlEcTeam> findSLEcTeamYesOrOn(BaseParam baseParam){
        return super.findList(baseParam);
    }

    public int removeETeam(SL241103070Bean sL241103070Bean){
        return super.remove(Sql.SQL_ID_DELETE_ETEAM,sL241103070Bean);
    }

    public int update(SL241103070Bean sL241103070Bean){
        return  super.modify(Sql.SQL_ID_MODIFY_ONE,sL241103070Bean);
    }
}
