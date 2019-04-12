package com.micro.system.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author Noageir
 * Date: 2017-12-23 3:26
 * Modifyed: Noageir
 */
@Data
public class ReturnJson<T> {
    private final String resultCode;

    private final String resultMessage;

    private transient final T data;


    public ReturnJson() {
        this.resultCode = CommConstant.SUCCESS_CODE;
        this.resultMessage = CommConstant.SUCCESS_MESSAGE;
        this.data = null;
    }

    private ReturnJson(String resultCode, String resultMessage, T data) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.data = data;
    }

    public static ReturnJson json(ResponseCode responseCode, Object data) {
        return new ReturnJson<Object>(responseCode.getCode(), responseCode.getMessage(), data);
    }

    public static ReturnJson json(ResponseCode responseCode) {
        return new ReturnJson<Object>(responseCode.getCode(), responseCode.getMessage(), null);
    }

    /**
     * 返回成功的JSON串
     *
     * @param data 有参数
     */
    public static ReturnJson success(Object data) {
        return ReturnJson.json(CommConstant.SUCCESS, data);
    }

    /**
     * 返回成功的JSON串
     */
    public static ReturnJson success() {
        return ReturnJson.success(null);
    }


    /**
     * 返回默认失败的JSON串
     *
     * @param data 返回值
     * @return json串
     */
    public static ReturnJson fail(Object data) {
        return ReturnJson.json(CommConstant.SYSTEM_FAIL, data);
    }


    /**
     * 返回失败的JSON串,数据体为null
     */
    private static ReturnJson fail(Exception exception) {
        CommonResult commonResult = new CommonResult();
        commonResult.setErrorMessage(exception.getMessage());
        commonResult.setExceptionName(exception.getClass().getSimpleName());
        return ReturnJson.fail(commonResult);
    }

    /**
     * 根据结果码、结果信息、数据体生成实体
     */
    public static ReturnJson json(String resultCode, String resultMessage, Object data) {
        return new ReturnJson<Object>(resultCode, resultMessage, data);
    }


    /**
     * 根据结果码判断请求是否处理成功
     */
    @JsonIgnore
    public boolean isSuccess() {
        return CommConstant.SUCCESS_CODE.equalsIgnoreCase(resultCode);
    }

    @JsonIgnore
    public ResponseCode getResponseCode() {
        return new ResponseCode(resultCode, resultMessage);
    }

    /**
     * 返回结果code
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 返回结果具体信息
     */
    public String getResultMessage() {
        return resultMessage;
    }

    /**
     * 返回结果的具体数据
     */
    public T getData() {
        return data;
    }
}
