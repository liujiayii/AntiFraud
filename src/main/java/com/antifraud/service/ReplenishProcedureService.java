package com.antifraud.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.antifraud.entity.ReplenishProcedure;
import com.antifraud.entity.ReplenishProcedureImage;
import com.antifraud.entityVO.HousePropertyMortgageVo;

/**
 * 
 *
 * @ClassName: ReplenishProcedureService

 * @description 补充手续表Service层
 *
 * @author zhangkai
 * @createDate 2018年10月30日
 */
public interface ReplenishProcedureService {


	/* 通过报单编号修改 */
	public int updateReplenishProcedureByRecordId (ReplenishProcedure replenishProcedure) throws Exception;

	/* 增加补充手续表信息 */
	public int addReplenishProcedure (ReplenishProcedure replenishProcedure) throws Exception;

	/* 通过报单编号查询 */
	public ReplenishProcedure findReplenishProcedureByRecordId (String id);
	
	
}
