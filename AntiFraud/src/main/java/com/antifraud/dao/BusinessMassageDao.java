package com.antifraud.dao;


import com.antifraud.entity.BusinessMassage;

/**
 * 
 *
 * @ClassName: BusinessMassageDao

 * @description 补充手续借款人业务信息表
 *
 * @author lishaozhang
 * @createDate 2018年11月23日
 */
public interface BusinessMassageDao {
    
    int insert(BusinessMassage record);

    BusinessMassage findTBusinessMassageByEntry_number(String entry_number);
    
}