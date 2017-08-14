package com.msk.bp.logic;

import com.msk.bp.bean.BP112214Bean;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.StringConst;
import com.msk.core.entity.PdBreed;
import com.msk.core.exception.BusinessException;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang_qiang1 on 2016/3/29.
 */
@Service
public class BP112214Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BP112214Logic.class);

    @Autowired
    private ProductLogic productLogic;

    /**
     *
     */
    private interface SqlId {
        String SQL_ID_FIND_ORDERLEVELLIST = "getOrderLevelList";
        String SQL_ID_FIND_SLCODE = "getSlCode";
        String SQL_ID_GET_BREEDPARAM="getBreedParam";
        String SQL_ID_GET_BREADS="getBreeds";
    }


    /**
     *  zhang_qiang1
     *  设置 产品参数
     * @param pageResult
     */
   public void  setProductPagram(PageResult<BP112214Bean> pageResult){
       List<BP112214Bean> bP112214BeanList=pageResult.getData();
       if(pageResult!=null&&bP112214BeanList.size()>0){
          for(BP112214Bean bean :bP112214BeanList){
              if(bean.getPdCode()!=null&&!"".equals(bean.getPdCode())){
                  ProductBean productBean= productLogic.getProductInfo(bean.getPdCode());
                  if (productBean == null) {
                      logger.info("产品编号:" + bean.getPdCode() + "没有相关产品");
                      throw new BusinessException("产品编号:" + bean.getPdCode() + "没有相关产品");
                  }
                  if(productBean.getPdBreed() != null){// 品名
                      bean.setPdName(productBean.getPdBreed().getBreedName());
                  }else {
                      bean.setPdName("");
                  }
                  if(productBean.getPdFeature() != null){// 规格
                      bean.setFeatureName(productBean.getPdFeature().getFeatureName());
                  }else{
                      bean.setFeatureName("");
                  }
                  if(productBean.getPdMachining() != null){// 配料
                      bean.setMachining(productBean.getPdMachining().getMachiningName());
                  }else {
                      bean.setMachining("");
                  }
                  if(productBean.getPdGrade() != null){// 产品等级
                      bean.setPdGrade(productBean.getPdGrade().getGradeName());
                  }else {
                      bean.setPdGrade("");
                  }

              }

          }
       }

   }


    public List<BP112214Bean> getOrderLevelList(BaseParam baseParam){
        List<BP112214Bean> list=new ArrayList<BP112214Bean>() ;
        list=this.findList(SqlId.SQL_ID_FIND_ORDERLEVELLIST,baseParam);
        return list;
    }


    /**
     * 通过登录用户的id  获取 sl_sell  中的sl_code
     * @param loginUserId
     * @return
     */
    public String getSlCode(String loginUserId){
        String slCode="";
        BasePageParam baseParam=new BasePageParam();
        baseParam.getFilterMap().put("SL_ACCOUNT",loginUserId);
        List<BP112214Bean> list=  this.findList(SqlId.SQL_ID_FIND_SLCODE,baseParam);
        if(list!=null){
            if(list.size()==1){
                slCode=list.get(0).getSlCode();
            }else if(list.size()>1){
                throw new BusinessException("一个用户的id  对应多个 sl_code");
            }
        }
        return slCode;
    }

    /**\
     * 通过品名  查询对应的 pd_breed 参数
     * @param breedName
     * @return
     */
    public String getBreedCodeP(String breedName){
        String breedCodeP="";
        if(breedName!=null&&! "".equals(breedName)){
           BasePageParam base=new BasePageParam();
            base.getFilterMap().put("breedName",breedName);
           List<PdBreed> pdBreeds=this.findList(SqlId.SQL_ID_GET_BREEDPARAM, base);
           if(pdBreeds!=null){
                if(pdBreeds.size()==1){
                    PdBreed breedBean=   pdBreeds.get(0);
                    breedCodeP=breedBean.getClassesCode()+breedBean.getMachiningCode()+breedBean.getBreedCode();
                }else if(pdBreeds.size()==0) {
                    breedCodeP="-1";//  从数据库中查询  但没有返回数据 说明 数据不存在
                }else if(pdBreeds.size()>1){
                    throw new BusinessException("pd_breed 表 存在重复名称，名称为："+breedName);
                }

            }
        }
        return  breedCodeP;
    }

    public List<BP112214Bean> getBreeds(String breedName){
            List<BP112214Bean> list=null;
            if(breedName!=null&&!"".equals(breedName)){
                list=new ArrayList<>();
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("breedName",breedName);
                list=this.findList(map, SqlId.SQL_ID_GET_BREADS);
            }

        return  list;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
