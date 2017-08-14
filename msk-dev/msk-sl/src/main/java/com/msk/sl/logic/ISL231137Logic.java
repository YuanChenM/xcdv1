package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.SlSeller;
import com.msk.sl.bean.ISL231137RsBean;
import com.msk.sl.bean.ISL231137RsParam;
import com.msk.sl.bean.SlSellerBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by gyh on 2016/3/17.
 */
public class ISL231137Logic extends BaseLogic {

    /**
     * 查询卖家生产商信息
     * @param param 参数
     * @return 生产商信息
     */
    public List<ISL231137RsBean> search(ISL231137RsParam param) {
        param.setFlag("1");
        List<ISL231137RsBean> auths2=this.findList(SqlId.SQL_ID_FIND_SEARCH_BY_FLG, param);
        param.setFlag("2");
        List<ISL231137RsBean> auths3=this.findList(SqlId.SQL_ID_FIND_SEARCH_BY_FLG, param);
        auths2.addAll(auths3);
        SlSellerBean slSeller=searchSelfFlg(param);
        ISL231137RsBean isl231137RsBean=new ISL231137RsBean();
        if(null!=slSeller && slSeller.getSelfFlg().equals("1")){
            isl231137RsBean.setSlCode(slSeller.getSlCode());
            isl231137RsBean.setProducerEpId(slSeller.getEpId());
            isl231137RsBean.setProducerEpName(slSeller.getEpName());
        }
        auths2.add(isl231137RsBean);
        return auths2;
    }

    /**
     * 查询是否是自产商
     * @param param 参数
     * @return 生产商信息
     */
    public SlSellerBean searchSelfFlg(ISL231137RsParam param) {
        SlSellerBean slSeller=this.findOne(SqlId.SQL_ID_FIND_SEACHSELFFLG, param);
        return slSeller;
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_FIND_SEARCH_BY_FLG = "searchByFlg";
        static final String SQL_ID_FIND_SEACHSELFFLG = "searchSelfFlg";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
