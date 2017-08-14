package com.msk.bs.logic;

import com.msk.bs.bean.IBS2101105RsParam;
import com.msk.bs.bean.IBS2101105RsResult;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsPageParam;
import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.SlHouseProduct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by gyh on 2016/3/17.
 */
public class IBS2101105RsLogic  extends BaseLogic {
    @Autowired
    private BS2101102Logic bS2101102Logic;
    /**
     * 查询冻品管家信息
     * @param param 参数
     * @return 结果
     */
    public List<IBS2101105RsResult> search(IBS2101105RsParam param){
        List<IBS2101105RsResult> rs=this.findList(SqlId.SQL_ID_FIND_HOUSE_ACCUNT,param);
        for(IBS2101105RsResult result:rs){
            param.setHouseCode(result.getHouseCode());
            param.setSlCode(result.getSlCode());
            //管家管理产品list
            List<SlHouseProduct> housePdList=this.findList(SqlId.SQL_ID_FIND_HOUSE_PRODUCT, param);
            result.setHousePdList(housePdList);
            //经营区域List
//            List<SlHouseArea> slAreaList=this.findList(SqlId.SQL_ID_FIND_HOUSE_AREA, param);
//            result.setSlAreaList(slAreaList);
        }
        return rs;
    }


    @Override
    public <T extends BaseEntity> List<T> findPageList(RsPageParam param,RsPageResult pageResult) {
        IBS2101105RsParam ibs2101105RsParam = (IBS2101105RsParam) param;
        if(param.getPageCount()==0||param.getPageNo()==0){
            param.setPaging(false);
        }else {
            param.setPaging(true);
        }
        param.setFilter("slCode",ibs2101105RsParam.getSlCode());
        param.setFilter("houseAccount",ibs2101105RsParam.getHouseAccount());
        param.setFilter("houseTel",ibs2101105RsParam.getHouseTel());
        param.setFilter("houseCode",ibs2101105RsParam.getHouseCode());
        param.setFilter("accountPsd",ibs2101105RsParam.getAccountPsd());
        param.setFilter("vprovinceCode",ibs2101105RsParam.getVprovinceCode());
        param.setFilter("vcityCode",ibs2101105RsParam.getVcityCode());
        param.setFilter("vdistrictCode",ibs2101105RsParam.getVdistrictCode());
        param.setFilter("vhouseAddress",ibs2101105RsParam.getVhouseAddress());
        param.setFilter("houseCategory",ibs2101105RsParam.getHouseCategory());
        param.setFilter("greade",ibs2101105RsParam.getGreade());
        param.setFilter("fromFlg",ibs2101105RsParam.getFromFlg());
        List<IBS2101105RsResult> rs= this.bS2101102Logic.findPageList(param,pageResult);
        for(IBS2101105RsResult result:rs){
            param.setFilter("houseCode",result.getHouseCode());
            //管家管理产品list
            List<SlHouseProduct> housePdList=this.findList(SqlId.SQL_ID_FIND_HOUSE_PRODUCT, param);
            result.setHousePdList(housePdList);
            //经营区域List
//            List<SlHouseArea> slAreaList=this.findList(SqlId.SQL_ID_FIND_HOUSE_AREA, param);
//            result.setSlAreaList(slAreaList);
        }
        return (List<T>) rs;
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    interface SqlId {
        /**
         * 查询冻品管家信息
         */
        static final String SQL_ID_FIND_HOUSE_ACCUNT = "findHouseAccunt";
        static final String SQL_ID_FIND_HOUSE_PRODUCT = "findHouseProduct";
        static final String SQL_ID_FIND_HOUSE_AREA = "findHouseArea";
    }
}
