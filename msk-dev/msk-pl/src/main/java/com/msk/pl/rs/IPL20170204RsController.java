package com.msk.pl.rs;

import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.file.FileUtils;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170204Param;
import com.msk.pl.bean.IPL20170204Result;
import com.msk.pl.util.PLUploadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Controller
public class IPL20170204RsController extends BaseUploadController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170204RsController.class);

    private final String PL = "/pl";

    @RequestMapping(value = "/bs_task_img_upload",method = RequestMethod.POST)
    public @ResponseBody RsResponse<IPL20170204Result> findBreedList(MultipartFile file, IPL20170204Param param, HttpServletResponse response) throws IOException {
        RsResponse<IPL20170204Result> rs = new RsResponse<IPL20170204Result>();
        IPL20170204Result thisReturn = new IPL20170204Result();
        String keyWord = URLDecoder.decode(param.getBsName(),"UTF-8");
        //查询后台,获取数据
        if (file.getSize() > NumberConst.IntDef.INT_ZERO) {
            String svnUrl = PL +"/"+ keyWord + "/" + DateTimeUtil.formatDate("yyyy-MM-dd", new Date()) + "/";
            String uploadFileName = DateTimeUtil.formatDate("yyyyMMddHHmmss", new Date());
            String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + svnUrl;
            PLUploadFile plUploadFile = new PLUploadFile();
            plUploadFile.saveUploadFile(file, uploadFilePath, uploadFileName);
            thisReturn.setFileUploadUrl(ConfigManager.getFtpHttpUrl() + svnUrl + uploadFileName + "." + FileUtils.getFileSuffix(file.getOriginalFilename()));
            logger.debug("图片上传成功,ftp");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("图片上传成功！");
            rs.setResult(thisReturn);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("图片上传失败！");
        return rs;

    }
}
