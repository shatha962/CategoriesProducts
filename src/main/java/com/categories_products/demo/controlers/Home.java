package com.categories_products.demo.controlers;

import com.categories_products.demo.models.Category;
import com.categories_products.demo.models.Product;
import com.categories_products.demo.services.ProCatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@Controller
public class Home {
    private final ProCatService proCatServ;

    public Home(ProCatService proCatServ) {
        this.proCatServ = proCatServ;
    }

    @RequestMapping("/show/pro")
    public List<Product> getAllProducts() {
        return proCatServ.allProducts();
    }

    @RequestMapping("/show/cat")
    public List<Category> getAllCategories() {
        return proCatServ.allCategories();
    }

    @RequestMapping(value = "/create/cat", method = RequestMethod.POST)
    public List<Category> createNewCat(@RequestParam("name") String name) {
        Category cat = proCatServ.createCategory(new Category(name));
        return proCatServ.allCategories();
    }

    @RequestMapping("/products")
    public String showProducts(@ModelAttribute("prod") Product prod, Model model) {
        List<Product> products = proCatServ.allProducts();
        model.addAttribute("products", products);
        return "newProduct.jsp";
    }

    @RequestMapping(value = "/products/new",method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("prod") Product prod) {
        // Code
        Product p = proCatServ.createProduct(prod);
        return "redirect:/products";
    }
    @RequestMapping("/categories")
    public String showCategories(@ModelAttribute("cat") Category category, Model model) {
        List<Category> categories = proCatServ.allCategories();
        model.addAttribute("categories", categories);
        return "newCategory.jsp";
    }

    @RequestMapping(value = "/categories/new",method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("cat") Category category) {
        Category p = proCatServ.createCategory(category);
        return "redirect:/categories";
    }

    @RequestMapping("/categories/{id}")
    public String category(@ModelAttribute("cat") Category category,@PathVariable("id") Long id,Model model){
        Category cat = proCatServ.findCategory(id);
        model.addAttribute("cat", cat);
        return "category.jsp";
    }
}
