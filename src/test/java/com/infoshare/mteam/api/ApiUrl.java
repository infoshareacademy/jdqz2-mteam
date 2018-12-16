package com.infoshare.mteam.api;

public class ApiUrl {

    protected final String apiUrl = "http://demo.shopizer.com:8080";

    public String path(String path) {
        return apiUrl.concat(path);
    }
}
