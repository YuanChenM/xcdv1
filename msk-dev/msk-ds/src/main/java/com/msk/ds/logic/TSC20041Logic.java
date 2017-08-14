package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.TSC20041Bean;
import com.msk.ds.bean.TSC20041Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * TSC10041Logic
 * @author gyh
 */
@Service
public class TSC20041Logic extends BaseLogic {


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询数据
     * @return
     */
    @Transactional(readOnly = true)
    public PageResult<TSC20041Bean> findInfo() {
        //查询列表数据
        PageResult<TSC20041Bean> list=new PageResult<>();
        List<TSC20041Bean> beanList=new ArrayList<>();
        TSC20041Bean bean1=new TSC20041Bean();
        bean1.setInfo1("1");
        bean1.setInfo2("RK20160607001001");
        bean1.setInfo3("河北某某畜禽养殖有限公司");
        bean1.setInfo4("2016-4-11");
        bean1.setInfo5("河北某某畜禽销售部");
        bean1.setInfo6("松江仓库");
        bean1.setInfo7("采购入库");
        bean1.setInfo8("20160607001001");
        bean1.setInfo9("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean1.setInfo10("FH20160607001001");

        TSC20041Bean bean2=new TSC20041Bean();
        bean2.setInfo1("2");
        bean2.setInfo2("RK20160607001002");
        bean2.setInfo3("山东荣达农业发展有限公司");
        bean2.setInfo4("2016-4-11");
        bean2.setInfo5("山东荣达畜禽销售部");
        bean2.setInfo6("松江仓库");
        bean2.setInfo7("采购入库");
        bean2.setInfo8("20160607001002");
        bean2.setInfo9("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean2.setInfo10("FH20160607001001");

        TSC20041Bean bean3=new TSC20041Bean();
        bean3.setInfo1("3");
        bean3.setInfo2("RK20160607001003");
        bean3.setInfo3("山东硕昌食品有限公司");
        bean3.setInfo4("2016-4-11");
        bean3.setInfo5("山东硕昌食品销售部");
        bean3.setInfo6("松江仓库");
        bean3.setInfo7("采购入库");
        bean3.setInfo8("");
        bean3.setInfo9("");
        bean3.setInfo10("");

        TSC20041Bean bean4=new TSC20041Bean();
        bean4.setInfo1("4");
        bean4.setInfo2("RK20160607001004");
        bean4.setInfo3("萧县强英食品有限公司");
        bean4.setInfo4("2016-4-11");
        bean4.setInfo5("萧县强英食品有限公司销售部");
        bean4.setInfo6("松江仓库");
        bean4.setInfo7("采购入库");
        bean4.setInfo8("");
        bean4.setInfo9("");
        bean4.setInfo10("");
        beanList.add(bean1);
        beanList.add(bean2);
        beanList.add(bean3);
        beanList.add(bean4);
        list.setData(beanList);
        list.setRecordsTotal(beanList.size());
        return list;
    }
}
