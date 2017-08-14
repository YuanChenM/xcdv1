package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.sl.bean.ISL231201RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ISL231201Logic.
 *
 * @author gyh
 */
@Service
public class ISL231201Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_FIND_SL_DIST_REGU_CHAP = "findSlDistReguChap";
    }

    /**
     * 根据类别查询章节
     * @param param 参数
     * @return 章节信息
     */
    public List<ISL231201RsResult> findSlDistReguChap(BaseParam param) {
        return this.findList(SqlId.SQL_ID_FIND_SL_DIST_REGU_CHAP, param);
    }
    /**
     * 获取章节信息
     * @return 章节信息
     */
    public List<ISL231201RsResult> findSlDistReguChap() {
        List<ISL231201RsResult> list=new ArrayList<ISL231201RsResult>();
        ISL231201RsResult rs=new ISL231201RsResult();
        rs.setChapId(1);
        rs.setChapNo(1);
        rs.setChapTitle("第一章节");
        rs.setVer(1);
        list.add(rs);
        return list;
    }

}
