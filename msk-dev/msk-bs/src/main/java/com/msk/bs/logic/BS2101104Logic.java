package com.msk.bs.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.MdProvince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 买手店管家会员列表
 * @author cx
 */
@Service
public class BS2101104Logic extends BaseLogic {

    @Autowired
      @Override
      public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public List<MdProvince> findProvinceName() {
        BaseParam param = new BaseParam();
        param.setFilter("","");
      return super.findList(param);
    }
}
