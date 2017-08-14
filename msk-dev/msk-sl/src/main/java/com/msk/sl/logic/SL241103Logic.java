package com.msk.sl.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.msk.core.entity.SlEpDd;
import com.msk.core.entity.SlSeller;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;

@Service
public class SL241103Logic extends BaseLogic {

    /**
     * SQL Map 中SQL ID定义
     * 
     * @author pxg
     */
    interface SqlId {
        String SQL_ID_QUERYTONE = "querytOne";
        String SQL_ID_QUERYLIST = "queryList";
        String SQL_ID_QUERYLIST2 = "queryList2";
        String SQL_ID_SELECTLIST="findListTeam";
        String SQL_ID_SELECTONE="findOneSlSeller";
        String SQL_ID_FIND_QUERY_SLEPDD="querySlEpDd";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 根据卖家编码查询出卖家的企业ID信息，用与拼接文件服务器图片路径
     * @param slCode 卖家编码
     * @return 返回卖家基本信息对象
     */
    public SlSeller findSlSellerBySlCode(String slCode) {
        BaseParam base = new BaseParam();
        base.setFilter("slCode",slCode);
        SlSeller slSeller= super.findOne(SqlId.SQL_ID_SELECTONE,base);
        return slSeller;
    }

    /**
     * 根据卖家编码查询卖家下面所有的电商团队成员
     * @param slCode 卖家编码
     * @return 返回卖家成员集合
     */
    public List<SL24110307Bean> findEcTeamList(String slCode) {
        BaseParam base = new BaseParam();
        base.setFilter("slCode",slCode);
        base.setFilter("delFlg","0");
        List<SL24110307Bean> list=super.findList(SqlId.SQL_ID_SELECTLIST,base);
        return list;
    }
    /**
     * 根据企业ID查询企业专业资质
     * 
     * @author pxg
     */
    public List<SL24110302Bean> findSL24110302Bean(BaseParam param) {
        return super.findList(SqlId.SQL_ID_QUERYLIST, param);
    }

    /**
     * 根据企业ID企业标识
     * 
     * @author pxg
     */
    public SlSeller findSlSeller(BaseParam param) {
        return super.findOne(SqlId.SQL_ID_QUERYTONE, param);
    }

    /**
     * 根据证照ID查询企业资质详细
     * 
     * @author pxg
     */
    public List<SL24110302_1Bean> findSL24110302_1Bean(BaseParam param) {
        return super.findList(SqlId.SQL_ID_QUERYLIST2, param);
    }


    /**
     * 根据企业ID查询企业检测设备
     * @author pxg
     */
    public List<SlEpDdBean> findEpEquipment(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_QUERY_SLEPDD, param);
    }


    /**
     * 生产商列表
     * 
     * @param
     * @return PageResult
     * @author hyx
     */
    public PageResult<SlEpAgentAuth> selectListPe() {

        PageResult<SlEpAgentAuth> pageResult = new PageResult<SlEpAgentAuth>();
        ArrayList<SlEpAgentAuth> list = new ArrayList<SlEpAgentAuth>();
        SlEpAgentAuth bean = new SlEpAgentAuth();
        bean.setProducerEpId(1101010001L);
        bean.setOnTime("2013-06-11 ~ 2020-08-10");
        bean.setEpName("上海浦东区风华公司");
        bean.setSlAreaCode("上海上海市浦东新区");
        list.add(bean);
        SlEpAgentAuth bean2 = new SlEpAgentAuth();
        bean2.setProducerEpId(1201090002L);
        bean2.setOnTime("2010-06-11 ~ 2035-11-30");
        bean2.setEpName("北京真龙公司");
        bean2.setSlAreaCode("北京市六合区");
        list.add(bean2);
        SlEpAgentAuth bean3 = new SlEpAgentAuth();
        bean3.setProducerEpId(1101020003L);
        bean3.setOnTime("2015-06-11 ~ 2025-06-10");
        bean3.setEpName("无锡同人区库金公司");
        bean3.setSlAreaCode("无锡市同人区");
        list.add(bean3);

        pageResult.setData(list);
        pageResult.setRecordsTotal(list.size());

        return pageResult;

    }

