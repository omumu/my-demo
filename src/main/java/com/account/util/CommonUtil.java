package com.account.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author Administrator
 *
 */
public class CommonUtil {
	/**
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	public static JSONObject constructResponse(int code, String msg, Object data) {
		JSONObject jb = new JSONObject();
		jb.put("code", code);
		jb.put("msg", msg);
		jb.put("data", data);
		return jb;
	}
}
