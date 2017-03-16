package com.account.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
@Repository("imageUtil")
public class ImageUtil {
	private final static int WIDTH = 250;
	private final static int HEIGHT = 100;

	public void drawRandomImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		setBackground(g);
		setBorder(g);
		drawRandomLine(g);
		String randomCode = drawRandomNum((Graphics2D) g);
		HttpSession session=request.getSession();
		session.setAttribute("code", randomCode);
		response.setContentType("image/jpeg");
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		ImageIO.write(bi, "jpg", response.getOutputStream());
	}

	private String drawRandomNum(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.setFont(new Font("微软雅黑", Font.BOLD, 25));
		return createRandomStr(g);
	}

	private String createRandomStr(Graphics2D g) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(4);
		for (int i = 0, x = 30; i < 4; i++) {
			Random random = new Random();
			Integer a = random.nextInt(10);
			sb.append(a.toString());
			int degree = random.nextInt() % 30;
			// 正向角度
			g.rotate(degree * Math.PI / 180, x, 60);
			g.drawString(a.toString(), x, 60);
			// 反向角度
			g.rotate(-degree * Math.PI / 180, x, 60);
			x += 60;
		}
		return sb.toString();
	}

	private void drawRandomLine(Graphics g) {
		// TODO Auto-generated method stub
		Random random = new Random();
		g.setColor(Color.GRAY);
		for (int i = 0; i < 20; i++) {
			g.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT), random.nextInt(WIDTH), random.nextInt(HEIGHT));
		}
	}

	private void setBorder(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
	}

	private void setBackground(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
}
