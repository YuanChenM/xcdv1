package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.SO151414Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author sjj 发货单列表Logic
 */
@Service
public class SO151414Logic extends BaseLogic {
    private static Logger logger = LoggerFactory.getLogger(SO151414Logic.class);

    /**
     * 查询仓库list
     *
     * @return
     */
    public List<SO151414Bean> findWhList() {
        return super.findList(new BaseParam());
    }

    /**
     * @param basePageParam
     * @return PageResult
     */
    public PageResult<SO151414Bean> search(BasePageParam basePageParam) {
        PageResult<SO151414Bean> results = this.findPage(basePageParam, SO151414Bean.class);
        return results;
    }

    /**
     * 保存
     *
     * @param shipIdList
     * @param whCode
     */
    @Transactional
    public void save(Collection<SO151414Bean> shipIdList, BaseParam param, String whCode) {
        SO151414Bean saveParam = new SO151414Bean();
        saveParam.setUpdId(param.getUpdId());
        saveParam.setUpdTime(DateTimeUtil.getCustomerDate());
        saveParam.setWhCode(whCode);
        for (SO151414Bean bean : shipIdList) {
            saveParam.getShipIdList().add(Long.parseLong(bean.getShipId()));
        }
        super.modify(SqlId.SQL_ID_UPDATE_WH, saveParam);
    }

    interface SqlId {
        String SQL_ID_UPDATE_WH = "modifyWhCode";
    }


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}