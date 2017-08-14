package com.msk.bs.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.MdCity;
import com.msk.core.entity.MdProvince;
import com.msk.core.entity.SlHouseAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 买手店管家会员列表
 *
 * @author cx
 */
@Service
public class BS2101107Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        String SQL_ID_FINDPROVINCECODE = "findProvinceCode";
        String SQL_ID_FINDCITYCODE = "findCityCode";
        String SQL_ID_FINDSAVEDATA = "findSaveData";
    }

    /**
     * 根据市ID查询市
     * @param cityCode 市Code
     * @return MdCity
     */
    public MdCity findCity(String cityCode) {
        BaseParam base = new BaseParam();
        base.setFilter("cityCode",cityCode);
        return super.findOne(SqlId.SQL_ID_FINDCITYCODE,base);
    }

    /**根据省ID查询省*/
    public MdProvince findProvince(String provinceCode) {
        BaseParam base = new BaseParam();
        base.setFilter("provinceCode",provinceCode);
        return super.findOne(SqlId.SQL_ID_FINDPROVINCECODE, base);
    }

    /**保存数据*/
    public int saveData(SlHouseAccount slHouseAccount) {
        return super.save(SqlId.SQL_ID_FINDSAVEDATA, slHouseAccount);
    }
}
