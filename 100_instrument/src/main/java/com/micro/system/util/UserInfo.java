package com.micro.system.util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 2017/3/15.
 */
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

    //开关
    private String umapFlag;

    //灰度的地址url
    private String gatewayUrl;

    //灰度的版本号别名
    private String envCode;


    public String getUmapFlag() {
        return umapFlag;
    }

    public void setUmapFlag(String umapFlag) {
        this.umapFlag = umapFlag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentityInfo() {
        return identityInfo;
    }

    public void setIdentityInfo(String identityInfo) {
        this.identityInfo = identityInfo;
    }

    public String getSubsystemCode() {
        return subsystemCode;
    }

    public void setSubsystemCode(String subsystemCode) {
        this.subsystemCode = subsystemCode;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public String getMenuList() {
        return menuList;
    }

    public void setMenuList(String menuList) {
        this.menuList = menuList;
    }

    public Date getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(Date dateLogin) {
        this.dateLogin = dateLogin;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public boolean isForceLogOut() {
        return forceLogOut;
    }

    public void setForceLogOut(boolean forceLogOut) {
        this.forceLogOut = forceLogOut;
    }

    public Date getForceLogOutDate() {
        return forceLogOutDate;
    }

    public void setForceLogOutDate(Date forceLogOutDate) {
        this.forceLogOutDate = forceLogOutDate;
    }

    public String getForceLogOutClientIp() {
        return forceLogOutClientIp;
    }

    public void setForceLogOutClientIp(String forceLogOutClientIp) {
        this.forceLogOutClientIp = forceLogOutClientIp;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getEnvCode() {
        return envCode;
    }

    public void setEnvCode(String envCode) {
        this.envCode = envCode;
    }
}
