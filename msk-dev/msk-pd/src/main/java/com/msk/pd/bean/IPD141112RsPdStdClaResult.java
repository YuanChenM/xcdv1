package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.bean.BaseBean;
import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * 封装参数
 * IPD141112RsPdTncParam.
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = {"delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId"})
public class IPD141112RsPdStdClaResult extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String qltStdClaId; // 分类质量标准指标id

    private String qltStdClaName; // 分类质量标准指标名称

    private List<IPD141112RsPdStdSubResult> qltStdSubList; // 具体质量指标列表

    /**
     * 获得qltStdClaId
     */
    public String getQltStdClaId() {
        return qltStdClaId;
    }

    /**
     * 设置qltStdClaId
     */
    public void setQltStdClaId(String qltStdClaId) {
        this.qltStdClaId = qltStdClaId;
    }

    /**
     * 获得qltStdClaName
     */
    public String getQltStdClaName() {
        return qltStdClaName;
    }

    /**
     * 设置qltStdClaName
     */
    public void setQltStdClaName(String qltStdClaName) {
        this.qltStdClaName = qltStdClaName;
    }

    /**
     * 获得qltStdSubList
     */
    public List<IPD141112RsPdStdSubResult> getQltStdSubList() {
        return qltStdSubList;
    }

    /**
     * 设置qltStdSubList
     */
    public void setQltStdSubList(List<IPD141112RsPdStdSubResult> qltStdSubList) {
        this.qltStdSubList = qltStdSubList;
    }
}