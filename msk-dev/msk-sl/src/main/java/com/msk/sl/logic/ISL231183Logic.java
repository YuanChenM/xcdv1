package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.SlAccount;
import com.msk.sl.bean.ISL231183RsParam;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gyh on 2016/3/18.
 */
public class ISL231183Logic extends BaseLogic {
    /**
     * 卖家账号密码修改
     *
     * @param param
     * @return
     */
    public String psdUpdate(ISL231183RsParam param) {
        String message="";
        SlAccount account=this.findOne(SqlId.SQL_ID_FIND_SL_ACCOUNT,param);
        if(account!=null){
            if(param.getOldAccountPsd().equals(account.getAccountPsd())){
                int rs=this.modify(SqlId.SQL_ID_UPD_ACCOUNT_PSD,param);
                if(rs<1){
                    message="卖家账号为"+param.getSlAccount()+"，密码修改失败！";
                }else{
                    message="卖家账号密码修改成功！";
                }
            }else{
                message="卖家账号为"+param.getSlAccount()+"，旧密码错误！";
            }
        }else{
            message="卖家账号"+param.getSlAccount()+"不存在！";
        }
        return message;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SQL ID
     */
    interface SqlId {
        String SQL_ID_FIND_SL_ACCOUNT = "findSlAccount";
        String SQL_ID_UPD_ACCOUNT_PSD = "updAccountPsd";
    }
}
