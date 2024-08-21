package com.normdevstorm.commerce_platform.util;

import jakarta.servlet.http.HttpServletRequest;

public class UtilsManager {
    static public boolean toBoolean(Integer integer){
        return integer == 1 ? true : false;
    }

    public static String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
