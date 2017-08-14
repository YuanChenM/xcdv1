package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.PdLogiarea;
import com.msk.pd.bean.PD144103Bean;
import com.msk.pd.bean.PD144103Param;
import com.msk.pd.bean.PD144104Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


/**
 * PD144103Logic
 * 产品楼层设置
 *
 * @author ren_qiang
 */

@Service
public class PD144103Logic extends BaseLogic {
    @Autowired
    private PD144104Logic pd144104Logic;
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * sqlName
     */
    interface SqlId {
        static final String SQL_ID_FIND_LGCS_INFO = "findLgcsInfo"; //获取物流区
        static final String SQL_ID_UPDATE_SORT = "updateSort"; //修改排序
        static final String SQL_ID_DELETE_APP_FLOOR = "deleteAppFloor"; //修改排序

    }

    /**
     * 获取物流区
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdLogiarea> getLgcsAreaInfo() {
        BaseParam param = new BaseParam();
        return this.findList(SqlId.SQL_ID_FIND_LGCS_INFO, param);
    }

    /**
     * 批量修改顺序
     *
     * @param beans
     * @param param
     * @return
     */
    @Transactional
    public Integer batchEditSort(Collection<PD144103Bean> beans, PD144103Param param) {
        Integer result = null;
        for (PD144103Bean bean : beans) {
            bean.setUpdTime(param.getUpdTime());
            bean.setUpdId(param.getUpdId());
            result = this.modify(SqlId.SQL_ID_UPDATE_SORT, bean);
        }
        return result;
    }

    @Transactional
    public Integer delete(PD144103Bean bean) {
        // 排他处理.
        if (null != bean.getId()) {
            super.versionValidator("PD_APP_FLOOR", new String[]{"ID"}, new Object[]{bean.getId()}, bean.getVer());
        }
        Integer result = this.modify(SqlId.SQL_ID_DELETE_APP_FLOOR, bean);

        //删除楼层对应的产品
        PD144104Param param = new PD144104Param();
        param.setFloorId(String.valueOf(bean.getId()));
        pd144104Logic.remove(param);
        return result;
    }
}
