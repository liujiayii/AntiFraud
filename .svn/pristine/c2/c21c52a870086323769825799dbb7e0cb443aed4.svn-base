package com.antifraud.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.LoanInformation;

public interface LoanService {

	/*插入普惠平台穿过来的数据*/
	int AddLoanInformation(LoanInformation loanInformation);
	/*获取当前期数的数据*/
	List<LoanInformation> listLoanInformation(String time,int page,int size);
	

}
