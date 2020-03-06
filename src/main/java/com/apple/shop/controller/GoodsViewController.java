package com.apple.shop.controller;


import com.apple.shop.dto.GoodsDTO;
import com.apple.shop.entity.Goods;
import com.apple.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import java.util.List;
import java.util.Set;

@RestController
public class GoodsViewController {





@Autowired
GoodsService goodsService;

    @RequestMapping(value="/type={type}/model={name}",method= RequestMethod.POST)
    public GoodsDTO getProducts( @PathVariable("type") String type, @PathVariable("name") String name){


        if(name==null){
            return null;
        }
        Set<String> models = goodsService.findByModelContains(name);
        Set<Integer> memories = goodsService.getMemoriesByModel(name);
        GoodsDTO goodsDTO= new GoodsDTO();
        goodsDTO.from(goodsService.getGoodsByModel(name),models,memories);

        Goods goods = goodsService.getGoodsByModel(name);



           Integer priceByMemory = goodsDTO.getMemoryAndPrice().get(16);






        return goodsDTO;

    }

}
