package com.micro.system.zuul.config;

import com.micro.system.util.MdcUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeignClientRequestInterceptor implements RequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(FeignClientRequestInterceptor.class);

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