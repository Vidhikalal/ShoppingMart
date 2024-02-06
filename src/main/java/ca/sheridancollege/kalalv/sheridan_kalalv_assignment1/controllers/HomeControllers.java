package ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllers {
  @GetMapping("/")
   public String index(){
       return "index";
   }
}
