package com.apple.shop.service;

import com.apple.shop.entity.Goods;

import com.apple.shop.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsService  {


    @Autowired
    GoodsRepository goodsRepository;










    @Transactional
    public boolean saveGoods(Goods goods){

       Goods existingGoods = goodsRepository.findByModelAndCategoryAndPriceAndName(goods.getModel(),goods.getCategory(),goods.getPrice(),goods.getName());

       if (existingGoods==null){
           goodsRepository.save(goods);
       }else {
           existingGoods.setCount(existingGoods.getCount()+goods.getCount());
           goodsRepository.save(existingGoods);
       }




        return true;
    }


    @Transactional
    public Goods getGoodsById(Long id){

        return goodsRepository.getOne(id);
    }


    public Goods getGoodsByModel(String name) {
        return  goodsRepository.findByModel(name);

    }
}
