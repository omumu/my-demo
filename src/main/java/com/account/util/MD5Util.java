package com.account.util;

import java.security.MessageDigest;

public class MD5Util {
	public static String md5Encode(String inStr){
		MessageDigest md5=null;
		try{
			md5=MessageDigest.getInstance("MD5");
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		byte[] byteArray=inStr.getBytes();
		byte[] md5Bytes=md5.digest(byteArray);
		StringBuilder hexValue=new StringBuilder();
		for(int i=0;i<md5Bytes.length;i++){
			int val=((int)md5Bytes[i])&0xff;
			if(val<16){
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	public static void main(String[] args) {
		String str = new String("123456");
        System.out.println("原始：" + str);
        System.out.println("MD5后：" + md5Encode(str));
        System.out.println("MD5后：" + md5Encode(str).length());
	}
}
