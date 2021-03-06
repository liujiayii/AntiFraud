package com.antifraud.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.antifraud.entity.Ukey;
import com.antifraud.entity.User;
import com.antifraud.service.PopedomService;
import com.antifraud.service.UkeyService;
import com.antifraud.service.UserService;
import com.antifraud.utils.DesUtil;
import com.antifraud.utils.MD5Encrypt;
import com.antifraud.utils.ResultInfo;
import com.softkey.SoftKey;
import com.softkey.jsyunew3;

/**
 * @ClassName: LoginController
 * @description 登录控制器中
 * @author LiuHangjing
 * @createDate 2018年9月26日下午5:29:03
 */
@Controller
public class LoginController {

	private final Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	UserService userService;
	
	@Autowired
	UkeyService ukeyService;

	@Autowired
	private PopedomService popedomService; // 权限的Service
	/** 随机数 */
	private String rnd;
	/** 测试环境下启用普通登录常量（1为U盾登录，0为普通登录） */
	private final String ISIN = "0";

	/**
	 * 
	 * @Title: toLogin
	 * @description 跳转到登录页面
	 *
	 * @return ModelAndView
	 * @author LiuHangjing
	 * @createDate 2018年9月27日 下午6:05:23
	 */
	@RequestMapping("/toLogin")
	public ModelAndView toLogin(HttpServletRequest request) {	
		
		/** 生成随机数 */
		int number_1 = (int) (Math.random() * 65535) + 1;
		int number_2 = (int) (Math.random() * 65535) + 1;
		String s_rnd = (new Integer(number_1)).toString() + (new Integer(number_2)).toString();
		/** 将生成的随机数赋值给成员变量 */
		rnd = s_rnd;
		ModelAndView mv = new ModelAndView();
		mv.addObject("isCheck", ISIN);
		mv.addObject("rnd", s_rnd);
		mv.setViewName("riskManagement/login/login");
		return mv;
	}

	/**
	 * 
	 * @Title: loginUser
	 * @description 登录方法
	 * @param @param
	 *            username 账号
	 * @param @param
	 *            password 密码
	 * @param @param
	 *            session session
	 * @param @return
	 * @return Map<String,Object> 返回状态码
	 * @author caoyaru
	 * @createDate 2018年11月25日-下午3:50:21
	 */
	@RequestMapping("/qdloginUser")
	@ResponseBody
	public Map<String, Object> qdloginUser(String _a, String _s, String _t, HttpSession session) {
		int code = 0;
		int img = 0;
		String msg = null;
		Map<String, Object> map = new HashMap<>();
		String key = "yunqueadmin";
		// 获取主体
		Subject subject = SecurityUtils.getSubject();
		try {
			String str = DesUtil.getrechargeMember(_a, _t);
			if (str != "") {
				String md5 = MD5Encrypt.MD5Encode(str);
				if (md5.equals(_s)) {
					Map<String, String> data = DesUtil.map(str);
					String passw = data.get("password");
					String usern = data.get("username");
					// 用户名和密码信息
					String newpassword = MD5Encrypt.MD5Encode(passw);
					String pwd = DesUtil.encode(key, newpassword);
					AuthenticationToken token = new UsernamePasswordToken(usern, pwd);
					// 获取用户
					User user = userService.findUserByname(usern);

					// 登录成功
					subject.login(token);
					// User user = userService.findUserByUserName(username);
					// 获取登录用户
					// User user =
					// (User)SecurityUtils.getSubject().getPrincipal();
					if ( user.getImg_url() == null||  user.getImg_url().equals("")) {
						// 查询数据库没有图片
						img = 0;
						map.put("img", img);
					} else {
						// 查询数据库有图片
						img = 1;
						msg = "有图片";
						map.put("img", img);
					}
					code = 1;
					msg = "登录成功";
					map.put("code", code);
					map.put("msg", msg);
					map.put("data", user);
					map.put("status", user.getStatus());
					session.setAttribute("user", user);

				} else {
					map.put("code", -1);
					map.put("msg", "签名错误，您的访问数据非法");

				}
			} else {
				map.put("code", -1);
				map.put("msg", "网络超时您的网络不行");
			}
		} catch (AuthenticationException ex) {
			code = -1;
			msg = "登录失败:用户名或密码错误";
			map.put("code", code);
			map.put("msg", msg);
			// map.put("status", user.getStatus());
		} catch (Exception e) {
			code = -1;
			msg = "系统异常";
			map.put("code", code);
			map.put("msg", msg);
		}
		return map;

	}

