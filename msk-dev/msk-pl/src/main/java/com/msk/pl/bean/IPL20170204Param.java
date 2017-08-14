package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xuhongyang on 2017/2/6.
 *
 * 外勤用户验证接口入参
 */
public class IPL20170204Param extends BaseParam {

    private String bsName;

    /**
     * Getter method for property <tt>bsName</tt>.
     *
     * @return property value of bsName
     */
    public String getBsName() {
        return bsName;
    }

    /**
     * Setter method for property <tt>bsName</tt>.
     *
     * @param bsName value to be assigned to property bsName
     */
    public void setBsName(String bsName) {
        this.bsName = bsName;
    }
}
