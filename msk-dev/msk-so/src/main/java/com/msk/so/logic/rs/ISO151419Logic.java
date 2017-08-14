package com.msk.so.logic.rs;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.*;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liutao on 2016/10/11.
 */
@Service
public class ISO151419Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    private static Logger logger = LoggerFactory.getLogger(ISO151419Logic.class);

    /**
     * 查询评价是否已提交
     * @param param
     * @return
     */
    @Transactional
    public ISO151419RsResult searchEvaluateSubmit(ISO151419RsParam param){
        return (ISO151419RsResult)this.findOne(param);
    }
}
