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
public class DataLinkSourceTableColumn implements Serializable {
    private Long id;

    private String dataCode;

    private String tableCode;

    private String columnCode;

    private String columnName;

    private String columnType;

    private String columnPropertyA;

    private String columnPropertyB;

    private String columnPropertyC;

    private String columnPropertyD;

    private String columnDesc;

    private Integer isUsed;

    private String env;

    private Integer isDeleted;

    private String owner;

    private Date sysCreate;

    private Date sysUpdate;

    private String sysOper;

    private Boolean isInUsing;


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

    public String getColumnCode() {
        return columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnPropertyA() {
        return columnPropertyA;
    }

    public void setColumnPropertyA(String columnPropertyA) {
        this.columnPropertyA = columnPropertyA;
    }

    public String getColumnPropertyB() {
        return columnPropertyB;
    }

    public void setColumnPropertyB(String columnPropertyB) {
        this.columnPropertyB = columnPropertyB;
    }

    public String getColumnPropertyC() {
        return columnPropertyC;
    }

    public void setColumnPropertyC(String columnPropertyC) {
        this.columnPropertyC = columnPropertyC;
    }

    public String getColumnPropertyD() {
        return columnPropertyD;
    }

    public void setColumnPropertyD(String columnPropertyD) {
        this.columnPropertyD = columnPropertyD;
    }

    public String getColumnDesc() {
        return columnDesc;
    }

    public void setColumnDesc(String columnDesc) {
        this.columnDesc = columnDesc;
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

    public Boolean getIsInUsing() {
        return isInUsing;
    }

    public void setIsInUsing(Boolean isInUsing) {
        this.isInUsing = isInUsing;
    }
}