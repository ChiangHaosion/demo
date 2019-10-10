package com.dossen.demo.controller;

import com.dossen.demo.domain.User;
import com.dossen.demo.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/listall")
    public Object listAll(){
        List<User> list=userService.selectAll();
        return list;
    }

    @RequestMapping("/listone")
    public Object listOne(Long id){
        User user=userService.selectOne(id);
        return user;
    }

    @RequestMapping("/add")
    public Object listInsert(User user){
        User tUser=new User();
        BeanUtils.copyProperties(user,tUser);
        int i=userService.insert(user);
        if (i>0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }

    @RequestMapping("/addone")
    public Object addOne(@RequestBody User user){
        int i = userService.insert(user);
        if (i>0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }

    @RequestMapping("/delete")
    public Object listDelete(@RequestBody Long id){
        int c=userService.deleteOne(id);
        if (c>0){
            return "delete success";
        }else {
            return "delete failed";
        }
    }

    @RequestMapping("update")
    public Object listUpdate(@RequestBody User user){
        int c=userService.updateById(user);
        if (c>0){
            return "update success";
        }else {
            return "update failed";
        }
    }
}
