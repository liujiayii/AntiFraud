package com.antifraud.controller;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyun.oss.model.SetBucketLifecycleRequest;
import com.antifraud.dao.CompactDao;
import com.antifraud.dao.PhotoDao;
import com.antifraud.dao.ReplenishProcedureImageDao;
import com.antifraud.entity.Compact;
import com.antifraud.entity.Photo;
import com.antifraud.entityVO.PostLoanManageVo;
@Controller
@RequestMapping("update")
public class UpdateFielUrlContorller {
	private static String endpoint = "http://oss-cn-zhangjiakou.aliyuncs.com";
    private static String accessKeyId = "LTAILXMrV4PXgX4z";
    private static String accessKeySecret = "h38zzq6DgpukdxmyTWsrWwaRaTp9v9";
    private static String bucketName = "ouyepuhui";
    private static String picLocation="data/attachments/";
    private static String Key = "key";
    private static String ruleId0 = "rule0";
    private static String matchPrefix0 = "A0/";
       
    @Autowired
    private PhotoDao photoDao;
    @Autowired
    private CompactDao  compactDao;
    @Autowired
    private ReplenishProcedureImageDao replenishProcedureImageDao;
	
	/*public static void main(String[] args) {
		
	
	String s="http://system-im.oss-cn-beijing.aliyuncs.com/data/attachments/37BE77EFEA2D4671A84CFA217F3367CC.jpg?Expires=1545895116&OSSAccessKeyId=LTAIvnDBZYK3DLbL&Signature=etCOwRC%2BCA1odmk0jqoQRnnc8gU%3D";
	System.out.println(s.substring(s.indexOf("data/"),s.indexOf("?")));
	}*/
	
   
	@RequestMapping("updatefile")  
    public void update(){
    	List<Photo> listAll = photoDao.listAll();
    	
       for (Photo photo : listAll) {
    	   try {
			
		
    	  System.out.println(photo);
    	String ur  =   photo.getImg_url().toString();
    	Key=ur.substring(ur.indexOf("data/"),ur.indexOf("?"));
	 	    	
	   OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	    
	   Date expiration = new Date(new Date().getTime() + 3600l* 1000*24*365*10);
	   
	    URL url = ossClient.generatePresignedUrl(bucketName, Key, expiration);	
	   
	    System.out.println("url"+url);
	    photo.setImg_url(url.toString());
	    photoDao.updateByPrimaryKey(photo);
		 ossClient.shutdown();
    	   } catch (Exception e) {
   			
   		}
       }
       
       List<Compact> findAllCompact = compactDao.findAllCompact(0, 100000);
       try {
		
	} catch (Exception e) {
		// TODO: handle exception
	}
       for (Compact compact : findAllCompact) {
    	   try {
			
		
    	   System.out.println(compact);
       	String ur  =   compact.getImg_url().toString();
       	Key=ur.substring(ur.indexOf("data/"),ur.indexOf("?"));
   	 	    	
   	   OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
   	    
   	   Date expiration = new Date(new Date().getTime() + 3600l* 1000*24*365*10);
   	   
   	    URL url = ossClient.generatePresignedUrl(bucketName, Key, expiration);	
   	   
   	    System.out.println("url"+url);
   	 compact.setImg_url(url.toString());
    	compactDao.updateCompactByid(compact);
   		 ossClient.shutdown();
    	   } catch (Exception e) {
   			// TODO: handle exception
   		}
	}
    	
       
       
      /* List<PostLoanManageVo> findAllFiduciary = replenishProcedureImageDao.findAllFiduciary(0, 10000);
       for (PostLoanManageVo postLoanManageVo : findAllFiduciary) {
    	    String ur = postLoanManageVo.getImg_url();
    	 
         	Key=ur.substring(ur.indexOf("data/"),ur.indexOf("?"));
    	   
    	   OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
      	    
	   	   Date expiration = new Date(new Date().getTime() + 3600l* 1000*24*365*10);
	   	   
	   	    URL url = ossClient.generatePresignedUrl(bucketName,Key , expiration);
	    	 postLoanManageVo.setImg_url(url.toString());
	    	 
	    	 replenishProcedureImageDao.update
	}*/
    	
    }
	
	
//	
	@RequestMapping("updateone")
	public void upone(){
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
   	    
	   	   Date expiration = new Date(new Date().getTime() + 3600l* 1000*24*365*10);
	   	   
	   	    URL url = ossClient.generatePresignedUrl(bucketName, "/data/attachments/FFE16BABC3414F97A7804917B36AA888.jpg", expiration);	
	System.out.println(url);
	}
        	
}
