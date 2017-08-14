package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.so.bean.SO153203Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/1/29.
 */
@Service
public class SO153203Logic extends BaseLogic {

    private static Logger logger = LoggerFactory.getLogger(SO153203Logic.class);


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 买家-交易记录详情
     * @return
     */
    public SO153203Bean findOne(){
        SO153203Bean SO153203Bean = new SO153203Bean();
        SO153203Bean.setName("鸡大腿 交易号 2016012521001004150044367284 商户订单号 202_10788905972");
        SO153203Bean.setCoupon("-0.00");
        SO153203Bean.setDiscount("+0.00");
        SO153203Bean.setPrice("1000");
        SO153203Bean.setServiceCharge("200");
        SO153203Bean.setTotal("2000");
        SO153203Bean.setType("食品");
        return SO153203Bean;
    }

}
