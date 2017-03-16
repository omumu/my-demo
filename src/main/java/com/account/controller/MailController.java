package com.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.model.Mail;
import com.account.util.CommonUtil;
import com.account.util.EnumUtil;
import com.account.util.MailSender;
import com.account.util.StringUtil;
import com.alibaba.fastjson.JSONObject;
@Controller
@RequestMapping("/mail")
public class MailController {
	@Autowired
	private MailSender sender;
	private final static Logger logger=LoggerFactory.getLogger(MailController.class);
	@RequestMapping("sendMail")
	@ResponseBody
	public JSONObject sendMail(String toMail,String inputCode,HttpServletRequest request) {
		if(StringUtil.isempty(toMail)){
			return CommonUtil.constructResponse(EnumUtil.REQUERST_INVALID, "邮件地址为空", null);
		}
		if(StringUtil.isempty(inputCode)){
			return CommonUtil.constructResponse(EnumUtil.REQUERST_INVALID, "验证码为空", null);
		}
		if(!StringUtil.isEmail(toMail)){
			return CommonUtil.constructResponse(EnumUtil.REQUERST_INVALID, "邮箱格式不对", null);
		}
		HttpSession session =request.getSession();
		String code=(String)session.getAttribute("code");
		if(!inputCode.equals(code)){
			return CommonUtil.constructResponse(EnumUtil.REQUERST_INVALID, "验证码不正确", null);
		}
		session.removeAttribute("code");
		Mail mail=new Mail();
		mail.setTo(toMail);
		mail.setSubject("注册邮件");
		mail.setContentText("欢迎注册account！！！");
		try{
			sender.sendSimpleMail(mail);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("邮件发送失败:"+toMail,e);
			return CommonUtil.constructResponse(EnumUtil.SYSTEM_ERROR, "系统故障,发送失败", null);
		}
		return CommonUtil.constructResponse(EnumUtil.REQUERST_SUCCESS, "发送成功，请在邮件中查收，如果没有看见，请在垃圾箱查看。。。", null);
	}
}
