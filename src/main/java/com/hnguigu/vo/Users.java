package com.hnguigu.vo;

public class Users {
    private Integer uid;
    private String user;
    private String password;

    public Integer getUid() {
        return uid;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
