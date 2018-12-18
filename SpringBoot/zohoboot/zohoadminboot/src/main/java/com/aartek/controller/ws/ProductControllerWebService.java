package com.aartek.controller.ws;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.model.Products;
import com.aartek.model2.ProductImage;
import com.aartek.service.ProductsService;

@Controller
public class ProductControllerWebService {
	@Autowired
	private ProductsService proService;

	@RequestMapping(value="/productView",method=RequestMethod.POST)
	@ResponseBody
	public Products getProducts(@RequestBody Products product,HttpServletRequest req){
		System.out.println("WebService Of Products");
		Enumeration e = req.getHeaderNames();
		String version = null;
		while(e.hasMoreElements()){
			String name = (String)e.nextElement();
		   // System.out.println(name);
			if(name.equals("versionnumber")){
				version = req.getHeader(name);
			}
		}
		System.out.println(version);
		if(version.equals("1.0")){
		Products pro = proService.getProducts(product);
		List<ProductImage> list = pro.getProImg();
		Iterator<ProductImage> it = list.iterator();
		while(it.hasNext()){
			ProductImage proImg = (ProductImage)it.next();
			System.out.println(proImg.getImgName()+"---"+proImg.getImgId());
		}
		pro.setProductName("Dell Laptop");
	    return pro;
		}
		if(version.equals("2.0")){
			Products pro = proService.getProducts(product);
			List<ProductImage> list = pro.getProImg();
			Iterator<ProductImage> it = list.iterator();
			while(it.hasNext()){
				ProductImage proImg = (ProductImage)it.next();
				System.out.println(proImg.getImgName()+"---"+proImg.getImgId());
			}
			pro.setProductName("Accer Laptop");
		    return pro;
		}
		else{
			Products pro = proService.getProducts(product);
			List<ProductImage> list = pro.getProImg();
			Iterator<ProductImage> it = list.iterator();
			while(it.hasNext()){
				ProductImage proImg = (ProductImage)it.next();
				System.out.println(proImg.getImgName()+"---"+proImg.getImgId());
			}
			pro.setProductName("Sony Vio Laptop");
		    return pro;
		}
	}
}
