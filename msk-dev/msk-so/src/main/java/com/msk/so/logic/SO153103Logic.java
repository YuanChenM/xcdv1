package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.so.bean.SO153103Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/1/29.
 */
@Service
public class SO153103Logic extends BaseLogic {

    private static Logger logger = LoggerFactory.getLogger(SO153103Logic.class);


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 买家-交易记录详情
     * @return
     */
    public SO153103Bean findOne(){
        SO153103Bean sO153103Bean = new SO153103Bean();
        sO153103Bean.setName("鸡大腿 交易号 2016012521001004150044367284 商户订单号 202_10788905972");
        sO153103Bean.setCoupon("-0.00");
        sO153103Bean.setDiscount("+0.00");
        sO153103Bean.setPrice("1000");
        sO153103Bean.setServiceCharge("200");
        sO153103Bean.setTotal("2000");
        sO153103Bean.setType("食品");
        return sO153103Bean;
    }

}
