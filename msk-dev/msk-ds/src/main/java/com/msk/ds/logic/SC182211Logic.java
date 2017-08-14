package com.msk.ds.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.DsLotSerial;
import com.msk.core.entity.DsPrintTask;
import com.msk.core.entity.DsSlPdLot;
import com.msk.core.entity.PdClassestree;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.ds.bean.SC182211Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * SC182211Logic.
 * @author pxg
 * @version 1.0
 **/
@Service
public class SC182211Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC182211Logic.class);
    /**
     * SQL Map 中SQL ID定义
     * @author pxg
     */
    private interface SqlId {
        String SQL_ID_FIND_EPNAMELIST = "findEpNameList";
        String SQL_ID_FIND_SLONECLASS = "findSlOneClass";
        String SQL_ID_FIND_SLPROPEPLIST = "findSlPropEpList";
        String SQL_ID_FIND_SLBRAND = "findSlBrand";
        String SQL_ID_FIND_NORMSOUT = "findNormsOut";
        String SQL_ID_FIND_SAVEDATA = "saveData";
        String SQL_ID_FIND_SLPDARTNO = "findSlPdArtno";
        String SQL_ID_FIND_DATAEXPORT = "findDataExport";
        String SQL_ID_FIND_DELETE_DATA = "findDeleteData";
        String SQL_ID_FIND_SAVEDSSLPDLOT = "saveDsSlPdLot";
        String SQL_ID_FIND_SAVEDDSLOTSERIAL = "saveDsLotSerial";
        String SQL_ID_FIND_QUERYDATASEARCH = "queryDataSearch";
        String SQL_ID_FIND_DATAEXISTED = "dataExisted";
        String SQL_ID_FIND_DATAEXISTEDTWO = "dataExistedTwo";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private CommonLogic commonLogic;
    /**
     * 查询所有卖家列表
     * @return 卖家名称
     */
    public List<SC182211Bean> findEpNameList(){
        BaseParam param=new BaseParam();
       return super.findList(SqlId.SQL_ID_FIND_EPNAMELIST,param);
    }

    /**
     * 根据卖家编码查询一级分类
     * @return 分类List
     */
    public List<PdClassestree> findSlOneClass(String slCode,String treeLevel,String parentCode,String classCode){
        BaseParam param=new BaseParam();
        param.setFilter("slCode",slCode);
        param.setFilter("parentCode",parentCode);
        if(!StringUtil.isNullOrEmpty(treeLevel) && treeLevel.equals("1")){
            param.setFilter("treeLevel","1");
        }else if(!StringUtil.isNullOrEmpty(treeLevel) && treeLevel.equals("2")){
            param.setFilter("treeLevel","2");
            param.setFilter("pdClassesCode",classCode);
        }else if(!StringUtil.isNullOrEmpty(treeLevel) && treeLevel.equals("3")){
            param.setFilter("treeLevel","3");
            param.setFilter("machiningCode",classCode);
        }else if(!StringUtil.isNullOrEmpty(treeLevel) && treeLevel.equals("4")){
            param.setFilter("treeLevel","4");
            param.setFilter("pdBreedCode",classCode);
        }
        else if(!StringUtil.isNullOrEmpty(treeLevel) && treeLevel.equals("5")){
            param.setFilter("treeLevel","5");
            param.setFilter("pdFeatureCode",classCode);
        }
        return super.findList(SqlId.SQL_ID_FIND_SLONECLASS,param);
    }

    /**
     * 根据卖家产品查询产品生产商
     * @return  生产商List
     */
    public List<SC182211Bean> findSlPropEpList(SC182211Bean sc182211Bean){
        BaseParam param=new BaseParam();
        param.getFilterMap().put("sc182211Bean",sc182211Bean);
        return super.findList(SqlId.SQL_ID_FIND_SLPROPEPLIST,param);
    }

    /**
     * 根据卖家查询品牌
     * @return  产品List
     */
    public List<SC182211Bean> querySlBrand(SC182211Bean sc182211Bean){
        BaseParam param=new BaseParam();
        param.getFilterMap().put("sc182211Bean",sc182211Bean);
        return super.findList(SqlId.SQL_ID_FIND_SLBRAND,param);
    }
    /**
     * 根据卖家查询包装规格
     * @return  产品List
     */
    public List<SC182211Bean> queryNormsOut(SC182211Bean sc182211Bean){
        BaseParam param=new BaseParam();
        param.getFilterMap().put("sc182211Bean",sc182211Bean);
        return super.findList(SqlId.SQL_ID_FIND_NORMSOUT,param);
    }

    /**
     * 保存数据
     * @return  保存结果
     */
    @Transactional
    public void saveData(SC182211Bean sc182211Bean){
        DsPrintTask dsPrintTask=new DsPrintTask();
        String dateTime=sc182211Bean.getPriceDate().replace("-", "");
        sc182211Bean.setPriceDate(dateTime);
        if(null!=sc182211Bean){
           Integer number=Integer.parseInt(sc182211Bean.getNumber());
           Integer numberTwo=Integer.parseInt(sc182211Bean.getNumberTwo());
            //插入卖家产品的批次管理表
            DsSlPdLot dsSlPdLotOne=this.dataExistedTwo(sc182211Bean);
            DsSlPdLot dsSlPdLot=new DsSlPdLot();
            Long lotId=0L;
            if(null==dsSlPdLotOne){
                lotId=commonLogic.maxId("ds_sl_pd_lot", "LOT_ID");
                dsSlPdLot.setLotId(lotId);
                dsSlPdLot.setClassesCode(sc182211Bean.getPdClassesCode());
                dsSlPdLot.setMachiningCode(sc182211Bean.getMachiningCode());
                dsSlPdLot.setBreedCode(sc182211Bean.getPdBreedCode());
                dsSlPdLot.setFeatureCode(sc182211Bean.getPdFeatureCode());
                dsSlPdLot.setLgcsName(sc182211Bean.getLgcsName());
                dsSlPdLot.setLgcsCode(sc182211Bean.getLgcsCode());
                dsSlPdLot.setWeightCode(sc182211Bean.getWeightCode());
                dsSlPdLot.setPkgCode(sc182211Bean.getNormsCode());
                dsSlPdLot.setGradeCode(sc182211Bean.getGroupCode());
                dsSlPdLot.setSlCode(sc182211Bean.getSlCode());
                dsSlPdLot.setSlCodeDis(sc182211Bean.getSlCodeDis());
                dsSlPdLot.setSlCodeManufacture(sc182211Bean.getSlCodeManufacture());
                dsSlPdLot.setSalesPlatform(sc182211Bean.getSalePlatform());
                dsSlPdLot.setManufacturer(sc182211Bean.getEpName());
                dsSlPdLot.setDateCode(sc182211Bean.getPriceDate()+sc182211Bean.getHalf());
                dsSlPdLot.setPdCode(sc182211Bean.getPdClassesCode()+sc182211Bean.getMachiningCode()+sc182211Bean.getPdBreedCode()+sc182211Bean.getPdFeatureCode()+sc182211Bean.getWeightCode()+sc182211Bean.getGroupCode());
                dsSlPdLot.setClassesName(sc182211Bean.getPdClassesName());
                dsSlPdLot.setMachiningName(sc182211Bean.getMachiningName());
                dsSlPdLot.setPdName(sc182211Bean.getPdClassesName()+" "+sc182211Bean.getMachiningName()+" "+sc182211Bean.getPdBreedName()+" "+sc182211Bean.getPdFeatureName()+" "+sc182211Bean.getWeightName()+" "+sc182211Bean.getGroupName());
                dsSlPdLot.setBreedName(sc182211Bean.getPdBreedName());
                dsSlPdLot.setFeatureName(sc182211Bean.getPdFeatureName());
                dsSlPdLot.setWeightName(sc182211Bean.getWeightName());
                dsSlPdLot.setGradeName(sc182211Bean.getGroupName());
                dsSlPdLot.setSlName(sc182211Bean.getSlCodeName());
                dsSlPdLot.setBrand(sc182211Bean.getBrandName());
                dsSlPdLot.setPkgSpec(sc182211Bean.getNormsOut());
                dsSlPdLot.setCrtId(sc182211Bean.getCrtId());
                dsSlPdLot.setCrtTime(new Date());
                dsSlPdLot.setDelFlg("0");
                dsSlPdLot.setVer(NumberConst.IntDef.INT_ONE);
                super.save(SqlId.SQL_ID_FIND_SAVEDSSLPDLOT,dsSlPdLot);
            }else{
                lotId=dsSlPdLotOne.getLotId();
            }
            int count=this.dataExisted(sc182211Bean);
            if(0<count){
                throw new BusinessException("流水号已经存在，请查询上次批次号后重新设置流水号!");
            }
            for (int i = number; i <=numberTwo; i++) {
                dsPrintTask.setTableId(commonLogic.maxId("ds_print_task","TABLE_ID"));
                SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                String aa=sim.format(new Date());
                Date date=DateTimeUtil.parseDate(aa, "yyyy-MM-dd HH-mm-ss");
                dsPrintTask.setPrintTaskId(StringUtil.toSafeString(date.getTime()));
                DecimalFormat df = new DecimalFormat("00000");
                final String numberData=df.format(i);
              /*  String numberData="00001";*/
                //生产商编码
                String epIdCode=sc182211Bean.getProdEpId().substring(sc182211Bean.getProdEpId().length()-6,sc182211Bean.getProdEpId().length());
                String mainClass=sc182211Bean.getSlCodeDis().substring(0,1);
                String mainClassOther=sc182211Bean.getSlCodeDis().substring(1,7);
                 //组成阅读码
                String readBar="";
                //自产商  1     代理商  2    OEM商  3
                if("1".equals(mainClass)){
                    readBar=sc182211Bean.getPdClassesCode()+sc182211Bean.getMachiningCode()+sc182211Bean.getPdBreedCode()+sc182211Bean.getPdFeatureCode()+sc182211Bean.getGroupCode()+
                            sc182211Bean.getWeightCode()+sc182211Bean.getNormsCode()+mainClass+sc182211Bean.getBrandClass()+mainClassOther+epIdCode+sc182211Bean.getBrandId()+sc182211Bean.getPriceDate()+sc182211Bean.getHalf()+numberData;
                }else if("2".equals(mainClass)){
                    readBar=sc182211Bean.getPdClassesCode()+sc182211Bean.getMachiningCode()+sc182211Bean.getPdBreedCode()+sc182211Bean.getPdFeatureCode()+sc182211Bean.getGroupCode()+
                            sc182211Bean.getWeightCode()+sc182211Bean.getNormsCode()+mainClass+sc182211Bean.getBrandClass()+mainClassOther+epIdCode+sc182211Bean.getBrandId()+sc182211Bean.getPriceDate()+sc182211Bean.getHalf()+numberData;
                }else if("3".equals(mainClass)){
                    readBar=sc182211Bean.getPdClassesCode()+sc182211Bean.getMachiningCode()+sc182211Bean.getPdBreedCode()+sc182211Bean.getPdFeatureCode()+sc182211Bean.getGroupCode()+
                            sc182211Bean.getWeightCode()+sc182211Bean.getNormsCode()+mainClass+sc182211Bean.getBrandClass()+mainClassOther+sc182211Bean.getBrandId()+epIdCode+sc182211Bean.getPriceDate()+sc182211Bean.getHalf()+numberData;
                }
                //组成操作码
                String operateBar="92"+sc182211Bean.getSlCodeDis()+sc182211Bean.getSlPdArtno()+sc182211Bean.getPriceDate()+sc182211Bean.getHalf()+numberData;

                dsPrintTask.setOperateBar(operateBar);
                dsPrintTask.setReadBar(readBar);
                dsPrintTask.setBrandName(sc182211Bean.getBrandName());
                dsPrintTask.setGradeName(sc182211Bean.getGroupName());
                /**新添加四个属性  应上海需求*/
                dsPrintTask.setProductName(sc182211Bean.getPdBreedName());
                dsPrintTask.setFeatureName(sc182211Bean.getPdFeatureName());
                dsPrintTask.setSuppName(sc182211Bean.getEpName());
                dsPrintTask.setNetWeight(sc182211Bean.getWeightName());
                dsPrintTask.setDelFlg("0");
                dsPrintTask.setCrtId(sc182211Bean.getCrtId());
                dsPrintTask.setCrtTime(new Date());
                dsPrintTask.setVer(NumberConst.IntDef.INT_ONE);
                //插入批次标签打印任务表
                super.save(SqlId.SQL_ID_FIND_SAVEDATA, dsPrintTask);
                //保存根据批次号生成的流水号
                DsLotSerial dsLotSerial=new DsLotSerial();
                dsLotSerial.setLotId(lotId);
                dsLotSerial.setSerialId(numberData);
                dsLotSerial.setLotCode(operateBar);
                dsLotSerial.setReadCode(readBar);
                dsLotSerial.setCrtId(sc182211Bean.getCrtId());
                dsLotSerial.setCrtTime(new Date());
                dsLotSerial.setDelFlg("0");
                dsLotSerial.setVer(NumberConst.IntDef.INT_ONE);
                super.save(SqlId.SQL_ID_FIND_SAVEDDSLOTSERIAL,dsLotSerial);

            }
        }
    }

    /**
     * 根据卖家产品查询货号
     * @return  生产商List
     */
    public List<SC182211Bean> findSlPdArtno(SC182211Bean sc182211Bean){
        BaseParam param=new BaseParam();
        param.getFilterMap().put("sc182211Bean",sc182211Bean);
        return super.findList(SqlId.SQL_ID_FIND_SLPDARTNO,param);
    }

    /**
     * 标签所有数据
     * @return  生产商List
     */
    public List<DsPrintTask> findDataExport(){
        BaseParam param=new BaseParam();
        return super.findList(SqlId.SQL_ID_FIND_DATAEXPORT,param);
    }

    /**
     * 删除所有数据
     * @return  生产商List
     */
    public int dataDelete(){
        BaseParam param=new BaseParam();
        return super.remove(SqlId.SQL_ID_FIND_DELETE_DATA, param);
    }


    /**
     * 查询上次批次数据
     * @return 批次最大值和最小值
     */
    public String dataSearch(SC182211Bean sc182211Bean){
        String code="";
        if(null!=sc182211Bean){
            code="92"+sc182211Bean.getSlCodeDis()+sc182211Bean.getSlPdArtno()+sc182211Bean.getPriceDate().replace("-", "")+sc182211Bean.getHalf();
        }
        BaseParam param=new BaseParam();
        param.setFilter("lotCode",code);
        SC182211Bean sc182211BeanTwo=super.findOne(SqlId.SQL_ID_FIND_QUERYDATASEARCH, param);
        String returnData="";
        if(null!=sc182211BeanTwo){
            returnData="最小值为:"+sc182211BeanTwo.getMinNumber()+",最大值为:"+sc182211BeanTwo.getMaxNumber();
        }
        return returnData;
    }


    /**
     * 查询批次数据是否存在
     * @return 批次数据结果值
     */
    public int dataExisted(SC182211Bean sc182211Bean){
        String code="";
        if(null!=sc182211Bean){
            code="92"+sc182211Bean.getSlCodeDis()+sc182211Bean.getSlPdArtno()+sc182211Bean.getPriceDate().replace("-", "")+sc182211Bean.getHalf()+sc182211Bean.getNumber();
        }
        BaseParam param=new BaseParam();
        param.setFilter("lotCode",code);
        int num=super.getCount(SqlId.SQL_ID_FIND_DATAEXISTED,param);
        return num;
    }

    /**
     * 查询批次数据是否存在
     * @return 批次数据结果值
     */
    public DsSlPdLot dataExistedTwo(SC182211Bean sc182211Bean){
        BaseParam param=new BaseParam();
        if(null!=sc182211Bean){
            sc182211Bean.setDateCode(sc182211Bean.getPriceDate().replace("-", "")+sc182211Bean.getHalf());
        }
        param.getFilterMap().put("sc182211Bean", sc182211Bean);
        DsSlPdLot dsSlPdLot=super.findOne(SqlId.SQL_ID_FIND_DATAEXISTEDTWO,param);
        return dsSlPdLot;
    }
}
