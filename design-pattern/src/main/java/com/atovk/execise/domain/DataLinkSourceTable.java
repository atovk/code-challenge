/**
 * Yonghui.cn Inc.
 * Copyright (c) 2001-2019 All Rights Reserved.
 */
package com.atovk.execise.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chingsung
 */
public class DataLinkSourceTable implements Serializable {
    private Long id;

    private String groupCode;

    private String groupName;

    private String dataCode;

    private String tableCode;

    private String tableName;

    private String tableComment;

    private String tablePropertyA;

    private String tablePropertyB;

    private String tablePropertyC;

    private String tablePropertyD;

    private String tableDesc;

    private Integer isGroup;

    private Integer isUsed;

    private String env;

    private Integer isDeleted;

    private String owner;

    private Date sysCreate;

    private Date sysUpdate;

    private String sysOper;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getTablePropertyA() {
        return tablePropertyA;
    }

    public void setTablePropertyA(String tablePropertyA) {
        this.tablePropertyA = tablePropertyA;
    }

    public String getTablePropertyB() {
        return tablePropertyB;
    }

    public void setTablePropertyB(String tablePropertyB) {
        this.tablePropertyB = tablePropertyB;
    }

    public String getTablePropertyC() {
        return tablePropertyC;
    }

    public void setTablePropertyC(String tablePropertyC) {
        this.tablePropertyC = tablePropertyC;
    }

    public String getTablePropertyD() {
        return tablePropertyD;
    }

    public void setTablePropertyD(String tablePropertyD) {
        this.tablePropertyD = tablePropertyD;
    }

    public String getTableDesc() {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getSysCreate() {
        return sysCreate;
    }

    public void setSysCreate(Date sysCreate) {
        this.sysCreate = sysCreate;
    }

    public Date getSysUpdate() {
        return sysUpdate;
    }

    public void setSysUpdate(Date sysUpdate) {
        this.sysUpdate = sysUpdate;
    }

    public String getSysOper() {
        return sysOper;
    }

    public void setSysOper(String sysOper) {
        this.sysOper = sysOper;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Integer isGroup) {
        this.isGroup = isGroup;
    }
}