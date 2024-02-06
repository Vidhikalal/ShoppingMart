package ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeControllers {
  @GetMapping("/")
   public String index(){
       return "index";
   }
//   @GetMapping("/product")
//    public String product(){
//      return "product";
//   }
//   @GetMapping("/checkout")
//    public String checkout(){
//      return "checkoutpage";
//    }
}
