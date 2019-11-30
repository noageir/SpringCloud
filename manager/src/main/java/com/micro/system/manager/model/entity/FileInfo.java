package com.micro.system.manager.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Noageir
 * Date: 2019-11-30
 * Project: com.master
 * Package: com.micro.system.manager.model.entity
 */
@Data
public class FileInfo {
    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private String age;
}
