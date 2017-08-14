package com.msk.so.bean;

import com.msk.core.bean.RsPageParam;
import com.msk.so.bean.rs.Product;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ISO151423RsParam接受参数.
 *
 * @author zhang_qiang1
 */
public class ISO151430RsParam extends RsPageParam {
     private String pdCode;// 商品编码


    private String slCode;// 卖家编码

    private String  lgcsCode;//物流区编码

    private String warehoseCode;//仓库编码

    private String pdName;//产品名称


    private String classesCode;//产品类别

    private String breedCode;//产品品种


    private String classesName;//产品类别名称


    private String breedName;//产品品种名称


    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getSlCode() {
        return slCode;
    }

    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getWarehoseCode() {
        return warehoseCode;
    }

    public void setWarehoseCode(String warehoseCode) {
        this.warehoseCode = warehoseCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }
}
