package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 接口参数基类
 * 用于调用外勤365的api的请求发送
 */
//@JsonIgnoreProperties(value = {"filterMap"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WqRequest {
}
