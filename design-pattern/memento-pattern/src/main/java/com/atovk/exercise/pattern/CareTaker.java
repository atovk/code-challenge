package com.atovk.exercise.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 状态保存类
 */
public class CareTaker {

    private List<Memento> mementos = new ArrayList<>(8);

    public void add(Memento memento) {
        mementos.add(memento);
    }

    public Memento get(int x) {
        return mementos.get(x);
    }
}
