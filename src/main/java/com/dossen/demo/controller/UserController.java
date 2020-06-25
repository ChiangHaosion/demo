package com.dossen.demo.controller;

import cn.hutool.core.util.RandomUtil;
import com.dossen.demo.domain.User;
import com.dossen.demo.mapper.UserMapper;
import com.dossen.demo.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

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


    @RequestMapping("insertToLarge")
    public Object insertLarge(){
        long start = System.currentTimeMillis();
        //给线程起名
        ThreadFactory threadFactory = r -> new Thread(r,"thread-name-"+r.hashCode());
        //自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(),threadFactory);
        //循环生成假数据
        for (int i = 0; i < 10000; i++) {
            User user = new User(RandomUtil.randomLong(10,1000),UUID.randomUUID().toString().substring(0,4),
                    UUID.randomUUID().toString().substring(0,4),"x");
            //丢到线程池里执行
            threadPoolExecutor.execute(()->{
                int x=userMapper.insertTodbb(user);
            });
        }
        //终止线程池
        threadPoolExecutor.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (end - start) + "ms");
        return "Ok";
    }
}
