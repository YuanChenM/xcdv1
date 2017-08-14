package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 接口返回值
 * 用于调用外勤365的api的请求发送
 *
 * @param <T> 返回数据类型
 */
public class WqResponse<T> {
    /**
     * 消息ID
     */
    @JsonProperty("msg_id")
    private String msgId;
    /**
     * 返回代码
     */
    @JsonProperty("return_code")
    private String returnCode;
    /**
     * 结果消息
     */
    @JsonProperty("return_msg")
    private String returnMsg;
    /**
     * 结果
     */
    @JsonProperty("response_data")
    private String responseData;
    /**
     * 业务返回值
     */
    private List<T> data;

    /**
     * 构造方法
     */
    public WqResponse() {

    }

    /**
     * Get the 消息ID.
     *
     * @return 消息ID
     */
    public String getMsgId() {
        return this.msgId;
    }

    /**
     * Set the 消息ID.
     *
     * @param msgId 消息ID
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * Get the returnCode.
     *
     * @return returnCode
     */
    public String getReturnCode() {
        return this.returnCode;
    }

    /**
     * Set the returnCode.
     *
     * @param returnCode returnCode
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    /**
     * Get the returnMsg.
     *
     * @return returnMsg
     */
    public String getReturnMsg() {
        return this.returnMsg;
    }

    /**
     * Set the message.
     *
     * @param returnMsg returnMsg
     */
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    /**
     * Get the responseData.
     *
     * @return responseData
     */
    public String getResponseData() {
        return this.responseData;
    }

    /**
     * Set the responseData.
     *
     * @param responseData responseData
     */
    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    /**
     * Get the data.
     *
     * @return data
     */
    public List<T> getData() {
        return this.data;
    }

    /**
     * Set the data.
     *
     * @param data data
     */
    public void setData(List<T> data) {
        this.data = data;
    }

}
