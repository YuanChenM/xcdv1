package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.PdAppScrollImg;
import com.msk.core.entity.PdAppScrollImgSetting;
import com.msk.core.file.FileUploadUtil;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pd.bean.PD144101Param;
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
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PD144101Logic
 *
 * @author gao_min
 */

@Service
public class PD144101Logic extends BaseLogic {

    @Autowired
    private CommonLogic commonLogic;

    interface SqlId {
        // 查询轮播图设置表中的数据.
        static final String FIND_IMG_HEIGHT_INFO = "findImgHeight";
        // 新增一个图片的序号.
        static final String FIND_MAX_SORT = "findMaxSort";
        // 新增轮播图片.
        static final String INSERT_SCROLL_IMG = "insertScrollImg";
        // 删除轮播图片,物理删除.
        static final String DELETE_SCROLL_IMG = "deleteScrollImg";
        // 修改轮播顺序.
        static final String MODIFY_SCROLL_IMG_SORT = "modifyScrollImgSort";
        // 查看图片.
        String SQL_ID_FIND_IMG = "findImg";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    // 查询轮播图设置表中的数据.
    @Transactional(readOnly = true)
    public PdAppScrollImgSetting findImgSettingInfo() {
        return this.findOne(SqlId.FIND_IMG_HEIGHT_INFO, new BaseParam());
    }

    // 保存或更新轮播图设置的高度
    @Transactional
    public int saveOrUpdate(PD144101Param pd144101Param) {

        PdAppScrollImgSetting pdAppScrollImgSetting = new PdAppScrollImgSetting();
        // 查询轮播图设置表中有没有数据，如果没有，则新增一条，如果有，则更新数据.
        PdAppScrollImgSetting imgSettingInfo = findImgSettingInfo();
        int count;
        BigDecimal height = new BigDecimal(pd144101Param.getModelHeight());
        if (null != imgSettingInfo) {
            // 修改.
            pdAppScrollImgSetting.setModelHeight(height);
            pdAppScrollImgSetting.setId(imgSettingInfo.getId());
            pdAppScrollImgSetting.setUpdId(pd144101Param.getUpdId());
            pdAppScrollImgSetting.setUpdTime(DateTimeUtil.getCustomerDate());
            count = this.modify(pdAppScrollImgSetting);
        } else {
            // 新增.
            pdAppScrollImgSetting.setModelHeight(height);
            pdAppScrollImgSetting.setId(commonLogic.maxId("PD_APP_SCROLL_IMG_SETTING", "ID"));
            pdAppScrollImgSetting.setDelFlg("0");
            pdAppScrollImgSetting.setCrtId(pd144101Param.getCrtId());
            pdAppScrollImgSetting.setUpdId(pd144101Param.getUpdId());
            pdAppScrollImgSetting.setActId(pd144101Param.getActId());
            pdAppScrollImgSetting.setCrtTime(DateTimeUtil.getCustomerDate());
            pdAppScrollImgSetting.setUpdTime(DateTimeUtil.getCustomerDate());
            pdAppScrollImgSetting.setActTime(DateTimeUtil.getCustomerDate());
            pdAppScrollImgSetting.setVer(0);
            count = this.save(pdAppScrollImgSetting);
        }
        return count;
    }

    // 查询轮播图图片列表.
    @Transactional(readOnly = true)
    public PageResult<PdAppScrollImg> findImgInfo(BasePageParam param) {
        return this.findPage(param, PdAppScrollImg.class);
    }


    /**
     * 上传首页轮播图片
     *
     * @param param
     * @throws java.io.IOException
     */
    @Transactional
    public void upload(PD144101Param param) throws IOException {
        Map<String, InputStream> fileMap = new HashMap<>();
        MultipartFile fileM = param.getProductImgFile();
        fileMap.put("scrollImg", fileM.getInputStream());
        if (MapUtils.isNotEmpty(fileMap)) {
            Map<String, String> nameMap = FileUploadUtil.uploadStreamFiles(fileMap);
            PdAppScrollImg bean = new PdAppScrollImg();
            if (StringUtils.isNotBlank(nameMap.get("scrollImg"))) {
                bean.setScrollImg(ConfigManager.getFileServer() + "/" + nameMap.get("scrollImg"));
                //bean.setOriginalImgName(fileM.getOriginalFilename());
            }
            Date nowDate = DateTimeUtil.getCustomerDate();
            bean.setId(commonLogic.maxId("PD_APP_SCROLL_IMG", "ID"));
            // 图片上传方式 0:ftp 1:图片服务器
            bean.setType("1");
            bean.setOriginalImgName(param.getOriginalImgName());
            bean.setCrtTime(nowDate);
            bean.setDelFlg("0");
            bean.setVer(0);
            bean.setActTime(nowDate);
            bean.setUpdTime(nowDate);
            bean.setCrtId(param.getCrtId());
            bean.setActId(param.getActId());
            bean.setUpdId(param.getUpdId());
            bean.setSort(String.valueOf(NumberConst.IntDef.INT_ONE));
            PdAppScrollImg sort = this.findOne(SqlId.FIND_MAX_SORT, param);
            if (null != sort) {
                bean.setSort(sort.getSort());
            } else {
                bean.setSort("1");
            }
            this.save(SqlId.INSERT_SCROLL_IMG, bean);
        }
    }

    // 删除图片
    @Transactional
    public int deletePdAppScrollImg(PD144101Param pd144101Param) {
        PdAppScrollImg pdAppScrollImg = new PdAppScrollImg();
        pdAppScrollImg.setId(Long.valueOf(pd144101Param.getId()));
        pdAppScrollImg.setUpdId(pd144101Param.getUpdId());
        pdAppScrollImg.setUpdTime(new Date());
        // 排他.
        if (null != pd144101Param.getId()) {
            super.versionValidator("PD_APP_SCROLL_IMG", new String[]{"ID"}, new Object[]{pd144101Param.getId()}, pd144101Param.getVer());
        }
        // 物理删除.
        return this.remove(SqlId.DELETE_SCROLL_IMG, pdAppScrollImg);

    }

    /**
     * 批量修改产品图片信息
     *
     * @param params
     * @return
     */
    @Transactional
    public int modifyPdAppScrollImg(List<PD144101Param> params, BaseParam baseParam) {
        int count = 0;
        for (PD144101Param pd144101Param : params) {
            pd144101Param.setUpdTime(DateTimeUtil.getCustomerDate());
            pd144101Param.setUpdId(baseParam.getUpdId());
            count = this.modify(SqlId.MODIFY_SCROLL_IMG_SORT, pd144101Param);
            count++;
        }
        return count;
    }

    @Transactional
    public PdAppScrollImg getImg(PD144101Param param) {
        return this.findOne(SqlId.SQL_ID_FIND_IMG, param);
    }
}
