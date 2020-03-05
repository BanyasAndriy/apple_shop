package com.apple.shop.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Basket {

@Id
@GeneratedValue
private Long idBasket;



@OneToMany(cascade = CascadeType.ALL , mappedBy = "basket")
List<Goods> goods = new ArrayList<>();


    public Basket(List<Goods> goods) {
        this.goods = goods;
    }

    public Basket() {

    }

    @OneToOne(mappedBy = "basket")
    private CustomUser customUser;


    public Long getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(Long idBasket) {
        this.idBasket = idBasket;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods.add(goods);
    }


    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }
}
