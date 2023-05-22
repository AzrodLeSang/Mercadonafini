package com.example.mercadonafini.Controller;



import com.example.mercadonafini.model.UserModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {




    @GetMapping(value = "/")
    public String getThymeleafVue() { return "index"; }

    @GetMapping(value = "/admins")
    public String getThymeleafVue_admin() { return "index_admin"; }

   @GetMapping(value = "/login")
   public String getLoginPage(Model model){model.addAttribute("loginRequest", new UserModel());
        return "login";
    }



}
