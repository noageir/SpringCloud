package com.micro.system.util;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.micro.system.util.excel.ExcelException;
import com.micro.system.util.excel.ExcelListener;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Noageir
 * Date: 2019-09-06
 * Project: com.spring.cloud
 * Package: com.micro.system.util
 */
public class ExcelUtil {
    /**
     * 读取 Excel(多个 sheet)
     *
     * @param excel    文件
     * @param rowModel 实体类映射，继承 BaseRowModel 类
     * @return Excel 数据 list
     */
    public static <T extends BaseRowModel> Map<String, List<T>> readExcelForAll(MultipartFile excel, final Class<? extends BaseRowModel> rowModel) {
        ExcelListener excelListener = new ExcelListener<>();
        ExcelReader reader = getReader(excel, excelListener);
        Map<String, List<T>> map = new HashMap<>();
        if (reader == null) {
            return null;
        }

        for (Sheet sheet : reader.getSheets()) {
            if (rowModel != null) {
                sheet.setClazz(rowModel);
            }
            reader.read(sheet);
            if (!excelListener.getDataInfo().isEmpty()) {
                map.put(sheet.getSheetName(), excelListener.getDataInfo());
                excelListener.setDataInfo(new ArrayList());
            }
        }
        return map;
    }

    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel    文件
     * @param rowModel 实体类映射，继承 BaseRowModel 类
     * @param sheetNo  sheet 的序号 从1开始
     * @return Excel 数据 list
     */
    public static <T extends BaseRowModel> List<T> readExcelByOne(MultipartFile excel, final Class<? extends BaseRowModel> rowModel, int sheetNo) {
        ExcelListener<T> excelListener = new ExcelListener<>();
        ExcelReader reader = getReader(excel, excelListener);
        if (reader == null) {
            return null;
        }
        reader.read(new Sheet(sheetNo, 1, rowModel));
        return excelListener.getDataInfo();
    }

    /**
     * 返回 ExcelReader
     *
     * @param excel         需要解析的 Excel 文件
     * @param excelListener new ExcelListener()
     */
    private static ExcelReader getReader(MultipartFile excel, ExcelListener excelListener) {
        String filename = excel.getOriginalFilename();
        if (filename == null || (!filename.toLowerCase().endsWith(".xls") && !filename.toLowerCase().endsWith(".xlsx"))) {
            throw new ExcelException("文件格式错误！");
        }
        try {
            InputStream inputStream = new BufferedInputStream(excel.getInputStream());
            return new ExcelReader(inputStream, null, excelListener, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

