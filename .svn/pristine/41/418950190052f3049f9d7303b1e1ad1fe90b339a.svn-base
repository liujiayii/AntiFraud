package com.softkey;

public class jsyunew3 {

	//获到锁的版本
		public static native int GetVersion(String InPath);
		//获到锁的扩展版本
		public static native int GetVersionEx(String InPath);
		//获到锁的ID
		public static native long GetID_1(String InPath);
		public static native long GetID_2(String InPath);
		//返回最后的错误信息
		public static native long get_LastError();
		//查找加密锁
		public static native String FindPort(int start);

		//设置读密码
		public static native int SetReadPassword(String W_hkey, String W_lkey, String new_hkey, String new_lkey, String InPath);
		//设置写密码
		public static native int SetWritePassword(String W_hkey, String W_lkey, String new_hkey, String new_lkey, String InPath);

		//从加密锁中读取一批字节
		public static native int YReadEx(short Address, short len, String HKey, String LKey, String InPath);
		//从加密锁中读取一个字节，一般不使用
		public static native int YRead(short Address, String HKey, String LKey, String InPath);
		//从缓冲区中获得数据
		public static native short GetBuf(int pos);
		//写一批字节到加密锁中
		public static native int YWriteEx(short Address, short len, String HKey, String LKey, String InPath);
		//写一个字节到加密锁中，一般不使用
		public static native int YWrite(short inData, short Address, String HKey, String LKey, String InPath);
		//设置要写入的缓冲区的数据
		public static native int SetBuf(int pos, short Data);
		//从加密锁中读字符串-新
		public static native String NewReadString(int Address, int len, String HKey, String LKey, String InPath);
		//写字符串到加密锁中-新
		public static native int NewWriteString(String InString, int Address, String HKey, String LKey, String InPath);
		//兼容旧的读写字符串函数，不再使用
		public static native String YReadString(short Address, short len, String HKey, String LKey,String InPath);
		public static native int YWriteString(String InString, short Address, String HKey, String LKey,String InPath);
		//'设置增强算法密钥一
		public static native int SetCal_2(String Key, String InPath);
		//使用增强算法一对字符串进行加密
		public static native String EncString(String InString, String InPath);
		//使用增强算法一对二进制数据进行加密
		public static native int Cal(String InPath);

		//使用增强算法对字符串进行解密
		public static native String DecString(String InString, String Key);
		//设置要加密的缓冲区的数据
		public static native int SetEncBuf(int pos, short Data);
		//从缓冲区中获取加密后的数据
		public static native short GetEncBuf(int pos);
		
		//返回加密锁的公钥对
		public static native String GetPubKeyX(String InPath);
		public static native String GetPubKeyY(String InPath);
		//生成SM2密钥对，获取私钥及公钥
		public static native String get_GenPriKey();
		public static native String get_GenPubKeyX();
		public static native String get_GenPubKeyY();
		//生成SM2密钥对,产生密钥对
		public static native int StarGenKeyPair(String InPath);
		public static native String SM2_EncString(String InString,String InPath);
		public static native String SM2_DecString(String InString,String Pin,String InPath);
		public static native int YtSetPin(String OldPin,String NewPin,String InPath);
		//对消息进行签名
		public static native String YtSign(String msg,String Pin,String InPath);
		//对签名进行验证
		public static native boolean YtVerfiy(String id,String msg,String PubKeyX,String  PubKeyY,String VerfiySign,String InPath);
		//设置SM2密钥对及身份
		public static native int Set_SM2_KeyPair(String PriKey,String PubKeyX,String PubKeyY,String sm2UserName,String InPath);
		//获取加密锁中的身份
		public static native String GetSm2UserName(String InPath);
		//返回锁的硬件芯片唯一ID
		public static native String GetChipID(String InPath);
		//查找加密锁，返回的是U盘的路径,即U盘的盘符，通过这个路径也可以直接操作锁
		public static native String FindU(int start);
		//查找指定的加密锁（使得普通算法二），返回的是U盘的路径,即U盘的盘符，通过这个路径也可以直接操作锁
		public static native String FindU_3(int start,int in_data,int verf_data);
		//查找指定的加密锁（使得普通算法一），返回的是U盘的路径,即U盘的盘符，通过这个路径也可以直接操作锁
		public static native String FindU_2(int start,int in_data,int verf_data);
		//设置U盘部分为只读状态，
		public static native int SetUReadOnly(String InPath);
		//设置是否显示U盘部分盘符，真为显示，否为不显示
		public static native int SetHidOnly(boolean IsHidOnly,String InPath);
		//返回U盘部分是否为只读状态，真为只读
		public static native boolean IsUReadOnly(String InPath);

		//***初始化加密锁函数
		public static native int ReSet(String Path);

		static {
			
			System.loadLibrary("jsyunew3");
		}
		
	
	
	
	
	
}
