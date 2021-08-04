package com.halim.web.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.halim.model.Category;
import com.halim.model.Product;
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
    public String showAddProduct(Model model)
    {
    	model.addAttribute("category", new Category());
    	model.addAttribute("categories", productService.getAllCategories());
    	model.addAttribute("products", productService.getAllProduct());
    	return "Admin/product";
    }
    
    @PostMapping("/Admin/addP")
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") Double price,
    		@RequestParam("desc") String desc
    		,@RequestParam("quantity") int quantity
    		,@RequestParam("brand") String brand,
    		@RequestParam("categories") String categories)
    {
    	
    	productService.saveProductToDB(file, name, desc,quantity, price,brand,categories);
    	return "redirect:/Admin/product";
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
    		@RequestParam("newPrice") Double price)
    {
    	
    	productService.changeProductPrice(id, price);
    	return "redirect:/Admin/index";
    }
    @PostMapping("/Admin/changeQuantity")
    public String changeQuantity(@RequestParam("id") Long id ,
    		@RequestParam("newQuantity") int quantity)
    {
    	
    	productService.changeProductQuantity(id, quantity);
    	return "redirect:/Admin/index";
    }
    
    @PostMapping("/Admin/changeDiscount")
    public String changeDiscount(@RequestParam("id") Long id ,
    		@RequestParam("newDiscount") int discount)
    {
    	
    	productService.changeProductDiscount(id, discount);
    	return "redirect:/Admin/index";
    }
    
    @PostMapping("/Admin/addCategory")
    public String addCategory(@ModelAttribute Category category , Model model) {
    	productService.saveCategory(category);
    	return "redirect:/Admin/product";
    }
    @PostMapping("/Admin/addPictureToP")
    public String addImageToProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("product_id") Long id ) {
    	productService.addImageToProduct(file,id);
    	return "redirect:/Admin/product";
    }
    @PostMapping("/Admin/addDiscountToP")
    public String addDiscountToproduct(@RequestParam("product_id") Long id ,
    		@RequestParam("discount") int discount) {
    	productService.saveProductDicount(id,discount);
    	return "redirect:/Admin/product";
    }
}
