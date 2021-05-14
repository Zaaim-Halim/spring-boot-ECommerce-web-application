package com.halim.web.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.halim.web.model.Product;
import com.halim.web.service.ProductService;

@Controller
public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/Admin/index")
	public String showExampleView(Model model)
	{
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "Admin/index";
	}
    @GetMapping("/Admin/product")
    public String showAddProduct()
    {
    	
    	return "Admin/product";
    }
    
    @PostMapping("/Admin/addP")
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") int price,
    		@RequestParam("desc") String desc)
    {
    	productService.saveProductToDB(file, name, desc, price);
    	return "redirect:/Admin/index";
    }
    
    @GetMapping("/Admin/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
    	
    	productService.deleteProductById(id);
    	return "redirect:/Admin/index";
    }
    
    @PostMapping("/Admin/changeName")
    public String changePname(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name)
    {
    	productService.chageProductName(id, name);
    	return "redirect:/Admin/index";
    }
    @PostMapping("/Admin/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
    		@RequestParam("newDescription") String description)
    {
    	productService.changeProductDescription(id, description);
    	return "redirect:/Admin/index";
    }
    
    @PostMapping("/Admin/changePrice")
    public String changePrice(@RequestParam("id") Long id ,
    		@RequestParam("newPrice") int price)
    {
    	productService.changeProductPrice(id, price);
    	return "redirect:/Admin/index";
    }
    
}
