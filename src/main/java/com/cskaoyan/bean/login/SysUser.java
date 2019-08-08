package com.cskaoyan.bean.login;

import org.springframework.stereotype.Component;

@Component
public class SysUser {
    String id;
    String username;
    String password;
    char locked;
    String randomcode;
    String rolename="超级管理员";

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRandomcode() {
        return randomcode;
    }

    public void setRandomcode(String randomcode) {
        this.randomcode = randomcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getLocked() {
        return locked;
    }

    public void setLocked(char locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", locked=" + locked +
                ", randomcode='" + randomcode + '\'' +
                '}';
    }
}
