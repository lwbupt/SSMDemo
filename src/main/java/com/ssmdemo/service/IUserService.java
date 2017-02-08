/**
 * 
 */
package com.ssmdemo.service;

import com.ssmdemo.domain.Permission;
import com.ssmdemo.domain.Role;
import com.ssmdemo.domain.User;

/**
 * @author Administrator
 *
 */
public interface IUserService {
	
	User findUserByName(String name);
    
    Role findRoleByName(String name);
    
    Permission findPermissionByName(String name);
}
