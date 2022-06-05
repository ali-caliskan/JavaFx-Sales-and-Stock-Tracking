package com.Mysql.Util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.*;


public class VeritabaniAyarlari {
	static Connection conn=null;
	private static final String DATABASE_URL = "jdbc:mysql://localhost/satisstok";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "";
	public static Connection Connect() {

		try {
			conn=DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
			// TODO: handle exception
		}
	}

	public static String MD5Encryption(String content){
	try {
		MessageDigest md=MessageDigest.getInstance("MD5");
		byte[]hashInBytes= md.digest(content.getBytes());


		BigInteger no= new BigInteger(1,hashInBytes);
		String hashcontent=no.toString(16);
		while (hashcontent.length()<32) {
			hashcontent="0"+hashcontent;

		}
		return hashcontent;
	} catch (NoSuchAlgorithmException e) {
		System.out.println(e.getMessage());
		throw new RuntimeException(e);
	}


	}
	
	

}
