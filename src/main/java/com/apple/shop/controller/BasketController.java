package com.apple.shop.controller;


import com.apple.shop.entity.Basket;
import com.apple.shop.entity.CustomUser;
import com.apple.shop.entity.Goods;
import com.apple.shop.service.BasketService;
import com.apple.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BasketController {


    @Autowired
    BasketService basketService;

    @Autowired
    UserService userService;

  @RequestMapping("/")
  ModelAndView getBasketInfo(){

      ModelAndView res = new ModelAndView("index");


     res.addObject("basket",basketService.countOfGoodsInBasket(getEmailCurrentUser()));

     return res;

  }


    private String  getEmailCurrentUser() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();


  return email;
  }






}
