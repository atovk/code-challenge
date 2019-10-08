package com.atovk.execise.domain;

public class DataLinkRunningServerWithBLOBs extends DataLinkRunningServer {
    private String serviceInfo;

    private String runInfo;

    public String getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo == null ? null : serviceInfo.trim();
    }

    public void appendServiceInfo(String newLine){
        final String originalString = this.getServiceInfo();
        StringBuilder sb = new StringBuilder();
        sb.append(originalString);
        sb.append("\n");
        sb.append(newLine);
        this.setServiceInfo(sb.toString());
    }

    public String getRunInfo() {
        return runInfo;
    }

    public void setRunInfo(String runInfo) {
        this.runInfo = runInfo == null ? null : runInfo.trim();
    }
}