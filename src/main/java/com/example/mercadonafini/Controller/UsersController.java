package com.example.mercadonafini.Controller;



import com.example.mercadonafini.Service.UsersService;
import com.example.mercadonafini.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }



    @GetMapping(value = "/")
    public String getThymeleafVue() { return "index"; }

    @GetMapping(value = "/admins")
    public String getThymeleafVue_admin() { return "index_admin"; }

   @GetMapping(value = "/login")
   public String getLoginPage(Model model){model.addAttribute("loginRequest", new UserModel());
        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model){
        System.out.println("login request : " + userModel);
        UserModel authenticated = usersService.authenticate(userModel.getUsername(), userModel.getPassword());
        if(authenticated != null){
            model.addAttribute("userLogin", authenticated.getUsername());
            return "index_admin";
        }else{
            return "403";
        }
    }



}
