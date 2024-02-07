package ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.controllers;

import ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.beans.Products;
import ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.database.ProductRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeControllers {
  @GetMapping("/")
   public String index(){
       return "index";
   }

   @GetMapping("/product")
    public String getProduct(Model model){
//      model.addAttribute("productList", ProductRepo.findAll());
      model.addAttribute("product",new Products());
      return "product";
   }
//   @PostMapping("/product")
//   public ModelAndView AddProduct(Model model, @ModelAttribute Products product){
//       ProductRepo.save(product);
//       ModelAndView modelAndView = new ModelAndView("inserProducts", "ProductList", ProductRepo.findAll());
//       modelAndView.addObject("product", new Products());
//       return modelAndView;
//   }
   @PostMapping("/shopping")
   public String shopping(){
      return "shopping";
   }
   @GetMapping("/checkout")
    public String checkout(){
      return "checkout";
    }
}
