package com.account.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String 的工具类
 * @author Administrator
 *
 */
public class StringUtil {
	/**
	 * 一个String的工具类
	 * @param str
	 * @return
	 */
	public static boolean isempty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
	public static boolean isEmail(String email){
		try{
			String check="^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern pattern = Pattern.compile(check);
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