    /*
     * pxg
     * 企业基本资质
     */
    public SL24110301Bean selectSlenterPrise() {
        SL24110301Bean sl01 = new SL24110301Bean();
        sl01.setEpName("神农客");
        sl01.setLicNo("32323232323232");
        sl01.setLicAddr("上海市浦东");
        sl01.setLicLegalPerson("王东");
        sl01.setLicBusiType("好再来有限责任公司");
        sl01.setLicBusiScope("牛羊肉");
        sl01.setLicRegCapital(new BigDecimal(100000.00));
        sl01.setLicPaidinCapital(new BigDecimal(19000.00));
        sl01.setLicCrtDate(new Date());
        sl01.setLicTermEnd(new Date());
        sl01.setTaxNo("国税 沪字 88888888888888号");
        sl01.setTaxVatNo("32323232");
        sl01.setOrgNo("88888888-8");
        sl01.setBalLegalPerson("李四");
        sl01.setBalBank("建设银行分行");
        sl01.setBalAccount("623324252425245");
        return sl01;
    }

    /*
     * 企业专业资质审批
     * pxg
     */
    public List<SL24110302Bean> selectSlEpCert() {
        List<SL24110302Bean> list = new ArrayList<SL24110302Bean>();
        SL24110302Bean bean = new SL24110302Bean();
        bean.setEpId(1);// 企业id
        bean.setCertId(1);// 证照id
        bean.setCertName("动物防疫条件合格证");// 证照名称
        SL24110302Bean bean2 = new SL24110302Bean();
        bean2.setEpId(1);// 企业id
        bean2.setCertId(2);// 证照id
        bean2.setCertName("定点屠宰证");// 证照名称
        SL24110302Bean bean3 = new SL24110302Bean();
        bean3.setEpId(1);// 企业id
        bean3.setCertId(3);// 证照id
        bean3.setCertName("QS证");// 证照名称
        SL24110302_1Bean beans = new SL24110302_1Bean();
        beans.setEpId("1");// 企业ID
        beans.setCertId("1");// 证照ID
        beans.setCertItemId("1"); // 证照项目ID
        beans.setCertItemName("代码编号");// 证照项目名称
        beans.setCertItemValue("888888888888");// 证照项目内容
        SL24110302_1Bean beans1 = new SL24110302_1Bean();
        beans1.setEpId("1");// 企业ID
        beans1.setCertId("1");// 证照ID
        beans1.setCertItemId("2"); // 证照项目ID
        beans1.setCertItemName("年检日期");// 证照项目名称
        beans1.setCertItemValue("2015-12-11");// 证照项目内容
        List<SL24110302_1Bean> list2 = new ArrayList<SL24110302_1Bean>();
        list2.add(beans);
        list2.add(beans1);
        bean.setBeanList(list2);
        SL24110302_1Bean beans2 = new SL24110302_1Bean();
        beans2.setEpId("1");// 企业ID
        beans2.setCertId("2");// 证照ID
        beans2.setCertItemId("1"); // 证照项目ID
        beans2.setCertItemName("定点屠宰代码");// 证照项目名称
        beans2.setCertItemValue("4398323");// 证照项目内容
        SL24110302_1Bean beans3 = new SL24110302_1Bean();
        beans3.setEpId("1");// 企业ID
        beans3.setCertId("2");// 证照ID
        beans3.setCertItemId("2"); // 证照项目ID
        beans3.setCertItemName("批准号");// 证照项目名称
        beans3.setCertItemValue("11111111");// 证照项目内容
        List<SL24110302_1Bean> list3 = new ArrayList<SL24110302_1Bean>();
        list3.add(beans2);
        list3.add(beans3);
        bean2.setBeanList(list3);
        SL24110302_1Bean beans4 = new SL24110302_1Bean();
        beans4.setEpId("1");// 企业ID
        beans4.setCertId("3");// 证照ID
        beans4.setCertItemId("1"); // 证照项目ID
        beans4.setCertItemName("证书编号");// 证照项目名称
        beans4.setCertItemValue("4398323");// 证照项目内容
        SL24110302_1Bean beans5 = new SL24110302_1Bean();
        beans5.setEpId("1");// 企业ID
        beans5.setCertId("3");// 证照ID
        beans5.setCertItemId("2"); // 证照项目ID
        beans5.setCertItemName("有效期");// 证照项目名称
        beans5.setCertItemValue("2012-11-11");// 证照项目内容
        List<SL24110302_1Bean> list4 = new ArrayList<SL24110302_1Bean>();
        list4.add(beans4);
        list4.add(beans5);
        bean3.setBeanList(list4);
        list.add(bean);
        list.add(bean2);
        list.add(bean3);
        return list;
    }

