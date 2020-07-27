package com.micro.system.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created on 2019/8/10.
 *
 * @author Noageir
 * com.spring.cloud
 * com.micro.system.util
 */
public class ToolsUtils {

    static String getUserIdFromReq(HttpServletRequest request) {
        //先从header中获取
        String userId = request.getHeader(MdcUtil.MDC_USER_ID);
        if (StringUtils.isBlank(userId)) {
            //获取不到, 再从session中获取
            HttpSession httpSession = request.getSession();
            Object userObj = httpSession.getAttribute(CommConstant.CURRENT_USER_INFO);
            if (userObj == null) {
                return "";
            } else {
                UserInfo userInfo = (UserInfo) userObj;
                userId = userInfo.getUserId();
            }
        }
        if (StringUtils.isBlank(userId)) {
            return "";
        }
        return userId;
    }
}
