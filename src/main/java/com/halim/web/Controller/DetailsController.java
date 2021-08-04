package com.halim.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.halim.model.Product;
import com.halim.web.service.ProductService;

@Controller
public class DetailsController {
	@Autowired
	private ProductService productService;

	@GetMapping("/detail/{id}")
	public String showIndex(@PathVariable("id") Long id, Model model) {
		Product produt = productService.getProductById(id);
		model.addAttribute("product", produt);
		return "details";
	}
}
