package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.pl.bean.IPL20170206Param;
import com.msk.pl.bean.IPL20170206Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170206Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 产品查询接口
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public IPL20170206Result findPdById(IPL20170206Param param) {
        String pdNameAndFea[] = param.getPdName().split(" ");
        if (pdNameAndFea.length == 1) {
            pdNameAndFea = param.getPdName().split("　");
        }
        for (int i = 0; i < pdNameAndFea.length; i++) {
            if (i == 0) {
                param.setPdName(pdNameAndFea[i].trim());
            } else if (i == 1) {
                param.setFilter("featureName", pdNameAndFea[1].trim());
            }
        }
        IPL20170206Result result = super.findOne(param);
        if (result != null) {
            result.setPdGrade("A2");
        }
        return result;
    }

}
