package com.service.impl;

import com.domain.AppUser;
import com.domain.SameUser;

public interface UserService {
	/**
	 * ÃÌº””√ªß
	 * @param user
	 * @throws Exception
	 */
	public SameUser checkout(AppUser user) throws Exception;
	public void register(AppUser user) throws Exception;
	public AppUser login(AppUser user) throws Exception;

}
