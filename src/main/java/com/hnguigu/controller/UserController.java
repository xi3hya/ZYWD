package com.hnguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.hnguigu.service.UserService;
import com.hnguigu.vo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    //查所有
    @RequestMapping(value = "/queryAll.action", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryAll() {
        return JSONObject.toJSONString(service.queryAll());
    }

    //登录
    @RequestMapping("/login.action")
    @ResponseBody
    public boolean login(Users users, HttpSession session) {
        Users u=service.login(users);
        if (u!=null){
            session.setAttribute("user",u);
        }
        return u!=null;
    }

    //注册
    @RequestMapping("/register.action")
    @ResponseBody
    public boolean register(Users users) {
        int num=service.register(users);
        return num>0;
    }

    @RequestMapping(value = "/add.action",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String add(Users users){
        //方法的参数  直接给vo  前端传递的多个数据 自动填充到vo对象的属性中
        int num = service.add(users);
        if(num==1){
            return "添加成功";
        }
        return "添加失败";
    }

    //页面调用编辑方法  将页面数据传递进来 保存到db
    @RequestMapping(value = "/update.action",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String update(Users users){
        //方法的参数  直接给vo  前端传递的多个数据 自动填充到vo对象的属性中
        int num = service.update(users);
        if(num==1){
            return "修改成功";
        }
        return "修改失败";
    }

    //页面调用删除方法  将页面id传递进来 删除db数据
    @RequestMapping(value = "/del.action",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String del(int uid){
    //方法的参数  直接给vo  前端传递的多个数据 自动填充到vo对象的属性中
        int num = service.del(uid);
        if(num==1){
            return "删除成功";
        }
        return "删除失败";
    }

    @RequestMapping("/querybyid.action")
    @ResponseBody
    public Users querybyId(int uid){
        return service.querybyid(uid);
    }
}
