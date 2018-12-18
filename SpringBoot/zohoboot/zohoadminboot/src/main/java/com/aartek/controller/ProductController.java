package com.aartek.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.Products;
import com.aartek.model2.ProductImage;
import com.aartek.service.ProductsService;
import com.aartek.util.MultiPartUtil;
import com.aartek.validator.ProductValidator;

@Controller
public class ProductController {
	
	@Autowired
	private ProductValidator proValidator;
	@Autowired
	private ProductsService proService;

	@Autowired
	private MultiPartUtil multipartUtil;

	ProductImage proImg = new ProductImage();

	@PostMapping(value = "/products")
	public String showProducts(@ModelAttribute("productsMap") Products product, BindingResult result, Model model,
			HttpServletRequest req, HttpServletResponse res) {
		model.addAttribute("productRecords", proService.getAllProducts());
		proValidator.validate(product, result);
		if (result.hasErrors()) {
			return "products";
		}
		List<ProductImage> list = new ArrayList<ProductImage>();
		String name = multipartUtil.multiPartFile(product, req);
		if (name != null) {
			proImg.setImgName(name);
			list.add(proImg);
			product.setProImg(list);
		}
		String str = proService.productsAddService(product);
		if (str != null) {
			try {
				res.sendRedirect("products");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "products";
	}

	@GetMapping(value = "/products")
	public String showProductPage(Products product, Model model) {
		model.addAttribute("productRecords", proService.getAllProducts());
		model.addAttribute("productsMap", product);
		return "products";
	}

	@GetMapping(value = "/deleteRecord/{id}")
	public String deletrecords(@PathVariable Integer id) {
		Products pro = new Products();
		pro.setProductId(id);
		if (proService.deleteRecordById(pro) != null) {
			return "redirect:/products";
		}
		return "redirect:/products";
	}

	@GetMapping(value = "/editRecord/{id}")
	public String updateProduct(@PathVariable Integer id, Model model) {
		Products product = proService.findById(id);
		model.addAttribute("productRecords", proService.getAllProducts());
		model.addAttribute("productsMapUpdate", product);
		return "updateView";
	}

	@RequestMapping(value = "/productsUpdates/uppate",method=RequestMethod.POST)
	public String updateProducts(@ModelAttribute("productsMapUpdate") Products product, BindingResult result,
			Model model, HttpServletRequest req, HttpServletResponse res) {
		model.addAttribute("productRecords", proService.getAllProducts());
		proValidator.validate(product, result);
		if (result.hasErrors()) {
			return "updateView";
		}
		List<ProductImage> list = new ArrayList<ProductImage>();
		String name = multipartUtil.multiPartFile(product, req);
		if (name != null) {
			proImg.setImgName(name);
			list.add(proImg);
			product.setProImg(list);
		}
		proService.updateRecord(product);
		return "redirect:/products";
	}

}
