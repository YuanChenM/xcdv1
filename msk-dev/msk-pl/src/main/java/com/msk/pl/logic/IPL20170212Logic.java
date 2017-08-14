package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.utils.StringUtil;
import com.msk.pl.bean.IPL2017021201Result;
import com.msk.pl.bean.IPL20170212Param;
import com.msk.pl.bean.IPL20170212Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170212Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 进货单激励费用查看
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public IPL20170212Result findFeeList(IPL20170212Param param) {
        IPL20170212Result result = new IPL20170212Result();
        List<IPL2017021201Result> list = (super.findList(param));
        BigDecimal big = new BigDecimal("0");
        BigDecimal bigTwo = new BigDecimal("0");
        if (list != null&&list.size()>0) {
            for (IPL2017021201Result returnOne : list) {
                if(returnOne.getStatus()!= 0){
                    big = big.add(returnOne.getIncentiveFee());
                }else{
                    returnOne.setIncentiveFee(bigTwo);
                }
            }
            result.setFeeList(list);
            result.setTotalAmount(big);
        }else{
            result.setTotalAmount(null);
        }
        return result;
    }

}
