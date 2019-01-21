package com.antifraud.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.Ukey;

/**
 * U盾表业务层
 *
 * @ClassName: UkeyService

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月18日-上午10:23:50
 */
public interface UkeyService {
	
	/**
	 * 添加U盾
	 *
	 * @Title: insertUkeyAll
	
	 * @description 
	 *
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午10:20:22
	 */
	int insertUkeyAll(Ukey ukey);
	
	/**
	 * 插入指定字段数据
	 *
	 * @Title: insertSelective
	
	 * @description 
	 *
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午10:20:57
	 */
	int insertSelective(Ukey ukey);
	
	/**
	 * 修改指定字段
	 *
	 * @Title: updateByIdSelective
	
	 * @description 
	 *
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午10:21:24
	 */
	int updateByIdSelective(Ukey ukey);
	
	/**
	 * 删除
	 *
	 * @Title: deleteById
	
	 * @description 
	 *
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午10:21:54
	 */
	int deleteById(Long id);
	
	/**
	 * 通过主键查询
	 *
	 * @Title: selectById
	
	 * @description 
	 *
	 * @return 
	   
	 * Ukey
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午10:23:04
	 */
	Ukey selectById(Long id);
	
	/**
	 * 分页查询
	 *
	 * @Title: findByLimit
	
	 * @description 
	 *
	 * @return 
	   
	 * List<Ukey>
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午10:36:29
	 */
	List<Ukey> findByLimit(Integer page, Integer size);
	
	/**
	 * 查询总条数
	 *
	 * @Title: getCount
	
	 * @description 
	 *
	 * @return 
	   
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午10:38:40
	 */
	int getCount();
	
	/**
	 * 通过账号查询
	 *
	 * @Title: selectByUserName
	
	 * @description 
	 *
	 * @param ukey_user
	 * @return 
	   
	 * Ukey
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-下午5:30:39
	 */
	Ukey selectByUserName(String ukey_user);
	
	/**
	 * 修改U盾状态（0正常，1锁定）
	 *
	 * @Title: updateUkeyStatById
	
	 * @description 
	 *
	 * @param ukey
	 * @return 
	 * int
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月21日-上午9:39:47
	 */
	int updateUkeyStatById (Ukey ukey);
	
	/**
	 * 通过U盾编号查询
	 *
	 * @Title: selectByUkeySn
	
	 * @description 
	 *
	 * @param ukey_sn
	 * @return 
	   
	 * Ukey
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月21日-上午11:46:33
	 */
	Ukey selectByUkeySn (String ukey_sn);

}
