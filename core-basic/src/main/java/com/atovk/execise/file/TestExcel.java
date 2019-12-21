package com.atovk.execise.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestExcel {


    public static void main(String[] args) throws IOException {

        File excelFile = new File("/Users/atovk/IdeaProjects/code-challenge/core-basic/src/main/resources/DataLinkSourceTemplate .xlsx");


        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(excelFile));


        System.out.println();

    }


}
