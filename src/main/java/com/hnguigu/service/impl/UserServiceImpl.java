package com.hnguigu.service.impl;

import com.hnguigu.dao.UserDao;
import com.hnguigu.service.UserService;
import com.hnguigu.vo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao dao;

    @Override
    public Users login(Users users) {
        return dao.login(users);
    }

    @Override
    public int register(Users users) {
        return dao.register(users);
    }

    @Override
    public List<Users> queryAll() {
        return dao.queryAll();
    }

    @Override
    public int add(Users users) {
        return dao.add(users);
    }

    @Override
    public int update(Users users) {
        return dao.update(users);
    }

    @Override
    public int del(int uid) {
        return dao.del(uid);
    }

    @Override
    public Users querybyid(int uid) {
        return dao.querybyid(uid);
    }
}
