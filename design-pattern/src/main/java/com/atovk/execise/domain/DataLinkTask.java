/**
 * Yonghui.cn Inc.
 * Copyright (c) 2001-2019 All Rights Reserved.
 */
package com.atovk.execise.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  chingsung
 */
public class DataLinkTask implements Serializable {
    private Long id;

    private String taskCode;

    private String taskName;

    private String taskState;

    private Date startDate;

    private Date endDate;

    private String timeRef;

    private Integer priority;

    private Integer rerunTimes;

    private Integer rerunInterval;

    private String sourceFrom;

    private String sourceTo;

    private String scriptGet;

    private String scriptGetName;

    private String taskDesc;

    private String cronExpress;

    private String isUsed;

    private String env;

    private String isDeleted;

    private String owner;

    private Date sysCreate;

    private String sysOper;

    private String fastFlag;

    private Date sysUpdate;

    private String scriptCode;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTimeRef() {
        return timeRef;
    }

    public void setTimeRef(String timeRef) {
        this.timeRef = timeRef;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getRerunTimes() {
        return rerunTimes;
    }

    public void setRerunTimes(Integer rerunTimes) {
        this.rerunTimes = rerunTimes;
    }

    public Integer getRerunInterval() {
        return rerunInterval;
    }

    public void setRerunInterval(Integer rerunInterval) {
        this.rerunInterval = rerunInterval;
    }

    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }

    public String getSourceTo() {
        return sourceTo;
    }

    public void setSourceTo(String sourceTo) {
        this.sourceTo = sourceTo;
    }

    public String getScriptGet() {
        return scriptGet;
    }

    public void setScriptGet(String scriptGet) {
        this.scriptGet = scriptGet;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
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

    public String getSysOper() {
        return sysOper;
    }

    public void setSysOper(String sysOper) {
        this.sysOper = sysOper;
    }

    public String getFastFlag() {
        return fastFlag;
    }

    public void setFastFlag(String fastFlag) {
        this.fastFlag = fastFlag;
    }

    public Date getSysUpdate() {
        return sysUpdate;
    }

    public void setSysUpdate(Date sysUpdate) {
        this.sysUpdate = sysUpdate;
    }

    public String getCronExpress() {
        return cronExpress;
    }

    public void setCronExpress(String cronExpress) {
        this.cronExpress = cronExpress;
    }

    public String getScriptGetName() {
        return scriptGetName;
    }

    public void setScriptGetName(String scriptGetName) {
        this.scriptGetName = scriptGetName;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public String getScriptCode() {
        return scriptCode;
    }

    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }
}