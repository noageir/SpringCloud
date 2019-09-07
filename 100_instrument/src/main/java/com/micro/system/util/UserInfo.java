package com.micro.system.util;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 2017/3/15.
 */
@Data
public class UserInfo implements Serializable {

    /**
     * 登录用户名
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 是否是坐席
     */
    private String identityInfo;
    /**
     * 所属子系统
     */
    private String subsystemCode;

    /**
     * 登录时间
     */
    private Date dateLogin;
    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 是否已被强制退出
     */
    private boolean forceLogOut = false;
    /**
     * 登录时间
     */
    private Date forceLogOutDate;

    /**
     * 客户端IP
     */
    private String forceLogOutClientIp;

    /**
     * 登录角色列表
     */
    private List<String> roleList;

    /**
     * 登录权限url列表
     */
    private List<String> urlList;

    /**
     * 用户菜单
     */
    private String menuList;
}
