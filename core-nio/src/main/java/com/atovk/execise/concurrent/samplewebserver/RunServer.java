package com.atovk.execise.concurrent.samplewebserver;

import java.io.IOException;

public class RunServer {

    public static void main(String[] args) throws IOException {

        SimpleHttpServer.setBasePath("/Users/atovk/IdeaProjects/code-challenge/core-nio/src/main/resources/");
        SimpleHttpServer.start();

    }

}
