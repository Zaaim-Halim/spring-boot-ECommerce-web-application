package com.halim.web.Controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.halim.model.ShoppingCart;
import com.halim.web.service.ShoppingCartService;

@Controller
public class CartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@PostMapping("/addToCart")
	public String addToCart(HttpServletRequest request, Model model, @RequestParam("id") Long id,
			@RequestParam("quantity") int quantity) {

		// sessiontToken
		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
		if (sessionToken == null) {

			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("sessiontToken", sessionToken);
			shoppingCartService.addShoppingCartFirstTime(id, sessionToken, quantity);
		} else {
			shoppingCartService.addToExistingShoppingCart(id, sessionToken, quantity);
		}
		return "redirect:/";
	}
	
	@GetMapping("/shoppingCart")
	public String showShoopingCartView(HttpServletRequest request, Model model) {
		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
		if (sessionToken == null) {
			model.addAttribute("shoppingCart", new ShoppingCart());	
		}
		else {
			ShoppingCart shoppigCart = shoppingCartService.getShoppingCartBySessionTokent(sessionToken);
			model.addAttribute("shoppingCart", shoppigCart);
		}
		return "shoppingCart";
	}

}
