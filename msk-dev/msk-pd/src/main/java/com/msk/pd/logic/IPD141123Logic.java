package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.PdStandard;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.IPD141146RsParam;
import com.msk.pd.bean.IPD141123RsParam;
import com.msk.pd.bean.IPD141123RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by FjM on 2016/3/14.
 */
@Service
public class IPD141123Logic extends BaseLogic{

    interface SqlId {
        String SQL_ID_FINDPDSTANDARD = "findPdStandard";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public List<IPD141123RsResult> selectSource(RsRequest<IPD141123RsParam> param){

        //创建输入对象
        IPD141123RsParam ipd141123RsParam = param.getParam();
        //创建输出对象
        /*IPD141124RsResult ss = new IPD141124RsResult();*/

        //开始查询
        BaseParam baseParam = new BaseParam();

        baseParam.setFilter("classestreeCode", StringUtil.toSafeString(ipd141123RsParam.getClassesCode() + ipd141123RsParam.getMachiningCode() + ipd141123RsParam.getBreedCode()));

        //去pd_standard表里面查出STANDARD_ID

        PdStandard s = super.findOne(SqlId.SQL_ID_FINDPDSTANDARD, baseParam);

        if (s ==null) throw new BusinessException("输入的参数有误,请核对后输入!(没有找到standardId!)");

        //根据STANDARD_ID去pd_fed_std和pd_fed_std_item里面查出数据

        baseParam.setFilter("standardId",s.getStandardId().toString());

        List<IPD141123RsResult> list = super.findList(baseParam);

        /*ss.setResultlist(list);*/

        return list;
    }


    public List<BaseEntity> selectSourceOrg(RsRequest<IPD141146RsParam> param){

        //创建输入对象
        IPD141146RsParam ipd141123RsParam = param.getParam();
        //创建输出对象
        /*IPD141124RsResult ss = new IPD141124RsResult();*/

        //开始查询
        BaseParam baseParam = new BaseParam();

        baseParam.setFilter("classestreeCode", StringUtil.toSafeString(ipd141123RsParam.getClassesCode() + ipd141123RsParam.getMachiningCode() + ipd141123RsParam.getBreedCode()));

        //去pd_standard表里面查出STANDARD_ID

        PdStandard s = super.findOne(SqlId.SQL_ID_FINDPDSTANDARD, baseParam);

        if (s ==null) throw new BusinessException("输入的参数有误,请核对后输入!(没有找到standardId!)");

        //根据STANDARD_ID去pd_fed_std和pd_fed_std_item里面查出数据

        baseParam.setFilter("standardId",s.getStandardId().toString());

        List<BaseEntity> list = super.findList(baseParam);

        /*ss.setResultlist(list);*/

        return list;
    }

}
