package com.antifraud.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antifraud.dao.FiduciaryLoanDao;
import com.antifraud.dao.HousePropertyMortgageDao;
import com.antifraud.dao.PostLoanManagerDao;
import com.antifraud.dao.VehicleMortgageDao;
import com.antifraud.entity.PostLoanManage;
import com.antifraud.entityVO.HousePropertyMortgageVo;
import com.antifraud.entityVO.PostLoanManageVo;
import com.antifraud.service.PostLoanManageService;

/**
 * 
 *
 * @ClassName: PostLoanManageServiceImpl
 * 
 * @description 贷后管理表层
 *
 * @author zhangkai
 * @createDate 2018年10月11日
 */
@Service
@Transactional
public class PostLoanManageServiceImpl implements PostLoanManageService {
	@Autowired
	private PostLoanManagerDao postLoanManagerDao;

	/**
	 * 
	 *
	 * @Title: updatePostLoanManage
	 * 
	 * @description 详情页修改数据
	 *
	 * @param @return
	 * 
	 * @return int
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月7日
	 */
	@Override
	public int updatePostLoanManage(PostLoanManage postLoanManage) throws Exception {

		return postLoanManagerDao.updatePostLoanManage(postLoanManage);
	}

	/**
	 * 
	 *
	 * @Title: findPostLoanManageByRecordId
	 * 
	 * @description 详情页通过报单编号查询
	 *
	 * @param @return
	 * 
	 * @return PostLoanManage
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月7日
	 */
	@Override
	public PostLoanManageVo findPostLoanManageByRecordId(String id) throws Exception {

		return postLoanManagerDao.findPostLoanManageByRecordId(id);
	}

	/**
	 * 
	 *
	 * @Title: addPostLoanManage
	 * 
	 * @description 详情页增加数据
	 *
	 * @param @return
	 * 
	 * @return PostLoanManage
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月7日
	 */
	@Override
	public int addPostLoanManage(PostLoanManage postLoanManage) throws Exception {

		return postLoanManagerDao.addPostLoanManage(postLoanManage);
	}

	/**
	 * 
	 *
	 * @Title: findHousePropertyByPhone
	 * 
	 * @description 主页通过电话查询房产报单申请表
	 *
	 * @param @param
	 *            phone
	 * @param @return
	 * 
	 * @return List<PostLoanManageVo>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月7日
	 */
	@Override
	public List<PostLoanManageVo> findHousePropertyByPhone(String phone) throws Exception {

		return postLoanManagerDao.findHousePropertyByPhone(phone);
	}

	/**
	 * 
	 *
	 * @Title: findAllHouseProperty
	 * 
	 * @description 主页列表查询房产报单申请表
	 *
	 * @param @return
	 * 
	 * @return List<PostLoanManageVo>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月7日
	 */
	@Override
	public List<PostLoanManageVo> findAllHouseProperty() throws Exception {

		return postLoanManagerDao.findAllHouseProperty();
	}

	/**
	 * 
	 *
	 * @Title: findVehicleByPhone
	 * 
	 * @description 主页通过电话查询车辆报单申请表
	 *
	 * @param @param
	 *            phone
	 * @param @return
	 * 
	 * @return List<PostLoanManageVo>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月7日
	 */
	@Override
	public List<PostLoanManageVo> findVehicleByPhone(String phone) throws Exception {

		return postLoanManagerDao.findVehicleByPhone(phone);
	}

	/**
	 * 
	 *
	 * @Title: findAllVehicle
	 * 
	 * @description 主页列表查询车辆报单申请表
	 *
	 * @param @return
	 * 
	 * @return List<PostLoanManageVo>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月7日
	 */
	@Override
	public List<PostLoanManageVo> findAllVehicle() throws Exception {

		return postLoanManagerDao.findAllVehicle();
	}

	/**
	 * 
	 *
	 * @Title: findFiduciaryByPhone
	 * 
	 * @description 主页通过电话查询信用报单申请表
	 *
	 * @param @param
	 *            phone
	 * @param @return
	 * 
	 * @return List<PostLoanManageVo>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月7日
	 */
	@Override
	public List<PostLoanManageVo> findFiduciaryByPhone(String phone) throws Exception {

		return postLoanManagerDao.findFiduciaryByPhone(phone );
	}

	/**
	 * 
	 *
	 * @Title: findAllFiduciary
	 * 
	 * @description 主页列表查询信用报单申请表
	 *
	 * @param @return
	 * 
	 * @return List<PostLoanManageVo>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月7日
	 */
	@Override
	public List<PostLoanManageVo> findAllFiduciary() throws Exception {

		return postLoanManagerDao.findAllFiduciary();
	}

	/**
	 * 
	 *
	 * @Title: updateHousePropertyStatus
	 * 
	 * @description 详情页修改房产报单申请表状态
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return int
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月9日
	 */
	@Override
	public int updateHousePropertyStatus(String id) {
		return postLoanManagerDao.updateHousePropertyStatus(id);
	}

	/**
	 * 
	 *
	 * @Title: updateVehicleStatus
	 * 
	 * @description 详情页修改车辆报单申请表状态
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return int
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月9日
	 */
	@Override
	public int updateVehicleStatus(String id) {
		return postLoanManagerDao.updateVehicleStatus(id);
	}

	/**
	 * 
	 *
	 * @Title: updateFiduciaryStatus
	 * 
	 * @description 详情页修改信用报单申请表状态
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return int
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月9日
	 */
	@Override
	public int updateFiduciaryStatus(String id) {
		return postLoanManagerDao.updateFiduciaryStatus(id);
	}

}
