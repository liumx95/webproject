package com.service.impl;

import com.dao.UserDao;
import com.dao.imple.UserDaoImpl;
import com.domain.AppUser;
import com.domain.SameUser;

public class UserServiceImpl implements UserService {
	 UserDao userDao=new UserDaoImpl();

	@Override
	public void register(AppUser user) throws Exception {
	userDao.addUser(user);
	}

	@Override
	public AppUser login(AppUser user) throws Exception {
			AppUser u=null;
			u=userDao.findUser(user);
			System.out.println(user);
			return u;
		}

	@Override
	public SameUser checkout(AppUser user) throws Exception {
		SameUser su=null;
		su=userDao.sameUser(user);
		return su;
	}
		
}



