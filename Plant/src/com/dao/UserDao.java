package com.dao;

import com.domain.AppUser;
import com.domain.SameUser;

public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void addUser(AppUser user) throws Exception;
	/**
	 * 根据用户名密码查找用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public AppUser findUser(AppUser user)throws Exception;
	/**
	 * 根据用户名查找是否有相同用户名
	 * 
	 */
	public SameUser sameUser(AppUser user)throws Exception;
	
	

}
