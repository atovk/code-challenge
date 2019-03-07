package com.atovk.execise.serialization;

public class SimpleTask extends Task {

    private String name;

    SimpleTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " run this simple task!");
    }
}
