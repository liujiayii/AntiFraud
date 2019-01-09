package com.antifraud.utils;

import java.io.IOException;
import org.apache.http.client.fluent.*;
import org.apache.http.entity.ContentType;
import org.apache.log4j.Logger;
/**
 * Linkface 金融云 API
 *
 * @ClassName: LinkfaceAntiFraud

 * @description 
 *
 * @author lujinpeng
 * @createDate 2018年11月20日-上午10:43:26
 */
public class LinkfaceAntiFraud {

	private final static Logger logger = Logger.getLogger(LinkfaceAntiFraud.class);
	
	/**
	 * 通过姓名、身份证号验证该用户是否有在多家借贷平台进行过贷款申请行为
	 *
	 * @Title: LongBorrowing
	
	 * @description 
	 *
	 * @param name 借贷人姓名
	 * @param id_number 借贷人身份证号
	 * @param @return 
	   
	 * @return Content    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月20日-上午11:25:29
	 */
	public static Content LongBorrowing(String name, String id_number) {
		Content content = null;
		
		try {
	       
	      // Create request
	      content = Request.Post("https://cloudapi.linkface.cn/data/check_multi_applications")
	      // Add headers
	      .addHeader("Content-Type", "application/json; charset=utf-8")
	      // Add body
	      .bodyString("{\"api_secret\": \"d56afc378a214547843dc38d42423223\",\"id_number\": \" " + id_number + " \",\"api_id\": \"2649ae6ac9044fb3987ee5279e36ca3b\",\" " + name + " \": \"NAME\"}", ContentType.APPLICATION_JSON)
	      // Fetch request and return content
	      .execute().returnContent();

	    } catch (IOException e) {
	    	e.printStackTrace();
	    	logger.error(e.getMessage());
	    }
	    
	    return content;
	  
	}
	
}
