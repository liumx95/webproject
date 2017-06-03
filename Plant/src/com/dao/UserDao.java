package com.dao;

import com.domain.AppUser;
import com.domain.SameUser;

public interface UserDao {
	/**
	 * ����û�
	 * @param user
	 * @throws Exception
	 */
	public void addUser(AppUser user) throws Exception;
	/**
	 * �����û�����������û���Ϣ
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public AppUser findUser(AppUser user)throws Exception;
	/**
	 * �����û��������Ƿ�����ͬ�û���
	 * 
	 */
	public SameUser sameUser(AppUser user)throws Exception;
	
	

}
