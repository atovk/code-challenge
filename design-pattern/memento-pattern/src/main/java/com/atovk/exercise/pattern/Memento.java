package com.atovk.exercise.pattern;

/**
 * 状态包装
 */
public class Memento {

    private String state;

    Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
