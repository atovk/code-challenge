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
public class DataLinkCsScriptText implements Serializable {
    private Long id;

    private String scriptCode;

    private String versionCode;

    private String versionName;

    private Date versionTime;

    private String nextVersion;

    private String scriptHead;

    private String scriptText;

    private String env;

    private Integer isDeleted;

    private Integer isHis;

    /**
     * 针对管理组，需要指定其所管理的分组编号
     */
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

    public String getScriptCode() {
        return scriptCode;
    }

    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getNextVersion() {
        return nextVersion;
    }

    public void setNextVersion(String nextVersion) {
        this.nextVersion = nextVersion;
    }

    public String getScriptHead() {
        return scriptHead;
    }

    public void setScriptHead(String scriptHead) {
        this.scriptHead = scriptHead;
    }

    public String getScriptText() {
        return scriptText;
    }

    public void setScriptText(String scriptText) {
        this.scriptText = scriptText;
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

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Integer getIsHis() {
        return isHis;
    }

    public void setIsHis(Integer isHis) {
        this.isHis = isHis;
    }

    public Date getVersionTime() {
        return versionTime;
    }

    public void setVersionTime(Date versionTime) {
        this.versionTime = versionTime;
    }
}