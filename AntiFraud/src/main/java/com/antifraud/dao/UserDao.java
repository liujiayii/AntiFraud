package com.antifraud.dao;

import java.io.File;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.stereotype.Repository;

import com.antifraud.entity.Role;
import com.antifraud.entity.User;
/**
 * @ClassName: UserDao
 * @description 用户管理持久层
 * @author ZhaoSong
 * @createDate 2018年11月1日
 */
public interface UserDao {
	
	
	/**
	 * @Title: insertUser
	 * @description 添加用户
	 * @param user 用户信息
	 * @return int 生效行数   
	 * @author ZhaoSong
	 * @createDate 2018年11月5日
	 */
	int insertUser(User user);
	
	
	/**
	 * @Title: findUserByUserName
	 * @description 通过用户名查找用户
	 * @param user_name 用户名
	 * @return User 用户信息   
	 * @author ZhaoSong
	 * @createDate 2018年11月5日
	 */
	User findUserByUserName(String user_name);
	
	
	
	
	
	/**
	 * 
	 * @Title: loginUser
	 * @description 登录 查询用户
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return User  返回对象
	 * @author LiuHangjing
	 * @createDate 2018年9月26日 下午3:52:58
	 */
	User loginUser(@Param("username")String user_name,@Param("password")String user_pwd);
	/**
	 * 
	 * @Title: updateUser
	 * @description 修改用户信息
	 *
	 * @param user 用户对象
	 * @return int  执行条数
	 * @author LiuHangjing
	 * @createDate 2018年9月26日 下午5:14:34
	 */
	int updateUser(User user);
	/**
	 * 
	 * @Title: findUserById
	 * @description 通过id查询用户
	 *
	 * @param id 
	 * @return User 返回用户对象  
	 * @author LiuHangjing
	 * @createDate 2018年9月26日 下午5:23:52
	 */
	User findUserById(Long id);
	/**
	 * 
	  * @Title: findByUsername
	  * @description 获取用户
	  * @param @param username
	  * @param @return 
	  * @return User    
	  * @author caoyaru
	  * @createDate 2018年10月17日-下午2:50:05
	 */
	User findUserByname(String username);
	/**
	 * 
	  * @Title: findByUser
	  * @description 根据ID查询角色
	  * @param @param id
	  * @param @return 
	  * @return List<User>    
	  * @author caoyaru
	  * @createDate 2018年11月6日-上午10:13:10
	 */
	List<User> findByUser(@Param("id")Long id);
	/**
	 * 
	  * @Title: findAll
	  * @description 查询全部
	  * @param @return 
	  * @return List<User>    
	  * @author caoyaru
	  * @createDate 2018年11月6日-上午10:13:39
	 */
	List<User> findAll();
	
	/**
	 * @Title: findUserByPhone
	 * @description 通过电话号码查询用户,用于电话搜索
	 * @param phone 用户电话号码
	 * @return List<User> 返回用户集合
	 * @author ZhaoSong
	 * @createDate 2018年11月7日
	 */
	List<User> findUserByPhone(@Param("phone")String phone,@Param("page")Integer page,@Param("limit")Integer limit);
	
	/**
	 * @Title: updateUserStatus
	 * @description 锁定/解锁用户
	 * @param id 用户id
	 * @param status 用户状态值
	 * @return int 受影响函数   
	 * @author ZhaoSong
	 * @createDate 2018年11月8日
	 */
	int updateUserStatus(@Param("id")Long id ,@Param("status")int status);

	/**
	 * 
	  * @Title: saveImage
	  * @description 保存人脸图片地址
	  * @param @param address 
	  * @return void    
	  * @author caoyaru
	  * @createDate 2018年11月12日-上午10:20:13
	 */
	void saveImage(@Param("id")Long id,@Param("address")String address);

	/**
	 * 
	  * @Title: findaddressById
	  * @description 根据用户ID查询图片地址
	  * @param @param userid
	  * @param @return 
	  * @return String    
	  * @author caoyaru
	  * @createDate 2018年11月12日-上午11:41:30
	 */
	String findaddressById(@Param("userid")Long userid);
	
	
	
	/**
	 * @Title: findUserLimit
	 * @description 分页查询用户信息
	 * @param page 当前页
	 * @param limit 单页显示条数
	 * @return List<User> 当前页用户信息列表   
	 * @author ZhaoSong
	 * @createDate 2018年11月14日
	 */
	List<User> findUserLimit(@Param("page")Integer page,@Param("limit")Integer limit);

	
	/**
	 * @Title: findPhoneCount
	 * @description 符合电话查询条件的信息的条数
	 * @param @param phones 电话号码
	 * @return List<User>   符合条件集合
	 * @author ZhaoSong
	 * @createDate 2018年12月6日
	 */
	
	List<User> findPhoneCount(String phones);

	
	/**
	 * @Title: updateUserById
	 * @description 根据用户id修改用户信息
	 * @param @param id 用户id
	 * @param @param address 地址 
	 * @param @param passWord 密码 
	 * @param @param post 职位 
	 * @param @return  受影响行数
	 * @return int    
	 * @author ZhaoSong
	 * @createDate 2018年12月24日
	 */
	int updateUserById(@Param("id")Long id,@Param("address")String address,@Param("passWord")String passWord,@Param("post")String post,@Param("phone")String phone,@Param("key_word")String key_word);
	
}
