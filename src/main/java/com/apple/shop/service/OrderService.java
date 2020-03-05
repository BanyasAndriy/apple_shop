package com.apple.shop.service;


import com.apple.shop.entity.Order;
import com.apple.shop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {


    @Autowired
    OrderRepository orderRepository;


    @Transactional
    public Long createOrder(Order order){
        orderRepository.save(order);
        return order.getIdOrder();

    }




}
