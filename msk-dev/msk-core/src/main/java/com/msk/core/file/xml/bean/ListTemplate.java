package com.msk.core.file.xml.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.msk.core.entity.BaseEntity;

import java.util.List;

@XmlRootElement(name="DATACOLLECTION")
public abstract class ListTemplate<T> extends BaseEntity{
    @XmlElement(name = "DATA")
    public abstract List<T> getData();

}
