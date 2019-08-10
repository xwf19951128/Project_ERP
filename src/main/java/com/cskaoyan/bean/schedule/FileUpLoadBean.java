package com.cskaoyan.bean.schedule;

public class FileUpLoadBean {
    public int error;
    public String url;

    public FileUpLoadBean() {
    }

    public FileUpLoadBean(int error, String url) {
        this.error = error;
        this.url = url;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
