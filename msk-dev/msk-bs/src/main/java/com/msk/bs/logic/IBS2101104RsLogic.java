package com.msk.bs.logic;

import com.msk.bs.bean.IBS2101104RsParam;
import com.msk.bs.bean.IBS2101104SlHouseAccount;
import com.msk.bs.bean.IBS2101104SlHouseArea;
import com.msk.bs.bean.IBS2101104SlHouseProduct;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.consts.TableNameDef;
import com.msk.core.entity.SlHouseAccount;
import com.msk.core.entity.SlHouseArea;
import com.msk.core.entity.SlHouseProduct;
import com.msk.core.entity.SlSeller;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/3/1.
 */
@Service
public class IBS2101104RsLogic extends BaseLogic {
    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        /**
         * 查询冻品管家用户是否存在
         */
        static final String SQL_ID_FIND_HOUSE_ACCUNT = "findHouseAccunt";
        /**
         * 查询卖家账户信息
         */
        static final String SQL_ID_FIND_SL_ACCUNT = "findSlAccount";
        /**
         * 保存冻品管家
         */
        static final String SQL_ID_SAVE_HOUSE_ACCUNT = "saveHouseAccunt";
        /**
         * 保存冻品管家等级
         */
        static final String SQL_ID_SAVE_HOUSE_GRADE = "saveHouseGrade";
        /**
         * 保存冻品管家经营区域
         */
        static final String SQL_ID_SAVE_SL_HOUSE_AREA = "saveSlHouseArea";
        /**
         * 保存买冻品管家产品分类
         */
        static final String SQL_ID_SAVE_SL_HOUSE_PRODUCT = "saveSlHouseProduct";
        /**
         * 删除冻品管家
         */
        static final String SQL_ID_DELETE_HOUSE_ACCUNT = "deleteHouseAccunt";
        /**
         * 删除冻品管家等级
         */
        static final String SQL_ID_DELETE_HOUSE_GRADE = "deleteHouseGrade";
        /**
         * 删除冻品管家等级
         */
        static final String SQL_ID_DELETE_SL_HOUSE_AREA = "deleteSlHouseArea";
        /**
         * 删除冻品管家产品分类
         */
        static final String SQL_ID_DELETE_SL_HOUSE_PRODUCT = "deleteSlHouseProduct";
        /**
         * 更新冻品管家
         */
        static final String SQL_ID_UPDATE_HOUSE_ACCUNT = "updateHouseAccunt";
        /**
         * 更新冻品管家等级
         */
        static final String SQL_ID_UPDATE_HOUSE_GRADE = "updateHouseGrade";
        /**
         * 更新冻品管家经营区域
         */
        static final String SQL_ID_UPDATE_SL_HOUSE_AREA = "updateSlHouseArea";
        /**
         * 更新冻品管家产品分类
         */
        static final String SQL_ID_UPDATE_SL_HOUSE_PRODUCT = "updateSlHouseProduct";
        /**
         * 根据id查询经营区域
         */
        static final String SQL_ID_FIND_SL_HOUSE_AREA = "findSlHouseArea";
        /**
         * 根据id查询冻品管家产品分类
         */
        static final String SQL_ID_FIND_SL_HOUSE_PRODUCT = "findSlHouseProduct";

        /**
         * 查询冻品管家账号
         */
        static final String SQL_ID_FIND_HOUSE_ACCOUNT = "findHouseAccount";