    /*
     * pxg
     * 卖家电商团队
     */
    public List<SL24110307Bean> selectSlEcTeam() {
        List<SL24110307Bean> li = new ArrayList<SL24110307Bean>();
        SL24110307Bean bean = new SL24110307Bean();
        bean.setSlCode("1");
        bean.setMemberId("1");
        bean.setLeaderFlg("1");
        bean.setMemberName("王成");
        bean.setMemberAge("本科");
        bean.setMemberEduc("15120319243");
        SL24110307Bean bean2 = new SL24110307Bean();
        bean2.setSlCode("1");
        bean2.setMemberId("2");
        bean2.setLeaderFlg("0");
        bean2.setMemberName("李武");
        bean2.setMemberAge("本科");
        bean2.setMemberEduc("15120319333");
        SL24110307Bean bean3 = new SL24110307Bean();
        bean3.setSlCode("1");
        bean3.setMemberId("3");
        bean3.setLeaderFlg("0");
        bean3.setMemberName("张飞");
        bean3.setMemberAge("本科");
        bean3.setMemberEduc("15120323233");
        SL24110307Bean bean4 = new SL24110307Bean();
        bean4.setSlCode("1");
        bean4.setMemberId("3");
        bean4.setLeaderFlg("0");
        bean4.setMemberName("张飞");
        bean4.setMemberAge("本科");
        bean4.setMemberEduc("15120323233");
        li.add(bean);
        li.add(bean2);
        li.add(bean3);
        li.add(bean4);
        return li;

    }

    /**
     * rwf
     * 企业基本能力描述 将同一页面下的企业荣誉和厂房平面图放置在SL24110303Bean中
     * 后期可以根据slcode和epid获取
     */
    public SL24110303Bean selectLi3(String slCode, String epId) {
        SL24110303Bean sL24110303Bean = new SL24110303Bean();

        // 首先获取SL2411030301Bean 即企业荣誉
        List<SL2411030301Bean> list1 = new ArrayList<SL2411030301Bean>();
        SL2411030301Bean sl01 = new SL2411030301Bean();
        sl01.setEpId(1);
        sl01.setCertDate(new Date());
        sl01.setAptitudeDesc("发证日期：2015-12-16");
        sl01.setCertIssuer("发证单位:北京万达企业");

        SL2411030301Bean sl02 = new SL2411030301Bean();
        sl02.setEpId(NumberConst.IntDef.INT_ONE);
        sl02.setAptitudeDesc("发证日期：2015-12-17");
        sl02.setCertIssuer("发证单位:上海互联局");
        list1.add(sl01);
        list1.add(sl02);

        // 再获取厂房平面图
        List<SL2411030302Bean> list2 = new ArrayList<SL2411030302Bean>();
        SL2411030302Bean sl03 = new SL2411030302Bean();
        sl03.setEpId("1");
        sl03.setFtyAsset("333322");
        sl03.setFtyLandArea("4892");
        sl03.setFtyFloorArea("3382");
        sl03.setFtyEquipment("大型猪肉加工设备");
        sl03.setFtyDesignCap("1000");
        sl03.setFtyActualCap("999");
        sl03.setFtyFtRate("80");
        sl03.setFtyDsRate("10");
        sl03.setFtyAsRate("10");
        sl03.setAptitudeDesc("总资产：" + sl03.getFtyAsset() + "(万元)<br/>占地面积：" + sl03.getFtyLandArea() + "(平米)<br/>厂房面积：" + sl03.getFtyFloorArea() + "(平米)<br/>主要设备：" + sl03.getFtyEquipment() + "<br/>设计产能：" + sl03.getFtyDesignCap() + "吨/天<br/>实际产能：" + sl03.getFtyActualCap() + "吨/天<br/>外贸销售占比：" + sl03.getFtyFtRate() + "%<br/>直销占比：" + sl03.getFtyDsRate() + "%<br/>代理占比：" + sl03.getFtyAsRate() + "%");
        list2.add(sl03);

        // 新建一个SL24110303Bean对象用来接收企业基本能力描述信息
        sL24110303Bean.setsL2411030301BeanList(list1);
        sL24110303Bean.setsL2411030302BeanList(list2);
        return sL24110303Bean;
    }

