package com.atovk.exercise.pattern;

import org.junit.Test;

import static org.junit.Assert.*;

public class CareTakerTest {

    @Test
    public void careTaker() {

        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("state #1");
        originator.setState("state #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("state #3");
        careTaker.add(originator.saveStateToMemento());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println(originator.getState());
    }
}