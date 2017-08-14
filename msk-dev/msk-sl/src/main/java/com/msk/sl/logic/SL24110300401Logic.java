package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlEpHonor;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/1/28.
 */
@Service
public class SL24110300401Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        static  final String SQL_ID_SAVE_SLEPHONOR = "saveSlEpHonor";
        static final String SQL_ID_SELECT_HONORDES="selectHonorDes";
    }

    /**
     * 保存企业荣誉信息
     * @param slEpHonor 企业荣誉数据
     * @param slEpId 企业ID
     */
    @Transactional
        public void saveSlEpHonor(SlEpHonor slEpHonor,Long slEpId) {
            slEpHonor.setEpId(slEpId);
            slEpHonor.setDelFlg("0");
            super.save(SqlId.SQL_ID_SAVE_SLEPHONOR,slEpHonor);
        }

    /**
     *  查询同意个企业中的荣誉描述是否有重复
     * @param slEpId 企业ID
     */
    public void findIfExistHonor(Long slEpId,String des) {
        BaseParam base = new BaseParam();
        base.setFilter("epId", StringUtil.toSafeString(slEpId));
        base.setFilter("honorDes",des);
        List<SlEpHonor> list= this.findList(SqlId.SQL_ID_SELECT_HONORDES,base);
        if(list.size()>0){
            throw  new BusinessException("录入了已经存在的企业荣誉");
        }
    }

}
