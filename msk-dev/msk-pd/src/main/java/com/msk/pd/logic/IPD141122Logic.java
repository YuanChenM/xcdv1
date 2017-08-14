package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.BaseEntity;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.IPD141146RsParam;
import com.msk.pd.bean.IPD141122RsParam;
import com.msk.pd.bean.IPD141122RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fjm on 2016/3/9.
 */
@Service
public class IPD141122Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public IPD141122RsResult selectSource(RsRequest<IPD141122RsParam> param){
        // 创建输入参数
        IPD141122RsParam ipd141122RsParam = param.getParam();

        //开始查询
        BaseParam params = new BaseParam();

        if(ipd141122RsParam.getBreedCode()=="" || ipd141122RsParam.getBreedCode()==null){
            String classestreeCode = ipd141122RsParam.getClassesCode()+ipd141122RsParam.getMachiningCode();
            params.setFilter("classestreeCode", StringUtil.toSafeString(classestreeCode));
        }else{
            String classestreeCode = ipd141122RsParam.getClassesCode()+ipd141122RsParam.getMachiningCode()+ipd141122RsParam.getBreedCode();
            params.setFilter("classestreeCode", StringUtil.toSafeString(classestreeCode));
        }

        IPD141122RsResult s = super.findOne(params);

        return s;
    }


    public List<BaseEntity> selectSourceMat(RsRequest<IPD141146RsParam> param){
        // 创建输入参数
        IPD141146RsParam ipd141122RsParam = param.getParam();
        List<BaseEntity> results = new ArrayList<>();

        //开始查询
        BaseParam params = new BaseParam();

        if(ipd141122RsParam.getBreedCode()=="" || ipd141122RsParam.getBreedCode()==null){
            String classestreeCode = ipd141122RsParam.getClassesCode()+ipd141122RsParam.getMachiningCode();
            params.setFilter("classestreeCode", StringUtil.toSafeString(classestreeCode));
        }else{
            String classestreeCode = ipd141122RsParam.getClassesCode()+ipd141122RsParam.getMachiningCode()+ipd141122RsParam.getBreedCode();
            params.setFilter("classestreeCode", StringUtil.toSafeString(classestreeCode));
        }

        IPD141122RsResult s = super.findOne(params);

        results.add(s);
        return results;
    }

}
