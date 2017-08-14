package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.PdStandard;
import com.msk.core.exception.BusinessException;
import com.msk.pd.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xhy
 * @version 创建时间：2016年3月10日 下午15:26:20
 *          产品技术标准接口  返回技术列表
 */
@Service
public class IPD141121Logic extends BaseLogic {



    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询产品等级&卫生质量标准
     *
     * @return List 返回list集合
     * @version xhy
     */
    @Transactional(readOnly = true)
    public List<IPD141121RsResult> findListMct(IPD141121RsParam param) {

        if (param == null) {
            param = new IPD141121RsParam();
        }
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("classestreeCode",param.getClassesCode()+param.getMachiningCode()+param.getBreedCode());
        List<IPD141121RsResult>  beanList= super.findList(baseParam);
        return beanList;
    }

    @Transactional(readOnly = true)
    public List<BaseEntity> selectSourceMct(IPD141146RsParam param) {

        if (param == null) {
            param = new IPD141146RsParam();
        }
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("classestreeCode",param.getClassesCode()+param.getMachiningCode()+param.getBreedCode());
        List<BaseEntity> beanList= super.findList(baseParam);
        return beanList;
    }

}