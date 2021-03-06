package com.antifraud.utils;

import com.alibaba.druid.stat.TableStat.Name;
import com.antifraud.entity.Log;
import com.antifraud.entity.User;
import com.antifraud.service.LogService;
import com.antifraud.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpSession;
/**
 * 
  * @ClassName: LogAspect
  * @description 日志Util
  * @author caoyaru
  * @createDate 2018年12月12日-上午9:35:02
 */
@Aspect
public class LogAspect {

	public Long id =null;

	@Autowired
	private LogService logService;
	@Autowired
	private UserService userService;

	/**
	 * 管理员登录方法的切入点
	 */
	@Pointcut("execution(* com.antifraud.controller.LoginController.loginUser(..))")
	public void loginCell() {
	}
	/**
	 * 管理员登录方法的切入点
	 *//*
	@Pointcut("execution(* com.antifraud.controller.LoginController.qdloginUser(..))")
	public void qdloginCell() {
	}*/
/*//	@Pointcut("execution(* com.antifraud.controller.*.qdloginUser(..))")
//	public void qbloginCell() {
//	}
*/
	/**
	 * 添加业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.antifraud.controller.*.add*(..))")
	public void insertCell() {
	}
	/**
	 * 添加业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.antifraud.controller.*.save*(..))")
	public void insertCellTwo() {
	}
	/**
	 * 添加业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.antifraud.controller.*.Result*(..))")
	public void ResultCell() {
	}
	/**
	 * 查询业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.antifraud.controller.*.select*(..))")
	public void SelectCell() {
	}
	/**
	 * 查询业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.antifraud.controller.*.find*(..))")
	public void FindCell() {
	}
	/**
	 * 修改业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.antifraud.controller.*.update*(..))")
	public void updateCell() {
	}

	/**
	 * 删除业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.antifraud.controller.*.delete*(..))")
	public void deleteCell() {
	}

	/**
	 * 导入业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.antifraud.controller.*.import*(..))")
	public void importCell() {
	}

	/**
	 * 导出业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.antifraud.controller.*.export*(..))")
	public void exportCell() {
	}
	
	/**
	 * 移动登录操作(后置通知)
	 * 
	 * @param joinPoint
	 * @param object
	 * @throws Throwable
	 *//*
	@AfterReturning(value = "qdloginCell()", argNames = "joinPoint,object", returning = "object")
	public void qdloginLog(JoinPoint joinPoint, Object object) throws Throwable {
		 //User user = (User)session.getAttribute("user");
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		if (user == null) {
			return;
		}
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}
		id = user.getId();
		//获取类名
	    String name = joinPoint.getTarget().getClass().getName();
	    name = name.substring(name.lastIndexOf(".")+1);
	   
		System.out.println("类名========》"+name);
		// 获取方法名
		String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);

		Log log = new Log();
		log.setContent(opContent);
		log.setAdminId(id.toString());
		log.setAdmin(user.getUser_name());
		log.setCreateDate(new Date());
		log.setOperation("登录");
		logService.saveLog(log);
	}*/
	/**
	 * 登录操作(后置通知)
	 * 
	 * @param joinPoint
	 * @param object
	 * @throws Throwable
	 */
	@AfterReturning(value = "loginCell()", argNames = "joinPoint,object", returning = "object")
	public void loginLog(JoinPoint joinPoint, Object object) throws Throwable {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		//System.out.println("session===========>"+session.getAttribute("user"));
		if (user == null) {
			return;
		}
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}
		id = user.getId();
		//获取类名
	    String name = joinPoint.getTarget().getClass().getName();
	    name = name.substring(name.lastIndexOf(".")+1);
		
