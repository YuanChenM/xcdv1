package com.msk.core.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msk.core.utils.ConfigManager;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mao_yejun on 2016/4/18.
 */
public class FileUploadUtil {

    public static final String FILE_SERVICE_URL = ConfigManager.getFileServerUploadInside();
    private static final int SUCCESS_RESPONSE = 200;

    public static Map<String, String> uploadFiles(Map<String, File> files) throws IOException {

        Map<String, String> result = new HashMap<String, String>();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(FILE_SERVICE_URL);
        ContentType contentType = ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), Charset.forName("UTF-8"));
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));
        for (String key : files.keySet()) {

            multipartEntityBuilder.addPart(key, new FileBody(files.get(key)));

        }
        multipartEntityBuilder.seContentType(ContentType.MULTIPART_FORM_DATA);
        HttpEntity entity = multipartEntityBuilder.build();
        httpPost.setEntity(entity);
        HttpResponse response = client.execute(httpPost);
        if(response.getStatusLine().getStatusCode() == SUCCESS_RESPONSE) {
            result = objectMapper.readValue(IOUtils.toString(response.getEntity().getContent(), "UTF-8"), Map.class);

        }
        return result;
    }

    /**
     * 文件流形式上传。
     *
     * @param streamMaps 指定的流文件 map 集。
     * @return 上传成功后的文件信息 map（key：所上传的文件流唯一标识，value：文件存储唯一标识）
     * @throws java.io.IOException
     */
    public static Map<String, String> uploadStreamFiles(Map<String, InputStream> streamMaps) throws IOException
    {
        Map<String, String> result = new HashMap<String, String>();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(FILE_SERVICE_URL);
        ContentType contentType = ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), Charset.forName("UTF-8"));
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));
        for (String key : streamMaps.keySet())
        {
            multipartEntityBuilder.addBinaryBody(key, streamMaps.get(key));
        }
        multipartEntityBuilder.seContentType(ContentType.MULTIPART_FORM_DATA);
        HttpEntity entity = multipartEntityBuilder.build();
        httpPost.setEntity(entity);
        HttpResponse response = client.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == SUCCESS_RESPONSE)
        {
            result = objectMapper.readValue(IOUtils.toString(response.getEntity().getContent(), "UTF-8"), Map.class);
        }
        return result;
    }
}


