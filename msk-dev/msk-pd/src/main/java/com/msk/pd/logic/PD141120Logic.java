package com.msk.pd.logic;

import java.util.List;

import com.msk.common.logic.CommonLogic;
import com.msk.core.consts.TableNameDef;
import com.msk.core.entity.PdPriceprdLogiarea;
import com.msk.pd.bean.PD141120Bean;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.MdLogisticsArea;
import com.msk.core.entity.PdOrderlevel;

/**
 * 产品品种Logic.
 *
 * @author gyh
 */
@Service
public class PD141120Logic extends BaseLogic {
    @Autowired
    private CommonLogic commonLogic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        String SQL_ID_FIND_PD_ORDERLEVEL = "findPdOrderlevel";
        String SQL_ID_FIND_LOGISTIC_AREA = "findLogisticsArea";
        String SQL_ID_FIND_PD_WAY_INFO = "findPdWayInfo";
        String SQL_ID_SAVE_PD_LOGIAREA_ORDER_LEVEL = "savePdLogiareaOrderlevel";
        String SQL_ID_SELECT_PD_LOGIAREA_PRICEPRD = "selectPriceprd";
        String SQL_ID_SAVE_PD_LOGIAREA_PRICEPRD_HISTORY = "savePriceprdHistory";
    }

    /**
     * 查询产品物流取订单等级信息
     * @param baseParam 参数
     * @return 结果
     * @author gyh
     */
    public List<PdPriceprdLogiarea> selectPriceprd(BaseParam baseParam){
        return this.findList(SqlId.SQL_ID_SELECT_PD_LOGIAREA_PRICEPRD, baseParam);
    }

    /**
     * 开始新周期价盘
     *
     * @author gyh
     */
    @Transactional(readOnly = false)
    public void newPriceprd() {
        //查询物流区产品价盘表
        List<PdPriceprdLogiarea> list = this.selectPriceprd(new BaseParam());
        for (PdPriceprdLogiarea priceprd : list) {
            //备份物流区产品价盘表到物流区产品价盘履历表
            priceprd.setPricecycleId(commonLogic.maxId(TableNameDef.PD_PRICEPRD_LOGIAREA_HISTORY, "HISTORY_ID"));
            this.save(SqlId.SQL_ID_SAVE_PD_LOGIAREA_PRICEPRD_HISTORY, priceprd);
        }
        BaseParam baseParam=new BaseParam();
        //清空产品物流区订单等级表
        baseParam.setFilter("table","0");
        super.remove(baseParam);
        //产品物流区订单等级表
        baseParam.setFilter("table","1");
        super.remove(baseParam);
    }

    /**
     * 保存数据到产品物流区订单等级表
     *
     * @param bean 参数
     * @return 结果
     */
    public int savePdLogiareaOrderlevel(PD141120Bean bean) {
        return this.save(SqlId.SQL_ID_SAVE_PD_LOGIAREA_ORDER_LEVEL, bean);
    }

    /**
     * * 查询通道等级
     *
     * @param param
     * @return 通道等级信息
     * @author gyh
     */
    @Transactional(readOnly = true)
    public List<PdOrderlevel> findPdWayInfo(BaseParam param) {
        return this.findList(SqlId.SQL_ID_FIND_PD_WAY_INFO, param);
    }

    /**
     * 查询价盘等级
     *
     * @return 加盘信息
     */
    @Transactional(readOnly = true)
    public List<PdOrderlevel> findPdOrderlevel(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_ORDERLEVEL, param);
    }

    /**
     * 查询物流区等级
     *
     * @return 加盘信息
     */
    @Transactional(readOnly = true)
    public List<MdLogisticsArea> findLogisticsArea(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_LOGISTIC_AREA, param);
    }


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
