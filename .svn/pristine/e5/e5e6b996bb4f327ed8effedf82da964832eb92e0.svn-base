package com.antifraud.utils;

/*import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

//Access restriction: The type BASE64Decoder is not accessible due to restriction on required library ,java build path jre改成workspace 
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

*//**
 * DES加密 解密算法
 * @author zhangdi
 *
 *//*
public class DesUtil {

    private final static String DES = "DES";
    private final static String ENCODE = "GBK";

    

    
    *//**
     * Description 根据键值进行加密
     * @param data 待加密数据
     * @param key 密钥
     * @return
     * @throws Exception
     *//*
    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(ENCODE), key.getBytes(ENCODE));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    *//**
     * 根据键值进行解密
     * @param data 待解密数据
     * @param key    密钥
     * @return
     * @throws IOException
     * @throws Exception
     *//*
    public static String decrypt(String data, String key) throws IOException,
            Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, key.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }

    *//**
     * Description 根据键值进行加密
     * 
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     *//*
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    *//**
     * Description 根据键值进行解密
     * 
     * @param data
     * @param key 加密键byte数组
     * @return
     * @throws Exception
     *//*
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }
    
    public static void main(String[] args){
        String data = "_t=2018-10-13 10:37:17&auth_code=&id=27&mid=30&mmember_area_id=27&mrecharge_amount=100.0&payment_method=1";
        
        //ecf1ac9e9baecb933efb068afcab1249
        //密钥的长度必须是8的倍数
       // String key ="12345678abcdefgh";
        
         
         Date date = new Date();
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
 		String strs = sdf.format(date);
 		
 		
 		String key ="jqmmbshh";

        System.out.println("加密前===>"+data);
        try {
        	String e1=encrypt(data, key);
            System.out.println("指定key加密后===>"+e1);
            String d1=decrypt("2C3XVlQoMFvG/0DS8nrIH1oHcLMwjtLloZcIK1C IAYkcn5LlTtDfcN7/ v/JmcvexMaN8o8KhmlK5IPWVSdXyM1z4DhLy4j/9087TYVDG/piU9BSlaLh4hevr4qdTIcSl4ecLWCbvdUCu6hHRFBCg==", key);
           System.out.println("指定key解密后===>"+d1);
            
            
        //   加密前===>12AUism810jsqASI08
        	//	   指定key加密后===>JWtfwlWtpNjyPIVTNXHmG9a9gyR8o0lU
        	//	   指定key解密后===>12AUism810jsqASI08
       //    加密前===>12AUism810jsqASI08
        	//	   指定key加密后===>/EyJSjHBoqbROfJ/arVGoC7EFP+qOIVS
        	//	   指定key解密后===>12AUism810jsqASI08
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
   
    
}
*/



import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * @author zhaokaiqiang
 * @ClassName: com.qust.rollcallstudent.utils.DESUtil
 * @Description: DES加密解密工具包
 * @date 2014-11-13 下午8:40:56
 */
public class DesUtil {

    public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";

    /**
     * DES算法，加密
     *
     * @param data 待加密字符串
     * @param key  加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     * @throws InvalidAlgorithmParameterException
     * @throws Exception
     */
    public static String encode(String key, String data) {
        if (data == null)
            return null;
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] bytes = cipher.doFinal(data.getBytes());
            return byte2String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    /**
     * DES算法，解密
     *
     * @param data 待解密字符串
     * @param key  解密私钥，长度不能够小于8位
     * @return 解密后的字节数组
     * @throws Exception 异常
     */
    public static String decode(String key, String data) {
        if (data == null)
            return null;
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
            return new String(cipher.doFinal(byte2hex(data.getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    /**
     * 二行制转字符串
     *
     * @param b
     * @return
     */
    private static String byte2String(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase(Locale.CHINA);
    }

    /**
     * 二进制转化成16进制
     *
     * @param b
     * @return
     */
    private static byte[] byte2hex(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException();
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }



public static  String getrechargeMember(String _a,String _t) throws java.text.ParseException {
	
	
	System.out.println("_a------->>>>" + _a);
	SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date dates = sdfs.parse(_t);
	Date date = new Date();
	SimpleDateFormat sdd = new SimpleDateFormat("yyyyMMddHHmmss");

	long t_key = Long.parseLong(sdd.format(date));
	long tt = Long.parseLong(sdd.format(dates));
	long ty=t_key - tt;
	String sds="";
	if (ty <= 120) {
		 sds = DesUtil.decode("jqmmbshh", _a);
	}
	return sds;	
}
public static  Map<String,String> map(String sds){
	
	Map<String,String> maplist= new HashMap<String, String>();
	String[] src = sds.split("&");

	for (int a = 0; a < src.length; a++) {
		System.out.println("src[a]" + src[a]);
		String[] suzhu = src[a].toString().split("=");
		if (suzhu.length > 1) {
			maplist.put(suzhu[0], suzhu[1]);
		} 

	}
	return maplist;
}

}















