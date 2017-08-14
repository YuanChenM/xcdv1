package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SlSeller;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.ISL23116601;
import com.msk.sl.bean.ISL231167RsParam;
import com.msk.sl.bean.ISL231168RsParam;
import com.msk.sl.bean.ISL231168RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cx on 2016/2/24.
 */
@Service
public class ISL231166RsLogic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        static final String SQL_ID_FIND_SL_PD_CLASSES_ALL = "findSLPdClassesAll";
    }

    /**
     * 增加卖家产品类别接口
     *
     * @param iSL23116601
     * @return
     */
    public int savaSLPdClasses(ISL23116601 iSL23116601) {
        return super.save(iSL23116601);
    }

    /**
     * 查询传过来的iscode是否存在sl_seller中
     *
     * @param baseParam
     * @return
     */
    public List<SlSeller> findIsCode(BaseParam baseParam) {
        return super.findList(baseParam);
    }

    /**
     * 增加卖家产品类别接口
     *
     * @param param
     * @return
     */
    public int removeSLPdClasses(RsRequest<ISL231167RsParam> param) {
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("slCode", StringUtil.toSafeString(param.getParam().getSlCode()));
        baseParam.setFilter("pdClassesCode", StringUtil.toSafeString(param.getParam().getPdClassesCode()));
        return super.remove(baseParam);
    }

    /**
     * 查询卖家产品类别接口
     *
     * @param param
     * @return
     */
    public ISL231168RsResult findSLPdClassesAllList(RsRequest<ISL231168RsParam> param){
        BaseParam baseParam = new BaseParam();
        ISL231168RsResult iSL231168RsResult = new ISL231168RsResult();
        baseParam.setFilter("slCode",StringUtil.toSafeString(param.getParam().getSlCode()));
        List<ISL23116601> list = super.findList(SqlId.SQL_ID_FIND_SL_PD_CLASSES_ALL,baseParam);
        iSL231168RsResult.setPdClassesCodeList(list);
        return iSL231168RsResult;
    }
}
