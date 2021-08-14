package com.halim.web.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.halim.model.ShoppingCart;
import com.halim.web.service.ProductService;
import com.halim.web.service.ShoppingCartService;

@ControllerAdvice
public class GeneralController {
	@Autowired
	private ShoppingCartService  shoppingCartService;
	@Autowired
	private ProductService  productService;
	
	@ModelAttribute
	public void populateModel(Model model, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
		if(sessionToken == null) {
			model.addAttribute("shoppingCart", new ShoppingCart());
		}
		else {
			model.addAttribute("shoppingCart", shoppingCartService.getShoppingCartBySessionTokent(sessionToken));
		}
		model.addAttribute("categories",productService.getAllCategories());
	}

}
