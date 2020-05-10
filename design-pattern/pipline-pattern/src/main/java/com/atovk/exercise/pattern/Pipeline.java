package com.atovk.exercise.pattern;

public interface Pipeline {

    public Valve getFirst();

    public Valve getBasic();

    public void setBasic(Valve valve);

    public void addValve(Valve valve);
}
