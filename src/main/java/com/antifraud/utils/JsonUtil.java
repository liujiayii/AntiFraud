package com.antifraud.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

/**
 * json工具类
 *
 * @ClassName: JsonUtil
 * @description 
 *
 * @author lujinpeng
 * @createDate 2018年10月31日-下午2:26:00
 */
public class JsonUtil {

	private static Logger logger = Logger.getLogger(JsonUtil.class);
	
	public static String getResponseJson(Integer code, String msg, Integer count, Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("count", count);
        if (count == null) {
        	count = 0;
        }
        if (obj == null) {
            obj = "null";
        }
        map.put("data", obj);
        String json = JSONObject.toJSONString(map);
        
        return json;
    }
	
	
	/**
	 * 获取json
	 * 
	 * @param url
	 * @return
	 */
	public static String loadJson(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(url);
			URLConnection uc = urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
}
