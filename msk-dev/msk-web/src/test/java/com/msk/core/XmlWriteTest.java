/*
package com.msk.core;

import com.msk.bean.XmlTest;
import com.msk.core.file.xml.XmlWrite;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * *XmlWriteTest
 * *@author jiang_nan
 * *@version 1.0
 **//*

public class XmlWriteTest {
    @Test
    public void testCreateXml(){
        String tempPatch = getClass().getResource("/").getPath().replaceAll("%20", " ") + "template";
        XmlWrite<List<XmlTest>> xmlWrite = new XmlWrite<>(tempPatch,"xml.ftl");
        List<XmlTest> list = new ArrayList<>();
        XmlTest xmlTest = new XmlTest();
        xmlTest.setAge("1");
        xmlTest.setId("2");
        list.add(xmlTest);
        System.out.print(xmlWrite.createXml(list,"test.xml"));

    }
}
*/