		// 获取方法名
		String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);

		Log log = new Log();
		log.setContent(opContent);
		log.setAdminId(id.toString());
		log.setAdmin(user.getUser_name());
		log.setCreateDate(new Date());
		log.setOperation("登录");
		logService.saveLog(log);
	}
	/**
	 * 查看操作日志(后置通知)
	 *
	 * @param joinPoint
	 * @param object
	 */
	@AfterReturning(value = "FindCell()", argNames = "joinPoint,object", returning = "object")
	public void findtLog(JoinPoint joinPoint, Object object) throws Throwable {
		// Admin admin=(Admin)
		// request.getSession().getAttribute("businessAdmin");
		// 判断参数
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		//获取类名
	    String methodName = joinPoint.getTarget().getClass().getName();
	    methodName = methodName.substring(methodName.lastIndexOf(".")+1);
		// 获取方法名
		//String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);
		Log log = new Log();
		log.setContent(opContent);
		log.setAdminId(id.toString());
		log.setAdmin(userService.findUserById(id).getUser_name());
		log.setOperation("查询" + getMethodChineseName(methodName));
		log.setCreateDate(new Date());
		logService.saveLog(log);
	}
	/**
	 * 查看操作日志(后置通知)
	 *
	 * @param joinPoint
	 * @param object
	 */
	@AfterReturning(value = "SelectCell()", argNames = "joinPoint,object", returning = "object")
	public void selectLog(JoinPoint joinPoint, Object object) throws Throwable {
		// Admin admin=(Admin)
		// request.getSession().getAttribute("businessAdmin");
		// 判断参数
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		//获取类名
	    String methodName = joinPoint.getTarget().getClass().getName();
	    methodName = methodName.substring(methodName.lastIndexOf(".")+1);
		// 获取方法名
		//String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);

		Log log = new Log();
		log.setContent(opContent);
		log.setAdminId(id.toString());
		log.setAdmin(userService.findUserById(id).getUser_name());
		log.setOperation("查询" + getMethodChineseName(methodName));
		log.setCreateDate(new Date());
		logService.saveLog(log);
	}
	/**
	 * 添加操作日志(后置通知)
	 *
	 * @param joinPoint
	 * @param object
	 */
	@AfterReturning(value = "insertCell()", argNames = "joinPoint,object", returning = "object")
	public void insertLog(JoinPoint joinPoint, Object object) throws Throwable {
		// Admin admin=(Admin)
		// request.getSession().getAttribute("businessAdmin");
		// 判断参数
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		
		//获取类名
	    String methodName = joinPoint.getTarget().getClass().getName();
	    methodName = methodName.substring(methodName.lastIndexOf(".")+1);
		// 获取方法名
		//String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);

		Log log = new Log();
		log.setContent(opContent);
		log.setAdminId(id.toString());
		log.setAdmin(userService.findUserById(id).getUser_name());
		log.setOperation("添加" + getMethodChineseName(methodName));
		log.setCreateDate(new Date());
		logService.saveLog(log);
	}
	/**
	 * 添加操作日志(后置通知)
	 *
	 * @param joinPoint
	 * @param object
	 */
	@AfterReturning(value = "insertCellTwo()", argNames = "joinPoint,object", returning = "object")
	public void insertLogTwo(JoinPoint joinPoint, Object object) throws Throwable {
		// Admin admin=(Admin)
		// request.getSession().getAttribute("businessAdmin");
		// 判断参数
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}
		
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		//获取类名
	    String methodName = joinPoint.getTarget().getClass().getName();
	    methodName = methodName.substring(methodName.lastIndexOf(".")+1);
		// 获取方法名
		//String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);

		Log log = new Log();
		log.setContent(opContent);
		log.setAdminId(id.toString());
		log.setAdmin(userService.findUserById(id).getUser_name());
		log.setOperation("添加" + getMethodChineseName(methodName));
		log.setCreateDate(new Date());
		logService.saveLog(log);
	}

	/**
	 * 管理员修改操作日志(后置通知)
	 *
	 * @param joinPoint
	 * @param object
	 * @throws Throwable
	 */
	@AfterReturning(value = "updateCell()", argNames = "joinPoint,object", returning = "object")
	public void updateLog(JoinPoint joinPoint, Object object) throws Throwable {
		// Admin admin=(Admin)
		// request.getSession().getAttribute("businessAdmin");

		// 判断参数
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		//获取类名
	    String methodName = joinPoint.getTarget().getClass().getName();
	    methodName = methodName.substring(methodName.lastIndexOf(".")+1);
		// 获取方法名
		//String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);
		// 创建日志对象
		Log log = new Log();
		log.setContent(opContent);
		log.setAdminId(id.toString());
		log.setAdmin(userService.findUserById(id).getUser_name());
		log.setOperation("修改" + getMethodChineseName(methodName));// 操作
		log.setCreateDate(new Date());
		logService.saveLog(log);
	}

	/**
	 * 管理员导入操作日志(后置通知)
	 *
	 * @param joinPoint
	 * @param object
	 * @throws Throwable
	 */
	@AfterReturning(value = "importCell()", argNames = "joinPoint,object", returning = "object")
	public void importLog(JoinPoint joinPoint, Object object) throws Throwable {
		// Admin admin=(Admin)
		// request.getSession().getAttribute("businessAdmin");

		// 判断参数
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		//获取类名
	    String methodName = joinPoint.getTarget().getClass().getName();
	    methodName = methodName.substring(methodName.lastIndexOf(".")+1);
		// 获取方法名
		//String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);

		// 创建日志对象
		Log log = new Log();
		log.setContent(opContent);
		log.setAdminId(id.toString());
		log.setAdmin(userService.findUserById(id).getUser_name());
		log.setOperation("导入" + getMethodChineseName(methodName));// 操作
		log.setCreateDate(new Date());
		logService.saveLog(log);
	}

	/**
	 * 管理员导出操作日志(后置通知)
	 *
	 * @param joinPoint
	 * @param object
	 * @throws Throwable
	 */
	@AfterReturning(value = "exportCell()", argNames = "joinPoint,object", returning = "object")
	public void exportLog(JoinPoint joinPoint, Object object) throws Throwable {
		// Admin admin=(Admin)
		// request.getSession().getAttribute("businessAdmin");

		// 判断参数
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		//获取类名
	    String methodName = joinPoint.getTarget().getClass().getName();
	    methodName = methodName.substring(methodName.lastIndexOf(".")+1);
		// 获取方法名
		//String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);

		// 创建日志对象
		Log log = new Log();
		log.setContent(opContent);
		log.setAdminId(id.toString());
		log.setAdmin(userService.findUserById(id).getUser_name());
		log.setOperation("导出" + getMethodChineseName(methodName));// 操作
		log.setCreateDate(new Date());
		logService.saveLog(log);
	}
	/**
	 * 评估(后置通知)
	 *
	 * @param joinPoint
	 * @param object
	 * @throws Throwable
	 */
	@AfterReturning(value = "ResultCell()", argNames = "joinPoint,object", returning = "object")
	public void ResultLog(JoinPoint joinPoint, Object object) throws Throwable {
		// Admin admin=(Admin)
		// request.getSession().getAttribute("businessAdmin");

		// 判断参数
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		//获取类名
	    String methodName = joinPoint.getTarget().getClass().getName();
	    methodName = methodName.substring(methodName.lastIndexOf(".")+1);
		// 获取方法名
		//String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);

		// 创建日志对象
		Log log = new Log();
		log.setContent(opContent);
		log.setAdminId(id.toString());
		log.setAdmin(userService.findUserById(id).getUser_name());
		log.setOperation("评估" + getMethodChineseName(methodName));// 操作
		log.setCreateDate(new Date());
		logService.saveLog(log);
	}
	/**
	 * 删除操作
	 *
	 * @param joinPoint
	 * @param object
	 */
	@AfterReturning(value = "deleteCell()", argNames = "joinPoint,object", returning = "object")
	public void deleteLog(JoinPoint joinPoint, Object object) throws Throwable {
		// Admin admin=(Admin)
		// request.getSession().getAttribute("businessAdmin");
		// 判断参数
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		//获取类名
	    String methodName = joinPoint.getTarget().getClass().getName();
	    methodName = methodName.substring(methodName.lastIndexOf(".")+1);
		// 获取方法名
		//String methodName = joinPoint.getSignature().getName();

		StringBuffer rs = new StringBuffer();
		rs.append(methodName);
		String className = null;
		for (Object info : joinPoint.getArgs()) {
			// 获取对象类型
			className = info.getClass().getName();
			className = className.substring(className.lastIndexOf(".") + 1);
			rs.append("[参数，类型:" + className + ")");
		}
		/*+ "，值:(id:" + joinPoint.getArgs()[0] */
		rs.append("]");

		// 创建日志对象
		Log log = new Log();
		log.setContent(rs.toString());
		log.setAdminId(id.toString());
		log.setAdmin(userService.findUserById(id).getUser_name());
		log.setOperation("删除" + getMethodChineseName(methodName));// 操作
		log.setCreateDate(new Date());
		logService.saveLog(log);
	}

	/**
	 * 使用Java反射来获取被拦截方法(insert、update)的参数值， 将参数值拼接为操作内容
	 *
	 * @param args
	 * @param mName
	 * @return
	 */
	public String optionContent(Object[] args, String mName) {
		if (args == null) {
			return null;
		}
		StringBuffer rs = new StringBuffer();
		rs.append(mName);
		String className = null;
		int index = 1;
		// 遍历参数对象
		for (Object info : args) {
			// 获取对象类型
			if(className==null){
				continue;
			}
			className = info.getClass().getName();
			className = className.substring(className.lastIndexOf(".") + 1);
			rs.append("[参数" + index + "，类型:" + className + "，值:");
			// 获取对象的所有方法
			Method[] methods = info.getClass().getDeclaredMethods();
			// 遍历方法，判断get方法
			for (Method method : methods) {
				String methodName = method.getName();
				// 判断是不是get方法
				if (methodName.indexOf("get") == -1) {// 不是get方法
					continue;// 不处理
				}
				Object rsValue = null;
				try {
					// 调用get方法，获取返回值
					rsValue = method.invoke(info);
				} catch (Exception e) {
					continue;
				}
				// 将值加入内容中
				rs.append("(" + methodName + ":" + rsValue + ")");
			}
			rs.append("]");
			index++;
		}
		return rs.toString();
	}

	/**
	 * 判断操作的中文名（根据自己项目而定）
	 * 
	 * @param methodName
	 * @return
	 */
	public String getMethodChineseName(String methodName) {
		
		if (methodName.endsWith("CompactController")) {
			return "合同";
		} else if (methodName.endsWith("FiduciaryLoanController")) {
			return "信用贷款";
		} else if (methodName.endsWith("FileUpload")) {
			return "上传文件图片";
		} else if (methodName.endsWith("FklistController")) {
			return "上标";
		} else if (methodName.endsWith("HousePropertyMortgageController")) {
			return "房产抵押";
		} else if (methodName.endsWith("LinkfaceAntiFraudController")) {
			return "金融云 API";
		} else if (methodName.endsWith("LiquidateManageController")) {
			return "清收管理";
		} else if (methodName.endsWith("MovingTrackController")) {
			return "实地移动轨迹";
		} else if (methodName.endsWith("PhoPhotoController")) {
			return "根据报单编号上传图片";
		} else if (methodName.endsWith("PhotoUpload")) {
			return "图片上传";
		} else if (methodName.endsWith("PopedomController")) {
			return "权限管理控制器,用户权限相关文件";
		} else if (methodName.endsWith("PostLoanManageController")) {
			return "贷后管理表";
		} else if (methodName.endsWith("QuestionAnswerController")) {
			return "面审";
		} else if (methodName.endsWith("QuestionTopicController")) {
			return "面审随机出题";
		} else if (methodName.endsWith("RecordManageBorrowController")) {
			return "借阅管理";
		} else if (methodName.endsWith("RecordManageSaveController")) {
			return "档案管理";
		} else if (methodName.endsWith("ReplenishProcedureController")) {
			return "补充手续";
		} else if (methodName.endsWith("ReplenishProcedureImageController")) {
			return "补充手续图片";
		} else if (methodName.endsWith("SpotImageController")) {
			return "实地图片表";
		} else if (methodName.endsWith("SpotRecordController")) {
			return "实地记录";
		} else if (methodName.endsWith("UpLoadPhotoController")) {
			return "上传图片/批量上传";
		} else if (methodName.endsWith("UserController")) {
			return "用户管理";
		} else if (methodName.endsWith("VehicleMortgageController")) {
			return "车辆质押抵押";
		} else if (methodName.endsWith("PhotoController")){
			return "图片";
		} else {
			return "";
		}
	}

}
