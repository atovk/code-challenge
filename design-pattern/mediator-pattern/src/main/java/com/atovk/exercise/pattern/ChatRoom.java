package com.atovk.exercise.pattern;

import java.util.Date;

public class ChatRoom {

    public static void showMessage(User user, String msg) {
        System.out.println(new Date().toString() + " " + user.getName() + " " + msg);
    }
}
