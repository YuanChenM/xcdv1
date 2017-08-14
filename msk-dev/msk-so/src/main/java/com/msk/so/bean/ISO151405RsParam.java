package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

import java.util.List;

/**
 * 
 * ISO151405RsParam接受参数.
 *
 * @author sjj
 */
public class ISO151405RsParam extends BaseParam {
    // 产品编码列表
    private List<PdCodeBean> pdCodeList;
    // 是否返回模糊值
    private Integer isReturnFuzzy;
    // 模糊值对比界限值
    private Integer fuzzyValueLimit;


    public Integer getIsReturnFuzzy() {
        return isReturnFuzzy;
    }

    public void setIsReturnFuzzy(Integer isReturnFuzzy) {
        this.isReturnFuzzy = isReturnFuzzy;
    }

    public Integer getFuzzyValueLimit() {
        return fuzzyValueLimit;
    }

    public void setFuzzyValueLimit(Integer fuzzyValueLimit) {
        this.fuzzyValueLimit = fuzzyValueLimit;
    }

    public List<PdCodeBean> getPdCodeList() {
        return pdCodeList;
    }

    public void setPdCodeList(List<PdCodeBean> pdCodeList) {
        this.pdCodeList = pdCodeList;
    }
}
