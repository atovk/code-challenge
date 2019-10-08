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
public class DataLinkRelation implements Serializable {
    private Long id;

    private String relationA;

    private String relationB;

    private String relationC;

    private String type;

    private String secType;

    private String aExt;

    private String bExt;

    private String cExt;

    private Integer isUsed;

    private Integer orderRef;

    private String env;

    private Integer isDeleted;

    private String owner;

    private Date sysCreate;

    private Date sysUpdate;

    private String sysOper;

    private String relationExt;

    private Object object;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelationA() {
        return relationA;
    }

    public void setRelationA(String relationA) {
        this.relationA = relationA;
    }

    public String getRelationB() {
        return relationB;
    }

    public void setRelationB(String relationB) {
        this.relationB = relationB;
    }

    public String getRelationC() {
        return relationC;
    }

    public void setRelationC(String relationC) {
        this.relationC = relationC;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public String getaExt() {
        return aExt;
    }

    public void setaExt(String aExt) {
        this.aExt = aExt;
    }

    public String getbExt() {
        return bExt;
    }

    public void setbExt(String bExt) {
        this.bExt = bExt;
    }

    public String getcExt() {
        return cExt;
    }

    public void setcExt(String cExt) {
        this.cExt = cExt;
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

    public String getRelationExt() {
        return relationExt;
    }

    public void setRelationExt(String relationExt) {
        this.relationExt = relationExt;
    }

    public Integer getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(Integer orderRef) {
        this.orderRef = orderRef;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}