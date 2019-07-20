package com.micro.system.manager.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @author Noageir
 * Date: 2018-05-11 22:03
 * Project: com.spring.cloud
 * Package: com.micro.system.manager.util
 */
@Data
public class BasePage implements Serializable {
    private static final int MAX_PAGE_SIZE = 200;

    @Min(value = 1, message = "当前页码不能为空")
    @ApiModelProperty(value = "当前页码-int-必填", example = "1")
    private int pageNum = 1;

    @Min(value = 1, message = "每页的数量不能为空")
    @Max(value = MAX_PAGE_SIZE, message = "每页的数量不能超过200条")
    @ApiModelProperty(value = "每页的数量-int-必填", example = "20")
    private int pageSize = 20;

    @ApiModelProperty(value = "是否获取总数-boolean-必填", example = "true")
    private boolean countSql = true;

}
