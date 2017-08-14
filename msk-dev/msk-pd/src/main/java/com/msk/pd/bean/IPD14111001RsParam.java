package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.PdClasses;

/**
 * 产品标准包装档案卡查询参数
 * IPD141108RsParam.
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = {"delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId"})
public class IPD14111001RsParam extends PdClasses {

    private static final long serialVersionUID = 1L;

    private String pdTypeCode2;//产品2级分类编码

    private String pdTypeName2;//产品2级分类名称

    /**
     * <p>产品分类接口。</p>
     *
     * @return pdType2List 技术标准有无
     */
    public String getPdTypeCode2() {
        return pdTypeCode2;
    }

    /**
     * <p>产品分类接口。</p>
     *
     * @param pdTypeCode2 技术标准有无
     */
    public void setPdTypeCode2(String pdTypeCode2) {
        this.pdTypeCode2 = pdTypeCode2;
    }

    /**
     * <p>产品分类接口。</p>
     *
     * @return String 产品分类
     */
    public String getPdTypeName2() {
        return pdTypeName2;
    }

    /**
     * <p>产品分类接口。</p>
     *
     * @param pdTypeName2 技术标准有无
     */
    public void setPdTypeName2(String pdTypeName2) {
        this.pdTypeName2 = pdTypeName2;
    }
}