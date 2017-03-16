package com.account.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.model.Admin;
import com.account.service.AdminService;
import com.account.util.CommonUtil;
import com.account.util.EnumUtil;
import com.account.util.FormUtil;
import com.account.util.StringUtil;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	private static Logger log = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping("/login")
	@ResponseBody
	public JSONObject adminLogin(String adminName, String token, String adminPassword, HttpServletRequest request) {
		log.info("用户开始登陆:" + adminName);

		/**
		 * 防止表单重复提交
		 */
		if(FormUtil.isRepeatSubmit(request,"token","token")){
			return CommonUtil.constructResponse(EnumUtil.REQUERST_INVALID, "请不要重复提交表单", null);
		}
		request.getSession().removeAttribute("token");
		
		Admin admin = null;
		if (StringUtil.isempty(adminName)) {
			return CommonUtil.constructResponse(EnumUtil.REQUERST_INVALID, "用户名为空", null);
		}
		if (StringUtil.isempty(adminPassword)) {
			return CommonUtil.constructResponse(EnumUtil.REQUERST_INVALID, "密码为空", null);
		}
		Map<String, Object> adminInfo = new HashMap<String, Object>();
		adminInfo.put("adminName", adminName);
		adminInfo.put("adminPassword", adminPassword);
		try {
			admin = adminService.adminLogin(adminInfo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("登录出错", e);
			return CommonUtil.constructResponse(EnumUtil.SYSTEM_ERROR, "系统错误", null);
		}
		if (admin == null) {
			return CommonUtil.constructResponse(EnumUtil.REQUERST_INVALID, "用户名或者密码错误", null);
		}
		HttpSession session = request.getSession();
		session.setAttribute("admin", admin);
		return CommonUtil.constructResponse(EnumUtil.REQUERST_SUCCESS, "请求成功", admin.getAdminName());
	}

	@RequestMapping("/interceptor")
	public String interceptorTest() {
		return "interceptor/success";
	}
}
