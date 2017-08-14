package com.msk.sl.logic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.*;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.SL241118Bean;

/**
 * 卖家产品技术标准Logic
 *
 * @author gyh
 */

@Service
public class SL241118Logic extends BaseLogic {
    @Autowired
    private SL241117Logic sl241117Logic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_MODIFY_SL_PRODUCT = "modifySlProduct";
        final String SQL_ID_SAVE_NOT_AGREE = "saveNotAgree";
        static final String SQL_ID_FIND_SL_PD_MCT_STD_NEW = "findSlPdMctStdNew";
        static final String SQL_ID_GET_STD_INFO = "getMctStdInfo";

    }
    /**
     * 修改卖家产品信息的产品技术标准定级
     *
     * @param slProduct 参数
     * @return 结果
     */
    @Transactional(readOnly = false)
    public int modifySlProduct(SlProduct slProduct) {
        return super.modify(SqlId.SQL_ID_MODIFY_SL_PRODUCT, slProduct);
    }

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(SL241118Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    /**
     * 根据条件查询卖家该产品加工技术标准
     * @param param 卖家编码、卖家产品id、产品标准ID、产品标准项目ID
     * @return 结果
     */
    @Transactional(readOnly = true)
    public List<SlPdMctStdNew> findSlPdMctStdNew(BaseParam param){
        return this.findList(SqlId.SQL_ID_FIND_SL_PD_MCT_STD_NEW,param);
    }
    /**
     * 保存不同意数据到卖家产品技术标准不同意表中
     *
     * @param provider 参数
     * @return 结果
     */
    @Transactional(readOnly = false)
    public int saveNotAgree(PdMctStdDiscussProvider provider) {
        return this.save(SqlId.SQL_ID_SAVE_NOT_AGREE, provider);
    }
    /**
     * 取得加工技术标准详细页面数据
     *
     * @param param param
     * @return 加工技术标准数据
     * @author gyh
     */
    @Transactional(readOnly = true)
    public List<SL241118Bean> getMctStd(BaseParam param) {
        logger.debug("取得产品加工技术标准数据");
        List<PdStandard> pdStandards = sl241117Logic.findStandardInfo(param);
        if (CollectionUtils.isEmpty(pdStandards)||pdStandards.size()<1) {
            return null;
        }
        PdStandard pdStandard = pdStandards.get(0);
        param.setFilter("standardId", StringUtil.toSafeString(pdStandard.getStandardId()));
        param.setFilter("levelId","1");
        List<SL241118Bean> sl241118Beans = super.findList(SqlId.SQL_ID_GET_STD_INFO, param);
        for(SL241118Bean bean:sl241118Beans){
            if("0".equals(bean.getIsCatalog())){
                param.setFilter("levelId","2");
                List<SL241118Bean> beanList = super.findList(SqlId.SQL_ID_GET_STD_INFO, param);
                bean.setPdMctStds(beanList);
            }
        }
        return sl241118Beans;
    }

    /**
     * 添加卖家产品技术标准不同意信息
     * @param slPdQltStd 参数
     * @return 结果
     */
    @Transactional(readOnly = false)
    public int saveNotAgree(SlPdTncStdNew slPdQltStd){
        return super.save(SqlId.SQL_ID_SAVE_NOT_AGREE,slPdQltStd);
    }
}
