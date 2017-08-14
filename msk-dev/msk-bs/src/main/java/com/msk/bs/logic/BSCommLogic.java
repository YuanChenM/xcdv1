package com.msk.bs.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.MdArea;
import com.msk.core.entity.MdCity;
import com.msk.core.entity.MdDistrict;
import com.msk.core.entity.MdProvince;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2016/3/31.
 */
public class BSCommLogic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        static final String SQL_ID_FIND_MDPROVINCE= "findMdProvince";
        static final String SQL_ID_FIND_MDCITY= "findMdCity";
        static final String SQL_ID_FIND_MDDISTRICT= "findMdDistrict";
        static final String SQL_ID_FINDPROVINCECODE = "findProvinceCode";
        static final String SQL_ID_FINDMDAREA = "findMdArea";
        static final String SQL_ID_FINDCITYCODE = "findCityCode";
    }
    /**
     * 查询全部省份，用于联动
     * @param baseParam 参数为空
     * @return 返回省全部
     */
    public List<MdProvince> findMdProvinces(BaseParam baseParam) {
        List<MdProvince> list = super.findList(SqlId.SQL_ID_FIND_MDPROVINCE,baseParam);
        return list;
    }

    /**
     * 根据市ID查询所有的区县
     * @param cityId 市ID
     * @return 该市ID对应下的所有的区 县
     */
    public List<MdDistrict> findDistrictList(String cityId) {
        BaseParam base = new BaseParam();
        base.setFilter("cityId",cityId);
        return super.findList(SqlId.SQL_ID_FIND_MDDISTRICT,base);
    }


    /**
     * 根据省ID查询地市全部，用于联动
     * @param provinceId 参数 省ID
     * @return 地市全部
     */
    public List<MdCity> findCityList(String provinceId) {
        BaseParam base= new BaseParam();
        base.setFilter("provinceId",provinceId);
        List<MdCity> list=super.findList(SqlId.SQL_ID_FIND_MDCITY,base);
        return list;
    }

    /**根据省ID查询省*/
    public MdProvince findProvince(String provinceCode) {
        BaseParam base = new BaseParam();
        base.setFilter("provinceCode",provinceCode);
        return super.findOne(SqlId.SQL_ID_FINDPROVINCECODE, base);
    }
    /**
     * 根据areaId 查询大区编码
     * @param areaId 大区ID
     * @return 返回大区编码
     */
    public String findAreaCode(Long areaId) {
        BaseParam base = new BaseParam();
        base.setFilter("areaId",areaId.toString());
        MdArea mdArea = super.findOne(SqlId.SQL_ID_FINDMDAREA,base);
        return mdArea.getAreaCode();
    }

    /**
     * 根据市cityCode查询市
     * @param cityCode 市Code
     * @return MdCity
     */
    public MdCity findCity(String cityCode) {
        BaseParam base = new BaseParam();
        base.setFilter("cityCode",cityCode);
        return super.findOne(SqlId.SQL_ID_FINDCITYCODE,base);
    }


}
