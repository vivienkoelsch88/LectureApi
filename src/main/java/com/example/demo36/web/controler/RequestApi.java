package com.example.demo36.web.controler;

import com.example.demo36.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestApi {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private final String APIURL =  "http://localhost:8081";

    public List<Product> getProducts(){
        // HttpHeaders
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
//        // Request to return JSON format
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("my_other_key", "my_other_value");
//
//        // HttpEntity<String>: To get result as String.
//        HttpEntity<String> entity = new HttpEntity<String>(headers);

        List response = restTemplate.getForObject(APIURL + "/Produits", //
                List.class);
        System.out.println(response);
//        HttpStatus statusCode = response.getStatusCode();
//
//        if (statusCode == HttpStatus.OK) {
            // Response Body Data
            List<Product> list = response;

//            if (list != null) {
//                for (Product e : list) {
//                    System.out.println("Produits: " + e.getNom() + " - " + e.getPrix());
//                }
                return list;
//            }
//        }
//        return null;
    }



}
