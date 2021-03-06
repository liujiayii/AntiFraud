package com.antifraud.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.antifraud.entity.User;
import com.antifraud.service.PopedomRoleService;
import com.antifraud.service.PopedomService;
import com.antifraud.service.UserService;
import com.antifraud.utils.JsonUtil;
import com.antifraud.utils.ResultInfo;
import com.antifraud.utils.UpdateFile;

import net.sf.json.JSONObject;

/**
 * @ClassName: UserController
 * @description 用户管理
 * @author ZhaoSong
 * @createDate 2018年11月1日
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PopedomService popedomService;

	public static final String api_id = "2649ae6ac9044fb3987ee5279e36ca3b";
	public static final String api_secret = "d56afc378a214547843dc38d42423223";
	// 这个从数据库获取
	// public static final String filepath1="F:/imgs/admin.png";//图片1路径
	// 这个是移动端传过来的图片
	// public static final String filepathtwo="F:/imgs/hmm.png";//图片2路径
	public static final String POST_URL = "https://cloudapi.linkface.cn/identity/historical_selfie_verification";

	/**
	 * 
	 * @Title: HttpClientPost
	 * @description 人脸识别
	 * @param @param
	 *            userid
	 * @param @param
	 *            filepathtwo
	 * @param @return
	 * @param @throws
	 *            ClientProtocolException
	 * @param @throws
	 *            IOException
	 * @return Map
	 * @author caoyaru
	 * @createDate 2018年11月12日-下午2:01:52
	 */
	@ResponseBody
	@RequestMapping(value = "/HttpClientPost", produces = "application/json; charset=utf-8")
	public Map HttpClientPost(Long userid, MultipartFile filepathtwo) throws ClientProtocolException, IOException {
		int code = 0;
		String msg = null;
		Map map = new HashMap<>();
		File file = null;
		CommonsMultipartFile cf = (CommonsMultipartFile) filepathtwo;
		DiskFileItem fi = (DiskFileItem) cf.getFileItem();

		File f = fi.getStoreLocation();
		try {
			// 根据用户ID查询图片地址
			String filepathone = userService.findaddressById(userid);
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost post = new HttpPost(POST_URL);
			// 账户
			StringBody id = new StringBody(api_id);
			// 密钥
			StringBody secret = new StringBody(api_secret);
			// 第一张图片
			StringBody stringBody = new StringBody(filepathone);
			// 第二张图片
			FileBody fileBodytwo = new FileBody(f);
			MultipartEntity entity = new MultipartEntity();
			entity.addPart("selfie_url", stringBody);
			entity.addPart("historical_selfie_file", fileBodytwo);
			entity.addPart("api_id", id);
			entity.addPart("api_secret", secret);
			post.setEntity(entity);

			HttpResponse response = httpclient.execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entitys = response.getEntity();
				BufferedReader reader = new BufferedReader(new InputStreamReader(entitys.getContent()));
				String line = reader.readLine();
				JSONObject json_test = JSONObject.fromObject(line);
				String status = json_test.getString("status");
				String confidence = json_test.getString("confidence");
				code = 1;
				msg = "对比成功";
				map.put("code", code);
				map.put("msg", msg);
				map.put("status", status);
				map.put("confidence", confidence);
			} else {
				HttpEntity r_entity = response.getEntity();
				String responseString = EntityUtils.toString(r_entity);
				// 你需要根据出错的原因判断错误信息，并修改
			}
			httpclient.getConnectionManager().shutdown();
		} catch (Exception e) {
			code = -1;
			msg = "对比失败";
			map.put("code", code);
			map.put("msg", msg);
			return map;
		}
		return map;
	}

	/**
	 * @Title: insertUser
	 * @description 添加用户
	 * @param user
	 *            用户信息
	 * @return ResultInfo
	 * @author ZhaoSong
	 * @createDate 2018年11月5日
	 */
	@RequestMapping("/insertUser")
	@ResponseBody
	public ResultInfo insertUser(User user) {
		ResultInfo result = new ResultInfo();
		int row = userService.insertUser(user);
		if (row == 1) {
			result.msg = "添加成功";
			result.code = 1;
		}
		if(row == -1){
			result.msg = "添加失败，用户名已被注册";
			result.code=-1;
		}
		return result;
	}

	/**
	 * 
	 * @Title: findUserById
	 * @description 通过id查询用户
	 * @param id
	 *            用户id
	 * @return User 返回对象
	 * @author LiuHangjing
	 * @createDate 2018年9月26日 下午5:26:37
	 */
	@RequestMapping("/findUserById")
	@ResponseBody
	public User findUserById(Long id) {
		User user = userService.findUserById(id);
		if (user != null) {
		}
		return user;
	}

	/**
	 * 
	 * @Title: updateUser
	 * @description 修改用户信息
	 * @param user
	 *            用户对象
	 * @return ResultInfo 返回值状态码
	 * @author LiuHangjing
	 * @createDate 2018年9月26日 下午5:19:53
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo updateUser(User user) {
		ResultInfo result = new ResultInfo();
		try {

			int rows = userService.updateUser(user);
			if (rows >= 1) {
				result.code = 1;
				result.msg = "successfully!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.code = -1;
			result.msg = "error!";
		}
		return result;
	}

	/**
	 * @Title: finaAll
	 * @description 查询所有用户信息,页面展示用
	 * @return String JSON字符串,所有用户信息集合
	 * @author ZhaoSong
	 * @createDate 2018年11月7日
	 */

	@RequestMapping(value = "/findAllUser", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String finaAll(Integer page, Integer limit) {
		int code = 1;
		String msg = null;
		List<User> users = null;
		if (page == null || page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		try {
			users = userService.findUserLimit(page, limit);

			if (users != null) {
				msg = "查询成功";
			}
			if (users == null) {
				msg = "查询数据为空";
			}
		} catch (Exception e) {
			msg = e.getMessage();
		}
		return JsonUtil.getResponseJson(code, msg, userService.findAll().size(), users);
	}

	/**
	 * @Title: finaUserByPhone
	 * @description 通过电话号码查询用户
	 * @param phone
	 *            用户电话号码
	 * @return String JSON字符串
	 * @author ZhaoSong
	 * @createDate 2018年11月7日
	 */
	@RequestMapping(value = "/findUserByPhone", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String finaUserByPhone(@Param("phone") String phone, @Param("page") Integer page,
			@Param("limit") Integer limit) {
		int code = 1;
		String msg = null;
		if (phone.equals("") || phone == null) {
			if (page <= 0) {
				page = 1;
			}
			page = (page - 1) * limit;
			List<User> users = userService.findUserLimit(page, limit);
			if (users.size() <= 0) {
				msg = "查询数据为空";
			}
			if (users != null) {
				msg = "查询成功";
			}
			return JsonUtil.getResponseJson(code, msg, userService.findAll().size(), users);
		} else {
			if (page <= 0) {
				page = 1;
			}
			page = (page - 1) * limit;
			String phones = "%" + phone + "%";
			List<User> users = userService.findUserByPhone(phones, page, limit);

			if (users.size() <= 0) {
				msg = "查询数据为空";
			}
			if (users != null) {
				msg = "查询成功";
			}
			return JsonUtil.getResponseJson(code, msg, userService.findPhoneCount(phones).size(), users);
		}

	}

	/**
	 * @Title: updateUserStatus
	 * @description 锁定/解锁用户
	 * @param id
	 *            用户id
	 * @param status
	 *            用户状态值
	 * @author ZhaoSong
	 * @createDate 2018年11月8日
	 */
	@RequestMapping(value = "/updateUserStatus", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateUserStatus(Long id, int status) {
		ResultInfo result = new ResultInfo();
		int code = 0;
		String msg = null;
		int row = userService.updateUserStatus(id, status);
		if (row <= 0) {
			code = -1;
			msg = "修改失败";
			result.msg = "修改失败";
		}
		if (row >= 1) {
			code = 1;
			msg = "修改成功";
			result.msg = "修改成功";
		}
		return JsonUtil.getResponseJson(code, msg, null, result);
	}

	/**
	 * 
	 * @Title: uploadfaces
	 * @description 上传人脸图片
	 * @param @param
	 *            file
	 * @param @param
	 *            id
	 * @param @return
	 * @param @throws
	 *            Exception
	 * @return Map
	 * @author caoyaru
	 * @createDate 2018年11月8日-下午4:28:21
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadfaces", produces = "application/json; charset=utf-8")
	public String uploadfaces(MultipartFile file, Long id) {
		int code = 0;
		String msg = null;
		try {
			Map<String, String> update = UpdateFile.update(file);
			// 上传图片
			// 数据库存入图片的地址
			userService.saveImage(id, update.get("Path"));
			// 上传成功
			code = 1;
			msg = "上传成功";
			return JsonUtil.getResponseJson(code, msg, null, null);
		} catch (Exception e) {
			// 上传失败
			code = -1;
			msg = "上传失败";
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
		
	
	
	/**
	 * @Title: updateUser
	 * @description 根据账户id修改账号户信息方法及权限
	 * @param @param id 账户Id
	 * @param @param post 账户职位
	 * @param @param phone 账户电话 
	 * @param @param address 账户地址
	 * @param @param user_pwd 账户密码
	 * @return ResultInfo 处理结果   
	 * @author ZhaoSong
	 * @createDate 2018年12月24日
	 */
	@RequestMapping("/updateUserById")
	@ResponseBody
	public ResultInfo updateUser(Long id,String post,String phone,String address,String user_pwd){
		ResultInfo result = new ResultInfo();
			int row = userService.updateUserById(id, address, user_pwd, post,phone);
			if(row >0){
				result.code=1;
				result.msg="修改账户成功";
			}else{
				result.code=-1;
				result.msg="修改失败";
			}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
