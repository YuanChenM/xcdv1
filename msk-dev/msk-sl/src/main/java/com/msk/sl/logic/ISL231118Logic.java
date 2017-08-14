package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.SlProduct;
import com.msk.sl.bean.ISL231101RsParam;
import com.msk.sl.bean.ISL231101RsResult;
import com.msk.sl.bean.ISL231118RsParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyh on 2016/1/14.
 */
public class ISL231118Logic extends BaseLogic {
    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
          static final String SQL_ID_FIND_SL_PD_IFNO = "findSlPdInfo";
    }

    /**
     * 卖家能销售的产品信息（真数据）
     * @param param param
     * @return 卖家能销售的产品信息
     */
    public List<SlProduct> findSlPdInfo(ISL231118RsParam param){
        return this.findList(SqlId.SQL_ID_FIND_SL_PD_IFNO, param);
    }
    /**
     * 获得卖家能销售的产品信息（假数据）
     * @return 卖家能销售的产品信息
     */
    public List<SlProduct> findSlPdInfo(){
        List<SlProduct> slProducts=new ArrayList<SlProduct>();
        SlProduct slProduct=new SlProduct();
        slProduct.setSlCode("264050107");
        slProduct.setSlPdId(1);
        slProduct.setProdEpId(1);
        slProduct.setBrandEpId(1);
        slProduct.setPdClassesCode("01");
        slProduct.setPdBreedCode("03");
        slProduct.setPdFeatureCode("001");
        slProduct.setDistFlg("1");
        slProduct.setSlTncGradeCode(2);
        slProduct.setSlQltGradeCode(3);
        slProduct.setDelFlg("1");
        slProducts.add(slProduct);
        return slProducts;
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