        /**
         * 查询冻品管家编号
         */
        static final String SQL_ID_FIND_HOUSE_CODEDIS = "findhouseCodeDis";

    }

    /**
     * 更新冻品管家账号信息
     *
     * @param slHouseAccount 参数
     * @return 结果
     */
    public SlHouseAccount modifySlHouseAccount(IBS2101104SlHouseAccount slHouseAccount) {
        SlHouseAccount houseAccount = slHouseAccount;
        //根据管家分类给备用字段赋值
        if (StringUtil.toSafeString(NumberConst.IntDef.INT_ZERO).equals(houseAccount.getHouseCategory())) {
            houseAccount.setHouseCategory0("1");
            houseAccount.setHouseCategory1("0");
            houseAccount.setHouseCategory2("0");
            houseAccount.setHouseCategory3("0");
            houseAccount.setHouseCategory4("0");
            houseAccount.setHouseCategory5("0");
            houseAccount.setHouseCategory6("0");
            houseAccount.setHouseCategory7("0");
            houseAccount.setHouseCategory8("0");
        } else if (StringUtil.toSafeString(NumberConst.IntDef.INT_ONE).equals(houseAccount.getHouseCategory())) {
            houseAccount.setHouseCategory0("0");
            houseAccount.setHouseCategory1("1");
            houseAccount.setHouseCategory2("0");
            houseAccount.setHouseCategory3("0");
            houseAccount.setHouseCategory4("0");
            houseAccount.setHouseCategory5("0");
            houseAccount.setHouseCategory6("0");
            houseAccount.setHouseCategory7("0");
            houseAccount.setHouseCategory8("0");
        } else if (StringUtil.toSafeString(NumberConst.IntDef.INT_TWO).equals(houseAccount.getHouseCategory())) {
            houseAccount.setHouseCategory0("0");
            houseAccount.setHouseCategory1("0");
            houseAccount.setHouseCategory2("1");
            houseAccount.setHouseCategory3("0");
            houseAccount.setHouseCategory4("0");
            houseAccount.setHouseCategory5("0");
            houseAccount.setHouseCategory6("0");
            houseAccount.setHouseCategory7("0");
            houseAccount.setHouseCategory8("0");
        } else if (StringUtil.toSafeString(NumberConst.IntDef.INT_THREE).equals(houseAccount.getHouseCategory())) {
            houseAccount.setHouseCategory0("0");
            houseAccount.setHouseCategory1("0");
            houseAccount.setHouseCategory2("0");
            houseAccount.setHouseCategory3("1");
            houseAccount.setHouseCategory4("0");
            houseAccount.setHouseCategory5("0");
            houseAccount.setHouseCategory6("0");
            houseAccount.setHouseCategory7("0");
            houseAccount.setHouseCategory8("0");
        } else if (StringUtil.toSafeString(NumberConst.IntDef.INT_FOUR).equals(houseAccount.getHouseCategory())) {
            houseAccount.setHouseCategory0("0");
            houseAccount.setHouseCategory1("0");
            houseAccount.setHouseCategory2("0");
            houseAccount.setHouseCategory3("0");
            houseAccount.setHouseCategory4("1");
            houseAccount.setHouseCategory5("0");
            houseAccount.setHouseCategory6("0");
            houseAccount.setHouseCategory7("0");
            houseAccount.setHouseCategory8("0");
        } else if (StringUtil.toSafeString(NumberConst.IntDef.INT_FIVE).equals(houseAccount.getHouseCategory())) {
            houseAccount.setHouseCategory0("0");
            houseAccount.setHouseCategory1("0");
            houseAccount.setHouseCategory2("0");
            houseAccount.setHouseCategory3("0");
            houseAccount.setHouseCategory4("0");
            houseAccount.setHouseCategory5("1");
            houseAccount.setHouseCategory6("0");
            houseAccount.setHouseCategory7("0");
            houseAccount.setHouseCategory8("0");
        } else if (StringUtil.toSafeString(NumberConst.IntDef.INT_SIX).equals(houseAccount.getHouseCategory())) {
            houseAccount.setHouseCategory0("0");
            houseAccount.setHouseCategory1("0");
            houseAccount.setHouseCategory2("0");
            houseAccount.setHouseCategory3("0");
            houseAccount.setHouseCategory4("0");
            houseAccount.setHouseCategory5("0");
            houseAccount.setHouseCategory6("1");
            houseAccount.setHouseCategory7("0");
            houseAccount.setHouseCategory8("0");
        } else if (StringUtil.toSafeString(NumberConst.IntDef.INT_SEVEN).equals(houseAccount.getHouseCategory())) {
            houseAccount.setHouseCategory0("0");
            houseAccount.setHouseCategory1("0");
            houseAccount.setHouseCategory2("0");
            houseAccount.setHouseCategory3("0");
            houseAccount.setHouseCategory4("0");
            houseAccount.setHouseCategory5("0");
            houseAccount.setHouseCategory6("0");
            houseAccount.setHouseCategory7("1");
            houseAccount.setHouseCategory8("0");
        } else if (StringUtil.toSafeString(NumberConst.IntDef.INT_EIGHT).equals(houseAccount.getHouseCategory())) {
            houseAccount.setHouseCategory0("0");
            houseAccount.setHouseCategory1("0");
            houseAccount.setHouseCategory2("0");
            houseAccount.setHouseCategory3("0");
            houseAccount.setHouseCategory4("0");
            houseAccount.setHouseCategory5("0");
            houseAccount.setHouseCategory6("0");
            houseAccount.setHouseCategory7("0");
            houseAccount.setHouseCategory8("1");
        }
        //判断管家id是否存在，存在即修改不存在即新增
        if (slHouseAccount.getHouseCode() == null || "".equals(slHouseAccount.getHouseCode())) {
            //根据卖家编码查询卖家账号
            BaseParam baseParam = new BaseParam();
            baseParam.setFilter("slCode", slHouseAccount.getSlCode());
            SlSeller account = this.findOne(SqlId.SQL_ID_FIND_SL_ACCUNT, baseParam);
            if (account == null || "".equals(account.getSlAccount())) {
                throw new BusinessException("买家id为" + slHouseAccount.getSlCode() + "的买手账号不存在！无法生成冻品管家账号");
            } else {
                if (account.getSlCodeDis() == null || "".equals(account.getSlCodeDis())) {
                    throw new BusinessException("买家id为" + slHouseAccount.getSlCode() + "的买手编码不存在！无法生成冻品管家编码");
                }
                houseAccount.setCrtId(slHouseAccount.getLoginId());
                BaseParam param = new BaseParam();
                param.setFilter("houseAccount", account.getSlAccount() + StringConst.PRE);
                param.setFilter("houseCodeDis", account.getSlCodeDis() + StringConst.PRE);
                Integer slAccount = this.getCount(SqlId.SQL_ID_FIND_HOUSE_ACCOUNT, param);
                if (slAccount == null || slAccount < 1) {
                    houseAccount.setHouseAccount(account.getSlAccount() + "01");
                } else {
                    slAccount = slAccount + 1;
                    if (slAccount < 10) {
                        houseAccount.setHouseAccount(account.getSlAccount() + "0" + StringUtil.toSafeString(slAccount));
                    } else {
                        houseAccount.setHouseAccount(account.getSlAccount() + StringUtil.toSafeString(slAccount));
                    }
                }
                Integer slCodeDis = this.getCount(SqlId.SQL_ID_FIND_HOUSE_CODEDIS, param);
                if (slCodeDis == null || slCodeDis < 1) {
                    houseAccount.setHouseCodeDis(account.getSlCodeDis() + "01" + houseAccount.getHouseCategory());
                } else {
                    slCodeDis = slCodeDis + 1;
                    if (slAccount < 10) {
                        houseAccount.setHouseCodeDis(account.getSlCodeDis() + "0" + StringUtil.toSafeString(slCodeDis) + houseAccount.getHouseCategory());
                    } else {
                        houseAccount.setHouseCodeDis(account.getSlCodeDis() + StringUtil.toSafeString(slCodeDis) + houseAccount.getHouseCategory());
                    }
                }
                houseAccount.setHouseCode(StringUtil.toSafeString(commonLogic.maxId(TableNameDef.SL_HOUSE_ACCOUNT, "CONVERT(HOUSE_CODE,SIGNED)")));
                houseAccount.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ZERO));
                houseAccount.setVer(NumberConst.IntDef.INT_ONE);
                int result = super.save(SqlId.SQL_ID_SAVE_HOUSE_ACCUNT, houseAccount);
                if (result < 1) {
                    throw new BusinessException("冻品管家账号信息新增失败，请检查参数是否正确！");
                }
            }
        } else {
            BaseParam baseParam = new BaseParam();
            baseParam.setFilter("houseCode", slHouseAccount.getHouseCode());
            SlHouseAccount house = super.findOne(SqlId.SQL_ID_FIND_HOUSE_ACCUNT, baseParam);
            if (house == null) {
                throw new BusinessException("管家id" + slHouseAccount.getHouseCode() + "不存在");
            }
            houseAccount.setHouseCode(slHouseAccount.getHouseCode());
            houseAccount.setUpdId(slHouseAccount.getLoginId());
            //删除标志是否为空，不为空则删除
            if (slHouseAccount.getDelFlg() != null && !"".equals(slHouseAccount.getDelFlg())) {
                int result = super.modify(SqlId.SQL_ID_DELETE_HOUSE_ACCUNT, houseAccount);
                if (result < 1) {
                    throw new BusinessException("冻品管家账号信息删除失败，请检查参数是否正确！");
                }
            } else {
                if (null != houseAccount.getHouseCategory() && !"".equals(houseAccount.getHouseCategory())) {
                    StringBuilder sb = new StringBuilder(house.getHouseCodeDis());
                    sb.setCharAt(sb.length() - 1, houseAccount.getHouseCategory().toCharArray()[0]);
                    houseAccount.setHouseCodeDis(sb.toString());
                } else {
                    houseAccount.setHouseCodeDis(house.getHouseCodeDis());
                }
                int result = super.modify(SqlId.SQL_ID_UPDATE_HOUSE_ACCUNT, houseAccount);
                if (result < 1) {
                    throw new BusinessException("冻品管家账号信息修改失败，请检查参数是否正确！");
                }
            }
        }
        return houseAccount;
    }

    /**
     * 更新经营区域
     *
     * @param slAreaList 参数
     * @return 结果
     */
    public String modifySlHouseArea(List<IBS2101104SlHouseArea> slAreaList, String accountCode) {
        for (IBS2101104SlHouseArea area : slAreaList) {
            SlHouseArea slHouseArea = area;
            //经营区域id存在则修改，不存在则新增
            if (area.getSlAreaId() == null) {
                if (area.getHouseCode() == null || "".equals(area.getHouseCode())) {
                    area.setHouseCode(accountCode);
                }
                slHouseArea.setCrtId(area.getLoginId());
                slHouseArea.setSlAreaId(commonLogic.maxId("sl_house_area", "SL_AREA_ID"));
                slHouseArea.setVer(1);
                int result = super.save(SqlId.SQL_ID_SAVE_SL_HOUSE_AREA, slHouseArea);
                if (result < 1) {
                    throw new BusinessException("冻品管家经营区域信息新增失败，请检查参数是否正确！");
                }
            } else {
                //检查区域id是否存在
                BaseParam param = new BaseParam();
                param.getFilterMap().put("slAreaId", area.getSlAreaId());
                int rs = this.getCount(SqlId.SQL_ID_FIND_SL_HOUSE_AREA, param);
                if (rs < 1) {
                    return "冻品管家经营区域id" + area.getSlAreaId() + "不存在";
                }
                slHouseArea.setUpdId(area.getLoginId());
                //删除标志是否为空
                if (area.getDelFlg() != null && !"".equals(area.getDelFlg())) {
                    int result = super.modify(SqlId.SQL_ID_DELETE_SL_HOUSE_AREA, slHouseArea);
                    if (result < 1) {
                        throw new BusinessException("冻品管家经营区域信息删除失败，请检查参数是否正确！");
                    }
                } else {
                    int result = super.modify(SqlId.SQL_ID_UPDATE_SL_HOUSE_AREA, slHouseArea);
                    if (result < 1) {
                        throw new BusinessException("冻品管家经营区域信息修改失败，请检查参数是否正确！");
                    }
                }
            }
        }
        return "经营区域信息更新成功";
    }

    /**
     * 冻品管家产品分类更新
     *
     * @param housePdList 参数
     * @return 结果
     */
    public String modifySlHouseProduct(List<IBS2101104SlHouseProduct> housePdList, SlHouseAccount account) {
        for (IBS2101104SlHouseProduct product : housePdList) {
            SlHouseProduct slHouseProduct = product;
            //冻品管家产品分类id存在修改，不存在新增
            if (product.getPdId() == null) {
                if (product.getHouseCode() == null || "".equals(product.getHouseCode())) {
                    if (account.getHouseCode() == null || "".equals(account.getHouseCode())) {
                        throw new BusinessException("冻品管家ID不能为空");
                    }
                    slHouseProduct.setHouseCode(account.getHouseCode());
                }
                slHouseProduct.setCrtId(product.getLoginId());
                slHouseProduct.setPdId(commonLogic.maxId("sl_house_product", "PD_ID"));
                slHouseProduct.setVer(1);
                int result = super.save(SqlId.SQL_ID_SAVE_SL_HOUSE_PRODUCT, slHouseProduct);
                if (result < 1) {
                    throw new BusinessException("冻品管家产品分类信息新增失败，请检查参数是否正确！");
                }
            } else {
                //检查冻品管家产品分类id是否存在
                BaseParam param = new BaseParam();
                param.getFilterMap().put("pdId", product.getPdId());
                int rs = this.getCount(SqlId.SQL_ID_FIND_SL_HOUSE_PRODUCT, param);
                if (rs < 1) {
                    return "冻品管家产品分类id" + product.getPdId() + "不存在";
                }
                slHouseProduct.setUpdId(product.getLoginId());
                //检查删除标志是是否为空，不为空则删除操作，为空修改
                if (product.getDelFlg() != null && !"".equals(product.getDelFlg())) {
                    int result = super.modify(SqlId.SQL_ID_DELETE_SL_HOUSE_PRODUCT, slHouseProduct);
                    if (result < 1) {
                        throw new BusinessException("冻品管家产品分类信息删除失败，请检查参数是否正确！");
                    }
                } else {
                    int result = super.modify(SqlId.SQL_ID_UPDATE_SL_HOUSE_PRODUCT, slHouseProduct);
                    if (result < 1) {
                        throw new BusinessException("冻品管家产品分类信息修改失败，请检查参数是否正确！");
                    }
                }

            }
        }
        return "冻品管家产品分类更新成功";
    }

    /**
     * 修改或新增冻品管家信息
     *
     * @param ibs2101104RsParam 参数
     * @return 结果
     */
    @Transactional(readOnly = false)
    public SlHouseAccount editBSSeller(IBS2101104RsParam ibs2101104RsParam) {
        //冻品管家账号信息
        IBS2101104SlHouseAccount slHouseAccount = ibs2101104RsParam.getSlHouseAccount();
        //经营区域List
        List<IBS2101104SlHouseArea> slAreaList = ibs2101104RsParam.getSlAreaList();
        //冻品管家产品分类list
        List<IBS2101104SlHouseProduct> housePdList = ibs2101104RsParam.getHousePdList();
        SlHouseAccount houseAccount = new SlHouseAccount();
        //更新冻品管家账号信息
        if (slHouseAccount != null) {
            houseAccount = this.modifySlHouseAccount(slHouseAccount);
        }
        //更新经营区域
//        if (!CollectionUtils.isEmpty(slAreaList) && slAreaList.size() > 0) {
//            this.modifySlHouseArea(slAreaList,accountCode);
//        }
        //更新冻品管家产品分类
        if (!CollectionUtils.isEmpty(housePdList) && housePdList.size() > 0) {
            this.modifySlHouseProduct(housePdList, houseAccount);
        }
        if (slHouseAccount == null && CollectionUtils.isEmpty(housePdList)) {
            throw new BusinessException("参数不规范，请检查后提交。");
        }
        return houseAccount;
    }
}
