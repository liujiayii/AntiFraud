package com.antifraud.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.Compact;
import com.antifraud.entity.FiduciaryLoan;

/**
 * 
 *
 * @ClassName: CompactMapper

 * @description 签合同DAO
 *
 * @author lishaozhang
 * @createDate 2018年10月24日-上午10:20:50
 * */
public interface CompactDao {

	/**
	 * 
	*
	 * @Title: insertCompact
	
	 * @description 合同表插入方法
	*
	 * @param @param compact
	 * @param @return 
	   
	 * @return int    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年10月24日
	 */
	 int insertCompact(Compact compact);
	 
	 
	 /**
	  * 
	 *
	  * @Title: findByEntry_number
	 
	  * @description 根据报单编号查询信用贷款
	 *
	  * @param @param entry_number
	  * @param @return 
	    
	  * @return FiduciaryLoan    
	 
	  *
	  * @author lishaozhang
	  * @createDate 2018年10月24日
	  */
	 FiduciaryLoan findByEntry_number(String entry_number);
	 
	 
	 /**
	  * 
	 *
	  * @Title: findLastCompact
	 
	  * @description  获取最后一条插入合同表的合同信息
	 *
	  * @param @return 
	    
	  * @return Compact    
	 
	  *
	  * @author lishaozhang
	  * @createDate 2018年10月24日
	  */
	 Compact findLastCompact();
	 
	 /**
	  * 
	 *
	  * @Title: updateCompactByContract_id
	 
	  * @description 根据id修改合同表
	 *
	  * @param @param id
	  * @param @return 
	    
	  * @return Compact    
	 
	  *
	  * @author lishaozhang
	 * @return 
	  * @createDate 2018年10月24日
	  */
	  int updateCompactByid (Compact compact);
	 
	 
	 /**
	  * 
	 *
	  * @Title: findCompactByEntry_number
	 
	  * @description 根据 报单编号查询合同
	 *
	  * @param @param Entry_number
	  * @param @return 
	    
	  * @return Compact    
	 
	  *
	  * @author lishaozhang
	  * @createDate 2018年10月24日
	  */
	 List<Compact> findCompactByEntry_number(String Entry_number);
		
	/**
	 * 
	*
	 * @Title: findAllCompact
	
	 * @description 查询所有合同表
	*
	 * @param @return 
	   
	 * @return List<Compact>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年10月25日
	 */
	 List<Compact> findAllCompact(@Param("star") int star,@Param("limit") int limit);
	 
	 /**
	  * 
	 *
	  * @Title: deleteCompactByReport_id
	 
	  * @description 根据报单编号删除合同表
	 *
	  * @param @param report_id
	  * @param @return 
	    
	  * @return int    
	 
	  *
	  * @author lishaozhang
	  * @createDate 2018年10月25日
	  */
	int deleteCompactByReport_id(String report_id );
	
	/**
	 * 
	*
	 * @Title: deleteCompactByid
	
	 * @description 根据主键id删除合同表
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return int    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年10月25日
	 */
	int deleteCompactByid(@Param("id")Long id );
	
	/**
	 * 
	*
	 * @Title: findOneCompactByEntry_number
	
	 * @description 根据报单编号查询一条图片为空的数据
	*
	 * @param @param Entry_number
	 * @param @return 
	   
	 * @return Compact    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年10月26日
	 */
	Compact findOneCompactByEntry_number(String Entry_number);
	
	/**
	 * 
	*
	 * @Title: findAllCompactImgIsNull
	
	 * @description 分页查询所有未上传图片的合同表
	*
	 * @param @return 
	   
	 * @return List<Compact>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月9日
	 */
	List<Compact> findAllCompactImgIsNull(@Param("star")int star,@Param("limit")int limit);
	
	/**
	 * 
	*
	 * @Title: findAllCompactImgIsNotNull
	
	 * @description 分页查询所有已经传图片的合同表
	*
	 * @param @param star
	 * @param @param limit
	 * @param @return 
	   
	 * @return List<Compact>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月9日
	 */
	List<Compact> findAllCompactImgIsNotNull(@Param("star")int star,@Param("limit")int limit);
	
	/**
	 * 
	 */
	List<Compact> findAllCompactCount();
	/**
	 * 
	 */
	Integer findAllCompactImgIsNullCount();
	/**
	 * 
	 * 
	 */
	List<Compact> findAllCompactImgIsNotNullCount();
}
