package com.atovk.exercise.pattern;

import org.junit.Test;

public class UserTest {

    @Test
    public void sendMessage() {

        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}