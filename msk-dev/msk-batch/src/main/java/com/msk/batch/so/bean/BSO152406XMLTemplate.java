package com.msk.batch.so.bean;

import com.msk.core.file.xml.bean.EntityTemplate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by wang_jianzhou on 2016/7/31.
 */
@XmlRootElement(name="DATACOLLECTION")
public class BSO152406XMLTemplate extends EntityTemplate<BSO152406Result> {
    private BSO152406Result data;
    @Override
    @XmlElement(name = "DATA")
    public BSO152406Result getData() {
        return data;
    }

    public void setData(BSO152406Result data) {
        this.data = data;
    }
}
