package com.msk.sl.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.sl.bean.SL241101Bean;

/**
 * 
 * 卖家审批审核列表Logic.
 *
 * @author gyh
 */
public class Sl241101Logic extends BaseLogic {

    /**
     * SQL Map 中SQL ID定义
     * 
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_FIND_DDJSH_BY_SL_CODE = "findDdjshBySlCode";
        static final String SQL_ID_FIND_DJKRSH_BY_SL_CODE = "findDjkrshBySlCode";
    }
    public PageResult<SL241101Bean> getListInfo() {
        PageResult<SL241101Bean> result = new PageResult<SL241101Bean>();
        result.setRecordsTotal(3);
        List<SL241101Bean> slAccounts = new ArrayList<SL241101Bean>();
        SL241101Bean slAccount1 = new SL241101Bean();
        slAccount1.setSlCode("1101010001");
        slAccount1.setSlShowName("上海浦东新区公司");
        slAccount1.setSelfFlg("1");
        slAccount1.setProxyFlg("1");
        slAccount1.setOemFlg("0");
        slAccount1.setSlContact("李先生");
        slAccount1.setSlTel("13589647968");
        slAccount1.setDdjsh("有");
        slAccount1.setDdjkr("无");
        slAccount1.setCityName("上海上海市浦东新区");
        slAccounts.add(slAccount1);
        SL241101Bean slAccount2 = new SL241101Bean();
        slAccount2.setSlCode("1201090002");
        slAccount2.setSlShowName("南京市六合区公司");
        slAccount2.setSelfFlg("0");
        slAccount2.setProxyFlg("1");
        slAccount2.setOemFlg("0");
        slAccount2.setSlContact("王先生");
        slAccount2.setSlTel("15348965475");
        slAccount2.setDdjsh("无");
        slAccount2.setDdjkr("有");
        slAccount2.setCityName("江苏南京市六合区");
        slAccounts.add(slAccount2);
        SL241101Bean slAccount3 = new SL241101Bean();
        slAccount3.setSlCode("1101020003");
        slAccount3.setSlShowName("上海市黄浦区公司");
        slAccount3.setSelfFlg("0");
        slAccount3.setProxyFlg("1");
        slAccount3.setOemFlg("1");
        slAccount3.setSlContact("张先生");
        slAccount3.setSlTel("13587965339");
        slAccount3.setDdjsh("有");
        slAccount3.setDdjkr("有");
        slAccount3.setCityName("上海上海市黄浦区");
        slAccounts.add(slAccount3);
        SL241101Bean slAccount4 = new SL241101Bean();
        slAccount4.setSlCode("1101020003");
        slAccount4.setSlShowName("上海市静安区公司");
        slAccount4.setSelfFlg("0");
        slAccount4.setProxyFlg("1");
        slAccount4.setOemFlg("1");
        slAccount4.setSlContact("江先生");
        slAccount4.setSlTel("13587965449");
        slAccount4.setDdjsh("无");
        slAccount4.setDdjkr("无");
        slAccount4.setCityName("上海市静安区");
        slAccounts.add(slAccount4);
        result.setData(slAccounts);
        return result;
    }
    /**
     * 根据卖家编号查询待定级审核有无     *
     *
     * @return
     * @author gyh
     */
    public SL241101Bean findResult1(String slCode){
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("slCode", slCode);
        return super.findOne(SqlId.SQL_ID_FIND_DDJSH_BY_SL_CODE, map);
    }
    
    /**
     * 根据卖家编号查询待监控人审核有无     *
     *
     * @return
     * @author gyh
     */
    public SL241101Bean findResult2(String slCode){
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("slCode", slCode);
        return super.findOne(SqlId.SQL_ID_FIND_DJKRSH_BY_SL_CODE, map);
    }
    /**
     * 获取展示数据并匹配审核有无     *
     *
     * @param basePageParam
     * @return
     * @author gyh
     */
    public  PageResult<SL241101Bean> findPageResult(BasePageParam basePageParam){
        PageResult<SL241101Bean> pageResult=this.findPage(basePageParam, SL241101Bean.class);
        List<SL241101Bean> listinfo=pageResult.getData();
        for (SL241101Bean sl241101Bean : listinfo) {
            SL241101Bean sl1=this.findResult1(sl241101Bean.getSlCode());
            SL241101Bean sl2=this.findResult2(sl241101Bean.getSlCode());
            sl241101Bean.setDdjsh(sl1.getDdjsh());
            sl241101Bean.setDdjkr(sl2.getDdjkr());
        }
        return pageResult;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
