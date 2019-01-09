package com.antifraud.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class AuthCode {
	
	public static StringBuffer authCode(){
		int width = 150;  //宽
		int height = 60;  //高
		int codeCount = 4; //产生随机的数量
		int x = 0;          //
		int fontHeight;    //字体高度
		int codeY;        
		//随机产生的字符
		char[] codeSequence ={    
           '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		//显示是x轴的位置
		x = width/(codeCount+1);
		//显示字体的高度
		fontHeight = height-2;
		//y轴的位置
		codeY = height-4;
		BufferedImage buffImg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = buffImg.createGraphics();
		//创建一个随机数生成器
		Random r = new Random();
		Color c = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
		g.setColor(c);
		g.fillRect(0, 0, width, height);
		//创建字体，字体的大小由图片的高度来定
		Font font = new Font("Fixedsys",Font.PLAIN,fontHeight);
		//设置字体
		g.setFont(font);
		//随即产生160条干扰线，使图像中的认证码不易被其它程序探测到
		int lines = 10;
		for(int i =0;i<lines;i++){
			//设置干扰线颜色
			Color c1 = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
			g.setColor(c1);
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
		
		//randomCode 用于保存随机产生的验证码，以使用户登录后进行验证
		StringBuffer randomCode = new StringBuffer();
		int red = 0,green=0,blue=0;
		//随机产生codeCount数字的验证码
		for(int i =0;i<codeCount;i++){
			String strRnd = String.valueOf(codeSequence[r.nextInt(10)]);
			//产生随机的颜色分量来构造颜色值。这样输出的每位数字的颜色值都将不同
			red = r.nextInt(255);
			green = r.nextInt(255);
			blue = r.nextInt(255);
			//用随机产生的颜色将验证码绘制到图像中
			g.setColor(new Color(red,green,blue));
			g.drawString(strRnd, (i+1)*x, codeY);
			//将产生的四个随机数组合到一起
			randomCode.append(strRnd);
		}
		System.out.println(randomCode.toString());
		try {
			//清空缓存
			g.dispose();
			//向文件中写入
			ImageIO.write(buffImg, "jpg", new File("img\test.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return randomCode;
		
	}
	public static void main(String[] args) {
		authCode();
		System.out.println("已画完");
	}
	
}
