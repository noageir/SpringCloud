package com.micro.system.manager.model.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class HelloTestForm {
    @ApiModelProperty(value = "用户")
    @NotNull(message = "用户不能为空")
    @Size(min = 1, max = 20, message = "用户字符最大长度不能超过20个字符")
    private String user;

    @ApiModelProperty(value = "序号")
    @NotNull(message = "序号不能为空")
    @Min(value = 1, message = "序号不能为空")
    private int serialNumber;
}
