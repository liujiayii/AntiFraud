package com.antifraud.dao;

import com.antifraud.entity.OccupationalIinformation;
/**
 * 
 *
 * @ClassName: OccupationalInformationDao

 * @description 职业信息DAO
 *
 * @author lishaozhang
 * @createDate 2018年11月23日
 */
public interface OccupationalInformationDao {
    

    int insert(OccupationalIinformation record);

    OccupationalIinformation  findOccupationalInformationByEntry_number(String entry_number );

    
}