package com.hwangfantasy.enums;

/**
 * @author hwangfantasy
 * @创建时间: 2017/3/3 11:14 <br/>
 * @方法描述: TODO ADD FUNCTION. <br/>
 */

public enum RoleEnum {
    ROLE_ADMIN("ROLE_ADMIN", "管理员"),
    ROLE_DEVLOPER("ROLE_DEVLOPER", "开发者");
    private String role;
    private String desc;

    RoleEnum(String role, String desc) {
        this.role = role;
        this.desc = desc;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
