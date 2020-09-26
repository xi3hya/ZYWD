package com.hnguigu.dao;

import com.hnguigu.vo.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //登录
    public Users login(Users users);

    //注册
    public int register(Users users);

    //查询所有
    public List<Users> queryAll();

    //添加
    public int add(Users user);

    //修改
    public int update(Users user);

    //删除
    public int del(Integer uid);

    //根据id查询当前记录
    public Users querybyid(int uid);
}
