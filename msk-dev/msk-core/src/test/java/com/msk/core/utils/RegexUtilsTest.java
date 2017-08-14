package com.msk.core.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mabo on 2016/7/12.
 */
public class RegexUtilsTest {

    @Test
    public void testFind() throws Exception {
        String regex = "^.+//.+/.+/(.+)/main$";
        String result = RegexUtils.find(regex, "http://localhost:8080/msk-web/so/main", 4);
        Assert.assertEquals("so", result);
        result = RegexUtils.find(regex, "http://localhost:8080/msk-web/so-cp/main", 4);
        Assert.assertEquals("so-cp", result);
    }
}