package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.PdAppFloor;
import com.msk.core.entity.PdLogiarea;
import com.msk.core.exception.BusinessException;
import com.msk.pd.bean.PD144103Bean;
import com.msk.pd.bean.PD144103Param;
import com.msk.pd.bean.PD144104Bean;
import com.msk.pd.bean.PD144104Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * PD144103Logic
 *产品楼层设置
 * @author ren_qiang
 */

@Service
public class PD144104Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private CommonLogic commonLogic;
    /**
     * sqlName
     */
    interface SqlId {
        static final String SQL_ID_GET_MAX_SORT = "getMaxSort"; //获取物流区
        static final String SQL_ID_GET_FLOOR_COUNT = "getFloorCount"; //获取市场需求标准列表
    }

    /**
     * 保存产品楼层信息
     * @param param
     * @return
     */
    @Transactional
    public String saveFloor(PD144103Param param){
        Long id = commonLogic.maxId("PD_APP_FLOOR","ID");
        if(null != param.getId()){
            id = param.getId();
            this.modify(param);
        }else{
            int count = this.getCount(SqlId.SQL_ID_GET_FLOOR_COUNT,param);
            if(count > NumberConst.IntDef.INT_ZERO){
                throw new BusinessException("该物流区已存在该楼层信息");
            }
            PdAppFloor pdAppFloor = this.findOne(SqlId.SQL_ID_GET_MAX_SORT,param);
            if(null != pdAppFloor){
                if(StringUtils.hasLength(pdAppFloor.getSort())){
                    param.setSort(pdAppFloor.getSort());
                }
            }
            else {
                param.setSort(String.valueOf(NumberConst.IntDef.INT_ONE));
            }
            param.setId(id);
            this.save(param);
        }
        return String.valueOf(id);
    }

    /**
     * 分页查询产品详细信息
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public PageResult<PD144104Bean> queryAppFloorDetail(PD144104Param param){
        return this.findPage(param,PD144104Bean.class);
    }

    /**
     * 删除产品详细信息
     * @param param
     * @return
     */
    @Transactional
    public Integer deleteFloorDetail(PD144104Param param){
        return this.remove(param);
    }
}
