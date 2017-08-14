package com.msk.pd.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.PdAppScrollImg;
import com.msk.core.entity.PdAppScrollImgSetting;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseUploadController;
import com.msk.pd.bean.PD144101Param;
import com.msk.pd.logic.PD144101Logic;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 轮播图设置.
 */
@Controller
@RequestMapping("PD144101")
public class PD144101Controller extends BaseUploadController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(PD144101Controller.class);
    /**
     * 图片文件后缀.
     */
    private static String[] IMG_SUFFIXS = {"png", "jpg", "jpeg", "bmp", "gif", "PNG", "JPG", "JPEG", "BMP", "GIF"};

    /**
     * 图片上传最大2MB.
     */
    private static long IMG_MAX_SIZE = 2 * 1024 * 1024;


    @Autowired
    private PD144101Logic pd144101Logic;

    /**
     * 查看图片高度.
     *
     * @param model 参数
     * @return 页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        BaseParam baseParam = new BaseParam();
        super.setCommonParam(baseParam);
        PdAppScrollImgSetting imgSettingInfo = pd144101Logic.findImgSettingInfo();
        if (null != imgSettingInfo && null != imgSettingInfo.getModelHeight()) {
            model.addAttribute("modelHeight", imgSettingInfo.getModelHeight().intValue());
        }
        List<PD144101Param> pd144101ParamList = new ArrayList<>();
        for (int i = NumberConst.IntDef.INT_TWENTY; i <= NumberConst.IntDef.INT_FOURTY; i++) {
            PD144101Param modelHeight = new PD144101Param();
            modelHeight.setModelHeight(i);
            pd144101ParamList.add(modelHeight);
        }
        model.addAttribute("modelHeightList", pd144101ParamList);
        return "pd/PD144101";
    }

    /**
     * 保存或更新轮播图设置的高度.
     */
    @RequestMapping(value = "saveHeight",
            method = RequestMethod.POST)
    public
    @ResponseBody
    int save(PD144101Param pd144101Param) {
        super.setCommonParam(pd144101Param);
        return pd144101Logic.saveOrUpdate(pd144101Param);
    }

    /**
     * 查询图片列表.
     *
     * @return PageResult
     */
    @RequestMapping(value = "searchImg",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<PdAppScrollImg> searchImg(BasePageParam param) {
        PageResult<PdAppScrollImg> pageResult = this.pd144101Logic.findImgInfo(param);
        for (int i = NumberConst.IntDef.INT_ZERO; i < pageResult.getData().size(); i++) {
            pageResult.getData().get(i).setSort(String.valueOf(i + NumberConst.IntDef.INT_ONE));
            String scrollImg = pageResult.getData().get(i).getScrollImg();
            pageResult.getData().get(i).setScrollImg("<img src='" + scrollImg + "' style='width:20px;height:20px;'" + "/>");
        }
        return pageResult;
    }

    /**
     * 上传图片
     *
     * @param param
     * @param response
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    @RequestMapping(value = "upload",
            method = RequestMethod.POST)
    public void uploadImg(PD144101Param param, HttpServletResponse response) throws IOException, ParseException {
        super.setCommonParam(param);
        MultipartFile fileM = param.getProductImgFile();
        String imgName = fileM.getOriginalFilename();
        if (StringUtils.isNotBlank(imgName)) {
            String name = imgName.substring(0, imgName.lastIndexOf("."));
            // 图片名称最长200个字.
            if (NumberConst.IntDef.INT_TWO_HUNDRED < name.length()) {
                throw new BusinessException("图片名字最长200字！");
            }
        } else {
            throw new BusinessException("请选择上传的图片！");
        }
        param.setOriginalImgName(imgName);
        if (StringUtils.isNotBlank(imgName)) {
            Boolean checkFileSuffixResult = super.checkFileSuffix(fileM, IMG_SUFFIXS);
            if (!checkFileSuffixResult) {
                throw new BusinessException("上传文件格式不正确,只能上传图片!");
            }
            Boolean checkFileSizeResult = super.checkFileSize(fileM, IMG_MAX_SIZE);
            if (!checkFileSizeResult) {
                throw new BusinessException("上传文件过大.(<2MB)");
            }
        }
        this.pd144101Logic.upload(param);
        super.callBack(null, "保存成功", response);
    }

    /**
     * 实例化页面
     *
     * @param model 参数
     * @return 页面
     */
    @RequestMapping(value = "initUpload",
            method = RequestMethod.POST)
    public String initUpload(Model model) {
        logger.debug("首页轮播图片上传页面");
        return "pd/PD144102";
    }

    /**
     * 删除图片
     */
    @RequestMapping(value = "deleteImg",
            method = RequestMethod.POST)
    public
    @ResponseBody
    int deleteImg(PD144101Param pd144101Param) {
        super.setCommonParam(pd144101Param);
        return pd144101Logic.deletePdAppScrollImg(pd144101Param);
    }

    /**
     * 修改图片顺序
     *
     * @return
     */
    @RequestMapping(value = "modifyImgSort",
            method = RequestMethod.POST)
    @ResponseBody
    public String updateImg(String jsonStr) {
        BaseParam baseParam = new BaseParam();
        super.setCommonParam(baseParam);
        Map<String, PD144101Param> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, PD144101Param>>() {
        });
        List<PD144101Param> list = new ArrayList<PD144101Param>(map.values());
        int count = pd144101Logic.modifyPdAppScrollImg(list, baseParam);

        if (count >= NumberConst.IntDef.INT_ONE) {
            return SystemConst.RsStatus.SUCCESS;
        }
        return SystemConst.RsStatus.FAIL;
    }

    /**
     * 实例化页面
     *
     * @param model 参数
     * @return 页面
     */
    @RequestMapping(value = "showImg",
            method = RequestMethod.POST)
    public String showImg(Model model, PD144101Param param) {
        logger.debug("轮播图图片预览");
        PdAppScrollImg pdAppScrollImg = pd144101Logic.getImg(param);
        String img = "<img src='" + pdAppScrollImg.getScrollImg() + "' style='width:475px;height:440px;'" + "/>";
        model.addAttribute("image", img);
        return "pd/PD144109";
    }
}
