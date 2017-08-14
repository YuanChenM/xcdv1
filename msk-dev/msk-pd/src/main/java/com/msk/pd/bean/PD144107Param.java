package com.msk.pd.bean;

import com.msk.core.bean.BaseParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yang_chunyan on 2016/10/28.
 */
public class PD144107Param extends BaseParam {
    //主键ID
    private Long id;
    //产品编码
    private String pdCode;
    //产品名称
    private String pdName;
    //封面
    private String cover;
    //产品轮播图片
    private String appImg;
    //使用场景
    private String source;
    //图片上传类型
    private String type;
    //排序
    private String sort;
    //状态
    private String status;
    //标签
    private String pdLabel;
    //物流区编码
    private String lgcsCode;
    //上传文件源文件名
    private String originFileName;
    //上传文件
    private MultipartFile productImgFile;

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAppImg() {
        return appImg;
    }

    public void setAppImg(String appImg) {
        this.appImg = appImg;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getProductImgFile() {
        return productImgFile;
    }

    public void setProductImgFile(MultipartFile productImgFile) {
        this.productImgFile = productImgFile;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public String getPdLabel() {
        return pdLabel;
    }

    public void setPdLabel(String pdLabel) {
        this.pdLabel = pdLabel;
    }
}
