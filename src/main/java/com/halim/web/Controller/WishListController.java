package com.halim.web.Controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.halim.web.service.WishListService;

@Controller
public class WishListController {
	@Autowired
	private WishListService wishListService;
	
	@GetMapping("/addToWishlist/{id}")
	public String addToWishList(@PathVariable("id") Long id, HttpServletRequest request) {
		// sessiontToken
				String sessionToken = (String) request.getSession(true).getAttribute("sessiontTokenWishList");
				if (sessionToken == null) {

					sessionToken = UUID.randomUUID().toString();
					request.getSession().setAttribute("sessiontTokenWishList", sessionToken);
					wishListService.addToWishFirstTime(id, sessionToken);
				} else {
					wishListService.addToExistingWishList(id, sessionToken);
				}
		
		return "redirect:/";
	}
	@GetMapping("/removeWishListItem/{id}")
	public String removeItem(@PathVariable("id") Long id, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontTokenWishList");
		System.out.println("got here ");
		wishListService.removeItemWishList(id, sessionToken);
		return "redirect:/shoppingCart";
	}
	
	@GetMapping("/clearWishList")
	public String clearShoopiString(HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontTokenWishList");
		request.getSession(false).removeAttribute("sessiontTokenWishList");
		wishListService.clearWishList(sessionToken);
		return "redirect:/shoppingCart";
	}
	

}
