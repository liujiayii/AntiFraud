package com.antifraud.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class AuthCodeUtils {
	
	public static int[] authCode(){
		//设置图片宽度和高度
		int width1 = 150;
		int height = 60;
		//干扰线条数
		int lines = 10;
		//验证码数组
		int[] random = new int[4];
		
		Random r = new Random();
		BufferedImage b = new BufferedImage(width1,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = b.getGraphics();
		g.setFont(new Font("宋体",Font.BOLD,30));
		for(int i = 0;i<4;i++){
			int number = r.nextInt(10);
			
			random[i] = number;
			int y = 10 + r.nextInt(40);//10-40范围内的一个整数，作为y坐标
			//随机颜色 ，RGB模式
			Color c = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
			g.setColor(c);
			//写验证码
			g.drawString(Integer.toString(number), 5+i*width1/4, y);
			
		}
		for(int i =0;i<lines;i++){
			//设置干扰线颜色
			Color c = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
			g.setColor(c);
			g.drawLine(r.nextInt(width1), r.nextInt(height), r.nextInt(width1), r.nextInt(height));
		}
		try {
			//清空缓存
			g.dispose();
			//向文件中写入
			ImageIO.write(b, "jpg", new File("E:\\Img\\test.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i =0;i<random.length;i++){
			System.out.println(random[i]);
		}
		return random;
		
	}
	public static void main(String[] args) {
		authCode();
		System.out.println("已画完");
	}
}
