package com.msk.sl.logic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.sl.bean.SL241109Bean;
@Service
public class SL241109Logic extends BaseLogic {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SL241109Logic.class);
    
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    
    public PageResult<SL241109Bean> getListInfo() {
        logger.info("分销章程列表");
        PageResult<SL241109Bean> result = new PageResult<SL241109Bean>();
        result.setRecordsTotal(14);
        List<SL241109Bean>  slChapters  = new ArrayList<SL241109Bean>();
        SL241109Bean slChapter1 = new SL241109Bean();
        slChapter1.setChapNo(1);
        slChapter1.setChapTitle("关于神农客商城分销");
        slChapter1.setContent("<<关于神农客商城分销的介绍>>");
        slChapter1.setContentHref("111111");
        slChapters.add(slChapter1);

        SL241109Bean slChapter2 = new SL241109Bean();
        slChapter2.setChapNo(2);
        slChapter2.setChapTitle("神农客商城分销产品品牌");
        slChapter2.setContent("<<神农客商城分销产品品牌介绍>>");
        slChapter2.setContentHref("22222");
        slChapters.add(slChapter2);
        
        SL241109Bean slChapter3 = new SL241109Bean();
        slChapter3.setChapNo(2);
        slChapter3.setChapTitle("产品标准及质量管控");
        slChapter3.setContent("<神农客商城产品标准及质量管控>>");
        slChapter3.setContentHref("33333");
        slChapters.add(slChapter3);
        
        SL241109Bean slChapter4 = new SL241109Bean();
        slChapter4.setChapNo(4);
        slChapter4.setChapTitle("卖家分销审批");
        slChapter4.setContent("");
        slChapter1.setContentHref("444444");
        slChapters.add(slChapter4);
        
        SL241109Bean slChapter5 = new SL241109Bean();
        slChapter5.setChapNo(5);
        slChapter5.setChapTitle("神农客价盘");
        slChapter5.setContent("");
        slChapter5.setContentHref("55555");
        slChapters.add(slChapter5);
        
        SL241109Bean slChapter6 = new SL241109Bean();
        slChapter6.setChapNo(6);
        slChapter6.setChapTitle("分销计划分配");
        slChapter6.setContent("");
        slChapter6.setContentHref("666");
        slChapters.add(slChapter6);
        
        SL241109Bean slChapter7 = new SL241109Bean();
        slChapter7.setChapNo(7);
        slChapter7.setChapTitle("分销卖家库存管理");
        slChapter7.setContent("");
        slChapter7.setContentHref("777777");
        slChapters.add(slChapter7);
        
        SL241109Bean slChapter8 = new SL241109Bean();
        slChapter8.setChapNo(8);
        slChapter8.setChapTitle("神农客商城费用收取标准");
        slChapter8.setContent("");
        slChapter8.setContentHref("8888");
        slChapters.add(slChapter8);
        
        SL241109Bean slChapter9 = new SL241109Bean();
        slChapter9.setChapNo(9);
        slChapter9.setChapTitle("资金结算");
        slChapter9.setContent("");
        slChapter9.setContentHref("9999999");
        slChapters.add(slChapter9);
        
        SL241109Bean slChapter10 = new SL241109Bean();
        slChapter10.setChapNo(10);
        slChapter10.setChapTitle("资金结算");
        slChapter10.setContent("");
        slChapter10.setContentHref("101010101");
        slChapters.add(slChapter10);
        
        SL241109Bean slChapter11 = new SL241109Bean();
        slChapter11.setChapNo(11);
        slChapter11.setChapTitle("货权管理");
        slChapter11.setContent("");
        slChapter11.setContentHref("111111111111");
        slChapters.add(slChapter11);
        
        SL241109Bean slChapter12 = new SL241109Bean();
        slChapter12.setChapNo(12);
        slChapter12.setChapTitle("卖家持续供应计划");
        slChapter12.setContent("");
        slChapter12.setContentHref("1212121212");
        slChapters.add(slChapter12);
        
        
        SL241109Bean slChapter13 = new SL241109Bean();
        slChapter13.setChapNo(13);
        slChapter13.setChapTitle("卖家退换货申明");
        slChapter13.setContent("");
        slChapter13.setContentHref("13131313");
        slChapters.add(slChapter13);
        
        SL241109Bean slChapter14 = new SL241109Bean();
        slChapter14.setChapNo(14);
        slChapter14.setChapTitle("平台法律声明(免责)");
        slChapter14.setContent("");
        slChapter14.setContentHref("1414141414");
        slChapters.add(slChapter14);
        result.setData(slChapters);
        return result;
    }
    
}
