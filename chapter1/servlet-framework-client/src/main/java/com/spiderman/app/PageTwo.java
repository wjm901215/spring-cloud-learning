package com.spiderman.app;

public class PageTwo implements Page {
    @Override
    public String getPageViewInfo() {
        return "view two info";
    }

    @Override
    public String getPageModelInfo() {
        return "model two info";
    }

    @Override
    public String getPath() {
        return "/pageTwo";
    }
}