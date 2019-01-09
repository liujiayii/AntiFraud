package com.antifraud.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.antifraud.dao.ReplenishProcedureDao;
import com.antifraud.dao.ReplenishProcedureImageDao;
import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.ReplenishProcedure;
import com.antifraud.entity.ReplenishProcedureImage;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entityVO.PostLoanManageVo;
import com.antifraud.entityVO.ReplenishProcedureVo;
import com.antifraud.service.ReplenishProcedureImageService;
import com.antifraud.utils.UpdateFile;

/**
 * 
 *
 * @ClassName: ReplenishProcedureImageServiceImpl
 * 
 * @description 补充手续图片表ServiceImpl层
 *
 * @author zhangkai
 * @createDate 2018年10月29日
 */
@Service("ReplenishProcedureImageService")
@Transactional
public class ReplenishProcedureImageServiceImpl implements ReplenishProcedureImageService {
	@Autowired
	private ReplenishProcedureImageDao replenishProcedureImageDao;
	@Autowired
	private ReplenishProcedureDao replenishProcedureDao;

	/* 详情页多文件上传 */
	@Override
	public void saveFile(MultipartFile file, String id) throws Exception {
		Date now_time = new Date();
		Date create_time;
		ReplenishProcedureImage replenishProcedureImage = new ReplenishProcedureImage();
		ReplenishProcedure replenishProcedure;
		Map<String, String> map;
		String img_format;
		String savePath;
		System.out.println(now_time);
		map = UpdateFile.update(file);

		img_format = map.get("Path");
		savePath = map.get("suffix");
		replenishProcedureImage.setReport_id(id);
		replenishProcedureImage.setImg_format(img_format);
		replenishProcedureImage.setImg_url(savePath);
		replenishProcedure = replenishProcedureDao.findReplenishProcedureByRecordId(id);
		if (replenishProcedure != null) {
			replenishProcedure.setUpdate_time(now_time);
			replenishProcedureDao.updateReplenishProcedureByRecordId(replenishProcedure);
			replenishProcedureImage.setUpdate_time(now_time);
			create_time = replenishProcedure.getCreate_time();
			replenishProcedureImage.setCreate_time(create_time);
			replenishProcedureImageDao.addReplenishProcedureImage(replenishProcedureImage);
		} else {
			replenishProcedure = new ReplenishProcedure();
			replenishProcedure.setReport_id(id);
			replenishProcedure.setCreate_time(now_time);
			replenishProcedure.setUpdate_time(now_time);
			replenishProcedureDao.addReplenishProcedure(replenishProcedure);
			replenishProcedureImage.setCreate_time(now_time);
			replenishProcedureImage.setUpdate_time(now_time);
			replenishProcedureImageDao.addReplenishProcedureImage(replenishProcedureImage);
		}

	}

	/* 主页通过电话查询房产报单申请表 */
	@Override
	public List<PostLoanManageVo> findHousePropertyByPhone(String phone, int start, int limit) {
		return replenishProcedureImageDao.findHousePropertyByPhone(phone, start, limit);
	}

	/* 主页通过电话查询车辆报单申请表 */
	@Override
	public List<PostLoanManageVo> findVehicleByPhone(String phone, int start, int limit) {
		return replenishProcedureImageDao.findVehicleByPhone(phone, start, limit);
	}

	/* 主页通过电话查询信用报单申请表 */
	@Override
	public List<PostLoanManageVo> findFiduciaryByPhone(String phone, int start, int limit) {
		return replenishProcedureImageDao.findFiduciaryByPhone(phone, start, limit);
	}

	/* 主页列表查询房产报单申请表 */
	@Override
	public List<PostLoanManageVo> findAllHouseProperty(int start, int limit) {
		return replenishProcedureImageDao.findAllHouseProperty(start, limit);
	}

	/* 主页列表查询车辆报单申请表 */
	@Override
	public List<PostLoanManageVo> findAllVehicle(int start, int limit) {
		return replenishProcedureImageDao.findAllVehicle(start, limit);
	}

