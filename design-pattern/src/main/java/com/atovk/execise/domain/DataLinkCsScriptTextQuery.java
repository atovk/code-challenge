/**
 * Yonghui.cn Inc.
 * Copyright (c) 2001-2019 All Rights Reserved.
 */
package com.atovk.execise.domain;

import java.util.List;

/**
 * @author chingsung
 */
public class DataLinkCsScriptTextQuery extends DataLinkCsScriptText {

    private String keyWord;

    private List<String> scriptTypes;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<String> getScriptTypes() {
        return scriptTypes;
    }

    public void setScriptTypes(List<String> scriptTypes) {
        this.scriptTypes = scriptTypes;
    }
}