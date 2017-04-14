package com.hwangfantasy.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author hwangfantasy
 * @创建时间: 2017/3/2 17:40 <br/>
 * @方法描述: TODO ADD FUNCTION. <br/>
 */
public class SessionUser implements Serializable {
    private static final long serialVersionUID = -4062960805911770971L;

    private Integer userId;
    private String userName;
    private String password;
    private String roleName;
    private List<String> urls;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
