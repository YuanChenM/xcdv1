package com.msk.batch.so.bean;

import com.msk.core.file.xml.bean.ListTemplate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by wang_jianzhou on 2016/7/31.
 */
@XmlRootElement(name="DATACOLLECTION")
public class BSO152408XMLTemplate extends ListTemplate<BSO152408Result> {
    private List<BSO152408Result> data;
    @Override
    @XmlElement(name = "DATA")
    public List<BSO152408Result> getData() {
        return data;
    }

    public void setData(List<BSO152408Result> data) {
        this.data = data;
    }
}
