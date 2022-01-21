package com.example.test.serviceImpl;

import com.example.util.PageResult;
import com.example.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.example.test.bean.UserBean;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import com.example.util.PageRequest;
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


    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     *
     * @param
     * @return
     */
    private PageInfo<UserBean> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<UserBean> sysMenus = userMapper.selectPage();
        return new PageInfo<UserBean>(sysMenus);
    }
}
