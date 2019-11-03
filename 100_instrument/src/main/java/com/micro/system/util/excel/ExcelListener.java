package com.micro.system.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.ExcelHeadProperty;
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
public class ExcelListener extends AnalysisEventListener {

    //自定义用于暂时存储data
    private List<Object> dataInfo = new ArrayList<>();
    //导入表头
    private StringBuilder importHeads = new StringBuilder();
    //模版表头
    private StringBuilder modelHeads = new StringBuilder();

    /**
     * 通过 AnalysisContext 对象还可以获取当前 sheet，当前行等数据
     */
    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        Integer currentRowNum = analysisContext.getCurrentRowNum();
        //获取导入表头，默认第一行为表头
        if (currentRowNum == 0) {
            try {
                Map<String, Object> m = objToMap(o);
                for (Object v : m.values()) {
                    importHeads.append(String.valueOf(v).trim()).append(",");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            dataInfo.add(o);
        }
    }

    /**
     * 读取完之后的操作
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //获取模版表头
        ExcelHeadProperty ehp = analysisContext.getExcelHeadProperty();
        for (List<String> s : ehp.getHead()) {
            modelHeads.append(s.get(0)).append(",");
        }
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
