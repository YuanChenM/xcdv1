package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.pd.bean.PdTcForbidParam;
import com.msk.pd.bean.PdTcOnlineOemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * PD141128Logic
 * @author pxg
 */
@Service
public class PD141129Logic extends BaseLogic {

    /**
     * SQL Map 中SQL ID定义
     * @author pxg
     */
    interface SqlId {
        String SQL_ID_FIND_SAVE_TCFORBID = "findSaveTcForBid";
        String SQL_ID_FIND_QUERY_TCFORBID = "findQueryTcForBid";
    }

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 保存禁止准入产品
     * @return
     */
    public int saveTcForbid(PdTcForbidParam pdTcForbidParam){
        Long tcOemId=commonLogic.maxId("pd_tc_forbid", "TC_FORBID_ID");
        String classesCode=null;
        String machiningCode=null;
        String breedCode=null;
        pdTcForbidParam.setTcForbidId(tcOemId);
        if(null!=pdTcForbidParam){
            pdTcForbidParam.setClassesCode(pdTcForbidParam.getBreedCode().substring(0, 2));
            pdTcForbidParam.setMachiningCode(pdTcForbidParam.getBreedCode().substring(2, 3));
            pdTcForbidParam.setBreedCode(pdTcForbidParam.getBreedCode().substring(3, 5));
        }
        pdTcForbidParam.setDelFlg("0");
        pdTcForbidParam.setCrtTime(new Date());
        pdTcForbidParam.setFeatureFlg(NumberConst.IntDef.INT_ZERO);
        int num=super.save(SqlId.SQL_ID_FIND_SAVE_TCFORBID, pdTcForbidParam);
        return num;
    }

    /**
     * 查询数据是否已存在
     * @param pdTcForbidParam pdTcForbidParam
     * @return
     */
    public int queryTcForbid(PdTcForbidParam pdTcForbidParam){
        BaseParam param=new BaseParam();
        String classesCode=null;
        String machiningCode=null;
        String breedCode=null;
        if(null!=pdTcForbidParam){
            classesCode=pdTcForbidParam.getBreedCode().substring(0, 2);
            machiningCode=pdTcForbidParam.getBreedCode().substring(2, 3);
            breedCode=pdTcForbidParam.getBreedCode().substring(3, 5);
        }
        param.setFilter("classesCode",classesCode);
        param.setFilter("machiningCode",machiningCode);
        param.setFilter("breedCode",breedCode);
        param.setFilter("featureName",pdTcForbidParam.getFeatureName());
        param.setFilter("delFlg","0");
        return super.getCount(SqlId.SQL_ID_FIND_QUERY_TCFORBID,param);
    }

}
