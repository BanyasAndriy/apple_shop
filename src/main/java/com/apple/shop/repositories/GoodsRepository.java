package com.apple.shop.repositories;

import com.apple.shop.entity.Category;
import com.apple.shop.entity.Goods;
import com.apple.shop.entity.Order;
import org.hibernate.annotations.Parameter;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods,Long> {


     List<Goods> findGoodsByOrder(Order order);
     Goods findByModelAndCategoryAndPriceAndName(String model, Category category, Long price, String name);

     Goods findByModel(String model);

     List<Goods> findAll();




     @Query("select g from Goods g where g.model Like '%:someDescription%' ")
     List<Goods> findBySomeDescription(@Param("someDescription") String someDescription);


}
