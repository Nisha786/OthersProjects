package com.aartek.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aartek.model2.Products;

@Component
public class MultiPartUtil {
	public String multiPartFile(Products pro, HttpServletRequest req) {
		String fileName = null;
		MultipartFile file = (MultipartFile) pro.getImagefile();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				// getting file Name
				MultipartHttpServletRequest multiReq = (MultipartHttpServletRequest) req;
				CommonsMultipartFile multipartfile = null;
				Iterator<String> it = multiReq.getFileNames();
				while (it.hasNext()) {
					String key = (String) it.next();
					multipartfile = (CommonsMultipartFile) multiReq.getFile(key);
				}
				System.out.println((String) multipartfile.getOriginalFilename());
				fileName = (String) multipartfile.getOriginalFilename();
				// Create the file on folder
				File serverFile = new File(
						"F://Prestige Java//MavenZoho//ZOHO//ZOHO-Admin//src//main//webapp//upload"
								+ File.separator + (String) multipartfile.getOriginalFilename());

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
                    System.out.println(e);
			}
		}
		return fileName;
	}
}
