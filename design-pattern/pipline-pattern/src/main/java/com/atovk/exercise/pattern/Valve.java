package com.atovk.exercise.pattern;

public interface Valve {

    public Valve getNext();

    public void setNext(Valve valve);

    public void invoke(String handling);
}
