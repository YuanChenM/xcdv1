package com.msk.sp.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.sp.bean.SP171103Bean;
import com.msk.sp.bean.SP171104Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * yang_yang
 */
@Service
public class SP171104Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SP171104Logic.class);

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
    public PageResult<SP171104Bean> findSP171104List(BasePageParam pageParam) {
        logger.info("价盘平台查看");
        /*PageResult<SP171104Bean> result = this.findPage(pageParam, SP171104Bean.class);

        return result;*/

        PageResult<SP171104Bean> result = new PageResult<SP171104Bean>();
        logger.info("获取假数据");
        List<SP171104Bean> list = new ArrayList<SP171104Bean>();

        SP171104Bean sp171104Bean1 = new SP171104Bean();
        sp171104Bean1.setCompanyId("1");
        sp171104Bean1.setCompanyCode("11220001");
        sp171104Bean1.setCompanyName("唐山中红三融畜禽有限公司");
        sp171104Bean1.setAccount("1121232112");
        sp171104Bean1.setAllotNum("1000");
        sp171104Bean1.setDeclareNum("1200");
        sp171104Bean1.setMobilePhone("15011112311");
        sp171104Bean1.setShowName("yyyy");

        SP171104Bean sp171104Bean2 = new SP171104Bean();
        sp171104Bean2.setCompanyId("2");
        sp171104Bean2.setCompanyCode("11220002");
        sp171104Bean2.setCompanyName("聊城六和荣达农牧有限公司");
        sp171104Bean2.setAccount("1121232112");
        sp171104Bean2.setAllotNum("1000");
        sp171104Bean2.setDeclareNum("1200");
        sp171104Bean2.setMobilePhone("15011112311");
        sp171104Bean2.setShowName("yyyy");

        SP171104Bean sp171104Bean3 = new SP171104Bean();
        sp171104Bean3.setCompanyId("3");
        sp171104Bean3.setCompanyCode("11220003");
        sp171104Bean3.setCompanyName("六安宝祥禽业科技有限责任公司");
        sp171104Bean3.setAccount("1121232112");
        sp171104Bean3.setAllotNum("1000");
        sp171104Bean3.setDeclareNum("1200");
        sp171104Bean3.setMobilePhone("15011112311");
        sp171104Bean3.setShowName("yyyy");

        list.add(sp171104Bean1);
        list.add(sp171104Bean2);
        list.add(sp171104Bean3);

        result.setData(list);
        result.setRecordsTotal(list.size());
        return result;
    }

}
