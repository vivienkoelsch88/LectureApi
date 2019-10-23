package com.example.demo36.web.controler;

import com.example.demo36.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestApi {

    private RestTemplate restTemplate = new RestTemplate();

    private final String APIURL =  "http://localhost:8081";

    public Product[] getProducts(){

        return restTemplate.getForObject(APIURL + "/Produits", //
                Product[].class);

    }

    public Product getProduct(int id){


        Product produit = restTemplate.getForObject(APIURL + "/Produits/" + id, //
                Product.class);
        System.out.println(produit);

        return produit;
    }



}
