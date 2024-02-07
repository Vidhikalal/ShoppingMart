package ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.controllers;

import ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.beans.Products;
import ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.database.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
   @GetMapping()
   public String getShopping(Model model){
       model.addAttribute("productList", pr.getAllProducts());
       model.addAttribute("product",new Products());
       return "shopping";
   }
   @GetMapping("/AddtoCart/{id}")
   public String addToCart(Model model, @PathVariable long id){
     Products product=pr.getProductById(id);
      pr.addToCart(product);
       model.addAttribute("productList", pr.getAllProducts());
       model.addAttribute("product",new Products());
      return "shopping";
   }
//   @PostMapping("/shopping")
////   public String shopping(Model model){
////       model.addAttribute("productList", pr.getAllProducts());
////       model.addAttribute("product",new Products());
////       return "shopping";
////   }
   @GetMapping("/checkout")
    public String checkout(){
      return "checkout";
    }
}
