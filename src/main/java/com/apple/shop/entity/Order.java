package com.apple.shop.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue
    private Long idOrder;


    private Calendar calendar;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER,mappedBy = "order")
    List<Goods> goods = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private CustomUser customUser;





    public Order() {
    }

    public Order(List<Goods> goods, CustomUser customUser) {
        this.goods = goods;
        this.customUser = customUser;
    }

    public Order(Goods goods, CustomUser customUser,Calendar calendar) {
        this.goods.add(goods);
        this.customUser = customUser;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
