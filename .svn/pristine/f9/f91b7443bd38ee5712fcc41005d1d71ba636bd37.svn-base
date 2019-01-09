package com.antifraud.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.antifraud.service.BusFeedbackTimerService;
import com.antifraud.service.impl.BusFeedbackTimerServiceImpl;
/**
 * 定时执行任务
 *
 * @ClassName: TimerTaskUtil
 * @description 
 *
 * @author lujinpeng
 * @createDate 2018年10月25日-上午10:29:53
 */
public class TimerTaskUtil implements ServletContextListener {

	private final static Logger logger = Logger.getLogger(TimerTaskUtil.class);
	/*@Autowired
	private BusFeedbackTimerService busFeedbackTimerService;*/
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("定时信息监听--已关闭！");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		final BusFeedbackTimerServiceImpl btsi = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(BusFeedbackTimerServiceImpl.class);
		
		// 指定的任务，从指定的延迟后，开始进行重复执行。
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		/**
		 *  定制每天的8:00:00执行，若程序已超过8点启动,当天不再执行，等到明日八点再执行
		 *  这样保证了时间一直是8点，而不会变成程序启动时间
		 */
		calendar.set(year, month, day, 8, 00, 00);
		Date defaultdate = calendar.getTime();// 今天8点（默认发送时间）
		Date sendDate = new Date();
		// 8点后开机
		if (defaultdate.before(new Date())) {
			// 将发送时间设为明天8点
			calendar.add(Calendar.DATE, 1);
			sendDate = calendar.getTime();
		}
		
		/**
		 * ----------------每刻任务 ----------------
		 * 启动服务器后，若此时时间没过8点，等待。到了8点自动执行一次，15分钟后再执行一次，周而复始
		 * 启动服务器后，若此时时间超过8点，会立刻执行一次，等到15分钟后再次执行一次，周而复始
		 * 到了第二天，不会再判断是否是8点，这个开始时间，只会判断一次而已
		 */
		Timer qTimer = new Timer();
		qTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				logger.info("每刻任务已执行");
				btsi.updateFiduciaryLoanStatus();
				btsi.updateHousePropertyMortgage();
				//btsi.updateVehicleMortgage();
			}
		}, defaultdate, 1 * 60 * 1000);// 定时每15分钟
		logger.debug("每刻定时发送Xml信息监听--已启动！");
 
		/**
		 * ----------------每日任务 ----------------
		 * 启动服务器后，若此时时间没过8点，等待。到了8点自动执行一次，24小时后（第二天8点）再执行一次，周而复始
		 * 启动服务器后，若此时时间已经超过8点，会立刻执行一次，等到24小时后（第二天8点）再次执行一次，周而复始
		 */
		Timer dTimer = new Timer();
		dTimer.schedule(new TimerTask() {
 
			@Override
			public void run() {
				logger.info("每日任务已经执行");
				/** 更新信贷报单时间超时状态值 */
				//busFeedbackTimerService.updateFiduciaryLoanStatus();
				/** 更新房产抵押报单时间超时状态值 */
				//busFeedbackTimerService.updateHousePropertyMortgage();
				/** 更新车辆抵押报单时间超时状态值 */
				//busFeedbackTimerService.updateVehicleMortgage();
			}
		}, sendDate, 24 * 60 * 60 * 1000);// 定时24小时：24 * 60 * 60 * 1000
		logger.debug("每日定时发送Xml信息监听--已启动！");
 
		/**
		 * ----------------每月任务 ----------------
		 * 启动服务器后，若此时时间没过8点，等待。到了8点自动执行判断是否是当前月份的1号，若是则执行一次，
		 * 24小时后（第二天8点）再执行一次判断（每月1号以后后的29天或30天后才会是下月1号，再执行一次），周而复始
		 * 启动服务器后，若此时时间已经超过8点，会立刻执行一次，等到下个月1号再次执行一次，周而复始
		 */
		Timer mTimer = new Timer();
		mTimer.schedule(new TimerTask() {
 
			@Override
			public void run() {
				Calendar c = Calendar.getInstance();
				int day = c.get(Calendar.DAY_OF_MONTH);
				logger.info("月任务 判断中");
				if (day == 1) {
					// 每天执行，若为每月1号才执行
					logger.info("月任务执行已执行");
					
				}
 
			}
		}, sendDate, 24 * 60 * 60 * 1000);// 每天执行一次检查
 
		logger.debug("每月定时发送Xml信息监听--已启动！");
		
	}

}
