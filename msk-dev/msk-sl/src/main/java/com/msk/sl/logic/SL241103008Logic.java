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
public class SL241103008Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        String SQL_ID_SELECT_MID = "selectmaxmid";
        String SQL_ID_SELECT_MEMBERNAME = "selectmemberName";
        String SQL_ID_SAVE_MANAGER1 = "saveManager1";
        String SQL_ID_FIND_ONE1 = "findOne1";
    }
    //验证名字是否重复
    public SL24110306Bean checkMemberDuties(Long epId,String memberDuties){
        BaseParam param = new BaseParam();
        param.setFilter("memberDuties", memberDuties);
        param.setFilter("epId",epId.toString());
        SL24110306Bean s = super.findOne(SqlId.SQL_ID_SELECT_MEMBERNAME, param);
        return s;
    }


    //通过epid查找memberid,返回集合
    public SL24110306Bean maxManagerByEpId(Long epId){
        BaseParam param = new BaseParam();
        param.setFilter("epId", epId.toString());
        SL24110306Bean s = super.findOne(SqlId.SQL_ID_SELECT_MID, param);
        return s;
    }


    public int saveManager(SL24110306Bean sL24110306Bean){
        return super.save(sL24110306Bean);
    }
    //保存企业团队管理接口
    public int saveManagerPort(SlEpManager slEpManager){
        return super.save(SqlId.SQL_ID_SAVE_MANAGER1,slEpManager);
    }

    //查询企业id
    public SlEpManager findEpId1(BaseParam baseParam){
        return super.findOne(SqlId.SQL_ID_FIND_ONE1,baseParam);
    }

}
