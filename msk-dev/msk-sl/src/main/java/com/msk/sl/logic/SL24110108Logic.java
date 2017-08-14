package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlEpManager;
import com.msk.sl.bean.SL24110306Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fjm on 2016/1/30.
 */
@Service
public class SL24110108Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface  Sql{
        String SQL_ID_MODIFY_ONE = "modifyOne";
        /**修改企业管理团队接口*/
        String SQL_ID_UPDATE_SL_EPMANAGER = "updateSlEpManager";
        String SQL_ID_DELETE_MA = "deleteMa";
        /**删除企业管理团队接口*/
        String SQL_ID_DELETE_Sl_Ep_Manager = "deleteSlEpManager";
        String SQL_ID_FIND_ENTITY="findEntity";
    }

    /**
     * 查询要删除的人员的职位，好确定删除文件服务器上哪一张图片
     * @param sl24110306Bean 传入对象
     */
    public SL24110306Bean findEntity(SL24110306Bean sl24110306Bean) {
        BaseParam base = new BaseParam();
        base.setFilter("epId",sl24110306Bean.getEpId().toString());
        base.setFilter("memberId",sl24110306Bean.getMemberId().toString());
       return super.findOne(Sql.SQL_ID_FIND_ENTITY,base);
    }


    public int removeMa(SL24110306Bean sL24110306Bean){
        return super.remove(Sql.SQL_ID_DELETE_MA,sL24110306Bean);
    }
    /**删除企业管理团队接口*/
    public int removeSlEpManagerPort(SL24110306Bean sL24110306Bean){
        return super.remove(Sql.SQL_ID_DELETE_Sl_Ep_Manager,sL24110306Bean);
    }

    public int update(SL24110306Bean sL24110306Bean){
        return super.modify(Sql.SQL_ID_MODIFY_ONE,sL24110306Bean);
    }

    /**"修改企业管理团队接口*/
    public int updateSlEpManagerPort(SlEpManager slEpManager){
        return super.modify(Sql.SQL_ID_UPDATE_SL_EPMANAGER,slEpManager);
    }
}
