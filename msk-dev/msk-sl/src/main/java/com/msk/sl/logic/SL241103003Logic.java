package com.msk.sl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlEpCert;
import com.msk.core.entity.SlEpCertItem;
import com.msk.core.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/28.
 */
@Service
public class SL241103003Logic extends BaseLogic{
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        static final String SQL_ID_SAVE_SLEPCERT= "saveSlEpCert";
        static  final String SQL_ID_SAVE_SLEPCERTITEM="saveSlEpCertItem";
    }
    //保存证书类数据到数据库sl_ep_cert
    @Transactional
    public void saveSlEpCert(ArrayList<SlEpCert> slEpCerts,Long slEpId) {
        for(int i=0;i<slEpCerts.size();i++){
            SlEpCert sl = slEpCerts.get(i);
            Long id=this.commonLogic.maxId("SL_EP_CERT","CERT_ID");
            sl.setCertId(id);
            sl.setEpId(slEpId);
            sl.setDelFlg("0");
            int result=super.save(SqlId.SQL_ID_SAVE_SLEPCERT,sl);
            if(result==0){
                throw new BusinessException("保存数据失败");
            }
        }
    }

    //查询同一个EPID下的所有的CERT_id
    public List<SlEpCert> findDateList(Long slEpId) {
        BaseParam baseParam= new BaseParam();
        String epId=slEpId.toString();
        baseParam.setFilter("epId",epId);
        List<SlEpCert> list=super.findList(baseParam);
        return list;
    }

    //保存数据sl_ep_cert_item
    public void saveCertItem(ArrayList<SlEpCertItem> slEpCertItems,Long slEpId) {
        for(int i=0;i<slEpCertItems.size();i++){
            SlEpCertItem slEpCertItem = slEpCertItems.get(i);
            slEpCertItem.setEpId(slEpId);
            slEpCertItem.setDelFlg("0");
            int result=super.save(SqlId.SQL_ID_SAVE_SLEPCERTITEM,slEpCertItem);
            if(result==0){
                throw new BusinessException("保存数据异常");
            }
        }
    }

}
