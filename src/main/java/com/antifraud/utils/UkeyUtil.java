package com.antifraud.utils;

import java.util.Random;

/**
 * U盾设置工具类
 *
 * @ClassName: UkeyUtil

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月18日-下午2:22:18
 */
public class UkeyUtil {

	/**
	 * 生成增强算法密钥
	 *
	 * @Title: toUkeySet
	
	 * @description 
	 *
	 * @param ukeySn U盾编号
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-下午2:23:42
	 */
	public static String toUkeySet() {
		
		Random random = new Random();

		String[] numArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String[] strArr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}; 
		
		//生成增强算法密钥
		StringBuffer calKey = new StringBuffer();
		for (int i = 0; i < 32; i++) {
			int ran = random.nextInt(2);
			
			if (ran == 0) {
				calKey.append(numArr[random.nextInt(10)]);
			} 
			if (ran == 1) {
				calKey.append(strArr[random.nextInt(26)]);
			}
		}
		
		String cKey = calKey.toString().toUpperCase();
		
		return cKey;
	}
}
