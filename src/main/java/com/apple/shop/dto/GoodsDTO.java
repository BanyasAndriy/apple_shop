package com.apple.shop.dto;

import com.apple.shop.entity.Goods;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class GoodsDTO {
    private String name;
    private Long count;
    private Long price;
    private String shortDescription;
    private String fullDescription;
    private String urlPhoto;
    private String model;

    private List<String> models = new ArrayList<>();


    public GoodsDTO() {
    }

    public GoodsDTO(String name, Long count, Long price, String shortDescription, String fullDescription, String urlPhoto, String model,List<String> models) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.urlPhoto = urlPhoto;
        this.model = model;
        this.models=models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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


    public List<String> getModels() {
        return models;
    }

    public void setModels(List<String> models) {
        this.models = models;
    }

    public void from(Goods goods){

        this.name=goods.getName();
        this.model=goods.getModel();
        this.fullDescription=goods.getFullDescription();
        this.shortDescription=goods.getShortDescription();
        this.count=goods.getCount();
        this.urlPhoto=goods.getUrlPhoto();
        this.price = goods.getPrice();
        //this.models=models;


    }







}
