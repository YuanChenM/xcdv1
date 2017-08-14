package com.msk.sp.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.sp.bean.SP171103Bean;
import com.msk.sp.bean.SP171128Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SP171128Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SP171128Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     */
    private interface SqlId {
        String SQL_ID_FIND_ORDERLEVELLIST = "getOrderLevelList";
        String SQL_ID_GET_BREADS="getBreeds";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 价盘平台查看
     * @return
     */
    public PageResult<SP171128Bean> findSP171128List(BasePageParam pageParam) {
        logger.info("价盘平台查看");
        /*PageResult<SP171103Bean> result = this.findPage(pageParam, SP171103Bean.class);

        return result;*/

        PageResult<SP171128Bean> result = new PageResult<SP171128Bean>();
        logger.info("获取假数据");
        List<SP171128Bean> list = new ArrayList<SP171128Bean>();

        SP171128Bean bean1 = new SP171128Bean();
        bean1.setLgcsName("上海");
        bean1.setPdName("海鲜丸子");
        bean1.setMachining(" 丸子");
        bean1.setFeacherName(" 2只装");
        bean1.setWeightVal("10");
        bean1.setPdLevel("A1");
        bean1.setPdCode("1011121");
        bean1.setStockWeight("24901");
        bean1.setQuotationStatus("报价中");
        list.add(bean1);

        SP171128Bean bean2 = new SP171128Bean();
        bean2.setLgcsName("南京");
        bean2.setPdName("海鲜丸子");
        bean2.setMachining(" 丸子");
        bean2.setFeacherName(" 2只装");
        bean2.setWeightVal("20");
        bean2.setPdLevel("A2");
        bean2.setPdCode("1011122");
        bean2.setStockWeight("24902");
        bean2.setQuotationStatus("报价中");
        list.add(bean2);

        SP171128Bean bean3 = new SP171128Bean();
        bean3.setLgcsName("杭州");
        bean3.setPdName(" 优质狗肉");
        bean3.setMachining(" 狗肉");
        bean3.setFeacherName(" 6只装");
        bean3.setWeightVal("5");
        bean3.setPdLevel("A3");
        bean3.setPdCode("1011123");
        bean3.setStockWeight("24903");
        bean3.setQuotationStatus("未报价");
        list.add(bean3);


        result.setData(list);
        return result;
    }

}