	/**
	 * 
	 * @Title: loginUser
	 * @description 登录方法
	 * @param @param
	 *            username 账号
	 * @param @param
	 *            password 密码
	 * @param @param
	 *            session session
	 * @param @return
	 * @return Map<String,Object> 返回状态码
	 * @author caoyaru
	 * @createDate 2018年11月25日-下午3:50:21
	 */
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loginUser(String username, String password, HttpSession session, HttpServletRequest req,
			HttpServletResponse resp) {
		
		Map<String, Object> map = new HashMap<>();
		String key = "yunqueadmin";
		/** 加密狗身份认证 */
		// 获取加密锁id
		String KeyID = req.getParameter("KeyID");
		// 获取前端对随机数加密后的结果
		String return_EncData = req.getParameter("return_EncData");
		// 判断是否是U盾登录
		if (!StringUtils.isEmpty(KeyID)) {
			Ukey ukey = null;
			String m_StrEnc = "";
			try {
				ukey = ukeyService.selectByUserName(username);
				if (ukey.getUkey_stat() == 1) {
					map.put("code", 1);
					map.put("msg", "当前U盾被锁定，无法登录");
					return map;
				}
			} catch (NullPointerException npe) {
				npe.printStackTrace();
				map.put("code", 1);
				map.put("msg", "请添加U盾");
				
				return map;
			} catch (Exception e) {
				e.printStackTrace();
				map.put("code", -1);
				map.put("msg", "系统异常");
				
				return map;
			}
			//判断增强密钥是否为空
			if (ukey.getUkey_ckey() == null) {
				map.put("code", 1);
				map.put("msg", "请设置增强密钥后登录");
			} else {
				// 对服务器端生成的随机数进行加密运算
				m_StrEnc = new SoftKey().StrEnc(rnd, ukey.getUkey_ckey());
			}

			if (m_StrEnc.trim().equals(return_EncData.trim())) {
				map = checkLogin(key, username, password, map, session);
			} else {
				logger.info("该用户不是合法用户");
				map.put("code", -1);
				map.put("msg", "该用户不是合法用户");
			}

		} else {
			map = checkLogin(key, username, password, map, session);
		}

		return map;

	}

	/**
	 * 
	 * @Title: logout
	 * @description 登陆退出功能
	 * @param @param
	 *            redirectAttributes
	 * @param @return
	 * @return String
	 * @author caoyaru
	 * @createDate 2018年11月6日-下午2:58:12
	 */
	@RequestMapping("logout")
	public String logout(RedirectAttributes redirectAttributes, HttpSession session) {
		// 使用权限管理工具进行用户的退出，跳出登录，给出提示信息

		Subject subject = SecurityUtils.getSubject();

		if (subject.isAuthenticated()) {
			session.removeAttribute("user");
			subject.logout();
		}
		return "redirect:toLogin.action";
	}

	@RequestMapping("/loginTwo")
	@ResponseBody
	public ResultInfo loginTwo(HttpSession session, User user, HttpServletRequest request) throws Exception {
		ResultInfo result = new ResultInfo();
		// 前端输入的值
		String auth_code = request.getParameter("auth_code").toString();

		// 验证码获取的结果值
		String resultNum = (String) session.getAttribute("results").toString();

		if (user != null) {
			if (resultNum.equals(auth_code)) {
				result.code = 0;
				result.msg = "正确";
			} else {
				result.code = -1;
				result.msg = "错误";
			}
		}
		return result;

	}

