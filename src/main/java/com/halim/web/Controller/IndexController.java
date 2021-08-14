package com.halim.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.halim.model.Product;
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
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView search(@RequestParam("value") String value) {
		ModelAndView mv = new ModelAndView();;
		mv.setViewName("fragments/searchFragment");
		List<Product> products = productService.searchProductByNameLike(value);
		mv.addObject("products", products);
		return mv;
	}
}
