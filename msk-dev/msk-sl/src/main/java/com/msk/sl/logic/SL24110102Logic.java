package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlEnterprise;
import com.msk.core.entity.SlSeller;
import com.msk.core.entity.SlSellerHis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fjm on 2016/1/28.
 */
@Service
public class SL24110102Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        String SQL_ID_MODIFY_EP = "modifyEp";
        String SQL_ID_MODIFY_SL = "modifySl";
        String SQL_ID_FINDSLSELLER="findSlSellerBySlCode";
        String SQL_ID_SAVE_HIS="saveHis";
    }

    /**保存履历*/
    public void saveHis(SlSellerHis slSellerHis) {
        super.save(SqlId.SQL_ID_SAVE_HIS,slSellerHis);
    }

        /**根据卖家编码查询卖家信息*/
    public SlSellerHis findSlSellerBySlCode(String slCode) {
        BaseParam base = new BaseParam();
        base.setFilter("slCode",slCode);
        return super.findOne(SqlId.SQL_ID_FINDSLSELLER,base);
    }

    @Transactional
    public int updateEp(SlEnterprise slEnterprise){

        return super.modify(SqlId.SQL_ID_MODIFY_EP, slEnterprise);
    }

    @Transactional
    public int updateSl(SlSeller slSeller){

        return super.modify(SqlId.SQL_ID_MODIFY_SL, slSeller);
    }

}
