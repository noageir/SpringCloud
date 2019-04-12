package com.micro.system.util;

import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author noageir
 * Date 2019-03-21 22:54
 * Project: com.spring.cloud
 * Package: com.micro.system.util
 */
public class Entity {
    private static final String BY_NONE = "none";

    /**
     * 主键ID
     */
    private long id;

    /**
     * 更新者
     */
    private String updatedBy;

    /**
     * 创建者
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private Date dateCreated;

    /**
     * 创建时间
     */
    private Date dateUpdated;

    public Entity() {
        super();
    }

    public Entity(long id) {
        this(id, null, null, null, null);
    }

    private Entity(long id, String updatedBy, String createdBy, Date dateCreated, Date dateUpdated) {
        super();
        this.id = id;
        this.updatedBy = updatedBy;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUpdatedBy() {
        if (StringUtils.isEmpty(updatedBy)) {
            String mdcUserId = MdcUtil.getUserId();
            updatedBy = StringUtils.isEmpty(mdcUserId) ? BY_NONE : mdcUserId;
        }
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedBy() {
        if (StringUtils.isEmpty(createdBy)) {
            String mdcUserId = MdcUtil.getUserId();
            createdBy = StringUtils.isEmpty(mdcUserId) ? BY_NONE : mdcUserId;
        }
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateUpdated() {
        if (dateUpdated == null) {
            dateUpdated = new Date();
        }
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Date getDateCreated() {
        if (dateCreated == null) {
            dateCreated = new Date();
        }
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
