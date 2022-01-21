package com.example.test.mapper;

import com.example.test.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface UserMapper {

    UserBean getInfo(String name, String password);

    //  @Insert("insert into user values(#{id},#{name},#{password})")
//  @Insert("insert into user values(#{name},#{password})")
//  //加入该注解可以保存对象后，查看对象插入id
//  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insetUser(UserBean user);

    //查询全部用户
    List<UserBean> findUsers();

    //分页查询用户
    List<UserBean> selectPage();
}
