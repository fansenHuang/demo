package com.core.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.core.util.DBInfoUtils;
import com.system.config.ParametersConfig;

public class FileUploadUtils {

	public static File upload(MultipartFile file, String rootPath,HttpServletRequest request) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		String res = sdf.format(new Date());

		// uploads文件夹位置
//		String rootPath = new DBInfoUtils("config.properties").getValue("uploadFilePath");
		
		// 原始名称
		String originalFileName = file.getOriginalFilename();

		// 新文件名
		String newFileName = res + originalFileName.substring(originalFileName.lastIndexOf("."));
		// 创建年月文件夹
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMM");
		String dir = sdf1.format(new Date());
		// 年月日文件夹
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String zdir = sdf2.format(new Date());
		File dateDirs = new File(dir + File.separator + zdir);

		// 新文件
//		File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
		
		File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
		// 判断目标文件所在目录是否存在
		if (!newFile.getParentFile().exists()) {
			// 如果目标文件所在的目录不存在，则创建父目录
			newFile.getParentFile().mkdirs();
		}
		System.out.println(newFile);
		// 将内存中的数据写入磁盘
		file.transferTo(newFile);
		// 完整的url
		// String fileUrl = date.get(Calendar.YEAR) + "/" +
		// (date.get(Calendar.MONTH)+1) + "/" + newFileName;
		return newFile;
	}

	public static File upload(MultipartFile file, HttpServletRequest request, String fileName) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		//String res = sdf.format(new Date());

		// uploads文件夹位置
		String rootPath = new DBInfoUtils("config.properties").getValue("uploadFilePath");
		// 原始名称
		String originalFileName = file.getOriginalFilename();

		// 新文件名
		String newFileName = fileName + originalFileName.substring(originalFileName.lastIndexOf("."));
		// 创建年月文件夹
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMM");
		String dir = sdf1.format(new Date());
		// 年月日文件夹
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String zdir = sdf2.format(new Date());
		File dateDirs = new File(dir + File.separator + zdir);

		// 新文件
		File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
		// 判断目标文件所在目录是否存在
		if (!newFile.getParentFile().exists()) {
			// 如果目标文件所在的目录不存在，则创建父目录
			newFile.getParentFile().mkdirs();
		}
		System.out.println(newFile);
		// 将内存中的数据写入磁盘
		file.transferTo(newFile);
		// 完整的url
		// String fileUrl = date.get(Calendar.YEAR) + "/" +
		// (date.get(Calendar.MONTH)+1) + "/" + newFileName;
		return newFile;

	}
}
