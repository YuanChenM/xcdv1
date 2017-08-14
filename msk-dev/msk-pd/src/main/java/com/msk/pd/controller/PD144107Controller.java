package com.msk.pd.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.PdAppImg;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import com.msk.pd.bean.PD144107Param;
import com.msk.pd.logic.PD144107Logic;
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
import java.util.Map;

/**
 * Created by yang_chunyan on 2016/10/28.
 */
@Controller
@RequestMapping(value = "PD144107")
public class PD144107Controller extends BaseUploadController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(PD141121Controller.class);

    /**
     * 图片文件后缀.
     */
    private static String[] IMG_SUFFIXS = {"png", "jpg", "jpeg", "bmp", "gif", "PNG", "JPG", "JPEG", "BMP", "GIF"};

    /**
     * 图片上传最大2MB.
     */
    private static long IMG_SIZE = 2 * 1024 * 1024;


    /**
     * 图片名称最长200个字.
     */
    private static long NAME_SIZE = 200;

    @Autowired
    private PD144107Logic pd144107Logic;


    /**
     * 实例化页面
     *
     * @param model 参数
     * @return 页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model, PD144107Param param) {
        logger.debug("产品详细信息管理页面");
        //获取该产品楼层信息
        param.setSource(String.valueOf(NumberConst.IntDef.INT_ZERO));
        PdAppImg bean = pd144107Logic.getImg(param);
        if (null != bean){
            param.setCover(bean.getAppImg());
            param.setId(bean.getId());
        }
        //model.addAttribute("pdCode",param.getPdCode().substring(NumberConst.IntDef.INT_ZERO,NumberConst.IntDef.INT_FIVE));
        model.addAttribute("bean", param);
        return "pd/PD144107";
    }


    /**
     * 实例化上传页面
     *
     * @param model 参数
     * @return 页面
     */
    @RequestMapping(value = "initUpload",
            method = RequestMethod.POST)
    public String initUpload(Model model, PD144107Param param) {
        logger.debug("产品图片上传页面");
        model.addAttribute("pdCode", param.getPdCode());
        model.addAttribute("type", param.getType());
        model.addAttribute("lgcsCode", param.getLgcsCode());
        return "pd/PD144108";
    }

    /**
     * 显示图片
     *
     * @param model 参数
     * @return 页面
     */
    @RequestMapping(value = "showImg",
            method = RequestMethod.POST)
    public String showImg(Model model, PD144107Param param) {
        logger.debug("显示图片");
        //param.setFilter("sort", "max");
        PdAppImg appImg = pd144107Logic.getImg(param);
        String img = "<img src='" + appImg.getAppImg() + "' style='width:475px;height:440px;'" + "/>";
        model.addAttribute("image", img);
        return "pd/PD144109";
    }

    /**
     * 分页查询图片数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<PdAppImg> search(BasePageParam param) {
        logger.debug("分页查询产品图片信息");
        PageResult<PdAppImg> pageResult = pd144107Logic.findPage(param, PdAppImg.class);
        for (int i = NumberConst.IntDef.INT_ZERO; i < pageResult.getData().size(); i++) {
            pageResult.getData().get(i).setSort(String.valueOf(i + NumberConst.IntDef.INT_ONE));
            String appImg = pageResult.getData().get(i).getAppImg();
            pageResult.getData().get(i).setAppImg("<img src='" + appImg + "' style='width:20px;height:20px;'" + "/>");
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
    public void uploadImg(PD144107Param param, HttpServletResponse response) throws IOException, ParseException {
        super.setCommonParam(param);

        MultipartFile fileM = param.getProductImgFile();
        String imgName = fileM.getOriginalFilename();
        if (StringUtils.isNotBlank(imgName)) {
            String name = imgName.substring(0, imgName.lastIndexOf("."));
            if (NAME_SIZE < name.length()) {
                throw new BusinessException("图片名字最长200字！");
            }
        } else {
            throw new BusinessException("请选择上传的图片！");
        }
        if (StringUtils.isNotBlank(imgName)) {
            Boolean checkFileSuffixResult = super.checkFileSuffix(fileM, IMG_SUFFIXS);
            if (!checkFileSuffixResult) {
                throw new BusinessException("上传文件格式不正确,只能上传图片!");
            }
            Boolean checkFileSizeResult = super.checkFileSize(fileM, IMG_SIZE);
            if (!checkFileSizeResult) {
                throw new BusinessException("上传文件过大.(<2MB)");
            }
        }
        String uploadImg = this.pd144107Logic.upload(param);
        super.callBack(null, "保存成功;" + uploadImg, response);
    }


    /**
     * 更新产品图片信息
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "updateImg",
            method = RequestMethod.POST)
    @ResponseBody
    public Object updateImg(PD144107Param param, String jsonStr, HttpServletResponse response) throws IOException, ParseException {
        BaseParam baseParam = new BaseParam();
        super.setCommonParam(param);
        int count = NumberConst.IntDef.INT_ZERO;
        //修改物流区标签
        pd144107Logic.updatePdLogiArea(param);
        if (StringUtil.isEmpty(jsonStr)) {
            count = pd144107Logic.updateImg(param);
        } else {
            Map<String, PD144107Param> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, PD144107Param>>() {
            });
            baseParam.setFilter("pdCode", param.getPdCode());
            count = pd144107Logic.updateImgs(map.values(), param);
        }
        if (count > NumberConst.IntDef.INT_ZERO) {
            return SystemConst.RsStatus.SUCCESS;
        }
        return SystemConst.RsStatus.FAIL;
    }

}
