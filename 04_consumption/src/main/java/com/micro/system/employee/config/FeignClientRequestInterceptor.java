package com.micro.system.employee.config;

import com.micro.system.util.MdcUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.micrometer.core.instrument.util.StringUtils;

public class FeignClientRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        String userId = MdcUtil.getUserId();
        if (StringUtils.isNotBlank(userId)) {
            template.header(MdcUtil.MDC_USER_ID, userId);
        }
        String transactionId = MdcUtil.getTransactionId();
        if (StringUtils.isNotBlank(transactionId)) {
            template.header(MdcUtil.MDC_TRANSACTION_ID, transactionId);
        }
    }
}