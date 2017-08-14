package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.PdAppImg;
import com.msk.core.exception.BusinessException;
import com.msk.core.file.FileUploadUtil;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pd.bean.PD144106Param;
import com.msk.pd.bean.PD144107Param;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by yang_chunyan on 2016/10/28.
 */
@Service
public class PD144107Logic extends BaseLogic {

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private PD144106Logic pd144106Logic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_SAVE_IMG = "saveImg";
        String SQL_ID_UPDATE_IMG = "updateImg";
        String SQL_ID_FIND_IMG = "findImg";
    }


    /**
     * 获取图片信息
     *
     * @param param
     * @return
     */
    @Transactional
    public PdAppImg getImg(PD144107Param param) {
        return this.findOne(SqlId.SQL_ID_FIND_IMG, param);
    }


    /**
     * 上传产品图片
     *
     * @param param
     * @throws java.io.IOException
     */
    public String upload(PD144107Param param) throws IOException {
        Map<String, InputStream> fileMap = new HashMap<>();
        MultipartFile fileM = param.getProductImgFile();
        String uploadImg = "";
        if (StringUtils.isNotBlank(fileM.getOriginalFilename())) {
            fileMap.put("productImg",fileM.getInputStream());
        }
        if (MapUtils.isNotEmpty(fileMap)) {
            Map<String, String> nameMap = FileUploadUtil.uploadStreamFiles(fileMap);
            PdAppImg bean = new PdAppImg();
            bean.setImgFunction(param.getSource());
            if (StringUtils.isNotBlank(nameMap.get("productImg"))) {
                bean.setAppImg(ConfigManager.getFileServer() + "/" + nameMap.get("productImg"));
                param.setAppImg(ConfigManager.getFileServer() + "/" + nameMap.get("productImg"));
                uploadImg = ConfigManager.getFileServer() + "/" + nameMap.get("productImg");
                bean.setOriginalImgName(fileM.getOriginalFilename());
                param.setOriginFileName(fileM.getOriginalFilename());
            }
            Date nowDate = DateTimeUtil.getCustomerDate();
            bean.setId(commonLogic.maxId("PD_APP_IMG", "ID"));
            bean.setCrtTime(nowDate);
            bean.setActTime(nowDate);
            bean.setUpdTime(nowDate);
            bean.setCrtId(param.getCrtId());
            bean.setActId(param.getActId());
            bean.setUpdId(param.getUpdId());
            bean.setImgFunction(param.getSource());
            bean.setPdCode(param.getPdCode().substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_FIVE));
            if (String.valueOf(NumberConst.IntDef.INT_ONE).equals(param.getSource())) {
                param.setFilter("sort", "maxSort");
                bean.setSort(String.valueOf(NumberConst.IntDef.INT_ONE));
                PdAppImg sort = this.findOne(SqlId.SQL_ID_FIND_IMG, param);
                if (null != sort) {
                    bean.setSort(sort.getSort());
                }
                this.save(SqlId.SQL_ID_SAVE_IMG, bean);
            } else {
                PdAppImg img = this.getImg(param);
                if (null != img) {
                    this.updateImg(param);
                } else {
                    this.save(SqlId.SQL_ID_SAVE_IMG, bean);
                }
            }
        }
        return uploadImg;
    }

    /**
     * 批量修改产品图片信息
     *
     * @param params
     * @return
     */
    public int updateImgs(Collection<PD144107Param> params, PD144107Param pd144107Param) {
        int count = NumberConst.IntDef.INT_ZERO;
        for (PD144107Param param : params) {
            param.setUpdTime(DateTimeUtil.getCustomerDate());
            param.setUpdId(pd144107Param.getUpdId());
            this.updateImg(param);
            count++;
        }
        return count;
    }

    /**
     * 修改物流区产品
     *
     * @param param
     */
    @Transactional
    public void updatePdLogiArea(PD144107Param param) {
        PD144106Param pd144106Param = new PD144106Param();
        if (StringUtils.isNoneEmpty(param.getPdLabel())) {
            pd144106Param.setPdLabel(param.getPdLabel());
        }
        if(StringUtils.isNoneEmpty(param.getStatus())){
            pd144106Param.setStatus(param.getStatus());
        }
        pd144106Param.setPdCode(param.getPdCode());
        pd144106Param.setLgcsCode(param.getLgcsCode());
        pd144106Param.setUpdTime(new Date());
        pd144106Param.setUpdId(param.getUpdId());
        pd144106Logic.modify(pd144106Param);
    }


    /**
     * 修改图片信息
     *
     * @param param
     * @return
     */
    @Transactional
    public int updateImg(PD144107Param param) {
        // 排他处理.
        if (null != param.getId()) {
            super.versionValidator("PD_APP_IMG", new String[]{"ID"}, new Object[]{param.getId()}, param.getVer());
        }
        param.setUpdTime(new Date());
        return super.modify(SqlId.SQL_ID_UPDATE_IMG, param);
    }
}
