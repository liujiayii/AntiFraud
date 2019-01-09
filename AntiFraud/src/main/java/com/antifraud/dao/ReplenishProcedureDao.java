package com.antifraud.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.antifraud.entity.ReplenishProcedure;
import com.antifraud.entity.ReplenishProcedureImage;
import com.antifraud.entityVO.HousePropertyMortgageVo;


/**
 * 
 *
 * @ClassName: ReplenishProcedureDao

 * @description 补充手续表Dao层
 *
 * @author zhangkai
 * @createDate 2018年10月30日
 */
public interface ReplenishProcedureDao {
		
	/* 通过报单编号修改 */
	public int updateReplenishProcedureByRecordId (ReplenishProcedure replenishProcedure); 

	/* 增加补充手续表信息 */
	public int addReplenishProcedure (ReplenishProcedure replenishProcedure);
	
	/* 通过报单编号查询 */
	public ReplenishProcedure findReplenishProcedureByRecordId (String id);
	
}
