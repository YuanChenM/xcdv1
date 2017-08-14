package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlEpCap;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 更新企业生产能力信息
 * Created by Administrator on 2016/1/28.
 */
@Service
public class SL24110300402Logic extends BaseLogic{
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        static  final String SQL_ID_SAVE_SLEPCAP = "saveSlEpCap";
        static final String SQL_ID_SELECT_SLEPCAPDATA="selectSlEpCapData";
        static final String SQL_ID_UPDATE_SLEPCAP ="updateSlEpCap";
        static  final String SQL_ID_ADD_SLEPCAP = "addSlEpCap";
    }

    /**
     * 接口数据新增企业生产能力
     * @param slEpCap 传递参数类型
     */
//    public void addSlEpCap(SlEpCap slEpCap) {
//        super.save(SqlId.SQL_ID_ADD_SLEPCAP,slEpCap);
//    }
    /**
     * 保存数据到数据库表中
     * @param slEpCap
     */
    @Transactional
    public void saveSlEpCap(SlEpCap slEpCap) {
        super.save(SqlId.SQL_ID_SAVE_SLEPCAP,slEpCap);
    }

    /**
     * 查询用户厂区概要信息是否存在，厂区概要仅仅需要一条就可以了
     * 若已经存在  直接更新操作，若不存在 执行插入操作
     * @param slEpId 企业ID
     */
    public SlEpCap findSlEpCapIfExist(Long slEpId) {
        BaseParam base = new BaseParam();
        base.setFilter("epId", StringUtil.toSafeString(slEpId));
        SlEpCap slEpCap=super.findOne(SqlId.SQL_ID_SELECT_SLEPCAPDATA, base);
        return slEpCap;
    }

    /**
     * 如果已经存在了厂房信息，则进行更新操作
     * @param slEpCap 更新数据
     */
    public void updateSlEpCap(SlEpCap slEpCap) {
        super.modify(SqlId.SQL_ID_UPDATE_SLEPCAP,slEpCap);
    }

}
