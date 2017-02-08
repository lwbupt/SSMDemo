package com.ssmdemo.dao;

import com.ssmdemo.domain.Permission;
import com.ssmdemo.domain.Role;
import com.ssmdemo.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //自己添加的方法，用于测试shiro，start
    User findUserByName(String name);
    
    Role findRoleByName(String name);
    
    Permission findPermissionByName(String name);
    //自己添加的方法，用于测试shiro，end
}