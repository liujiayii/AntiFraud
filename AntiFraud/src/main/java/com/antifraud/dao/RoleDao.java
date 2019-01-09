package com.antifraud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.Role;
import com.antifraud.entity.User;

public interface RoleDao {

	public List<Role> findAll() ;


	public List<Role> findByUser(@Param("id")Long id) ;


}