	/**
	 * 后台画验证码 ，前端页面显示，并计算结果
	 * 
	 * @param session
	 *            把计算结果result存到session中
	 * @param resp
	 */
	@RequestMapping(value = "/showAuthCode")
	public void showAuthCode(HttpSession session, HttpServletResponse resp, Model model) {

		int width = 150; // 宽
		int height = 60; // 高
		int codeCount = 4; // 产生随机的数量
		int x = 0; //
		int fontHeight; // 字体高度
		int codeY;
		// 随机产生的字符
		char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char[] codenumber = { '+', '-' };

		// 显示是x轴的位置
		x = width / (codeCount + 1);
		// 显示字体的高度
		fontHeight = height - 2;
		// y轴的位置
		codeY = height - 4;
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = buffImg.createGraphics();
		// 创建一个随机数生成器
		Random r = new Random();
		Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		g.setColor(c);
		g.fillRect(0, 0, width, height);
		// 创建字体，字体的大小由图片的高度来定
		Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
		// 设置字体
		g.setFont(font);
		// 随即产生160条干扰线，使图像中的认证码不易被其它程序探测到
		int lines = 10;
		for (int i = 0; i < lines; i++) {
			// 设置干扰线颜色
			Color c1 = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			g.setColor(c1);
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}

		// randomCode 用于保存随机产生的验证码，以使用户登录后进行验证
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		// 随机产生codeCount数字的验证码
		// 前一个数字
		String strRnd = String.valueOf(codeSequence[r.nextInt(10)]);
		// 中间的符号
		String s = String.valueOf(codenumber[r.nextInt(2)]);
		// 后面的数字
		String strRndlast = String.valueOf(codeSequence[r.nextInt(10)]);

		String coderesult = "=";
		String strRndwhy = "?";
		if (Integer.parseInt(strRnd) < Integer.parseInt(strRndlast)) {
			String a = strRndlast;
			strRndlast = strRnd;
			strRnd = a;
		}
		// 产生随机的颜色分量来构造颜色值。这样输出的每位数字的颜色值都将不同
		red = r.nextInt(255);
		green = r.nextInt(255);
		blue = r.nextInt(255);
		// 用随机产生的颜色将验证码绘制到图像中
		g.setColor(new Color(red, green, blue));
		g.drawString(strRnd, 1 * x / 3, codeY);
		g.drawString(s, 1 * x + 1, codeY);
		g.drawString(strRndlast, 2 * x, codeY);
		g.drawString(coderesult, 3 * x, codeY);
		g.drawString(strRndwhy, 4 * x, codeY);
		// 将产生的四个随机数组合到一起
		randomCode.append(strRnd);
		randomCode.append(s);
		randomCode.append(strRndlast);

		int start = Integer.parseInt(randomCode.substring(0, 1));
		String cen = randomCode.substring(1, 2);
		int end = Integer.parseInt(randomCode.substring(2, 3));
		int result = 0;
		if (cen.equals("-")) {
			result = start - end;

		} else if (cen.equals("+")) {
			result = start + end;
		}
		// 不需要计算的
		randomCode.append(coderesult);
		randomCode.append(strRndwhy);

		session.setAttribute("validateCode", randomCode.toString());
		session.setAttribute("results", result);
		model.addAttribute("results", result);
		ServletOutputStream sos;
		try {
			sos = resp.getOutputStream();
			ImageIO.write(buffImg, "jpg", sos);
			sos.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	/**
	 * 检查用户登录是否合法
	 *
	 * @Title: checkLogin
	
	 * @description 
	 *
	 * @param key
	 * @param username
	 * @param password
	 * @param map
	 * @param session 	   
	 * void 
	 *
	 * @author lujinpeng
	 * @createDate 2018年12月26日-上午10:06:35
	 */
	private Map<String, Object> checkLogin(String key, String username, String password, Map<String, Object> map, HttpSession session) {
		int code =0;
		int img = 0;
		String msg = "";
		
		// 获取主体
		Subject subject = SecurityUtils.getSubject();
		// 用户名和密码信息
		String newpassword = MD5Encrypt.MD5Encode(password);
		String pwd = DesUtil.encode(key, newpassword);
		AuthenticationToken token = new UsernamePasswordToken(username, pwd);
		// 获取用户
		User user = userService.findUserByname(username);
		try {
			
			// 登录成功
			subject.login(token);
			if (user.getImg_url()==null ||user.getImg_url().equals("")) {
				// 查询数据库没有图片
				img = 0;
				map.put("img", img);
			} else {
				// 查询数据库有图片
				img = 1;
				msg = "有图片";
				map.put("img", img);
			}
			code = 1;
			msg = "登录成功";
			map.put("code", code);
			map.put("msg", msg);
			map.put("status", user.getStatus());
			session.setAttribute("user", user);
			session.setAttribute("user_id",user.getId());
			
		} catch (AuthenticationException ex) {
			code = -1;
			msg = "用户名或密码错误";
			map.put("code", code);
			map.put("msg", msg);			
			
		}
		
		return map;
	}
	
}
