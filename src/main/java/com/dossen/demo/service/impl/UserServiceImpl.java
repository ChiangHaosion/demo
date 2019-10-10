package com.dossen.demo.service.impl;

import com.dossen.demo.domain.User;
import com.dossen.demo.mapper.UserMapper;
import com.dossen.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User selectOne(Long id) {
        return userMapper.selectOne(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteOne(Long id) {
        return userMapper.delete(id);
    }

    @Override
    public int updateById(User user) {
        return userMapper.update(user);
    }
}
