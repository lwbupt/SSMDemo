package com.ssmdemo.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssmdemo.dao.UserMapper;
import com.ssmdemo.domain.Permission;
import com.ssmdemo.domain.Role;
import com.ssmdemo.domain.User;
import com.ssmdemo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		User user = null;
		try{
			user = userMapper.findUserByName(name);
		}catch(Exception e){
			logger.error(e.getMessage());
			return null;
		}
		return user;
	}

	public Role findRoleByName(String name) {
		Role role = null;
		try{
			role = userMapper.findRoleByName(name);
		}catch(Exception e){
			logger.error(e.getMessage());
			return null;
		}
		return role;
	}

	public Permission findPermissionByName(String name) {
		Permission permission = null;
		try{
			permission = userMapper.findPermissionByName(name);
		}catch(Exception e){
			logger.error(e.getMessage());
			return null;
		}
		return permission;
	}
	
}
