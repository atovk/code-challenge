package com.atovk.execise.domain;

import java.util.Date;

public class DataLinkRunningServer {
    private Long id;

    private String taskCode;

    private String serviceIp;

    private String servicePod;

    private Date runBegin;

    private Date runEnd;

    private String runState;

    private String serviceDesc;

    private String runLog;

    private Integer isUsed;

    private String env;

    private Integer isDeleted;

    private String owner;

    private Date sysCreate;

    private Date sysUpdate;

    private String sysOper;

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
        this.taskCode = taskCode == null ? null : taskCode.trim();
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp == null ? null : serviceIp.trim();
    }

    public String getServicePod() {
        return servicePod;
    }

    public void setServicePod(String servicePod) {
        this.servicePod = servicePod == null ? null : servicePod.trim();
    }

    public Date getRunBegin() {
        return runBegin;
    }

    public void setRunBegin(Date runBegin) {
        this.runBegin = runBegin;
    }

    public Date getRunEnd() {
        return runEnd;
    }

    public void setRunEnd(Date runEnd) {
        this.runEnd = runEnd;
    }

    public String getRunState() {
        return runState;
    }

    public void setRunState(String runState) {
        this.runState = runState == null ? null : runState.trim();
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc == null ? null : serviceDesc.trim();
    }

    public String getRunLog() {
        return runLog;
    }

    public void setRunLog(String runLog) {
        this.runLog = runLog == null ? null : runLog.trim();
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
        this.env = env == null ? null : env.trim();
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
        this.owner = owner == null ? null : owner.trim();
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
        this.sysOper = sysOper == null ? null : sysOper.trim();
    }
}