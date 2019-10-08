package com.atovk.execise.adapter;

import java.util.List;
import java.util.Map;
import java.sql.Types;

public interface Attention<T extends Object> {
    public static final String ORACLE = "ORACLE";

     T takeConnect();
}
