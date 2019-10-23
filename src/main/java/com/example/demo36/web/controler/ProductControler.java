package com.example.demo36.web.controler;

import com.example.demo36.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
public class ProductControler {

    @RequestMapping(value="/Produits", method= RequestMethod.GET)
    public String listeProduits(Model model) {

        RequestApi requestApi = new RequestApi();
        List<Product> produits = requestApi.getProducts();
//        System.out.println(produits);
        model.addAttribute("products", produits);

        //return productDao.findAll();
        return "Produits";
    }


    @GetMapping(value="/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return null;
    }

    @DeleteMapping(value="/RemoveProduits/{id}")
    public Product supprimerUnProduit(@PathVariable int id) {
        return null;
    }

    @RequestMapping(value="/AddProduits", method=RequestMethod.POST)
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {

//        Product productAdded =  productDao.save(product);
//
//        if (productAdded == null)
//            return ResponseEntity.noContent().build();
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(productAdded.getId())
//                .toUri();

        return null;
    }

    //----------------------------------------------------------------------------------------------------

}
