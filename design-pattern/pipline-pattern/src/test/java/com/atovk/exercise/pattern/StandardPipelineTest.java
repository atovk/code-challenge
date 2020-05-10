package com.atovk.exercise.pattern;

import org.junit.Test;

import static org.junit.Assert.*;

public class StandardPipelineTest {

    @Test
    public void piplineHandel() {
        StandardPipeline pipeline = new StandardPipeline();

        pipeline.setBasic(new BasicValve());
        pipeline.addValve(new SecondValve());
        pipeline.addValve(new ThirdValve());

        pipeline.getFirst().invoke("aabb1122zzyy");

    }

}