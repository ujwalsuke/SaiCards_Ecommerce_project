package com.saicards.utility;

import java.io.FileInputStream;

import javax.servlet.http.Part;

import org.apache.tomcat.util.codec.binary.Base64;

public class Storage {
	
	public void savePhoto(Part part, int id) {
		
		try {
			part.write("c:/images/"+id+".jpg");
			
		} catch (Exception e) {
			System.out.println("Storage class utility error"+e.getMessage());
		}
		
	}
	
	public String getPhoto(int id) {
		try {
			FileInputStream fin = new FileInputStream("c:/images/"+id+".jpg");
			int size = fin.available();
			byte arr[]= new byte[size];
			fin.read(arr);
			fin.close();
			byte[] base64data = Base64.encodeBase64(arr);
			String imgdata = new String(base64data,"UTF-8");
			return imgdata;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "imgerror";
	}

}
