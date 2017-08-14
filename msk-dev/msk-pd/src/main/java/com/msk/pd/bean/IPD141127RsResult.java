package com.msk.pd.bean;

import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * IPD141127RsResult.产品卫生标准
 *
 * @author xhy
 */
public class IPD141127RsResult extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String  sftStdClaId; // 分类质量标准指标id

    private String sftStdClaName; // 分类质量标准指标名称

    private List<IPD141127RsSftStdResult> sftStdSublist; // 具体质量指标列表


    /**
     * Getter method for property <tt>sftStdClaId</tt>.
     *
     * @return property value of sftStdClaId
     */
    public String getSftStdClaId() {
        return sftStdClaId;
    }

    /**
     * Setter method for property <tt>sftStdClaId</tt>.
     *
     * @param sftStdClaId value to be assigned to property sftStdClaId
     */
    public void setSftStdClaId(String sftStdClaId) {
        this.sftStdClaId = sftStdClaId;
    }

    /**
     * Getter method for property <tt>sftStdClaName</tt>.
     *
     * @return property value of sftStdClaName
     */
    public String getSftStdClaName() {
        return sftStdClaName;
    }

    /**
     * Setter method for property <tt>sftStdClaName</tt>.
     *
     * @param sftStdClaName value to be assigned to property sftStdClaName
     */
    public void setSftStdClaName(String sftStdClaName) {
        this.sftStdClaName = sftStdClaName;
    }

    /**
     * Getter method for property <tt>sftStdSublist</tt>.
     *
     * @return property value of sftStdSublist
     */
    public List<IPD141127RsSftStdResult> getSftStdSublist() {
        return sftStdSublist;
    }

    /**
     * Setter method for property <tt>sftStdSublist</tt>.
     *
     * @param sftStdSublist value to be assigned to property sftStdSublist
     */
    public void setSftStdSublist(List<IPD141127RsSftStdResult> sftStdSublist) {
        this.sftStdSublist = sftStdSublist;
    }
}