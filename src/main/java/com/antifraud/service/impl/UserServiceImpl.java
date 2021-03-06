package com.antifraud.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antifraud.dao.PopedomDao;
import com.antifraud.dao.UserDao;
import com.antifraud.entity.Role;
import com.antifraud.entity.User;
import com.antifraud.entity.UserPopedom;
import com.antifraud.service.UserService;
import com.antifraud.utils.DesUtil;
import com.antifraud.utils.MD5Encrypt;
/**
 * @ClassName: UserServiceImpl
 * @description 用户管理业务层实现类
 * @author ZhaoSong
 * @createDate 2018年11月1日
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PopedomDao popedomDao;
	
	

	@Override
	public User loginUser(String username, String password) {
		User user = userDao.loginUser(username, password);
		return user;
	}

	@Override
	public int updateUser(User user) {
		int row = userDao.updateUser(user);
		return row;
	}

	@Override
	public User findUserById(Long id) {
		User user= userDao.findUserById(id);
		return user;
	}

	@Override
	public User findUserByname(String username) {
		User user = userDao.findUserByname(username);
		return user;
	}

	
	@Override
	public int insertUser(User user) {
			Date date=new Date();
			List<Integer> popedomId=new ArrayList<>();
			User u = userDao.findUserByUserName(user.getUser_name());
			if(u==null){
				//密码加密
				String key="yunqueadmin";//秘钥
				String newpassword = MD5Encrypt.MD5Encode(user.getUser_pwd());//MD5加密
				user.setUser_pwd(DesUtil.encode(key, newpassword));//DES加密,并设为此账号密码.
				
				user.setId(null);
				user.setCreate_time(date);
				user.setUpdate_time(date);
				user.setStatus(1);
				if(user.getP_id()== 2000) {
					user.setPost("超级管理员");
					user.setKey_word("admin");
				}
				if(user.getP_id() == 2001){
					user.setPost("业务员");
					user.setKey_word("salesman");
				}
				if(user.getP_id() == 2002){
					user.setPost("风控主管");
					user.setKey_word("management");
				}
				if(user.getP_id() == 2003){
					user.setPost("房屋评估师");
					user.setKey_word("proprietes");
				}
				if(user.getP_id() == 2004){
					user.setPost("车辆评估师");
					user.setKey_word("automobile");
				}
				if(user.getP_id() == 2005){
					user.setPost("信用评估师");
					user.setKey_word("emprumter");
				}
				if(user.getP_id() == 2006){
					user.setPost("档案人员");
					user.setKey_word("archives");
				}
				if(user.getP_id() == 2007){
					user.setPost("风控内勤人员");
					user.setKey_word("managementSecretary");
				}
				if(user.getP_id() == 2008){
					user.setPost("风控外勤人员");
					user.setKey_word("managementLegwork");
				}
				if(user.getP_id() == 2009){
					user.setPost("业务主管");
					user.setKey_word("businessSupervisor");
				}
				int row = userDao.insertUser(user);
				User us = userDao.findUserByUserName(user.getUser_name());
				
				if(us.getP_id() == 2000){
					for(int i =1001;i<=1038;i++){
						popedomId.add(i);//超级管理员拥有所有权限,循环添加所有权限
					}
				}
				if(us.getP_id() == 2001||us.getP_id() == 2009){//业务员或业务主管
					popedomId.add(1001);//业务保单
					popedomId.add(1002);//房屋抵押报单
					popedomId.add(1003);//车辆抵押报单
					popedomId.add(1004);//信用抵押报单
					popedomId.add(1009);//业务反馈
					popedomId.add(1019);//房屋业务反馈
					popedomId.add(1020);//车辆业务反馈
					popedomId.add(1021);//信用业务反馈
				}
				if(us.getP_id() == 2002){//风控主管
					popedomId.add(1010);//面审与反欺诈
					popedomId.add(1011);//实地
					popedomId.add(1012);//补充手续
					popedomId.add(1013);//签合同
					popedomId.add(1025);//房屋抵押合同
					popedomId.add(1026);//车辆抵押合同
					popedomId.add(1027);//信用贷款合同
					popedomId.add(1028);//上传合同
					popedomId.add(1016);//贷后管理
					popedomId.add(1029);//房屋抵押贷后管理
					popedomId.add(1030);//车辆抵押贷后管理
					popedomId.add(1031);//信用贷款贷后管理
					popedomId.add(1017);//清收管理
					popedomId.add(1032);//房屋抵押补充手续
					popedomId.add(1033);//车辆抵押补充手续
					popedomId.add(1034);//信用贷款补充手续
					popedomId.add(1035);//房屋抵押清收
					popedomId.add(1036);//车辆抵押清收
					popedomId.add(1037);//信用抵押清收
				}
				if(us.getP_id() == 2003){//房屋评估师
					popedomId.add(1005);//资产评估
					popedomId.add(1006);//房屋评估
				}
				if(us.getP_id() == 2004){//车辆评估师
					popedomId.add(1005);//资产评估
					popedomId.add(1007);//车辆评估
				}
				if(us.getP_id() == 2005){//信用借贷评估师
					popedomId.add(1005);//资产评估
					popedomId.add(1008);//信用评估
				}
				if(us.getP_id() == 2006){//档案人员
					popedomId.add(1014);//档案管理
					popedomId.add(1022);//档案归档
					popedomId.add(1023);//档案借阅
					popedomId.add(1024);//合同审核
				}
				if(us.getP_id() == 2007){//风控内勤
					popedomId.add(1016);//贷后管理
					popedomId.add(1029);//房屋抵押贷后管理
					popedomId.add(1030);//车辆抵押贷后管理
					popedomId.add(1031);//信用贷款贷后管理
					popedomId.add(1013);//签合同
					popedomId.add(1025);//房屋抵押合同
					popedomId.add(1026);//车辆抵押合同
					popedomId.add(1027);//信用贷款合同
					popedomId.add(1028);//上传合同
				}
				if(us.getP_id() == 2008){//风控外勤
					popedomId.add(1017);//清收管理
					popedomId.add(1035);//房屋抵押清收
					popedomId.add(1036);//车辆抵押清收
					popedomId.add(1037);//信用抵押清收
					popedomId.add(1012);//补充手续
					popedomId.add(1032);//房屋抵押补充手续
					popedomId.add(1033);//车辆抵押补充手续
					popedomId.add(1034);//信用贷款补充手续
				}
				for(int popedom_id:popedomId){
					UserPopedom userPopedom = new UserPopedom();
					userPopedom.setId(null);
					userPopedom.setPopedom_id(popedom_id);
					userPopedom.setUser_id(us.getId());
					userPopedom.setUpdate_time(date);
					userPopedom.setCreate_time(date);
					int row1 = popedomDao.addPopedomById(userPopedom);
					if(row1!=0){
					}
				}
				return row;
			}else{
				return -1;
			}
			
	}
	
	
	
	

	@Override
	public User findUserByUserName(String user_name) {
			User user = userDao.findUserByUserName(user_name);
		return user;
	}

	@Override
	public List<User> findByUser(User user) {
		// 基于用户查询角色，admin具有所有角色
				if(user.getUser_name().equals("admin")){
					return userDao.findAll();
				}else{
					return userDao.findByUser(user.getId());
				}
	}

	@Override
	public List<User> findAll() {
		List<User> users = userDao.findAll();
		return users;
	}

	@Override
	public List<User> findUserByPhone(String phone,Integer page,Integer limit) {
		List <User> users = userDao.findUserByPhone(phone,page,limit);
		return users;
	}

	@Override
	public int updateUserStatus(Long id, int status) {
		if(status==1){
			status=2;
		}else{
			status=1;
		}
		int row = userDao.updateUserStatus(id, status);
		return row;
	}

	@Override
	public void saveImage(Long id,String address) {
		userDao.saveImage(id,address);
		
	}

	@Override
	public String findaddressById(Long userid) {
		
		return userDao.findaddressById(userid);
	}

	@Override
	public List<User> findUserLimit(Integer page, Integer limit) {
		return	userDao.findUserLimit(page, limit);
	}

	@Override
	public List<User> findPhoneCount(String phones) {
		return userDao.findPhoneCount(phones);
	}

	@Override
	public int updateUserById(Long id, String address, String passWord, String post,String phone){
		String key_word=null;
		String key="yunqueadmin";//秘钥
		List<Integer> popedomId = new ArrayList<Integer>();
		int count=0;
		Date date = new Date();
		int row = popedomDao.deletePopedomById(id);
		if(row>0){
		if(post.equals("超级管理员")){
			for(int i =1001;i<=1037;i++){
				popedomId.add(i);
				key_word="admin";
			}
		}
		if(post.equals("业务员")){
			popedomId.add(1001);//业务保单
			popedomId.add(1002);//房屋抵押报单
			popedomId.add(1003);//车辆抵押报单
			popedomId.add(1004);//信用抵押报单
			popedomId.add(1009);//业务反馈
			popedomId.add(1019);//房屋业务反馈
			popedomId.add(1020);//车辆业务反馈
			popedomId.add(1021);//信用业务反馈
			key_word="salesman";
		}
		if(post.equals("业务主管")){
			popedomId.add(1001);//业务保单
			popedomId.add(1002);//房屋抵押报单
			popedomId.add(1003);//车辆抵押报单
			popedomId.add(1004);//信用抵押报单
			popedomId.add(1009);//业务反馈
			popedomId.add(1019);//房屋业务反馈
			popedomId.add(1020);//车辆业务反馈
			popedomId.add(1021);//信用业务反馈			
			key_word="businessSupervisor";
		}
		if(post.equals("风控主管")){
			popedomId.add(1010);//面审与反欺诈
			popedomId.add(1011);//实地
			popedomId.add(1012);//补充手续
			popedomId.add(1013);//签合同
			popedomId.add(1025);//房屋抵押合同
			popedomId.add(1026);//车辆抵押合同
			popedomId.add(1027);//信用贷款合同
			popedomId.add(1028);//上传合同
			popedomId.add(1016);//贷后管理
			popedomId.add(1029);//房屋抵押贷后管理
			popedomId.add(1030);//车辆抵押贷后管理
			popedomId.add(1031);//信用贷款贷后管理
			popedomId.add(1017);//清收管理
			popedomId.add(1032);//房屋抵押补充手续
			popedomId.add(1033);//车辆抵押补充手续
			popedomId.add(1034);//信用贷款补充手续
			popedomId.add(1035);//房屋抵押清收
			popedomId.add(1036);//车辆抵押清收
			popedomId.add(1037);//信用抵押清收
			key_word="management";
		}
		if(post.equals("房屋评估师")){
			popedomId.add(1005);//资产评估
			popedomId.add(1006);//房屋评估
			key_word="proprietes";
		}
		if(post.equals("车辆评估师")){
			popedomId.add(1005);//资产评估
			popedomId.add(1007);//车辆评估
			key_word="automobile";
		}
		if(post.equals("信用评估师")){
			popedomId.add(1005);//资产评估
			popedomId.add(1008);//信用评估
			key_word="emprumter";
		}
		if(post.equals("档案人员")){
			popedomId.add(1014);//档案管理
			popedomId.add(1022);//档案归档
			popedomId.add(1023);//档案借阅
			popedomId.add(1024);//合同审核
			key_word="archives";
		}
		if(post.equals("风控内勤人员")){
			popedomId.add(1016);//贷后管理
			popedomId.add(1029);//房屋抵押贷后管理
			popedomId.add(1030);//车辆抵押贷后管理
			popedomId.add(1031);//信用贷款贷后管理
			popedomId.add(1013);//签合同
			popedomId.add(1025);//房屋抵押合同
			popedomId.add(1026);//车辆抵押合同
			popedomId.add(1027);//信用贷款合同
			popedomId.add(1028);//上传合同
			key_word="managementSecretary";
		}
		if(post.equals("风控外勤人员")){
			popedomId.add(1017);//清收管理
			popedomId.add(1035);//房屋抵押清收
			popedomId.add(1036);//车辆抵押清收
			popedomId.add(1037);//信用抵押清收
			popedomId.add(1012);//补充手续
			popedomId.add(1032);//房屋抵押补充手续
			popedomId.add(1033);//车辆抵押补充手续
			popedomId.add(1034);//信用贷款补充手续
			key_word="managementLegwork";
		}
		for(int popedom_id:popedomId){
			UserPopedom userPopedom = new UserPopedom();
			userPopedom.setId(null);
			userPopedom.setPopedom_id(popedom_id);
			userPopedom.setUser_id(id);
			userPopedom.setUpdate_time(date);
			userPopedom.setCreate_time(date);
			popedomDao.addPopedomById(userPopedom);
		}
		}else{
			throw new RuntimeException("修改信息失败");
		}
		User user = userDao.findUserById(id);
		if(passWord.equals(user.getUser_pwd())){
			userDao.updateUserById(id, address, null, post,phone,key_word);
		}else{
		passWord=DesUtil.encode(key,MD5Encrypt.MD5Encode(passWord));
		}
		return userDao.updateUserById(id, address, passWord, post,phone,key_word);
	
	}
	
	


}
