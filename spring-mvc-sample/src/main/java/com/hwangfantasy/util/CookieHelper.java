package com.hwangfantasy.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/14 <br/>
 * @方法描述: CookieHelper. <br/>
 */

public class CookieHelper {
    public static void storeCookie(String key, String value, HttpServletResponse response) {
        Cookie c = new Cookie(key, value);
        c.setMaxAge(365 * 24 * 60 * 60); // one year
        response.addCookie(c);
    }
}
