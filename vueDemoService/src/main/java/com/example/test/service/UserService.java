package com.example.test.service;

import com.example.test.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface UserService {
//login
  UserBean loginIn(String name, String password);
//register
  int register(UserBean user);
//find users
 List<UserBean> findUsers();
}
