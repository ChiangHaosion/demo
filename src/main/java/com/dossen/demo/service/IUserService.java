package com.dossen.demo.service;

import com.dossen.demo.domain.User;

import java.util.List;

public interface IUserService {
 
    /**
     * @MethodName: selectAll
     * @Description: 查询所有数据
     * @Param: []
     * @Return: java.util.List<com.dossen.demo.domain.User>
     * @Author: Haosion
     * @Date: 2019/10/10
    **/
    List<User> selectAll();

    /**
     * @MethodName: selectOne
     * @Description: 查询一个
     * @Param: [id]
     * @Return: com.dossen.demo.domain.User
     * @Author: Haosion
     * @Date: 2019/10/10
    **/
    User selectOne(Long id);

    /**
     * @MethodName: insert
     * @Description: 插入一条数据
     * @Param: [user]
     * @Return: int
     * @Author: Haosion
     * @Date: 2019/10/10
    **/
    int insert(User user);

    /**
     * @MethodName: deleteOne
     * @Description: 根据id删除一条用户
     * @Param: [id]
     * @Return: int
     * @Author: Haosion
     * @Date: 2019/10/10
    **/
    int deleteOne(Long id);

    int updateById(User id);
}
