package com.account.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.account.util.ImageUtil;

@Controller
@RequestMapping("/image")
public class ImageController {
	@Resource
	private ImageUtil imageUtil;

	@RequestMapping("/randomCode")
	public void randomCode(HttpServletRequest request, HttpServletResponse response) {
		try {
			imageUtil.drawRandomImage(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