    public SL24110304Bean selectLi4(String slCode, String epId) {
        SL24110304Bean sl24110304Bean = new SL24110304Bean();

        // 设置车间概括 实例化
        List<SL2411030303Bean> list1 = new ArrayList<SL2411030303Bean>();
        SL2411030303Bean sl01 = new SL2411030303Bean();
        sl01.setEpId(1);
        sl01.setWorkshopName("粗加工生产主车间");
        sl01.setProduct("鸡腿");
        sl01.setProcess("粗加工");
        sl01.setWorkshopDesc("1、车间名称：" + sl01.getWorkshopName() + "<br/>2、生产产品：" + sl01.getProduct() + "<br/>3、工艺流特点：" + sl01.getProcess());

        SL2411030303Bean sl02 = new SL2411030303Bean();
        sl02.setEpId(1);
        sl02.setWorkshopName("精加工生产车间");
        sl02.setProduct("鸡肉");
        sl02.setProcess("精加工");
        sl02.setWorkshopDesc("1、车间名称：" + sl02.getWorkshopName() + "<br/>2、生产产品：" + sl02.getProduct() + "<br/>" + "3、工艺流特点：" + sl02.getProcess());
        list1.add(sl01);
        list1.add(sl02);

        // 设置库容概括 实例化
        List<SL2411030302Bean> list2 = new ArrayList<SL2411030302Bean>();
        SL2411030302Bean sl03 = new SL2411030302Bean();
        sl03.setEpId("1");
        sl03.setScapMaterial("12000");
        sl03.setScapProduct("45000");
        sl03.setScapDesc("1、原料库容：" + sl03.getScapMaterial() + "(立方)<br/>1、产品库容：" + sl03.getScapProduct() + "(立方)");
        list2.add(sl03);
        sl24110304Bean.setsL2411030302BeanList(list2);
        sl24110304Bean.setsL2411030303BeanList(list1);
        return sl24110304Bean;
    }

    /***
     * 假数据 实验室
     * 
     */
    public SL2411030302Bean selectLi5(String slCode, String epId) {
        SL2411030302Bean sl01 = new SL2411030302Bean();
        sl01.setEpId("1");
        sl01.setLabArea("9000");
        sl01.setLabFunction("负责研发新产品,提升精产品");
        sl01.setLabInvestment("3000");
        sl01.setLabMember(300);
        sl01.setDdEquipment("真空保鲜");
        return sl01;
    }

    /***
     * 假数据 实验室
     *
     */
    public List<SlEpDdBean> noSlEpDdData() {
        List<SlEpDdBean> list=new ArrayList<>();
        SlEpDdBean slEpDd = new SlEpDdBean();
        slEpDd.setEpId(Long.valueOf(NumberConst.IntDef.INT_TWENTY_FIVE));
        slEpDd.setDdId(Long.valueOf(NumberConst.IntDef.INT_TWENTY_ONE));
        slEpDd.setDdName("冰柜");
        slEpDd.setDdEquipment("用来冰冻产品");
        SlEpDdBean slEpDdTwo = new SlEpDdBean();
        slEpDdTwo.setEpId(Long.valueOf(NumberConst.IntDef.INT_TWENTY_FIVE));
        slEpDdTwo.setDdId(Long.valueOf(NumberConst.IntDef.INT_TWENTY_ONE));
        slEpDdTwo.setDdName("冰柜");
        slEpDdTwo.setDdEquipment("用来冰冻产品");
        list.add(slEpDd);
        list.add(slEpDdTwo);
        return list;
    }

