package com.micro.system.manager.web;

import com.alibaba.excel.util.CollectionUtils;
import com.micro.system.manager.constant.ManagerConstant;
import com.micro.system.manager.model.entity.FileInfo;
import com.micro.system.manager.model.file.FileUpload;
import com.micro.system.util.ExcelUtil;
import com.micro.system.util.ReturnJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
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
@Api(tags = "02-文件管理")
public class FileRest {
    @PostMapping("/file_upload")
    @ApiOperation(value = "文件上传", notes = "通过入参上传文件，返回结果", response = Map.class)
    public ReturnJson fileUpload(@ApiParam(value = "file", required = true) MultipartFile file) {
        Map<String, List<FileUpload>> list2 = ExcelUtil.readExcelForAll(file, FileUpload.class);
        if (CollectionUtils.isEmpty(list2)) {
            return ReturnJson.success(ManagerConstant.FILE_NULL);
        } else {
            Map<String, List<FileInfo>> fileInfoMap = new HashMap<>();
            for (String key : list2.keySet()) {
                List<FileUpload> fileUploads = list2.get(key);
                if (!CollectionUtils.isEmpty(fileUploads)) {
                    List<FileInfo> fileInfos = new ArrayList<>();
                    for (FileUpload fileUpload : fileUploads) {
                        FileInfo fileInfo = new FileInfo();
                        BeanUtils.copyProperties(fileUpload, fileInfo);
                        fileInfos.add(fileInfo);
                    }
                    fileInfoMap.put(key, fileInfos);
                }
            }
            return ReturnJson.success(fileInfoMap);
        }
    }
}
