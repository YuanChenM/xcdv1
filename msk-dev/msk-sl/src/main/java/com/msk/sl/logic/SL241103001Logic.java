package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fjm on 2016/1/26.
 */
@Service
public class SL241103001Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        String SQL_ID_MODIFY_ONE = "modifyOne";
        String SQL_ID_SELECT_SLACCOUNT = "findOneByAccount";
        String SQL_ID_SELECT_SLACEntity = "findOneEntity";
        String SQL_ID_SAVE_SELLER = "saveSeller";
        String SQL_ID_FINDSLCODE = "findSlcode";
        String SQL_ID_SAVE_EP = "saveEp";
        String SQL_ID_FINDPROVINCECODE = "findProvinceCode";
        String SQL_ID_FINDCITYCODE = "findCityCode";
        String SQL_ID_FINDMDAREA = "findMdArea";
        String SQL_ID_FINDMDLOGISTICSAREA = "findMdLogisiticsArea";
        String SQL_ID_DINDACCOUNTLIST="findAccountList";
        String SQL_ID_FIND_SL_CODE_MANUFACTURE="findSlCodeManufacture";
        String SQL_ID_FIND_SL_CODE_OTHER="findSlCodeOther";
        String SQL_ID_FINDAREA="findArea";
        String SQL_ID_FINDLOGISTTICSAREA="findLogistTicsArea";
        String SQL_ID_FINDSLSELLER="findSlSeller";
    }

    /**
     * 根据省code 城市Code 区Code 查询该区域是否已经存在卖家 有就去后八位+1，作为顺序号 没有就直接+00000001
     * @param cityCode 市区域code
     * @return
     */
    public String findAccount(String slMainClass, String cityCode,String slConFlg) {
        String slCode=null;
        BaseParam base = new BaseParam();
        base.setFilter("cityCode",cityCode);
        base.setFilter("slMainClass",slMainClass);
        base.setFilter("slConFlg",slConFlg);
        //String startFlag=slMainClass+cityCode;
        /**查询出所有的卖家账号，查询，如果是以startFlag开头的，截取后八位*/
        int num = super.getCount(SqlId.SQL_ID_DINDACCOUNTLIST, base);
        if(num>0){
            slCode="";
        }else{
            if(slConFlg.equals("1")){
                slCode=slMainClass+cityCode+"001";
            }else{
                slCode=slMainClass+cityCode+"701";
            }
        }
        //List<SlSeller> list = new ArrayList<SlSeller>();
       /* for(SlSeller slSeller : lists){
            SlSeller slSellerTemp = new SlSeller();
            if(slSeller.getSlCode().startsWith(startFlag)){
                slSellerTemp.setSlCode(slSeller.getSlCode());
                list.add(slSellerTemp);
            }
        }*/
        /*if(list.size()==0){
            if(slConFlg.equals("1")){
                return slMainClass+cityCode+"001";
            }else{
                return slMainClass+cityCode+"701";
            }
        }else{
            Integer temp =0;
            String slCodeSuffix="";
            for(SlSeller slSeller:list){
                String suffix=slSeller.getSlCode().substring(4,7);
                Integer codeSuffix=Integer.parseInt(suffix);
                if(codeSuffix>temp){
                    temp=codeSuffix;
                }
            }
            temp=temp+1;
            if(temp<100){
                if(temp<10){
                    slCodeSuffix=slCodeSuffix+"0";
                }
                slCodeSuffix=slCodeSuffix+"0";
            }
            return slMainClass+cityCode+slCodeSuffix+temp.toString();
        }*/
        return slCode;
    }
    /**
     * 根据城市Code 查询该区域是否已经存在卖家生产商编码 有返回空，没有根据国际返回编码
     * @param cityCode 市区域code
     * @return 卖家生产商编码
     */
    public String findSlCodeManufacture(String cityCode,String slConFlg) {
        String slCodeManufacture=null;
        BaseParam base = new BaseParam();
        base.setFilter("cityCode",cityCode);
        base.setFilter("slConFlg",slConFlg);
        base.setFilter("isSlCodeManufacture","1");
        /**根据区域区划和国籍查询是否已经存在编码*/
        SlSeller slSeller = super.findOne(SqlId.SQL_ID_FIND_SL_CODE_MANUFACTURE, base);
        //存在，返回空字符串，在插入时进行
        if(!StringUtil.isNullOrEmpty(slSeller.getSlCodeManufacture())){
            DecimalFormat df = new DecimalFormat("000000");
            Integer number=Integer.parseInt(slSeller.getSlCodeManufacture());
            slCodeManufacture=df.format(number);
        }else{
            //国籍为国内从001开始
            if(slConFlg.equals("1")){
                slCodeManufacture=cityCode+"001";
            }else{
                //国籍为国外从7011开始
                slCodeManufacture=cityCode+"701";
            }
        }
        return slCodeManufacture;
    }

    /**
     * 根据城市Code 查询该区域是否已经存在卖家生产商编码 有返回空，没有根据国际返回编码
     * @param param 参数
     * @return 卖家生产商编码
     */
    public String findSlCodeOther(BaseParam param) {
        /**根据区域区划和国籍查询是否已经存在编码*/
        SlSeller slSeller = super.findOne(SqlId.SQL_ID_FIND_SL_CODE_OTHER, param);
        //判断获取的是哪个编码
        String selfFlg=StringUtil.toSafeString(param.getFilterMap().get("selfFlg"));
        String agentFlg=StringUtil.toSafeString(param.getFilterMap().get("agentFlg"));
        String oemFlg=StringUtil.toSafeString(param.getFilterMap().get("oemFlg"));
        String slConFlg=StringUtil.toSafeString(param.getFilterMap().get("slConFlg"));
        String cityCode=StringUtil.toSafeString(param.getFilterMap().get("cityCode"));
        //
        if("1".equals(selfFlg)){
            //存在，返回空字符串，在插入时进行
            if(!StringUtil.isNullOrEmpty(slSeller.getSlCodeSelf())){
                return StringUtil.toSafeString(Integer.parseInt(slSeller.getSlCodeSelf())+1);
            }else{
                if(slConFlg.equals("1")){
                    return "1"+cityCode+"001";
                }else{
                    return "1"+cityCode+"701";
                }
            }
        }else if("1".equals(agentFlg)){
            //存在，返回空字符串，在插入时进行
            if(!StringUtil.isNullOrEmpty(slSeller.getSlCodeAgent())){
                return StringUtil.toSafeString(Integer.parseInt(slSeller.getSlCodeAgent())+1);
            }else{
                if(slConFlg.equals("1")){
                    return 2+cityCode+"001";
                }else{
                    return 2+cityCode+"701";
                }
            }
        }else if("1".equals(oemFlg)){
            //存在，返回空字符串，在插入时进行
            if(!StringUtil.isNullOrEmpty(slSeller.getSlCodeOem())){
                return StringUtil.toSafeString(Integer.parseInt(slSeller.getSlCodeOem())+1);
            }else{
                if(slConFlg.equals("1")){
                    return 3+cityCode+"001";
                }else{
                    return 3+cityCode+"701";
                }
            }
        }
        return "";
    }

    /**
     * 根据物流区ID查询物流区id
     * @param lgcsAreaId 物流区id
     * @return 返回物流区编码
     */
    public String findLgcsAreaCode(Long lgcsAreaId) {
        BaseParam base = new BaseParam();
        base.setFilter("lgcsAreaId",lgcsAreaId.toString());
        MdLogisticsArea mdLogisiticsArea = super.findOne(SqlId.SQL_ID_FINDMDLOGISTICSAREA,base);
        return mdLogisiticsArea.getLgcsAreaCode();
    }

    /**
     * 根据areaId 查询大区编码
     * @param areaId 大区ID
     * @return 返回大区编码
     */
    public String findAreaCode(Long areaId) {
        BaseParam base = new BaseParam();
        base.setFilter("areaId",areaId.toString());
        MdArea mdArea = super.findOne(SqlId.SQL_ID_FINDMDAREA,base);
        return mdArea.getAreaCode();
    }

    /**
     * 根据市ID查询市
     * @param cityCode 市Code
     * @return MdCity
     */
    public MdCity findCity(String cityCode) {
        BaseParam base = new BaseParam();
        base.setFilter("cityCode",cityCode);
        return super.findOne(SqlId.SQL_ID_FINDCITYCODE,base);
    }

    /**根据省ID查询省*/
    public MdProvince findProvince(String provinceCode) {
        BaseParam base = new BaseParam();
        base.setFilter("provinceCode",provinceCode);
        return super.findOne(SqlId.SQL_ID_FINDPROVINCECODE, base);
    }

    public int saveAccount(SlAccount slAccount){
        return super.save(slAccount);
    }


    public int saveSeller(SlSeller slSeller){
        return super.save(SqlId.SQL_ID_SAVE_SELLER,slSeller);
    }


    public int saveEp(SlEnterprise slEnterprise){
        return super.save(SqlId.SQL_ID_SAVE_EP,slEnterprise);
    }


    public SlAccount slAccountEntity2(String slAccount) {
        BaseParam param = new BaseParam();
        param.setFilter("slAccount", slAccount);
        SlAccount slAccountSql1 = super.findOne(SqlId.SQL_ID_SELECT_SLACEntity, param);
        if(null == slAccountSql1 || "".equals(slAccountSql1)){
            throw  new BusinessException("卖家账户不存在");
        }
        return slAccountSql1;
    }

    public List<SlSeller> findlist(String slAreaCode){
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("slAreaCode",slAreaCode);
        return super.findList(baseParam);
    }

    public  SlSeller findSlCode(String slAreaCode){
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("slAreaCode",slAreaCode);
        return super.findOne(SqlId.SQL_ID_FINDSLCODE,baseParam);
    }


    public SlAccount slAccountEntity(String slAccount) {
        BaseParam param = new BaseParam();
        param.setFilter("slAccount", slAccount);
        SlAccount slAccountSql2 = super.findOne(SqlId.SQL_ID_SELECT_SLACCOUNT, param);
        return slAccountSql2;
    }



    public int modifyOne(SlAccount slAccount){
        return super.modify(SqlId.SQL_ID_MODIFY_ONE, slAccount);
    }


    /**
     * 查询大区编码
     * @return
     */
    public MdArea areaSelect(String provinceCode){
        BaseParam param=new BaseParam();
        param.setFilter("provinceCode",provinceCode);
        MdArea mdArea= super.findOne(SqlId.SQL_ID_FINDAREA, param);
        return mdArea;
    }

    /**
     * 查询物流编码
     * @return
     */
    public MdLogisticsArea logisticsAreaSelect(String lgcsAreaId){
        BaseParam param=new BaseParam();
        param.setFilter("lgcsAreaId",lgcsAreaId);
        MdLogisticsArea mdLogisticsArea= super.findOne(SqlId.SQL_ID_FINDLOGISTTICSAREA, param);
        return mdLogisticsArea;
    }

    /**
     * 查询卖家ID
     * @return
     */
    public SlSeller findSlSeller(String slAccount){
        BaseParam param=new BaseParam();
        param.setFilter("slAccount",slAccount);
        SlSeller slSeller= super.findOne(SqlId.SQL_ID_FINDSLSELLER, param);
        return slSeller;
    }
}
