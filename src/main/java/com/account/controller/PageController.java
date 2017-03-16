package com.account.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.account.util.TokenProccessor;

/**
 * 配置路由
 * 
 * @author Administrator
 *
 */
@Controller
public class PageController {
	@RequestMapping("/")
	public String rootPage(HttpSession session) {
		TokenProccessor token = TokenProccessor.getInstance();
		session.setAttribute("token", token.makeToken());
		return "index";
	}
}
