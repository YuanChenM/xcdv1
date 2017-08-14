package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.SlProduct;
import com.msk.sl.bean.SL24110502Bean;
import com.msk.sl.bean.SL241105Bean;
import com.msk.sl.bean.SL241118Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * SL241105Logic
 *
 * @author jiang_nan
 * @version 1.0
 */
@Service
public class SL241105Logic extends BaseLogic {
    private static Logger logger = LoggerFactory.getLogger(SL241105Logic.class);

    /**
     * 取得卖家产品加工技术标准详细页面数据
     *
     * @param param param
     * @return 加工技术标准数据
     * @author gyh
     */
    @Transactional(readOnly = true)
    public List<SL241118Bean> getMctStd(BaseParam param) {
        return super.findList(SqlId.SQL_ID_GET_STD_INFO, param);
    }

    /**
     * 获取卖家产品质量标准信息假数据
     *
     * @return 卖家产品质量标准信息
     * @autor gyh
     * @Time 2016.1.9
     */

  public PageResult<SL241105Bean> getSL241105BeanInfo() {
      PageResult<SL241105Bean> pageResult = new PageResult<SL241105Bean>();
      List<SL241105Bean> datas = new ArrayList<SL241105Bean>();
      SL241105Bean sl241105Bean=new SL241105Bean();
      sl241105Bean.setProdEpName("神农客");
      sl241105Bean.setBrandName("神农客");
      sl241105Bean.setClassesName("鸡产品");
      sl241105Bean.setBreedName("冻琵琶腿");
      sl241105Bean.setProductCode("0103");
      sl241105Bean.setFeatureName("80-100g");
      sl241105Bean.setDistFlg("是");
      SL241105Bean sl241105Bean1=new SL241105Bean();
      sl241105Bean1.setProdEpName("神农客");
      sl241105Bean1.setBrandName("神农客");
      sl241105Bean1.setClassesName("鸡产品");
      sl241105Bean1.setBreedName("三黄土鸡");
      sl241105Bean1.setProductCode("0101");
      sl241105Bean1.setFeatureName("100-120g");
      sl241105Bean1.setDistFlg("是");

      SL241105Bean sl241105Bean2=new SL241105Bean();
      sl241105Bean2.setProdEpName("神农客");
      sl241105Bean2.setBrandName("神农客");
      sl241105Bean2.setClassesName("鸡产品");
      sl241105Bean2.setBreedName("冻鸡大胸");
      sl241105Bean2.setProductCode("0102");
      sl241105Bean2.setFeatureName("120-130g");
      sl241105Bean2.setDistFlg("是");

      SL241105Bean sl241105Bean3=new SL241105Bean();
      sl241105Bean3.setProdEpName("神农客");
      sl241105Bean3.setBrandName("神农客");
      sl241105Bean3.setClassesName("鸡产品");
      sl241105Bean3.setBreedName("鸡边腿");
      sl241105Bean3.setProductCode("0104");
      sl241105Bean3.setFeatureName("130-150g");
      sl241105Bean3.setDistFlg("是");

      SL241105Bean sl241105Bean4=new SL241105Bean();
      sl241105Bean4.setProdEpName("神农客");
      sl241105Bean4.setBrandName("神农客");
      sl241105Bean4.setClassesName("鸡产品");
      sl241105Bean4.setBreedName("鸡排腿");
      sl241105Bean4.setProductCode("0105");
      sl241105Bean4.setFeatureName("150g以上");
      sl241105Bean4.setDistFlg("是");
      datas.add(sl241105Bean);
      datas.add(sl241105Bean1);
      datas.add(sl241105Bean2);
      datas.add(sl241105Bean3);
      datas.add(sl241105Bean4);
      pageResult.setData(datas);
      pageResult.setRecordsTotal(5);
      return pageResult;
  }

    /**
     * 卖家产品技术审核
     * @param param param
     * @return 结果
     * @author gyh
     */
    @Transactional(readOnly = false)
    public int modifySlQlt(SlProduct param){
        return this.modify(SqlId.SQL_ID_MODIFY_SL_QLT,param);
    }

    /**
     * 卖家产品卫生定级
     * @param param param
     * @return 结果
     * @author gyh
     */
    @Transactional(readOnly = false)
    public int modifySlTncGrade(SlProduct param){
        return this.modify(SqlId.SQL_ID_MODIFY_SL_TNC_GRADE,param);
    }
    /**
     * 卖家产品卫生审核
     * @param param param
     * @return 结果
     * @author gyh
     */
    @Transactional(readOnly = false)
    public int modifySlTncMonitor(SlProduct param){
        return this.modify(SqlId.SQL_ID_MODIFY_SL_TNC_MONITOR,param);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_MODIFY_SL_QLT = "modifySlQlt";
        static final String SQL_ID_MODIFY_SL_TNC_GRADE = "modifySlTncGrade";
        static final String SQL_ID_MODIFY_SL_TNC_MONITOR = "modifySlQltMonitor";
        static final String SQL_ID_GET_STD_INFO = "getMctStd";
    }
}