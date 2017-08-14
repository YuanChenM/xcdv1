package com.msk.sp.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.exception.BusinessException;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import com.msk.sp.bean.SP171103Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * yang_yang
 */
@Service
public class SP171103Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SP171103Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author yang_yang
     */
    private interface SqlId {
        String SQL_ID_FIND_ORDERLEVELLIST = "getOrderLevelList";
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
    public PageResult<SP171103Bean> findSP171103List(BasePageParam pageParam) {
        logger.info("价盘平台查看");
        /*PageResult<SP171103Bean> result = this.findPage(pageParam, SP171103Bean.class);

        return result;*/

        PageResult<SP171103Bean> result = new PageResult<SP171103Bean>();
        logger.info("获取假数据");
        List<SP171103Bean> list = new ArrayList<SP171103Bean>();

        SP171103Bean sp171103Bean1 = new SP171103Bean();
        sp171103Bean1.setPdName("鸡大腿");
        sp171103Bean1.setPdCode("120011001");
        sp171103Bean1.setPdBreed("鸡产品");
        sp171103Bean1.setPdFeature("10kg/袋");
        sp171103Bean1.setPdPackage("01");
        sp171103Bean1.setPdWeight("10kg");
        sp171103Bean1.setNeedNum("2000");
        sp171103Bean1.setIsBid("是");

        SP171103Bean sp171103Bean2 = new SP171103Bean();
        sp171103Bean2.setPdName("鸡大腿1");
        sp171103Bean2.setPdCode("120011002");
        sp171103Bean2.setPdBreed("鸡产品");
        sp171103Bean2.setPdFeature("10kg/袋");
        sp171103Bean2.setPdPackage("01");
        sp171103Bean2.setPdWeight("10kg");
        sp171103Bean2.setNeedNum("2000");
        sp171103Bean2.setIsBid("否");

        SP171103Bean sp171103Bean3 = new SP171103Bean();
        sp171103Bean3.setPdName("鸡大腿2");
        sp171103Bean3.setPdCode("120011003");
        sp171103Bean3.setPdBreed("鸡产品");
        sp171103Bean3.setPdFeature("10kg/袋");
        sp171103Bean3.setPdPackage("01");
        sp171103Bean3.setPdWeight("10kg");
        sp171103Bean3.setNeedNum("2000");
        sp171103Bean3.setIsBid("否");

        list.add(sp171103Bean1);
        list.add(sp171103Bean2);
        list.add(sp171103Bean3);

        result.setData(list);
        result.setRecordsTotal(list.size());
        return result;
    }

}
