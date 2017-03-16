package com.account.util;

import java.security.MessageDigest;
import java.util.Random;

/**
 * 生成token的类（用户防止表单重复提交或者验证用户的权限等）
 * @author Administrator
 *
 */
public class TokenProccessor {
	/**
	 * 单例设计模式
	 */
	private TokenProccessor() {
	}

	private static final TokenProccessor instance = new TokenProccessor();

	/**
	 * 返回对象
	 * 
	 * @return
	 */
	public static TokenProccessor getInstance() {
		return instance;
	}

	public String makeToken() {
		String token = (System.currentTimeMillis() + new Random().nextInt(999999999) + "");
		StringBuffer sb = new StringBuffer(32);
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte md5[] = messageDigest.digest(token.getBytes());

			for (int i = 0; i < md5.length; i++) {
				int a = ((int) md5[i]) & 0xff;
				if (a < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(a));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return sb.toString();
	}
}
