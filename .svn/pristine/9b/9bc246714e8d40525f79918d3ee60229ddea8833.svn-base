package com.antifraud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antifraud.dao.LoanInfomationDao;
import com.antifraud.entity.LoanInformation;
import com.antifraud.service.LoanService;
@Service
public class LoanServiceImpl implements LoanService {
	
	 @Autowired
	 private LoanInfomationDao loanInfomationDao;
	

	@Override
	public int AddLoanInformation(LoanInformation loanInformation) {
		
		return loanInfomationDao.AddLoanInformation(loanInformation);
	}

	@Override
	public List<LoanInformation> listLoanInformation(String time, int page, int size) {
	
		return loanInfomationDao.listLoanInformation(time, page, size);
	}

}
