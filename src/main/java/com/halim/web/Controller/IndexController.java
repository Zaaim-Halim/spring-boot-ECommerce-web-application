package com.halim.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.halim.web.service.ProductService;

@Controller
public class IndexController {
	@Autowired
	private ProductService productService;
	@GetMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "index";
	}

}
