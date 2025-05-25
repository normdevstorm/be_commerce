package com.normdevstorm.commerce_platform.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
@Log4j2
public class UtilsManager {
    static public boolean toBoolean(Integer integer){
        return integer == 1 ? true : false;
    }

    public static String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    public static void  getUserIdContextLog(String userId, String userEventLog){
        ThreadContext.put("userId", "[ userId: " + userId + " ]");
        log.info(userEventLog);
        ThreadContext.clearMap();
    }

}
