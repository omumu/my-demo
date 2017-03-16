package com.account.dao;

import java.util.Map;

import com.account.model.Admin;

public interface AdminDao {
	/**
	 * ����Ա��¼
	 * @param admin
	 * @return
	 */
	Admin adminLogin(Map admin);
}