    /**
     * 查询企业管理
     * 
     * 
     */

    public List<SL24110306Bean> queryList() {

        List<SL24110306Bean> list = new ArrayList<SL24110306Bean>();
        SL24110306Bean sl0306 = new SL24110306Bean();
        sl0306.setMemberId(NumberConst.IntDef.INT_ONE);
        sl0306.setMemberDuties("公司董事长");
        sl0306.setMemberName("马云");
        sl0306.setMemberAge(25);
        sl0306.setMemberTel("13293540885");
        sl0306.setImage("图片1");
        sl0306.setMemberEduc("博士");
        list.add(sl0306);

        SL24110306Bean sl0306a = new SL24110306Bean();
        sl0306a.setMemberId(NumberConst.IntDef.INT_TWO);
        sl0306a.setMemberDuties("公司总经理");
        sl0306a.setMemberName("张总");
        sl0306a.setMemberAge(28);
        sl0306a.setMemberTel("13293540885");
        sl0306a.setImage("图片1");
        sl0306a.setMemberEduc("研究生");
        list.add(sl0306a);

        SL24110306Bean sl0306b = new SL24110306Bean();
        sl0306b.setMemberId(NumberConst.IntDef.INT_FOUR);
        sl0306b.setMemberDuties("公司副总经理");
        sl0306b.setMemberName("王总");
        sl0306b.setMemberAge(30);
        sl0306b.setMemberTel("13293540885");
        sl0306b.setImage("图片1");
        sl0306b.setMemberEduc("硕士");
        list.add(sl0306b);

        SL24110306Bean sl0306c = new SL24110306Bean();
        sl0306c.setMemberId(NumberConst.IntDef.INT_SIX);
        sl0306c.setMemberDuties("销售部经历");
        sl0306c.setMemberName("徐总");
        sl0306c.setMemberAge(32);
        sl0306c.setMemberTel("13293540885");
        sl0306c.setImage("图片1");
        sl0306c.setMemberEduc("博士");
        list.add(sl0306c);

        SL24110306Bean sl0306d = new SL24110306Bean();
        sl0306d.setMemberId(NumberConst.IntDef.INT_FIVE);
        sl0306d.setMemberDuties("财务部经理");
        sl0306d.setMemberName("马总");
        sl0306d.setMemberAge(30);
        sl0306d.setMemberTel("13293540885");
        sl0306d.setImage("图片1");
        sl0306d.setMemberEduc("研究生");
        list.add(sl0306d);
        return list;

    }

    // 查询品牌信息 品牌证书
    public List<SL24110308Bean> queryList0308() {
        List<SL24110308Bean> list0308 = new ArrayList<SL24110308Bean>();
        SL24110308Bean sl0308 = new SL24110308Bean();
        sl0308.setEpId(NumberConst.IntDef.INT_ONE);
        sl0308.setBrandName("好味道");
        sl0308.setBrandNo("389430034094509");
        sl0308.setEpName("神龙客");
        list0308.add(sl0308);
        return list0308;
    }

    /**
     * 
     * @return
     *         查询品牌荣誉
     *
     * @author chen_xin
     */
    public List<SL2411030801Bean> queryInfoList() {
        List<SL2411030801Bean> list030801 = new ArrayList<SL2411030801Bean>();
        SL2411030801Bean sl030801 = new SL2411030801Bean();
        sl030801.setHonorNo("DGDFGF");
        sl030801.setCertDate("2015-12-12 10:12:34");
        sl030801.setCertIssuer("阿里巴巴集团");
        list030801.add(sl030801);
        return list030801;
    }

