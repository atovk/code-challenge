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
public class DataLinkCsScript implements Serializable {
    private Long id;

    private String scriptCode;

    private String scriptName;

    private String scriptType;

    private String scriptDesc;

    private Integer isUsed;

    private String env;

    private Integer isDeleted;

    /**
     * 针对管理组，需要指定其所管理的分组编号
     */
    private String owner;

    private Date sysCreate;

    private Date sysUpdate;

    private String sysOper;

    private String scriptText;

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

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getScriptType() {
        return scriptType;
    }

    public void setScriptType(String scriptType) {
        this.scriptType = scriptType;
    }

    public String getScriptDesc() {
        return scriptDesc;
    }

    public void setScriptDesc(String scriptDesc) {
        this.scriptDesc = scriptDesc;
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

    public String getScriptText() {
        return scriptText;
    }

    public void setScriptText(String scriptText) {
        this.scriptText = scriptText;
    }
}