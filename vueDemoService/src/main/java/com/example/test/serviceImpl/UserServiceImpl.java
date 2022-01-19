package com.example.test.serviceImpl;

import com.example.test.bean.UserBean;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;

    //login
    @Override
    public UserBean loginIn(String name, String password) {
        return userMapper.getInfo(name, password);
    }

    //register
    @Override
    public int register(UserBean user) {
        return userMapper.insetUser(user);
    }

    //查询用户
    @Override
    public List<UserBean> findUsers() {
        return userMapper.findUsers();
    }
}
