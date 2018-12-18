package com.aartek.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.aartek.model.Products;

@Component
public class MultiPartUtil {
	public String multiPartFile(Products pro, HttpServletRequest req) {
		String fileName = null;
		MultipartFile file = (MultipartFile) pro.getImagefile();
		System.out.println(file.getSize());
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths
						.get("F://Prestige Java//SpringBoot//zohoboot//zohoadminboot//src//main//webapp//upload//"
								+ file.getOriginalFilename());
				Files.write(path, bytes);
				fileName = file.getOriginalFilename();
				// getting file Name
				/*
				 * MultipartHttpServletRequest multiReq =
				 * (MultipartHttpServletRequest) req; CommonsMultipartFile
				 * multipartfile = null; Iterator<String> it =
				 * multiReq.getFileNames(); while (it.hasNext()) { String key =
				 * (String) it.next(); multipartfile = (CommonsMultipartFile)
				 * multiReq.getFile(key); } System.out.println((String)
				 * multipartfile.getOriginalFilename()); fileName = (String)
				 * multipartfile.getOriginalFilename(); // Create the file on
				 * folder File serverFile = new File(
				 * "F://Prestige Java//SpringBoot//zohoboot//zohoadminboot//src//main//webapp//upload"
				 * + File.separator + (String)
				 * multipartfile.getOriginalFilename());
				 * 
				 * BufferedOutputStream stream = new BufferedOutputStream(new
				 * FileOutputStream(serverFile)); stream.write(bytes);
				 * stream.close();
				 */

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return fileName;
	}
}
