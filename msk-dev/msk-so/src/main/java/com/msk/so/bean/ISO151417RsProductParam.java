package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

/**
 * Created by liutao on 2016/10/11.
 */
public class ISO151417RsProductParam extends BaseParam {
    private String proDate;

    private String pdCode;

    private String evaluateDesc;

    private String remark;

    private Integer score;

    private String evaluateImg;

    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getEvaluateDesc() {
        return evaluateDesc;
    }

    public void setEvaluateDesc(String evaluateDesc) {
        this.evaluateDesc = evaluateDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getEvaluateImg() {
        return evaluateImg;
    }

    public void setEvaluateImg(String evaluateImg) {
        this.evaluateImg = evaluateImg;
    }
}