    /*
     * OEM列表显示
     */
    public PageResult<SlEpOemAuth> selectListOem() {
        PageResult<SlEpOemAuth> pageResult = new PageResult<SlEpOemAuth>();
        ArrayList<SlEpOemAuth> list = new ArrayList<SlEpOemAuth>();

        SlEpOemAuth bean = new SlEpOemAuth();
        bean.setProducerEpId(1103010004L);
        bean.setOnTime("2012-06-11 ~ 2024-06-10");
        bean.setEpName("宏伟有限公司");
        bean.setSlAreaCode("湖北开阳区");
        list.add(bean);
        SlEpOemAuth bean1 = new SlEpOemAuth();
        bean1.setProducerEpId(1103010023L);
        bean1.setOnTime("2012-06-11 ~ 2024-06-10");
        bean1.setEpName("日立公司");
        bean1.setSlAreaCode("河南杨刚区");
        list.add(bean1);
        SlEpOemAuth bean2 = new SlEpOemAuth();
        bean2.setProducerEpId(1104010094L);
        bean2.setOnTime("2012-06-11 ~ 2024-06-10");
        bean2.setEpName("问鼎有限公司");
        bean2.setSlAreaCode("黑龙江哈尔区");
        list.add(bean2);
        SlEpOemAuth bean3 = new SlEpOemAuth();
        bean3.setProducerEpId(1130010114L);
        bean3.setOnTime("2012-06-11 ~ 2024-06-10");
        bean3.setEpName("米昂图有限公司");
        bean3.setSlAreaCode("上海开阳区");
        list.add(bean3);

        pageResult.setData(list);
        pageResult.setRecordsTotal(list.size());
        return pageResult;

    }

    /**
     * 生产商列表
     * 空方法
     * 
     * @param string xxxx
     * @param param xxx
     * @return PageResult
     *
     * @author xhy
     */
    public PageResult<SlEpAgentAuth> findListPm(String string, BaseParam param) {
        List<SlEpAgentAuth> list = super.findList(string, param);
        for (SlEpAgentAuth sl : list) {
            sl.setOnTime(DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, sl.getAuthTermBegin()) + "~" + DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, sl.getAuthTermEnd()));
        }
        PageResult<SlEpAgentAuth> page = new PageResult<SlEpAgentAuth>();
        page.setData(list);
        page.setRecordsTotal(list.size());
        return page;
    }

    /**
     * oem列表
     *
     *
     * @param string
     * @param param
     * @return oem列表
     *
     * @author Administrator
     */
    public PageResult<SlEpOemAuth> findListOem(String string, BaseParam param) {
        List<SlEpOemAuth> list = super.findList(string, param);
        for (SlEpOemAuth sl : list) {
            sl.setOnTime(DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, sl.getAuthTermBegin()) + "~" + DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, sl.getAuthTermEnd()));
        }
        PageResult<SlEpOemAuth> page = new PageResult<SlEpOemAuth>();
        page.setData(list);
        page.setRecordsTotal(list.size());
        return page;
    }

    /**
     * @param basePageParam 参数
     * @param slCode 卖家编码
     * @return PageResult
     * @author xhy
     */
    @Transactional(readOnly = true)
    public PageResult<SlEpAgentAuth> findPages(BasePageParam basePageParam, String slCode) {
        basePageParam.setFilter("slCode", slCode);
        PageResult<SlEpAgentAuth> page = super.findPage(basePageParam, SlEpAgentAuth.class);
        for (SlEpAgentAuth sl : page.getData()) {
            //sl.setOnTime(DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, sl.getAuthTermBegin()) + "~" + DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, sl.getAuthTermEnd()));
            if(!StringUtil.isNullOrEmpty(sl.getAuthTermBeginString()) && !StringUtil.isNullOrEmpty(sl.getAuthTermEndString())){
                sl.setOnTime(sl.getAuthTermBeginString() + "~" +sl.getAuthTermEndString());
            }else{
                sl.setOnTime("");
            }
        }
        PageResult<SlEpAgentAuth> pages = new PageResult<SlEpAgentAuth>();
        pages.setData(page.getData());
        pages.setRecordsTotal(page.getData().size());
        return pages;
    }

}
