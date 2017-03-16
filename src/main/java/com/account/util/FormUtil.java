package com.account.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FormUtil {
	public static boolean isRepeatSubmit(HttpServletRequest request,String sessionTokenAttributeName,String requestTokenAttributeName) {
		String client_token = request.getParameter(requestTokenAttributeName);
		String server_token = (String) request.getSession().getAttribute(sessionTokenAttributeName);
		if (client_token == null) {
			return true;
		}
		if (server_token == null) {
			return true;
		}
		if (!server_token.equals(client_token)) {
			return true;
		}
		return false;
	}
}
