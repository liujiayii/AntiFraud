package com.antifraud.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 *
 * @ClassName: DateUtil
 * @description 获取日期格式的工具类
 * @author qixiyao
 * @createDate 2018年10月24日-下午1:34:07
 */
public class DateUtil {

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
			"yyyyMMdd");

	/**
	 * 
	 * @Title: getTime
	 * @description 日期工具类（返回YYYY-MM-DD HH:mm:ss格式）
	 * @param @return  
	 * @return String    
	 * @author qixiyao
	 * @createDate 2018年10月24日-下午1:33:32
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}
	
	/**
	 * 
	 * @Title: getDays
	 * @description 日期工具类（返回yyyyMMdd格式）
	 * @param @return  
	 * @return String    
	 * @author qixiyao
	 * @createDate 2018年10月24日-下午1:32:42
	 */
	public static String getDays() {
		return sdfDay.format(new Date());
	}
}
