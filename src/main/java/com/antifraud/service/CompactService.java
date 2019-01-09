package com.antifraud.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.antifraud.entity.Compact;
import com.antifraud.entity.FiduciaryLoan;

public interface CompactService {
	
	 /*合同表插入方法*/
     public int insertCompact(Compact compact);
     
	 /*根据报单编号查询信用贷款表*/
	 public FiduciaryLoan findByEntry_number(String entry_number);
	 
	/* 查询最后一条插入合同表的合同*/
	 public Compact findLastCompact();
    
	 /*上传合同图片并保存合同表*/
	public Map upLoadCompact(String entry_number, List<MultipartFile> files,String reamker);
	
	/*根据id修改合同*/
	public int updateCompactByContract_id(Compact compact);
	
	/*根据报单编号查询合同表*/
	public List<Compact> findCompactByEntry_number(String Entry_number);
	
	/*查询所有合同表*/
	public List<Compact> findAllCompact(int page,int limit);
	 
	 /*根据报单编号删除合同表*/
	public int deleteCompactByReport_id(String report_id );
	
	/*根据id删除合同表*/
	public int deleteCompactByid(Long id );
   /**
    * 
   *
    * @Title: findallForCamapte
   
    * @description 查询审核通过等待打印合同的信用贷款报单
   *
    * @param @param page
    * @param @param limit
    * @param @return 
      
    * @return Map    
   
    *
    * @author lishaozhang
    * @createDate 2018年11月8日
    */
	public Map findallForCamapte(int page, int limit);
    
	/**
	 * 
	*
	 * @Title: findAllHousePropertyMortgageForCompact
	
	 * @description 查询审核通过等待打印合同的房屋抵押贷款报单
	*
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return Map    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月8日
	 */
    public Map findAllHousePropertyMortgageForCompact(int page, int limit);
    
   /***
    * 
   *
    * @Title: findAllVehicleMortgageForCamapte
   
    * @description 分页查询所有可以签合同业务的车辆抵押业务报单
   *
    * @param @param page
    * @param @param limit
    * @param @return 
      
    * @return Map    
   
    *
    * @author lishaozhang
    * @createDate 2018年11月8日
    */
	public Map findAllVehicleMortgageForCamapte(int page, int limit);
    /***
     * 
    *
     * @Title: findAllCompactImgIsNull
    
     * @description 分页查询所有未上传图片的合同表
    *
     * @param @param page
     * @param @param limit
     * @param @return 
       
     * @return Map    
    
     *
     * @author lishaozhang
     * @createDate 2018年11月9日
     */
    public Map findAllCompactImgIsNull(int page, int limit);
     /**
      * 
     *
      * @Title: findAllCompactImgIsNotNull
     
      * @description 分页查询所有已经传图片的合同表
     *
      * @param @param page
      * @param @param limit
      * @param @return 
        
      * @return Map    
     
      *
      * @author lishaozhang
      * @createDate 2018年11月9日
      */
	public Map findAllCompactImgIsNotNull(int page, int limit);
     /**
      * 
     *
      * @Title: fiandFiduciaryLoanByStatus
     
      * @description 根据状态查询信用贷款表
     *
      * @param @param status1
      * @param @param status2
      * @param @param page
      * @param @param limit
      * @param @return 
        
      * @return Map    
     
      *
      * @author lishaozhang
      * @createDate 2018年11月26日
      */
	public Map fiandFiduciaryLoanByStatus(int status1, int status2, int page, int limit);

	/**
	 * 
	*
	 * @Title: fiandHousePropertyMortgageByStatus
	
	 * @description 根据状态查询房屋贷款表
	*
	 * @param @param status1
	 * @param @param status2
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return Map    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月26日
	 */
	public Map fiandHousePropertyMortgageByStatus(int status1, int status2, int page, int limit);
    
	/**
	 * 
	*
	 * @Title: fiandVehicleMortgageByStatus
	
	 * @description 根据状态查询车辆贷款表
	*
	 * @param @param status1
	 * @param @param status2
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return Map    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月26日
	 */
	public Map fiandVehicleMortgageByStatus(int status1, int status2, int page, int limit);

	
	
	
}
