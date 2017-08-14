package com.msk.sl.logic;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlEpAgentAuth;
import com.msk.core.entity.SlEpBrand;
import com.msk.core.entity.SlPdBrand;
import com.msk.core.exception.BusinessException;
import com.msk.sl.bean.SL2411030033Bean;
import com.msk.sl.bean.SL2411030073Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fjm on 2016/2/2.
 */
@Service
public class SL2411030071Logic extends BaseLogic{
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        String SQL_ID_SAVEBR = "savebrand";
        String SQL_ID_SAVEHR = "savehonor";
        String SQL_ID_SELECT_BRAND = "maxBrand";
        String SQL_ID_SELECT_PDBRAND = "savepdbrand";
        String SQL_ID_SELECT_PROXYLIST = "selectProxyList";
        String SQL_ID_FIND_PD_BRAND="selectBrand";
        String SQL_ID_SAVESLBRAND="saveslbrand";
        String SQL_ID_SAVEAGENTAUTH="saveagent";
        String SQL_ID_SELECT_BRANDId="selectbrandid";
        String SQL_ID_SELECT_NAME = "selectbrandname";
        String SQL_ID_SELECT_SLPDBRAND = "selectPdBrand";
        String SQL_ID_FIND_SLEPAGENTAUTH="findSlEpAgentAuth";
    }

    public List<SlEpAgentAuth> findSlEpAgentAuth() {
        List<SlEpAgentAuth> list = super.findList(SqlId.SQL_ID_FIND_SLEPAGENTAUTH,new BaseParam());
        return list;
    }
    /**
     * 查询卖家品牌列表中是否已经存在了该品牌
     * @param sL2411030073Bean 参入参数
     * @return SlPdBrand
     */
    public SlPdBrand findSlPdBrand(SL2411030073Bean sL2411030073Bean) {
        BaseParam base= new BaseParam();
        base.setFilter("slCode",sL2411030073Bean.getSlCode());
        base.setFilter("brandEpId",sL2411030073Bean.getProducerEpId().toString());
        base.setFilter("brandId",sL2411030073Bean.getBrandId().toString());
        SlPdBrand slpdBrand=super.findOne(SqlId.SQL_ID_SELECT_SLPDBRAND,base);
        return slpdBrand;
    }
    //check品牌保存是否重复
    public List<SlEpBrand> checkBrand(String brandNo){
        BaseParam param = new BaseParam();
        param.setFilter("brandNo", brandNo);
        List<SlEpBrand> s = super.findList(SqlId.SQL_ID_SELECT_NAME, param);
        return s;
    }

    public List<SlPdBrand> findPdBrand(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_BRAND, param);
    }

    //给SL241103000页面初始化之后给SL241103007页面的第二个页面select回显使用
    public List<SL2411030073Bean> selectProxyList(String slCode){
        List<SL2411030073Bean> list = new ArrayList<SL2411030073Bean>();
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("slCode",slCode);
        list= super.findList(map,SqlId.SQL_ID_SELECT_PROXYLIST);
        return list;
    }
    //查询brandid根据brandname
    public SlPdBrand selectBrandId(String brandName,Long id){
        BaseParam param = new BaseParam();
        param.setFilter("brandName", brandName);
        param.setFilter("epId",id.toString());
        SlPdBrand slPdBrand = super.findOne(SqlId.SQL_ID_SELECT_BRANDId, param);
        return slPdBrand;
    }
    //品牌表里，根据epId查询当前epId中最大的brand_id值
    public SlEpBrand maxBrandByEpId(Long epId){
        BaseParam param = new BaseParam();
        param.setFilter("epId", epId.toString());
        SlEpBrand slEpBrand = super.findOne(SqlId.SQL_ID_SELECT_BRAND, param);
        return slEpBrand;
    }

    public int savePd(SL2411030073Bean sL2411030073Bean){
         int i =super.save(SqlId.SQL_ID_SELECT_PDBRAND,sL2411030073Bean);
        if(i==0){
            throw new BusinessException("插入卖家产品表数据失败");
        }
        return i;
    }
    public int saveBr(SL2411030073Bean sL2411030073Bean){
        return super.save(SqlId.SQL_ID_SAVEBR, sL2411030073Bean);
    }
    public int saveHr(SL2411030033Bean sL2411030033Bean){
        return super.save(SqlId.SQL_ID_SAVEHR, sL2411030033Bean);
    }
    public int saveSlBrand(SL2411030073Bean sl2411030073Bean){
        return super.save(SqlId.SQL_ID_SAVESLBRAND,sl2411030073Bean);
    }
    public int saveAgenAuth(SL2411030073Bean sl2411030073Bean){
        return  super.save(SqlId.SQL_ID_SAVEAGENTAUTH,sl2411030073Bean);
    }
}
