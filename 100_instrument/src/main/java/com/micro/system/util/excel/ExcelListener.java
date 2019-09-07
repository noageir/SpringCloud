package com.micro.system.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Noageir
 * Date: 2019-09-06
 * Project: com.spring.cloud
 * Package: com.micro.system.util.excel
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExcelListener extends AnalysisEventListener {

    private List<Object> data = new ArrayList<Object>();

    public void invoke(Object o, AnalysisContext analysisContext) {
        data.add(o);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        /*
            解析结束销毁不用的资源
         */
        data.clear();
    }
}
