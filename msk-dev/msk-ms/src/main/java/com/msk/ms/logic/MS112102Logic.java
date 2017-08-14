/**
 * SO151502Logic.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.ms.bean.MS112102Bean;
import com.msk.ms.bean.MS112102MsCarduploadlog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Date;
import java.util.List;

/**
 * SO151502Logic.
 *
 * @author rwf
 */
@Service
public class MS112102Logic extends BaseLogic {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(MS112102Logic.class);
    /** 加密密钥 */
    String key="527f6b54";
    /** 当前时间 */
    Date nowDate = DateTimeUtil.getCustomerDate();
    @Autowired
    private CommonLogic commonLogic;

    /**
     * SqlId.
     * 
     * @author rwf
     */
    interface SqlId {
        static final String SQL_ID_SAVE_UPLOAD_EXCEL_MSCARDMANAGER = "saveUploadFileToMsCardManager";
        static final String SQL_ID_SELECT_MSCARDNO = "selectMsCardNoIfExist";
        static final String SQL_ID_SAVE_UPLOAD_RESULT_LOG = "saveUploadResultLog";
    }

    /**
     * @return String
     * @param source 待加密数据
     * @param key 密钥字符串
     */
    public String encryDES(byte[] source, String key) {
        byte[] resBytes = null;
        try {
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secureKey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(key.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, secureKey, iv);
            resBytes = cipher.doFinal(source);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new String(Base64Utils.encode(resBytes));
    }

    /**
     *
     * @return String 返回标志
     * @param dataList 读取到的全部数据
     *
     */
    @Transactional
    public String saveDataList(List<MS112102Bean> dataList) {
        logger.info("开始保存数据");
       // for (MS112102Bean ms112102Bean : dataList) {
        for(int i=1;i<dataList.size();i++){
            BaseParam base = new BaseParam();
            MS112102Bean ms112102Bean=dataList.get(i);
            base.setFilter("cardNo", ms112102Bean.getMsCardno());
            //查询读取的卡号是否有数据库存在的卡号
            MS112102Bean ms112102Selected = super.findOne(SqlId.SQL_ID_SELECT_MSCARDNO, base);
            if (null != ms112102Selected) {
                throw new BusinessException("录入失败,输入了已经存在的卡号:" + ms112102Selected.getMsCardno());
            }
            //获取数据库中最大的ID，如果表为空，则返回1
            Long maxId = commonLogic.maxId("MS_CARDMANAGER", "MS_ID");
            ms112102Bean.setMsId(maxId);
            ms112102Bean.setIsProvide("0");
            ms112102Bean.setCrtTime(nowDate);
            ms112102Bean.setUpdTime(nowDate);
            //将正常数据保存到数据库
            String isActicate = ms112102Bean.getIsActivate();
            if("是".equals(isActicate)){
                ms112102Bean.setIsActivate("1");
            }else{
                ms112102Bean.setIsActivate("0");
            }
            String password = ms112102Bean.getMsInitpw();
            ms112102Bean.setMsNowpw(this.encryDES(password.getBytes(),key));
            ms112102Bean.setMsInitpw(this.encryDES(password.getBytes(),key));
            super.save(SqlId.SQL_ID_SAVE_UPLOAD_EXCEL_MSCARDMANAGER, ms112102Bean);
        }
        //获取数据库中最大的ID，如果表为空，则返回1
        Long logId = this.commonLogic.maxId("MS_CARDUPLOADLOG", "LOG_ID");
        MS112102MsCarduploadlog msCarduploadlogBean = new MS112102MsCarduploadlog();
        msCarduploadlogBean.setLogId(logId);
        msCarduploadlogBean.setCrtTime(nowDate);
        msCarduploadlogBean.setUploadResult(NumberConst.IntDef.INT_ONE);
        //保存记录成功的日志信息
        super.save(SqlId.SQL_ID_SAVE_UPLOAD_RESULT_LOG, msCarduploadlogBean);
        return "uploadSuccess";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
