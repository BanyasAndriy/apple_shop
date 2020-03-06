package com.apple.shop.service;


import com.apple.shop.entity.Goods;

import com.apple.shop.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class GoodsService  {


    @Autowired
    GoodsRepository goodsRepository;










    @Transactional
    public boolean saveGoods(Goods goods){


       Goods existingGoods = goodsRepository.findTopByModelAndCategoryAndNameIgnoreCase(goods.getModel(),goods.getCategory(),goods.getName());

       if (existingGoods==null){
           goodsRepository.save(goods);
       }else {
           if (existingGoods.getMemoryPrice().equals(goods.getMemoryPrice())) {

               existingGoods.setCount(existingGoods.getCount() + goods.getCount());
               goodsRepository.save(existingGoods);


           }else{

               goodsRepository.save(goods);

           }




       }




        return true;
    }


    @Transactional
    public Goods getGoodsById(Long id){

        return goodsRepository.getOne(id);
    }

@Transactional
    public Goods getGoodsByModel(String name) {

         List<Goods> goods =  goodsRepository.findByModel(name);
    List<Integer> memories = new ArrayList<>();

    Integer memory = goods.get(0).getMemoryPrice().keySet().stream().findFirst().get();

    for (Goods g: goods
         ) {
         memories.add(g.getMemoryPrice().keySet().stream().findFirst().get());
    }
    Collections.sort(memories);

    for (Goods g: goods
    ) {
       if (g.getMemoryPrice().keySet().stream().findFirst().get()==memories.get(0)){
           return g;
       }
    }

return goods.get(0);
    }





   public Set<String> findByModelContains(String model){

        List<String> res = new ArrayList<>();


        List<Goods> goods = goodsRepository.findDistinctByModelContains(model);

        for (Goods g: goods
             ) {

            res.add(g.getModel());
        }

        Set<String> result = new HashSet<>(res);

        return result;
    }

    public Set<Integer> getMemoriesByModel(String model){


        Set<Integer> res = new TreeSet<>();

        List<Goods> models= goodsRepository.findByModel(model);



        for (Goods g: models
        ) {

            res.addAll(g.getMemoryPrice().keySet());
        }

        return res;

    }


}
