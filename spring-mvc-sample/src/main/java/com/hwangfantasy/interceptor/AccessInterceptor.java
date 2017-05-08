package com.hwangfantasy.interceptor;

import com.hwangfantasy.config.Constant;
import com.hwangfantasy.enums.RoleEnum;
import com.hwangfantasy.model.SessionUser;
import com.hwangfantasy.util.CookieHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;


/**
 * @author hwangfantasy
 * @创建时间: 2017/3/2 17:40 <br/>
 * @方法描述: TODO ADD FUNCTION. <br/>
 */
public class AccessInterceptor implements HandlerInterceptor {
    private String[] ignoreUrls = new String[]{"/sample","/index.html"};

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取url地址
        String reqUrl = httpServletRequest.getRequestURI().replace(httpServletRequest.getContextPath(), "");
        if (isIgnore(reqUrl)) {
            return true;
        } else {
            HttpSession session = httpServletRequest.getSession();
            if (session == null || session.getAttribute(Constant.SESSION_USER_KEY) == null ||
                    "".equals(session.getAttribute(Constant.SESSION_USER_KEY).toString())) {
                CookieHelper.storeCookie(Constant.LOGIN_COOKIE_KEY, null, httpServletResponse);
                httpServletResponse.sendRedirect(httpServletRequest.getServletContext().getContextPath() + "/login");
                httpServletResponse.flushBuffer();
                return false;
            } else if (!isAccess(httpServletRequest, reqUrl)) {
                httpServletRequest.setCharacterEncoding("UTF-8");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("text/html; charset=UTF-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.write("no access");
                out.close();
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    /**
     * -----------------------------------</br>
     *
     * @作者: hwangfantasy
     * @创建日期: 2017/3/2 17:52</br>
     * -----------------------------------</br>
     * @方法描述: 忽略拦截
     * -----------------------------------</br>
     */
    private boolean isIgnore(String url) {
        for (String s : ignoreUrls) {
            if (url.startsWith(s))
                return true;
        }
        return false;
    }

    /**
     * -----------------------------------</br>
     *
     * @作者: hwangfantasy
     * @创建日期: 2017/3/2 17:52</br>
     * -----------------------------------</br>
     * @方法描述: 权限判断
     * -----------------------------------</br>
     */
    private boolean isAccess(HttpServletRequest request, String reqUrl) {
        SessionUser sessionUser = (SessionUser) request.getSession().getAttribute(Constant.SESSION_USER_KEY);
        if (sessionUser == null)
            return false;
        if (RoleEnum.ROLE_ADMIN.getRole().equals(sessionUser.getRoleName()))//管理员后门
            return true;
        if (RoleEnum.ROLE_DEVLOPER.getRole().equals(sessionUser.getRoleName()))//开发者后门
            return true;
        List<String> permissionUrls = sessionUser.getUrls();
        if (permissionUrls.size() > 0) {
            for (String url : permissionUrls) {
                if (StringUtils.isNotBlank(url.trim()) && reqUrl.indexOf(url.trim()) >= 0 || reqUrl.equals("/index")) {
                    return true;
                }
            }
        }
        return false;
    }
}
