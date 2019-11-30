package com.micro.system.manager.model.file;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Noageir
 * Date: 2019-11-02
 * Project: com.spring.cloud
 * Package: com.micro.system.manager.model.entity
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FileUpload extends BaseRowModel implements Serializable {
    @ExcelProperty(index = 0, value = "姓名")
    @ApiModelProperty(value = "姓名")
    private String name;

    @ExcelProperty(index = 1, value = "年龄")
    @ApiModelProperty(value = "年龄")
    private String age;
}
