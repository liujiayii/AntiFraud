package com.antifraud.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antifraud.dao.UkeyDao;
import com.antifraud.entity.Ukey;
import com.antifraud.service.UkeyService;

/**
 * U盾业务层实现类
 *
 * @ClassName: UkeyServiceImpl

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月18日-上午10:25:12
 */
@Service
public class UkeyServiceImpl implements UkeyService {

	@Autowired
	private UkeyDao ukeyDao;
	
	/**
	 * 添加U盾
	 */
	@Override
	public int insertUkeyAll(Ukey ukey) {
		
		return ukeyDao.insertUkeyAll(ukey);
	}

	/**
	 * 插入指定字段数据
	 */
	@Override
	public int insertSelective(Ukey ukey) {
		
		return ukeyDao.insertSelective(ukey);
	}

	/**
	 * 修改指定字段
	 */
	@Override
	public int updateByIdSelective(Ukey ukey) {
		
		return ukeyDao.updateByIdSelective(ukey);
	}

	/**
	 * 删除
	 */
	@Override
	public int deleteById(Long id) {
		
		return ukeyDao.deleteById(id);
	}

	/**
	 * 通过主键查询
	 */
	@Override
	public Ukey selectById(Long id) {
		
		return ukeyDao.selectById(id);
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<Ukey> findByLimit(Integer page, Integer size) {
		
		return ukeyDao.findByLimit(page, size);
	}

	/**
	 * 查询总条数
	 */
	@Override
	public int getCount() {
		
		return ukeyDao.getCount();
	}

	/**
	 * 通过账号查询
	 */
	@Override
	public Ukey selectByUserName(String ukey_user) {
		
		return ukeyDao.selectByUserName(ukey_user);
	}

	/**
	 * 修改U盾状态
	 */
	@Override
	public int updateUkeyStatById(Ukey ukey) {
		
		return ukeyDao.updateUkeyStatById(ukey);
	}

	/**
	 * 通过U盾编号查询
	 */
	@Override
	public List<Ukey> selectByUkeySn(String ukey_sn,Integer page,Integer limit) {
		Integer star = null;
		
		if (page != null && limit != null) {
			star = (page - 1)* limit;
		}
		
		return ukeyDao.selectByUkeySn(ukey_sn,star,limit);
	}

}