	/* 主页列表查询信用报单申请表 */
	@Override
	public List<PostLoanManageVo> findAllFiduciary(int start, int limit) {
		return replenishProcedureImageDao.findAllFiduciary(start, limit);
	}

	/* 详情页修改房产报单申请表状态 */
	@Override
	public int updateHousePropertyStatus(String id) {
		return replenishProcedureImageDao.updateHousePropertyStatus(id);
	}

	/* 详情页修改车辆报单申请表状态 */
	@Override
	public int updateVehicleStatus(String id) {
		return replenishProcedureImageDao.updateVehicleStatus(id);
	}

	/* 详情页修改信用报单申请表状态 */
	@Override
	public int updateFiduciaryStatus(String id) {
		return replenishProcedureImageDao.updateFiduciaryStatus(id);
	}

	/* 详情页插入补充手续信息到借款人业务信息表 */
	@Override
	public int addReplenishProcedureToBusiness_massage(ReplenishProcedureVo replenishProcedureVo) {
		return replenishProcedureImageDao.addReplenishProcedureToBusiness_massage(replenishProcedureVo);
	}

	/* 详情页插入补充手续信息到贷款人职业信息表 */
	@Override
	public int addReplenishProcedureToOccupational_information(ReplenishProcedureVo replenishProcedureVo) {
		return replenishProcedureImageDao.addReplenishProcedureToOccupational_information(replenishProcedureVo);
	}

	/* 详情页通过报单编号修改借款人业务信息表 */
	@Override
	public int updateReplenishProcedureToBusiness_massage(ReplenishProcedureVo replenishProcedureVo) {
		return replenishProcedureImageDao.updateReplenishProcedureToBusiness_massage(replenishProcedureVo);
	}

	/* 详情页通过报单编号修改贷款人职业信息表 */
	@Override
	public int updateReplenishProcedureToOccupational_information(ReplenishProcedureVo replenishProcedureVo) {
		return replenishProcedureImageDao.updateReplenishProcedureToOccupational_information(replenishProcedureVo);
	}

	/* 详情页通过报单编号查询 */
	@Override
	public ReplenishProcedureVo findReplenishProcedureByEntry_number(String id) {
		return replenishProcedureImageDao.findReplenishProcedureByEntry_number(id);
	}

	/* 详情页通过报单编号修改房产报单申请表 */
	@Override
	public void updateHouseProperty(ReplenishProcedureVo replenishProcedureVo) {
		replenishProcedureImageDao.updateHouseProperty(replenishProcedureVo);
	}

	/* 详情页通过报单编号修改车辆报单申请表 */
	@Override
	public void updateVehicle(ReplenishProcedureVo replenishProcedureVo) {
		replenishProcedureImageDao.updateVehicle(replenishProcedureVo);
		;
	}

	/* 详情页通过报单编号修改信用报单申请表 */
	@Override
	public void updateFiduciary(ReplenishProcedureVo replenishProcedureVo) {
		replenishProcedureImageDao.updateFiduciary(replenishProcedureVo);
	}

	@Override
	public List<HousePropertyMortgage> findHousesd(int start, int limit) {
		
		return replenishProcedureImageDao.findHousesd(start, limit);
	}

	@Override
	public List<VehicleMortgage> findVehiclesd(int start, int limit) {
	
		return replenishProcedureImageDao.findVehiclesd(start, limit);
	}

	@Override
	public List<FiduciaryLoan> findFiduciarysd(int start, int limit) {
		
		return replenishProcedureImageDao.findFiduciarysd(start, limit);
	}

	@Override
	public 	Integer findHousesdcount() {
		
		return replenishProcedureImageDao.findHousesdcount();
	}

	@Override
	public Integer findVehiclesdcount() {
		
		return replenishProcedureImageDao.findVehiclesdcount();
	}

	@Override
	public Integer findFiduciarysdcount() {
	
		return replenishProcedureImageDao.findFiduciarysdcount();
	}

}
