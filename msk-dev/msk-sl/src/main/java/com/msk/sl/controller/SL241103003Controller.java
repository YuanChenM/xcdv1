package com.msk.sl.controller;

import com.msk.core.entity.SlEpCert;
import com.msk.core.entity.SlEpCertItem;
import com.msk.core.exception.BusinessException;
import com.msk.core.file.FtpUtils;
import com.msk.core.web.base.BaseUploadController;
import com.msk.sl.bean.SL241103003Bean;
import com.msk.sl.logic.SL241103003Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by writer on 2016/1/27.
 */
@Controller
@RequestMapping("SL241103003")
public class SL241103003Controller extends BaseUploadController {
    @Autowired
    private SL241103003Logic sL241103003Logic;

    @RequestMapping(value ="save",method = RequestMethod.POST)
    public void update(MultipartFile file,SL241103003Bean sl241103003Bean,HttpServletResponse response,HttpServletRequest request) throws IOException {
    }
}
