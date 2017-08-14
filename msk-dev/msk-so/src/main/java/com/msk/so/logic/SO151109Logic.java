/**
 * SO151109Logic.java
 *
 * @screen
 * @author rwf
 */
package com.msk.so.logic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.so.bean.SO151109Bean;

/** 
 * SO151109Logic.
 *
 * @author rwf
 */
@Service
public class SO151109Logic extends BaseLogic {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SO151109Logic.class);

    /**
     *
     *
     * @return
     * @author rwf
     */
    public PageResult<SO151109Bean> findOrderList() {
        logger.info("会员卡假数据");
        PageResult<SO151109Bean> result = new PageResult<SO151109Bean>();
        List<SO151109Bean> list=new ArrayList<SO151109Bean>();
        SO151109Bean so1=new SO151109Bean();
        so1.setMemberCode("XXXXXXXXX00001");//设置会员编码
        so1.setBuyersCode("XXXXXXXXXXXX00001");//设置买家编码
        so1.setBuyersName("张三");//设置买家名称
        so1.setActivateFlag("是");//设置激活标志
        so1.setIssueFlag("是");//设置发放标志
        so1.setIssueDate("2015-12-31");//设置发放日期
        list.add(so1);
        
        SO151109Bean so2=new SO151109Bean();
        so2.setMemberCode("XXXXXXXXX00002");//设置会员编码
        so2.setBuyersCode("XXXXXXXXXXXX00002");//设置买家编码
        so2.setBuyersName("李四");//设置买家名称
        so2.setActivateFlag("是");//设置激活标志
        so2.setIssueFlag("否");//设置发放标志
        so2.setIssueDate("");//设置发放日期
        list.add(so2);
        
        SO151109Bean so3=new SO151109Bean();
        so3.setMemberCode("XXXXXXXXX00003");//设置会员编码
        so3.setBuyersCode("XXXXXXXXXXXX00003");//设置买家编码
        so3.setBuyersName("王五");//设置买家名称
        so3.setActivateFlag("是");//设置激活标志
        so3.setIssueFlag("否");//设置发放标志
        so3.setIssueDate("");//设置方法日期
        list.add(so3);
        
        SO151109Bean so4=new SO151109Bean();
        so4.setMemberCode("XXXXXXXXX00004");//设置会员编码
        so4.setBuyersCode("XXXXXXXXXXXX00004");//设置买家编码
        so4.setBuyersName("赵六");//设置买家名称
        so4.setActivateFlag("是");//设置激活标志
        so4.setIssueFlag("否");//设置发放标志
        so4.setIssueDate("");//设置发放日期
        list.add(so4);
        result.setRecordsTotal(list.size());
        result.setData(list);
        return result;
    }
    
}
