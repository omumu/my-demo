package com.account.service;

import java.util.Map;

import com.account.model.Admin;

public interface AdminService {
	/**
	 * 
	 * @param admin
	 * @return
	 */
	Admin adminLogin  (Map admin);
}
