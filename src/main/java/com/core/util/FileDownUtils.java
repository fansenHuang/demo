package com.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownUtils {
	
	
    /**  
     * 文件下载功能  
     * @param request  
     * @param response  
     * @throws Exception  
     */  
    public static void down(String fileUrlName,HttpServletRequest request,HttpServletResponse response) throws Exception{  
       /* //下载
        String fileName = new DBInfoUtils("config.properties").getValue("downloadFilePath")+"/aa.docx"; */ 
        //获取输入流  
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileUrlName)));  
        
        int index = fileUrlName.lastIndexOf("/");
        String filename = fileUrlName.substring(index+1);
        
        //转码，免得文件名中文乱码  
        filename = URLEncoder.encode(filename,"UTF-8");  
        //设置文件下载头  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
        response.setContentType("multipart/form-data");
        ServletOutputStream outputStream = response.getOutputStream();
        BufferedOutputStream bout = new BufferedOutputStream(outputStream);  
        int len = 0;  
        while((len = bis.read()) != -1){
        	bout.write(len);  
        	bout.flush();  
        }
        
        bout.close();
        bis.close();
    }   
}
