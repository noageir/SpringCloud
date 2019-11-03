package com.micro.system.manager.web;

import com.alibaba.excel.util.CollectionUtils;
import com.micro.system.manager.model.file.FileUpload;
import com.micro.system.util.ExcelUtil;
import com.micro.system.util.ReturnJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author Noageir
 * Date: 2019-11-02
 * Project: com.spring.cloud
 * Package: com.micro.system.manager.web
 */
@RestController
@Log4j2
@RequestMapping("/file")
@Api(tags = "文件管理")
public class FileRest {
    @PostMapping("/file_upload")
    @ApiOperation(value = "文件上传", notes = "通过入参上传文件，返回结果", response = Boolean.class)
    public ReturnJson fileUpload(@ApiParam(value = "文件", required = true) MultipartFile file) {
        List<Object> list = ExcelUtil.readExcelByOne(file, new FileUpload(), 1);
        if (CollectionUtils.isEmpty(list)) {
            log.info("读取文件失败，文档内容为空");
        } else {
            log.info("First:{}", list.toString());
        }


        Map<String, List<Object>> list2 = ExcelUtil.readExcelForAll(file, new FileUpload());
        if (CollectionUtils.isEmpty(list2)) {
            log.info("读取文件失败，文档内容为空");
        } else {
            log.info("Two:{}", list2.toString());
        }
        return ReturnJson.success(true);
    }


}
