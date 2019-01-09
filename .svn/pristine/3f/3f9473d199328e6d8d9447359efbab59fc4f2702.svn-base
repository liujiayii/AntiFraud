package com.antifraud.utils;


	
	
	
	
	import com.alibaba.fastjson.JSONObject;
	 
	import java.io.BufferedReader;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.util.HashMap;
	import java.util.Map;
	 
	/**
	 * @Description:运营商和归属地查询
	 * @Author:ghw
	 * @Date:2018/8/29
	 **/
	public class Test {
	 
	    public static Map<String, String> interfaceUtil(String phone) {
	        StringBuilder r = new StringBuilder();
	        try {
	            //淘宝URL
//	            URL url = new URL("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="+phone);
	            //360URL
	            URL url = new URL("https://cx.shouji.360.cn/phonearea.php?number="+phone);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            PrintWriter out = null;
	            conn.setRequestProperty("accept", "*/*");
	            conn.setDoOutput(true);
	            out = new PrintWriter(conn.getOutputStream());
	            out.flush();
	            InputStream is = conn.getInputStream();
	            BufferedReader br = new BufferedReader(new InputStreamReader(is,"gb2312"));
	            String result = "";
	            while ((result = br.readLine()) != null) {
	                r.append(result);
	            }
	            is.close();
	            conn.disconnect();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	 
/*	        //淘宝返回结果处理
//	        r = r.replaceAll("__GetZoneResult_ = ", "");
//	        JSONObject jsonObject = JSONObject.parseObject(r);
//	        String catName = jsonObject.get("catName").toString();
//	        String carrier = jsonObject.get("carrier").toString();
//	        Map<String,String> map = new HashMap<>();
//	        map.put("location",catName);
//	        map.put("operator",carrier);
//	        return map;
*/	 
	 
	 
	        //360返回结果处理
	        JSONObject resultObj = JSONObject.parseObject(r.toString());
	        JSONObject data = (JSONObject) resultObj.get("data");
	        Map<String,String> map = new HashMap<>();
	        String province;
	        String city;
	        String sp;
	        try {
	            province = data.get("province").toString();
	            city = data.get("city").toString();
	            sp = data.get("sp").toString();
	        }catch (NullPointerException e){
	            province = "";
	            city = "";
	            sp = "";
	        }
	        map.put("location",province+city);
	        map.put("operator",sp);
	 
	        return map;
	    }
	 
	 
	    public static void main(String[] args) throws Exception{
	        Map<String, String> map = interfaceUtil("13932165955");
	        String location = map.get("location");
	        String operator = map.get("operator");
	        System.out.println("location:"+location+"\noperator:"+operator);
	    }
	 
	 
	    /**
	     * 360返回来的中文为unicode,需要转换
	     */
	    private static String ascii2native ( String asciicode )
	    {
	        String[] asciis = asciicode.split ("\\\\u");
	        String nativeValue = asciis[0];
	        try
	        {
	            for ( int i = 1; i < asciis.length; i++ )
	            {
	                String code = asciis[i];
	                nativeValue += (char) Integer.parseInt (code.substring (0, 4), 16);
	                if (code.length () > 4)
	                {
	                    nativeValue += code.substring (4, code.length ());
	                }
	            }
	        }
	        catch (NumberFormatException e)
	        {
	            return asciicode;
	        }
	        return nativeValue;
	    }

	}

