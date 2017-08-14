package com.msk.batch.wq.util;

//import com.msk.batch.wq.bean.BWQ200101Bean;
//import com.msk.batch.wq.bean.BWQ200101Req;
import com.msk.batch.wq.bean.WqResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ma_b on 2017/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/application-context.xml", "classpath:/spring/mybatis-context.xml", "classpath:/spring/restclient-context.xml"})
public class WqHttpClientTest {
    @Test
    public void httpPost() throws Exception {

//        String url = "employee/v2/queryEmployee";
//        String msgId = "WqHttpClientTest";
//        BWQ200101Req req = new BWQ200101Req();
//        req.setEmpCode("test");
//        WqResponse<BWQ200101Bean> result = WqHttpClient.httpPost(url, req, msgId, BWQ200101Bean.class);
//        List<BWQ200101Bean> datas = result.getData();
//
//        Assert.assertNotNull(datas);
//        Assert.assertTrue(datas.size() > 0);
    }

}