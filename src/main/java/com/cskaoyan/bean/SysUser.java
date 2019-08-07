package com.cskaoyan.bean;

import org.springframework.stereotype.Component;

@Component
public class SysUser {
    String id;
    String username;
    String password;
    char locked;
    String randomcode;

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
