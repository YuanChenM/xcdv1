package com.msk.plr.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.file.excel.ExcelWrite;
import com.msk.core.file.excel.JxlsExcelWrite;
import com.msk.plr.bean.PLR170201Bean;
import com.msk.plr.bean.PLR170201Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gyh on 2017/2/13.
 * PC端财务人员计费查看
 */
@Service
public class PLR170201Logic extends BaseLogic {

    /**
     * sqlId
     */
    interface SqlId {
        static final String PL_SQL_ID_FIND_PARTNER = "findPartner";
        static final String PL_SQL_ID_FIND_TERMINAL = "findTerminal";
        static final String PL_SQL_ID_FIND_BS = "findBs";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询合伙人
     *
     * @param param 参数
     * @return 结果
     */
    public List<PLR170201Bean> findPartner(PLR170201Param param) {
        return this.findList(SqlId.PL_SQL_ID_FIND_PARTNER, param);
    }

    /**
     * 查询合伙人
     *
     * @param param 参数
     * @return 结果
     */
    public List<PLR170201Bean> findTerminal(PLR170201Param param) {
        return this.findList(SqlId.PL_SQL_ID_FIND_TERMINAL, param);
    }

    /**
     * 查询买手
     *
     * @param param 参数
     * @return 结果
     */
    public List<PLR170201Bean> findBs(PLR170201Param param) {
        return this.findList(SqlId.PL_SQL_ID_FIND_BS, param);
    }

    @Transactional(readOnly = true)
    public void exportData(OutputStream outputStream, BasePageParam pageParam) {
        InputStream inputStream = PLR170201Logic.class.getResourceAsStream("/template/reportTemp.xlsx");
        ExcelWrite excelWrite = new JxlsExcelWrite(inputStream, new BufferedOutputStream(outputStream));
        pageParam.setPaging(false);
        //分页数据
        List<PLR170201Bean> resultList = super.findPageList(pageParam,PLR170201Bean.class);
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("list",resultList);
        excelWrite.excelWrite(paramMap);
    }
}
