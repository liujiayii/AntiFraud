package com.antifraud.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.antifraud.dao.ReplenishProcedureDao;
import com.antifraud.dao.ReplenishProcedureImageDao;
import com.antifraud.entity.ReplenishProcedure;
import com.antifraud.entity.ReplenishProcedureImage;
import com.antifraud.entityVO.HousePropertyMortgageVo;
import com.antifraud.service.ReplenishProcedureImageService;
import com.antifraud.service.ReplenishProcedureService;
/**
 * 
 *
 * @ClassName: ReplenishProcedureServiceImpl

 * @description 补充手续表ServiceImpl层
 *
 * @author zhangkai
 * @createDate 2018年11月5日
 */
@Service("ReplenishProcedureService")
@Transactional
public class ReplenishProcedureServiceImpl implements ReplenishProcedureService {	
	@Resource
	private ReplenishProcedureDao replenishProcedureDao;
		
	/*通过报单编号修改 */
	@Override
	public int updateReplenishProcedureByRecordId(ReplenishProcedure replenishProcedure)throws Exception {
		
		return replenishProcedureDao.updateReplenishProcedureByRecordId(replenishProcedure);
	}

	/* 增加补充手续表信息 */
	@Override
	public int addReplenishProcedure(ReplenishProcedure replenishProcedure)throws Exception {
		
		return replenishProcedureDao.addReplenishProcedure(replenishProcedure);
	}

	/* 通过报单编号查询 */
	@Override
	public ReplenishProcedure findReplenishProcedureByRecordId(String id) {
		return replenishProcedureDao.findReplenishProcedureByRecordId(id);
	}

   		
}
	
	
	

