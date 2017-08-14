package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.PdStandard;
import com.msk.core.entity.PdTncStdDiscussProvider;
import com.msk.core.entity.SlPdTncStdNew;
import com.msk.core.entity.SlProduct;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.SL241106Bean;
import com.msk.sl.bean.SL241116Bean;
import com.msk.sl.bean.SL241117Bean;
import com.msk.sl.bean.SlPdStdAgreeFlgBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 卖家产品加工质量标准Logic
 *
 * @author gyh
 */

@Service
public class SL241117Logic extends BaseLogic {


    @Autowired
    private Sl241116Logic sl241116Logic;
    @Autowired
    private SL241106Logic sl241106Logic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_GET_STD_INFO = "getTncStdInfo";
        static final String SQL_ID_FIND_STANDARD_INFO = "findStandardInfo";
        static final String SQL_ID_MODIFY_SL_PRODUCT = "modifySlProduct";
        static final String SQL_ID_SAVE_NOT_AGREE = "saveNotAgree";
        static final String SQL_ID_FIND_SL_PD_TNC_STD_NEW = "findSlPdTncStdNew";
        static final String SQL_ID_GET_MCT_COUNT = "getMctCount";
        static final String SQL_ID_GET_TNC_COUNT = "getTncCount";
        static final String SQL_ID_GET_STD_COUNT = "getStdCount";
    }

    /**
     * 加工技术标准同意信息
     *
     * @param param
     * @return 结果
     */
    public List<SlPdStdAgreeFlgBean> getMctCount(BaseParam param) {
        return this.findList(SqlId.SQL_ID_GET_MCT_COUNT, param);
    }

    /**
     * 加工质量标准同意信息
     *
     * @param param
     * @return 结果
     */
    public List<SlPdStdAgreeFlgBean> getTncCount(BaseParam param) {
        return this.findList(SqlId.SQL_ID_GET_TNC_COUNT, param);
    }

    /**
     * 其他标准同意信息
     *
     * @param param
     * @return 结果
     */
    public boolean getStdCount(BaseParam param) {
        //判断产品二级分类是否为白条
        if("1".equals(param.getFilterMap().get("machiningCode"))){
            param.setFilter("stdFlg", "1");
            if (this.getCount(SqlId.SQL_ID_GET_STD_COUNT, param) < 1) {
                return false;
            }
            param.setFilter("stdFlg", "2");
            if (this.getCount(SqlId.SQL_ID_GET_STD_COUNT, param) < 1) {
                return false;
            }
        }
        param.setFilter("stdFlg", "3");
        if (this.getCount(SqlId.SQL_ID_GET_STD_COUNT, param) < 1) {
            return false;
        }
        param.setFilter("stdFlg", "4");
        if (this.getCount(SqlId.SQL_ID_GET_STD_COUNT, param) < 1) {
            return false;
        }
        param.setFilter("stdFlg", "5");
        if (this.getCount(SqlId.SQL_ID_GET_STD_COUNT, param) < 1) {
            return false;
        }
        return true;
    }

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(SL241117Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 检查卖家产品加工技术标准、其他标准，包装标准是否符合要求
     *
     * @param param 参数
     * @return 结果
     */
    public String checkAgree(BasePageParam param) {
        //判断加工技术标准是否存在不同意
        List<SlPdStdAgreeFlgBean> agreeFlgBeans = this.getMctCount(param);
        if (!CollectionUtils.isEmpty(agreeFlgBeans) && agreeFlgBeans.size() > 0) {
            for (SlPdStdAgreeFlgBean bean : agreeFlgBeans) {
                //不同意
                if ("0".equals(bean.getAgreeFlg())) {
                    return "该卖家产品的加工技术标准存在不同意！请检查后提交";
                }
            }
        } else {
            return "该卖家产品的加工技术标准不存在！请检查后提交";
        }
        //加工技术标准全部同意
        //检查卖家产品加工技术标准定级是否为【合格】
        List<SL241116Bean> sl241116Beans = sl241116Logic.findSlProductList(param);
        if (!CollectionUtils.isEmpty(sl241116Beans) && sl241116Beans.size() > 0) {
            //不合格
            if (sl241116Beans.get(0).getSlQltGradeCode()!=2) {
                return "该卖家产品的加工技术标准定级不规范！请检查后提交";
            }
        }
        //判断加工质量标准是否存在不同意
        List<SlPdStdAgreeFlgBean> agreeFlgBeans1 = this.getTncCount(param);
        if (!CollectionUtils.isEmpty(agreeFlgBeans1) && agreeFlgBeans1.size() > 0) {
            for (SlPdStdAgreeFlgBean bean : agreeFlgBeans1) {
                //不同意
                if ("0".equals(bean.getAgreeFlg())) {
                    return "该卖家产品的加工质量标准存在不同意！请检查后提交";
                }
            }
        } else {
            return "该卖家产品的加工质量标准不存在！请检查后提交";
        }
        //加工质量标准全部同意
        //检查卖家产品加工质量标准定级是否为【A1/A2/A3】
        if (!CollectionUtils.isEmpty(sl241116Beans) && sl241116Beans.size() > 0) {
            //不合格
            if (sl241116Beans.get(0).getSlTncGradeCode()!=1 && sl241116Beans.get(0).getSlTncGradeCode()!=2 && sl241116Beans.get(0).getSlTncGradeCode()!=3) {
                return "该卖家产品的加工质量标准定级不规范！请检查后提交";
            }
        }


        //加工技术标准，加工技术等级，其他指标都符合
        //包装标准是否存在
        List<SL241106Bean> sl241106Beans = sl241106Logic.findPageList(param, SL241106Bean.class);
        if (CollectionUtils.isEmpty(sl241106Beans) && sl241106Beans.size() < 1) {
            return "该卖家产品的包装标准不存在！请检查后提交";
        }
        //判断其他指标是否存在
        if (!this.getStdCount(param)) {
            return "该卖家产品的其他标准不存在！请检查后提交";
        }
        return "1";
    }

    /**
     * 根据条件查询卖家该产品加工质量标准
     *
     * @param param 卖家编码、卖家产品id、产品标准ID、产品标准项目ID
     * @return 结果
     */
    @Transactional(readOnly = true)
    public List<SlPdTncStdNew> findSlPdTncStdNew(BaseParam param) {
        return this.findList(SqlId.SQL_ID_FIND_SL_PD_TNC_STD_NEW, param);
    }

    /**
     * 修改卖家产品信息的产品质量标准定级
     *
     * @param slProduct 参数
     * @return 结果
     */
    @Transactional(readOnly = false)
    public int modifySlProduct(SlProduct slProduct) {
        return super.modify(SqlId.SQL_ID_MODIFY_SL_PRODUCT, slProduct);
    }

    /**
     * 根据产品类别品种特征查询产品标准信息
     *
     * @param param 参数
     * @return 产品标准信息
     */
    @Transactional(readOnly = true)
    public List<PdStandard> findStandardInfo(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_STANDARD_INFO, param);
    }

    /**
     * 保存不同意数据到卖家产品技术标准不同意表中
     *
     * @param provider 参数
     * @return 结果
     */
    @Transactional(readOnly = false)
    public int saveNotAgree(PdTncStdDiscussProvider provider) {
        return this.save(SqlId.SQL_ID_SAVE_NOT_AGREE, provider);
    }

    /**
     * 取得加工质量详细页面数据
     *
     * @param param param
     * @return 加工质量标准数据
     * @author gyh
     */
    @Transactional(readOnly = true)
    public List<SL241117Bean> getTncStd(BaseParam param) {
        logger.debug("取得产品加工质量标准数据");
        List<PdStandard> pdStandards = this.findStandardInfo(param);
        if (CollectionUtils.isEmpty(pdStandards) || pdStandards.size() < 1) {
            return null;
        }
        PdStandard pdStandard = pdStandards.get(0);
        param.setFilter("standardId", StringUtil.toSafeString(pdStandard.getStandardId()));
        param.setFilter("levelId", "1");
        List<SL241117Bean> sl241117Beans = super.findList(SqlId.SQL_ID_GET_STD_INFO, param);
        for (SL241117Bean bean : sl241117Beans) {
            if ("0".equals(bean.getIsCatalog())) {
                param.setFilter("levelId", "2");
                List<SL241117Bean> beans = super.findList(SqlId.SQL_ID_GET_STD_INFO, param);
                bean.setPdTncStds(beans);
            }
        }
        return sl241117Beans;
    }

    /**
     * 取得技术标准详细页面数据（假数据）
     *
     * @return 技术标准数据
     * @author gyh
     */
    public List<SL241117Bean> getTncStdTestData() {
        List<SL241117Bean> tsClaList1 = new ArrayList<SL241117Bean>();
        List<SL241117Bean> SL241117BeanChilds = new ArrayList<SL241117Bean>();
        SL241117Bean bean1 = new SL241117Bean();
        bean1.setTncStdItemId("i01");
        bean1.setTncStdItemName("产品解冻失水率指标");
        bean1.setLevelId("1");
        bean1.setParentId("0");
        bean1.setIsCatalog("1");
        bean1.setTncStdVal1("≤6.5%");
        bean1.setTncStdVal1("≤8%");
        bean1.setTncStdVal1("≤9.5%");
        tsClaList1.add(bean1);

        SL241117Bean bean2 = new SL241117Bean();
        bean2.setTncStdItemId("i02");
        bean2.setTncStdItemName("产品均匀度指标");
        bean2.setLevelId("1");
        bean2.setParentId("0");
        bean2.setIsCatalog("1");
        bean2.setTncStdVal1("160+10g");
        bean2.setTncStdVal1("160+10g");
        bean2.setTncStdVal1("160+5g");
        tsClaList1.add(bean2);

        SL241117Bean bean3 = new SL241117Bean();
        bean3.setTncStdItemId("i03");
        bean3.setTncStdItemName("产品感官指标");
        bean3.setLevelId("1");
        bean3.setParentId("0");
        bean3.setIsCatalog("1");

        SL241117Bean bean7 = new SL241117Bean();
        bean7.setTncStdItemId("i06");
        bean7.setTncStdItemName("色泽");
        bean7.setLevelId("1");
        bean7.setParentId("0");
        bean7.setIsCatalog("1");
        bean7.setTncStdVal1("粉红");
        bean7.setTncStdVal1("粉红");
        bean7.setTncStdVal1("暗黄");
        SL241117BeanChilds.add(bean7);

        SL241117Bean bean8 = new SL241117Bean();
        bean8.setTncStdItemId("i07");
        bean8.setTncStdItemName("淤血");
        bean8.setLevelId("1");
        bean8.setParentId("0");
        bean8.setIsCatalog("1");
        bean8.setTncStdVal1("无");
        bean8.setTncStdVal1("无");
        bean8.setTncStdVal1("≤0.5cm²");
        SL241117BeanChilds.add(bean8);
//        bean3.setPdTncStdList(SL241117BeanChilds);
        tsClaList1.add(bean3);

        SL241117Bean bean4 = new SL241117Bean();
        bean4.setTncStdItemId("i04");
        bean4.setTncStdItemName("产品加工配方");
        bean4.setLevelId("1");
        bean4.setParentId("0");
        bean4.setIsCatalog("1");
        bean8.setTncStdVal1("/");
        bean8.setTncStdVal1("/");
        bean8.setTncStdVal1("/");
        tsClaList1.add(bean4);

        SL241117Bean bean5 = new SL241117Bean();
        bean5.setTncStdItemId("i05");
        bean5.setTncStdItemName("产品工艺流程");
        bean5.setLevelId("1");
        bean5.setParentId("0");
        bean5.setIsCatalog("1");
        bean8.setTncStdVal1("精修");
        bean8.setTncStdVal1("精修");
        bean8.setTncStdVal1("精修");
        tsClaList1.add(bean5);

        return tsClaList1;
    }
}
