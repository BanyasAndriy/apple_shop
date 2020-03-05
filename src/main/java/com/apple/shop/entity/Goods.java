package com.apple.shop.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Goods {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long count;
    private Long price;
    @Column( columnDefinition="TEXT")
    private String shortDescription;
    @Column( columnDefinition="TEXT")
    private String fullDescription;
    @Column( columnDefinition="TEXT")
    private String urlPhoto;
    private String model;



    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    private Basket basket;


    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER,mappedBy = "goods")
    List<Review> reviews ;


    @Enumerated(EnumType.STRING)
    private Category category;




    public Goods() {
    }

    public Goods(String name, Long count, Long price, String shortDescription, String fullDescription, String urlPhoto, String model,Category category) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.urlPhoto = urlPhoto;
        this.model = model;
        this.category=category;
    }


    public Goods(String name, Long count, Long price, String shortDescription, String fullDescription, String urlPhoto, String model, Order order, Category category) {
        this.name = name;
        this.count = count;
        this.price = price;
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
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
}
