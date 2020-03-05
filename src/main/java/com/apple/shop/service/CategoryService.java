package com.apple.shop.service;

import com.apple.shop.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {



    public Category getCategoryByString(String categoryName){

      Category category=null;
        if (categoryName.toLowerCase().equals("phone")) {
            category=Category.PHONE;
        }else if (categoryName.toLowerCase().equals("laptop")){
            category=Category.LAPTOP;
        }else if (categoryName.toLowerCase().equals("watch")){
            category=Category.WATCH;
        }else if (categoryName.toLowerCase().equals("airPods")){
            category=Category.AIRPODS;
        }

     return category;

    }


}
