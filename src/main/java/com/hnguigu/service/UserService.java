package com.hnguigu.service;

import com.hnguigu.vo.Users;

import java.util.List;

public interface UserService {
    //登录
    public Users login(Users users);

    //注册
    public int register(Users users);

    //查询所有
    public List<Users> queryAll();

    //添加
    public int add(Users users);

    //修改
    public int update(Users users);

    //删除
    public int del(int uid);

    //根据id查询当前记录
    public Users querybyid(int uid);
}
