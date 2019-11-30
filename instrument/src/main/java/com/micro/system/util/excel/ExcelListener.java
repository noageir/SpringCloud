package com.micro.system.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Noageir
 * Date: 2019-09-06
 * Project: com.spring.cloud
 * Package: com.micro.system.util.excel
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExcelListener<T extends BaseRowModel> extends AnalysisEventListener<T> {

    //自定义用于暂时存储data
    private List<T> dataInfo = new ArrayList<>();

    /**
     * 通过 AnalysisContext 对象还可以获取当前 sheet，当前行等数据
     */
    @Override
    public void invoke(T o, AnalysisContext analysisContext) {
        Integer currentRowNum = analysisContext.getCurrentRowNum();
        //获取导入表头，默认第一行为表头
        if (currentRowNum != 0) {
            dataInfo.add(o);
        }
    }

    /**
     * 读取完之后的操作
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    //Object转换为Map
    private Map<String, Object> objToMap(Object obj) throws Exception {
        Map<String, Object> map = new LinkedHashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }

}
