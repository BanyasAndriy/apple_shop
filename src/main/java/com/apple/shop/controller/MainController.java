package com.apple.shop.controller;


import com.apple.shop.dto.GoodsDTO;
import com.apple.shop.entity.CustomUser;
import com.apple.shop.entity.Goods;
import com.apple.shop.entity.Role;
import com.apple.shop.service.BasketService;
import com.apple.shop.service.CategoryService;
import com.apple.shop.service.GoodsService;
import com.apple.shop.service.UserService;
import com.sun.deploy.net.HttpRequest;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    BasketService basketService;

    @Autowired
    GoodsService goodsService;

/*
    @RequestMapping("/")
    String showMain(){
        return "index";
    }
*/

    @RequestMapping("/sign_in")
    String showSign_inPage() {
        return "sign_in";
    }






/*
    @GetMapping("/main_page_goods")
    GoodsDTO showMainPageGoods(HttpServletResponse response) throws IOException {

        ModelAndView res = new ModelAndView("main_page_goods");

        res.addObject("basket",basketService.countOfGoodsInBasket(getEmailCurrentUser()));

        GoodsDTO goodsDTO= new GoodsDTO();
        goodsDTO.from(goodsService.getGoodsById(26L));

        return goodsDTO;

    }
*/

    @RequestMapping("/login")
    public String loginPage() {
        return "sign_in";
    }


    @RequestMapping("/change_password")
    String changePassw() {
        return "change_password";
    }

    @RequestMapping("/errorPage")
    String errorUrl() {
        return "error";
    }


    @RequestMapping("/logout")
    String logout() {
        return "login";
    }

    @RequestMapping("/sign_in?error=user-exist")
    String userExist() {
        return "sign_in";
    }

  /*
    @RequestMapping("/")
    String mainPage() {
        return "index";
    }
*/



    @RequestMapping("/registration")
    ModelAndView registration(@RequestParam("fullname") String fullname,
                              @RequestParam("email") String email,
                              @RequestParam("password") String password) {


        ModelAndView modelAndView = new ModelAndView("sign_in");

        String uuid = UUID.randomUUID().toString();
        String[] pib = new String[3];

        pib = fullname.split(" ");


        String passHash = passwordEncoder.encode(password);

        CustomUser customUser = new CustomUser(pib[0], pib[1], pib[2], email, passHash, Role.USER);
        customUser.setUuid(uuid);
        if (!userService.saveUser(customUser)) {
            modelAndView.addObject("message", "Error!! User with typed email exist!");
            return modelAndView;
        } else {
            modelAndView.addObject("message", "Sign in to continue");
            return modelAndView;
        }
    }


    @RequestMapping("/send_mail")
    ModelAndView getPassword(@RequestParam String email) {

        ModelAndView modelAndView = new ModelAndView("sign_in");
        String message = "";

        if (!userService.sendUrlToChangePassword(email)) {
            message = "User with this email not exist!";

        } else message = "Check your email to change password!!";

        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping("/activate/{code}")
    public String activate(@PathVariable("code") String code, HttpServletRequest request) {

        CustomUser customUser = userService.findByUuid(code);

        if (customUser != null) {
            request.getSession().setAttribute("user", customUser);
            return "redirect:/change_password";
        } else return "errorPage";
    }


    @RequestMapping("/change")
    public ModelAndView changePassword(@RequestParam("password") String password,
                                       HttpServletRequest request
    ) {

        ModelAndView modelAndView = new ModelAndView("sign_in");
        ModelAndView fail = new ModelAndView("errorPage");
        if (userService.changePassword((CustomUser) request.getSession().getAttribute("user"), password)) {
            modelAndView.addObject("message", "Your password was changed");
            return modelAndView;
        } else return fail;


    }

    private String getEmailCurrentUser() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();


        return email;
    }


}
