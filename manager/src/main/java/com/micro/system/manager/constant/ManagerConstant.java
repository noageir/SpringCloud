package com.micro.system.manager.constant;

import com.micro.system.util.ResponseCode;

import java.io.Serializable;

/**
 * @author Noageir
 * Date: 2018-05-20
 * Project: com.spring.cloud
 * Package: com.micro.system.manager.constant
 */
public class ManagerConstant implements Serializable {
    /**
     * 错误码
     */
    public static final ResponseCode RESULT_NULL = new ResponseCode("Mr1000001", "批量新增用户失败");

    public static final ResponseCode FILE_NULL = new ResponseCode("Mr1000002", "上传文件内容为空");
}
