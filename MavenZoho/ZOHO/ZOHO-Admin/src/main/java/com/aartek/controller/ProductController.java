package com.aartek.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model2.Products;
import com.aartek.service.ProductService;
import com.aartek.util.MultiPartUtil;
import com.aartek.validator.ProductValidator;

@Controller
public class ProductController {

	@Autowired
	private ProductService proService;
	@Autowired
	private ProductValidator proValidator;
	@Autowired
	private MultiPartUtil multiPartUtil;

	@RequestMapping(value = "/products", method = { RequestMethod.GET, RequestMethod.POST })
	public String productAction(@ModelAttribute("productsMap") Products pro, BindingResult result, Model map,
			HttpServletRequest req, HttpServletResponse res) {
		/*
		 * System.out.println("Inside Product controller");
		 * System.out.println(pro.getProductname());
		 * System.out.println(pro.getPrice());
		 */
		String method = req.getMethod();
		map.addAttribute("productRecords", proService.getProducts());
		if ("GET".equals(method)) {
			System.out.println("Inside get Product Controoller");
			map.addAttribute("productsMap", new Products());
			return "product";
		} else {
			System.out.println("Inside Post Product Controoller");
			proValidator.validate(pro, result);
			if (result.hasErrors()) {
				return "product";
			} else {
				
                pro.setFileName(multiPartUtil.multiPartFile(pro,req));
				proService.addRecords(pro);
				try {
					
					res.sendRedirect("products.do");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return "product";
		}

	}
} 
