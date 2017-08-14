package com.msk.ms.logic;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.MsCardmanager;

/**
 * 会员卡密码修改
 * @author fjm
 *
 */
@Service
public class MS11210102Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
   
    /**
     * 定义sql语句常量
     * @author fjm
     *
     */
    interface SqlId {
        String SQL_ID_SELECT_MSID = "findOne";
        String SQL_ID_MODIFY_ONE = "modifyOne";
        String SQL_ID_SELECT_MSCARDNO = "findOneByCardNo";
    }
    
    /**
     * 根据传入msId，查询出单个对象返回
     * @param msId 参数msId
     * @return MsCardmanager 返回对象
     */
    @Transactional(readOnly=true)
    public MsCardmanager mS11210102Entity(String msId) {
        BaseParam param = new BaseParam();
        param.setFilter("msId", msId);
        MsCardmanager msCardmanager = super.findOne(SqlId.SQL_ID_SELECT_MSID, param);
        return msCardmanager;
    }

    /**
     * 查询对象返回
     * @param msCardno 会员卡编号
     * @return MsCardmanager 返回对象
     */
    @Transactional(readOnly=true)
    public MsCardmanager ms11210102Entity2(String msCardno){
        BaseParam param = new BaseParam();
        param.setFilter("msCardno", msCardno);
        MsCardmanager msCardmanager = super.findOne(SqlId.SQL_ID_SELECT_MSCARDNO, param);
        return msCardmanager;
    }
    
    
    /**
     * 密码修改
     * @param msCardmanager 对象参数
     * @return 返回int
     */
    @Transactional
    public int modifyOne(MsCardmanager msCardmanager){
        return super.modify(SqlId.SQL_ID_MODIFY_ONE, msCardmanager);
    }
    
    /**
     * @return String
     * @param source 待加密数据
     * @param key 密钥字符串
     */
    public String encryDES(byte[] source, String key){
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
        String res = new String(Base64Utils.encode(resBytes));
        return res;
    }
}
