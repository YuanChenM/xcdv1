package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.PdStandard;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FjM on 2016/3/11.
 */
@Service
public class IPD141125Logic extends BaseLogic{
    interface SqlId {
        String SQL_ID_FINDPDSTANDARD = "findPdStandard";
        String SQL_ID_FINDFIRSTLEVEL = "findFirstLevel";
        String SQL_ID_FINDSECONDLEVEL = "findSecondLevel";
        String SQL_ID_FINDSECONDTREE = "findSecondTree";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public List<IPD141125RsResult> selectSource(RsRequest<IPD141125RsParam> param){

        //创建输入对象
        IPD141125RsParam ipd141125RsParam = param.getParam();
        //创建第二级小对象
        List<IPD141125Bean> gnqStdSublist = new ArrayList<IPD141125Bean>();
        //创建第一级大对象
        List<IPD141125RsResult> firstBeans = new ArrayList<IPD141125RsResult>();


        //开始查询
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("classestreeCode", StringUtil.toSafeString(ipd141125RsParam.getClassesCode() + ipd141125RsParam.getMachiningCode() + ipd141125RsParam.getBreedCode()));

        //去pd_standard表里面查出STANDARD_ID
        PdStandard s = super.findOne(SqlId.SQL_ID_FINDPDSTANDARD, baseParam);
        if (s ==null) throw new BusinessException("输入的参数有误,请核对后输入!(没有找到standardId!)");

        String standardId = s.getStandardId().toString();
        //去pd_fed_std和pd_fed_std_item里面查出第一级数据
        baseParam.setFilter("levelId", String.valueOf(NumberConst.IntDef.INT_ONE));

        firstBeans = super.findList(SqlId.SQL_ID_FINDFIRSTLEVEL,baseParam);

        int i = 0;

        //迭代第一级的集合，获得单个bean，设置单个bean的gnqStdSublist（第二级bean的集合）
        for(IPD141125RsResult firstBean : firstBeans){
            String parentId = firstBean.getGnqStdClaId();
            baseParam.setFilter("parentId",parentId);
            baseParam.setFilter("standardId",standardId);

            gnqStdSublist = super.findList(SqlId.SQL_ID_FINDSECONDLEVEL, baseParam);
            if(gnqStdSublist.size()!=0){
                i=i+1;
            }
            firstBean.setGnqStdSublist(gnqStdSublist);
        }

        if(i==0){
            throw new BusinessException("数据为空！");
        }
        return firstBeans;
    }

    public List<BaseEntity> selectSourceGnq(RsRequest<IPD141146RsParam> param){

        //创建输入对象
        IPD141146RsParam ipd141125RsParam = param.getParam();
        //创建第二级小对象
        List<IPD141125Bean> gnqStdSublist = new ArrayList<IPD141125Bean>();
        //创建第一级大对象
        List<IPD141125RsResult> firstBeans = new ArrayList<IPD141125RsResult>();
        List<BaseEntity> list = new ArrayList<BaseEntity>();

        //开始查询
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("classestreeCode", StringUtil.toSafeString(ipd141125RsParam.getClassesCode() + ipd141125RsParam.getMachiningCode() + ipd141125RsParam.getBreedCode()));

        //去pd_standard表里面查出STANDARD_ID
        PdStandard s = super.findOne(SqlId.SQL_ID_FINDPDSTANDARD, baseParam);
        if (s ==null) throw new BusinessException("输入的参数有误,请核对后输入!(没有找到standardId!)");

        String standardId = s.getStandardId().toString();
        //去pd_fed_std和pd_fed_std_item里面查出第一级数据
        baseParam.setFilter("levelId", String.valueOf(NumberConst.IntDef.INT_ONE));

        firstBeans = super.findList(SqlId.SQL_ID_FINDFIRSTLEVEL,baseParam);

        int i = 0;

        //迭代第一级的集合，获得单个bean，设置单个bean的gnqStdSublist（第二级bean的集合）
        for(IPD141125RsResult firstBean : firstBeans){
            String parentId = firstBean.getGnqStdClaId();
            baseParam.setFilter("parentId",parentId);
            baseParam.setFilter("standardId",standardId);

            gnqStdSublist = super.findList(SqlId.SQL_ID_FINDSECONDLEVEL, baseParam);
            if(gnqStdSublist.size()!=0){
                i=i+1;
            }
            firstBean.setGnqStdSublist(gnqStdSublist);
            list.add(firstBean);
        }

        if(i==0){
            throw new BusinessException("数据为空！");
        }
        return list;
    }



}
