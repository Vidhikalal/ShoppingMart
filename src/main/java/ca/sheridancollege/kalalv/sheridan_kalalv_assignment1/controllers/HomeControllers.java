package ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.controllers;

import ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.beans.Products;
import ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.database.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HomeControllers {

  @Autowired
    private  ProductRepo pr;
  @GetMapping("/")
   public String index(){
       return "index";
   }

   @GetMapping("/product")
    public String getProduct(Model model){
      model.addAttribute("productList", pr.getAllProducts());
      model.addAttribute("product",new Products());
      return "product";
   }
   @PostMapping("/addProduct")
   public String AddProduct(Model model, @ModelAttribute Products product){
       pr.addProduct(product);
       model.addAttribute("productList", pr.getAllProducts());
       model.addAttribute("product",new Products());
       return "product";
   }
    @PostMapping("/addToCart")
    public String addToCart(Model model, @RequestParam("productId") Long productId) {

        model.addAttribute("cartSize",pr.getCartSize());
        return "redirect:/shopping";
    }
    @GetMapping("/shopping")
    public String getShopping(Model model) {
        model.addAttribute("productList", pr.getAllProducts());
        model.addAttribute("product", new Products());
        model.addAttribute("cartSize", pr.getCartSize());
        return "shopping";
    }

//   @PostMapping("/shopping")
////   public String shopping(Model model){
////       model.addAttribute("productList", pr.getAllProducts());
////       model.addAttribute("product",new Products());
////       return "shopping";
////   }
@GetMapping("/checkout")
public String checkout(Model model) {
    // Calculate subtotal, sales tax, and total
    Map<String, Double> totalValues = pr.calculateTotalValues();

    // Add the calculated values to the model
    model.addAttribute("subtotal", totalValues.get("subtotal"));
    model.addAttribute("salesTax", totalValues.get("salesTax"));
    model.addAttribute("total", totalValues.get("total"));

    // Add other attributes if needed
    model.addAttribute("productList", pr.getAllProducts());
    model.addAttribute("product", new Products());

    return "checkout";
}

}
