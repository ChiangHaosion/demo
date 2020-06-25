package com.dossen.demo.mapper;

import com.dossen.demo.domain.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    User selectOne(Long id);

    int insert(User user);

    int delete(Long id);

    int update(User user);

    int insertTodbb(User user);
}
