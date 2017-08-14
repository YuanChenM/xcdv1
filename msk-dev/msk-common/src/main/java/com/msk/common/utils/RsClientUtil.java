package com.msk.common.utils;

import java.io.IOException;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.utils.StringUtil;

/**
 * 
 * RsClientUtil.
 */
@Component
public class RsClientUtil {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(RsClientUtil.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * callRsService with GET method
     *
     * @param url url
     * @param resultType resultType
     * @param <T> resultType
     * @return RsResponse
     */
    public <T> T getRsService(String url, Class<T> resultType) {
        return restTemplate.getForObject(url, resultType);
    }

    /**
     * callRsService
     *
     * @param url url
     * @param param param
     * @param resultType resultType
     * @param <T> resultType
     * @return RsResponse
     */
    public <T> T postRsService(String url, Object param, Class<T> resultType) {
        return restTemplate.postForObject(url, param, resultType);
    }

    /**
     * callRsService
     *
     * @param url url
     * @param param param
     * @param resultType resultType
     * @param <T> resultType
     * @return RsResponse
     */
    public <T> RsResponse<T> postRsService(String url, RsRequest<?> param, Class<T> resultType) {
        // RestTemplate restTemplate1 = new RestTemplate();
        @SuppressWarnings("unchecked")
        RsResponse<T> result = restTemplate.postForObject(url, param, RsResponse.class);

        try {

            ObjectMapper mapper = new ObjectMapper();
            StringWriter sw = new StringWriter();
            JsonGenerator gen = new JsonFactory().createGenerator(sw);
            mapper.writeValue(gen, result.getResult());
            gen.close();
            String jsonResult = sw.toString();

            // get mapper
            ObjectMapper mapper1 = new ObjectMapper();
            // ignore
            mapper1.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            T rs = mapper1.readValue(jsonResult, resultType);
            logger.debug("{}:{}", StringUtil.toSafeString(rs), jsonResult);

            result.setResult(rs);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("Json 转换失败。", e);
        }

        return result;
    }
}
