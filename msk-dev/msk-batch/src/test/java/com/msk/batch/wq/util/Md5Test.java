package com.msk.batch.wq.util;

import com.msk.common.logic.ConfigLogic;
import com.msk.core.utils.ConfigInfo;
import com.msk.core.utils.ConfigManager;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ma_b on 2017/1/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/application-context.xml", "classpath:/spring/mybatis-context.xml","classpath:/spring/restclient-context.xml"})
    public class Md5Test {

    private static WqConfigInfo config;
    @Autowired
    public void setConfigInfo(final WqConfigInfo config) {
        Md5Test.config = config;
    }

    @org.junit.Test
    public void encode() throws Exception {

//        ApplicationContext context = new FileSystemXmlApplicationContext(
//                new String[] { "classpath:/spring/application-context.xml", "classpath:/spring/mybatis-context.xml","classpath:/spring/restclient-context.xml" });
//        WqConfigInfo config = context.getBean("wqConfigInfo", WqConfigInfo.class);

        String ts = "20170109153400";
        String appkey = config.getAppKey();
        //appkey="5OSDOXcvkK9I1A79IT";

        StringBuffer body = new StringBuffer();
        body.append("{");
        //body.append("\"emp_id\":\"test\"");
        body.append("}");

        String key = Md5.encode(String.format("%s|%s|%s", body.toString(), appkey, ts));
        System.out.println(String.format("%s|%s|%s", body.toString(), appkey, ts));
        System.out.println(key);
    }

}