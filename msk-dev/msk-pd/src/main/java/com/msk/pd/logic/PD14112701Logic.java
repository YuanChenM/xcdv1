package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.PdTcMarket;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.PD141128Param;
import com.msk.pd.bean.PdTcOnlineOemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * PD141128Logic
 * @author pxg
 */
@Service
public class PD14112701Logic extends BaseLogic {

    /**
     * SQL Map 中SQL ID定义
     * @author pxg
     */
    interface SqlId {
        String SQL_ID_FIND_SAVE_ONLINEOEM = "findSaveOnlineOem";
        String SQL_ID_FIND_QUERY_ONLINEOEM = "findQueryOnlineOem";
    }

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 保存市场需求审核注册值
     * @return
     */
    public int saveOnlineOem(PdTcOnlineOemParam pdTcOnlineOemParam){
        Long tcOemId=commonLogic.maxId("pd_tc_online_oem", "TC_OEM_ID");
        String classesCode=null;
        String machiningCode=null;
        String breedCode=null;
        pdTcOnlineOemParam.setTcOemId(tcOemId);
        if(null!=pdTcOnlineOemParam){
            pdTcOnlineOemParam.setClassesCode(pdTcOnlineOemParam.getBreedCode().substring(0, 2));
            pdTcOnlineOemParam.setMachiningCode(pdTcOnlineOemParam.getBreedCode().substring(2, 3));
            pdTcOnlineOemParam.setBreedCode(pdTcOnlineOemParam.getBreedCode().substring(3, 5));
        }
        pdTcOnlineOemParam.setDelFlg("0");
        pdTcOnlineOemParam.setCrtTime(new Date());
        pdTcOnlineOemParam.setFeatureFlg(NumberConst.IntDef.INT_ZERO);
        int num=super.save(SqlId.SQL_ID_FIND_SAVE_ONLINEOEM, pdTcOnlineOemParam);
        return num;
    }

    /**
     * 查询数据是否已存在
     * @param pdTcOnlineOemParam pdTcOnlineOemParam
     * @return
     */
    public int queryOnlineOem(PdTcOnlineOemParam pdTcOnlineOemParam){
        BaseParam param=new BaseParam();
        String classesCode=null;
        String machiningCode=null;
        String breedCode=null;
        if(null!=pdTcOnlineOemParam){
            classesCode=pdTcOnlineOemParam.getBreedCode().substring(0, 2);
            machiningCode=pdTcOnlineOemParam.getBreedCode().substring(2, 3);
            breedCode=pdTcOnlineOemParam.getBreedCode().substring(3, 5);
        }
        param.setFilter("classesCode",classesCode);
        param.setFilter("machiningCode",machiningCode);
        param.setFilter("breedCode",breedCode);
        param.setFilter("featureName",pdTcOnlineOemParam.getFeatureName());
        param.setFilter("delFlg","0");
        return super.getCount(SqlId.SQL_ID_FIND_QUERY_ONLINEOEM,param);
    }

}
