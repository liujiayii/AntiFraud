package com.antifraud.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultInfo {
	/** 公共错误码-99:数据库错误 */
	public static final int ERROR_SQL = -99;
	
	/** 公共错误码-404:未找到资源() */
	public static final int ERROR_404 = -404;
	
	/** 公共错误码-500:程序错误 */
	public static final int ERROR_500 = -500;
	
	
	/** 特殊业务标识-1314:数据未更新 */
	public static final int NOT_UPDATE = -1314;
	
	/** 特殊业务标识-1315:某业务已经成功执行 */
	public static final int ALREADY_RUN = -1315;
	
	/** 特殊业务标识-1316:超额投标 */
	public static final int OVER_BID_AMOUNT = -1316;
	
	
	/** 拦截标识-100:没有登录 */
	public static final int NOT_LOGIN = -100;
	
	/** 拦截标识-101:没有权限 */
	public static final int NOT_RIGHT = -101;
	
	/** 拦截标识-102:未开通资金托管账户 */
	public static final int NOT_PAYMENT_ACCOUNT = -102;
	
	/** 拦截标识-103:未实名认证 */
	public static final int NOT_REAL_NAME = -103;
	
	/** 没有绑定银行卡 */
	public static final int NOT_BIND_BANKCARD = -104;  

	/** 登录超时*/
	public static final int  LOGIN_TIME_OUT = -105; 
	
	/** 模拟登录*/
	public static final int  SIMULATED_LOGIN = -106; 
	
	/** 登录超时提醒语*/
	public static final String LOGIN_TIME_OUT_MSG = "登录超时，请重新登录";
	
	/** 未设置交易密码*/
	public static final int  SET_PASSWORD = -107; 
	
	/** 未找到用户信息*/
	public static final int  NO_INFORMATION = -108; 
	
	/** 企业用户提现暂不支持*/
	public static final int  NONSUPPORT = -109; 
	
	
	/** 
	 * 消息码。
	 * 默认：code = 0
	 * 成功：code > 0
	 * 失败：code < 1
	 */
	public int code = 0;
	
	
	/** 提示信息 */
	public String msg = "亲，系统繁忙！";
	
	/** 数据*/
	public Map<String,String> msgs=new HashMap<String,String>();
	
	/** 结果集中的对象 */
	public Object obj;
	
	/**结果集中的对象集合*/
	public List<Object> objs=new ArrayList<Object>();

	@Override
	public String toString() {
		return "ResultInfo [code=" + code + ", msg=" + msg + ", object="
				+ obj + "]";
	}
}
