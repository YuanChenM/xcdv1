package com.msk.by.logic;

import com.msk.by.bean.IBY121206RsParam;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.entity.ByBuyerPictures;
import com.msk.core.file.FileUtils;
import com.msk.core.file.FtpUtils;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.consts.BusinessConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.UUID;

/**
 * IBY121206Logic.
 *
 * @author zhou_yajun
 */
@Service
public class IBY121206Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121206Logic.class);

    @Autowired
    private CommonLogic commonLogic;
    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_yajun
     */
    interface SqlId {
        //买家证照图片信息获取
        static String SQL_FIND_PICTURES = "findPictures";
        //买家证照图片信息更新
        static String SQL_BUYER_PICTURES_MODIFY = "buyerPicturesModify";
        //买家证照图片信息插入
        static String SQL_BUYER_PICTURES_INSERT = "buyerPicturesInsert";
    }
    /**
     * (non-Javadoc)
     *
     * @see BaseLogic#setBaseDao(BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 买家证照信息更新接口
     * @param param
     * @return
     */
    @Transactional
    public int buyerLicencePicModify(IBY121206RsParam param){
        //根据传入参数获取买家图片信息
        BaseParam inParam = new BaseParam();
        inParam.setFilter("buyerId",param.getBuyerId());
        ByBuyerPictures pictures = super.findOne(SqlId.SQL_FIND_PICTURES,inParam);
        //营业执照
        String[] licenseId = new String[NumberConst.IntDef.INT_TWO];
        if(!StringUtil.isNullOrEmpty(param.getPicLicensePath())){
            String[] paramStr = param.getPicLicensePath().split("/");
            String filePath = "/" + paramStr[3] + "/" + paramStr[4] + "/" + paramStr[5];
            String fileName = paramStr[paramStr.length-1];
            licenseId = getFileId(filePath,fileName,param.getBuyerId());
        }
        //法定代表人
        String[] certId = new String[NumberConst.IntDef.INT_TWO];
        if(!StringUtil.isNullOrEmpty(param.getPicCertPath())){
            String[] paramStr = param.getPicCertPath().split("/");
            String filePath = "/" + paramStr[3] + "/" + paramStr[4] + "/" + paramStr[5];
            String fileName = paramStr[paramStr.length-1];
            certId = getFileId(filePath,fileName,param.getBuyerId());
        }
        //食品流通
        String[] foodId = new String[NumberConst.IntDef.INT_TWO];
        if(!StringUtil.isNullOrEmpty(param.getPicFoodCirculationPath())){
            String[] paramStr = param.getPicFoodCirculationPath().split("/");
            String filePath = "/" + paramStr[3] + "/" + paramStr[4] + "/" + paramStr[5];
            String fileName = paramStr[paramStr.length-1];
            foodId = getFileId(filePath,fileName,param.getBuyerId());
        }
        //组织机构代码
        String[] orgStructureId = new String[NumberConst.IntDef.INT_TWO];
        if(!StringUtil.isNullOrEmpty(param.getPicOrgStructurePath())){
            String[] paramStr = param.getPicOrgStructurePath().split("/");
            String filePath = "/" + paramStr[3] + "/" + paramStr[4] + "/" + paramStr[5];
            String fileName = paramStr[paramStr.length-1];
            orgStructureId = getFileId(filePath,fileName,param.getBuyerId());
        }
        //税务登记证
        String[] taxId = new String[NumberConst.IntDef.INT_TWO];
        if(!StringUtil.isNullOrEmpty(param.getPicTaxRegistrationPath())){
            String[] paramStr = param.getPicTaxRegistrationPath().split("/");
            String filePath = "/" + paramStr[3] + "/" + paramStr[4] + "/" + paramStr[5];
            String fileName = paramStr[paramStr.length-1];
            taxId = getFileId(filePath,fileName,param.getBuyerId());
        }
        ByBuyerPictures byPictures = new ByBuyerPictures();
        byPictures.setBuyerId(param.getBuyerId());
        byPictures.setBusLicPic(licenseId[NumberConst.IntDef.INT_ZERO]);
        byPictures.setBusLicSuf(licenseId[NumberConst.IntDef.INT_ONE]);
        byPictures.setOrgCertificatePic(orgStructureId[NumberConst.IntDef.INT_ZERO]);
        byPictures.setOrgCertificateSuf(orgStructureId[NumberConst.IntDef.INT_ONE]);
        byPictures.setTaxCertificatePic(taxId[NumberConst.IntDef.INT_ZERO]);
        byPictures.setTaxCertificateSuf(taxId[NumberConst.IntDef.INT_ONE]);
        byPictures.setFoodCertificatePic(foodId[NumberConst.IntDef.INT_ZERO]);
        byPictures.setFoodCertificateSuf(foodId[NumberConst.IntDef.INT_ONE]);
        byPictures.setLegalCertificatePic(certId[NumberConst.IntDef.INT_ZERO]);
        byPictures.setLegalCertificateSuf(certId[NumberConst.IntDef.INT_ONE]);
        if(null == pictures){
            return buyerPicturesSave(byPictures);
        }else {
            byPictures.setId(pictures.getId());
            byPictures.setUpdTime(DateTimeUtil.getCustomerDate());
            return super.modify(SqlId.SQL_BUYER_PICTURES_MODIFY,byPictures);
        }
    }

    /**
     * 买家证照图片插入
     * @param insertParam
     * @return
     */
    @Transactional
    public int buyerPicturesSave(ByBuyerPictures insertParam){
        Long id = commonLogic.maxId("by_buyer_Pictures", "ID");
        insertParam.setId(id);
        insertParam.setCrtId(insertParam.getUpdId());
        insertParam.setCrtTime(DateTimeUtil.getCustomerDate());
        insertParam.setUpdTime(DateTimeUtil.getCustomerDate());
        insertParam.setActId(insertParam.getUpdId());
        insertParam.setActTime(DateTimeUtil.getCustomerDate());
        insertParam.setUpdTime(DateTimeUtil.getCustomerDate());
        return super.save(SqlId.SQL_BUYER_PICTURES_INSERT,insertParam);
    }

    /**
     * 将ftp临时目录中的文件下载到本地，然后上传到ftp文件目录
     * @param tempPath
     * @param tempName
     * @param buyerId
     * @return
     */
    public String[] getFileId(String tempPath,String tempName,String buyerId){
        //ftpIp地址
        String url = ConfigManager.getFtpIp();
        //ftp登陆密码
        String password=ConfigManager.getFtpPwd();
        //ftp登陆名称
        String userName = ConfigManager.getFtpUser();
        //端口号
        int port= NumberConst.IntDef.INT_TWENTY_ONE;
        FtpUtils ftpUtils = new FtpUtils(url,port,userName,password);
        /*File tempFile = new File(tempFilePath);
        //ftp临时文件路径
        String tempPathFull = tempFile.getPath();
        String tempPath = tempPathFull.substring(0,tempPathFull.lastIndexOf("\\") + 1);
        //ftp临时文件名称
        String tempName = tempFile.getName();*/
        //ftp临时文件后缀名
        String fileSuffix = FileUtils.getFileSuffix(tempName);
        //下载保存到本地文件名称
        UUID uuid = UUID.randomUUID();
        String localFileName = String.valueOf(uuid) + StringConst.DOT+fileSuffix;
        //本地文件路径
        String localPath = System.getProperty("java.io.tmpdir");
        //从ftp下载文件到本地目录
        ftpUtils.download(tempPath,tempName,new File(localPath + "/" + localFileName));
        //图片上传到文件服务器
        String uploadFilePath = ConfigManager.getFtpImageRootPath() + BusinessConst.BYPath.BYIMAGEPATH + "/" + buyerId + "/";
        //读取本地存储的文件
        File uploadFile = new File(localPath,localFileName);
        //上传到ftp服务器
        ftpUtils.upload(uploadFilePath,uploadFile);
        //删除本地文件
        uploadFile.delete();
        //返回插入DB的数据
        String[] insertParam = new String[NumberConst.IntDef.INT_TWO];
        insertParam[NumberConst.IntDef.INT_ZERO] = String.valueOf(uuid);
        insertParam[NumberConst.IntDef.INT_ONE] = fileSuffix;
        return insertParam;
    }

    /**
     * 买家图片信息查询接口
     * @param param
     * @return
     */
    public IBY121206RsParam buyerLicencePicFind(IBY121206RsParam param){
        //根据传入参数获取买家图片信息
        IBY121206RsParam licencePic = null;
        BaseParam inParam = new BaseParam();
        inParam.setFilter("buyerId",param.getBuyerId());
        ByBuyerPictures pictures = super.findOne(SqlId.SQL_FIND_PICTURES,inParam);
        if(null != pictures){
            licencePic = new IBY121206RsParam();
            licencePic.setBuyerId(param.getBuyerId());
            //图片上传文件路径
            String http = "http://";
            String url = ConfigManager.getFtpIp();
            String uploadPicFilePath = ConfigManager.getFtpImageRootPath();
            //营业执照图片路径
            if(!StringUtil.isNullOrEmpty(pictures.getBusLicPic()) && !StringUtil.isNullOrEmpty(pictures.getBusLicSuf())){
                String picLicensePath = http + url + uploadPicFilePath + BusinessConst.BYPath.BYIMAGEPATH + "/" + pictures.getBuyerId() +"/" + pictures.getBusLicPic() + StringConst.DOT + pictures.getBusLicSuf();
                licencePic.setPicLicensePath(picLicensePath);
            }
            //食品流通许可证图片路径
            if(!StringUtil.isNullOrEmpty(pictures.getFoodCertificatePic()) && !StringUtil.isNullOrEmpty(pictures.getFoodCertificateSuf())){
                String picFoodCirculationPath = http + url + uploadPicFilePath + BusinessConst.BYPath.BYIMAGEPATH + "/" + pictures.getBuyerId() +"/" + pictures.getFoodCertificatePic() + StringConst.DOT + pictures.getFoodCertificateSuf();
                licencePic.setPicFoodCirculationPath(picFoodCirculationPath);
            }
            //组织机构代码证图片
            if(!StringUtil.isNullOrEmpty(pictures.getOrgCertificatePic()) && !StringUtil.isNullOrEmpty(pictures.getOrgCertificateSuf())){
                String picOrgStructurePath = http + url + uploadPicFilePath + BusinessConst.BYPath.BYIMAGEPATH + "/" + pictures.getBuyerId() +"/" + pictures.getOrgCertificatePic() + StringConst.DOT + pictures.getOrgCertificateSuf();
                licencePic.setPicOrgStructurePath(picOrgStructurePath);
            }
            //税务登记证图片
            if(!StringUtil.isNullOrEmpty(pictures.getTaxCertificatePic()) && !StringUtil.isNullOrEmpty(pictures.getTaxCertificateSuf())){
                String picTaxRegistrationPath = http + url + uploadPicFilePath + BusinessConst.BYPath.BYIMAGEPATH + "/" + pictures.getBuyerId() +"/" + pictures.getTaxCertificatePic() + StringConst.DOT + pictures.getTaxCertificateSuf();
                licencePic.setPicTaxRegistrationPath(picTaxRegistrationPath);
            }
            //法定代表人证件图片
            if(!StringUtil.isNullOrEmpty(pictures.getLegalCertificatePic()) && !StringUtil.isNullOrEmpty(pictures.getLegalCertificateSuf())){
                String picCertPath = http + url + uploadPicFilePath + BusinessConst.BYPath.BYIMAGEPATH + "/" + pictures.getBuyerId() +"/" + pictures.getLegalCertificatePic() + StringConst.DOT + pictures.getLegalCertificateSuf();
                licencePic.setPicCertPath(picCertPath);
            }
        }
        return licencePic;
    }
}
