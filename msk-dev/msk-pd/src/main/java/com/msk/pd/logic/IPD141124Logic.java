package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.PdStandard;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by air on 2016/3/10.
 */
@Service
public class IPD141124Logic extends BaseLogic{

    interface SqlId {
        String SQL_ID_FINDPDSTANDARD = "findPdStandard";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public List<PD141147Bean> selectSource(RsRequest<IPD141124RsParam> param){

        //创建输入对象
        IPD141124RsParam ipd141124RsParam = param.getParam();
        //创建输出对象
        /*IPD141124RsResult ss = new IPD141124RsResult();*/

        //开始查询
        BaseParam baseParam = new BaseParam();

        baseParam.setFilter("classestreeCode",StringUtil.toSafeString(ipd141124RsParam.getClassesCode()+ipd141124RsParam.getMachiningCode()+ipd141124RsParam.getBreedCode()));

        //去pd_standard表里面查出STANDARD_ID

        PdStandard s = super.findOne(SqlId.SQL_ID_FINDPDSTANDARD, baseParam);

        //根据STANDARD_ID去pd_fed_std和pd_fed_std_item里面查出数据

        baseParam.setFilter("standardId",s.getStandardId().toString());

        List<PD141147Bean> list = super.findList(baseParam);

        /*ss.setResultlist(list);*/

        return list;
    }

    public List<BaseEntity> selectSourceFed(RsRequest<IPD141146RsParam> param){

        //创建输入对象
        IPD141146RsParam ipd141124RsParam = param.getParam();
        //创建输出对象
        /*IPD141124RsResult ss = new IPD141124RsResult();*/

        //开始查询
        BaseParam baseParam = new BaseParam();

        baseParam.setFilter("classestreeCode",StringUtil.toSafeString(ipd141124RsParam.getClassesCode()+ipd141124RsParam.getMachiningCode()+ipd141124RsParam.getBreedCode()));

        //去pd_standard表里面查出STANDARD_ID

        PdStandard s = super.findOne(SqlId.SQL_ID_FINDPDSTANDARD, baseParam);

        //根据STANDARD_ID去pd_fed_std和pd_fed_std_item里面查出数据

        baseParam.setFilter("standardId",s.getStandardId().toString());

        List<BaseEntity> list = super.findList(baseParam);

        /*ss.setResultlist(list);*/

        return list;
    }


}
