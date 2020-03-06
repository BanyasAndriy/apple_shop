package com.apple.shop.entity;

import javax.persistence.*;
import java.util.Map;
import java.util.TreeMap;


@Entity
public class Goods {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long count;
   // private Long price;
    @Column( columnDefinition="TEXT")
    private String shortDescription;
    @Column( columnDefinition="TEXT")
    private String fullDescription;
    @Column( columnDefinition="TEXT")
    private String urlPhoto;
    private String model;
    @ElementCollection
    @CollectionTable(name = "memory_price",
            joinColumns = {@JoinColumn(name = "priceID", referencedColumnName = "id")})
    @MapKeyColumn(name = "memory")
    @Column(name = "price")
    private Map<Integer , Integer> memoryPrice = new TreeMap<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    private Basket basket;



    @Enumerated(EnumType.STRING)
    private Category category;




    public Goods() {
    }

    public Goods(String name, Long count,  String shortDescription, String fullDescription, String urlPhoto, String model,Category category , Integer memory, Integer price) {
        this.name = name;
        this.count = count;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.urlPhoto = urlPhoto;
        this.model = model;
        this.category=category;
        this.memoryPrice.put(memory,price);
    }


    public Goods(String name, Long count,  String shortDescription, String fullDescription, String urlPhoto, String model, Order order, Category category) {
        this.name = name;
        this.count = count;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.urlPhoto = urlPhoto;
        this.model = model;
        this.order = order;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Map<Integer, Integer> getMemoryPrice() {
        return memoryPrice;
    }

    public void setMemoryAndPrice(Map<Integer, Integer> memoryAndPrice) {
        this.memoryPrice.putAll(memoryAndPrice);
    }

    public void setMemoryAndPrice(Integer memory,Integer price){
        this.memoryPrice.put(memory,price);
    }



}
