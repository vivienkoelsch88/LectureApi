package com.example.demo36.web.controler;

import com.example.demo36.model.Product;
import com.example.demo36.web.form.FormProduct;
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
        Product[] produits = requestApi.getProducts();

        model.addAttribute("products", produits);

        //return productDao.findAll();
        return "Produits";
    }


    @GetMapping(value="/Produits/{id}")
    public String afficherUnProduit(@PathVariable int id, Model model) {
        RequestApi requestApi = new RequestApi();

        model.addAttribute("products", requestApi.getProduct(id));

        return "Produit";
    }

    @DeleteMapping(value="/RemoveProduits/{id}")
    public Product supprimerUnProduit(@PathVariable int id) {
        return null;
    }

    @RequestMapping(value="/addProductYolo", method=RequestMethod.POST)
    public String ajouterProduit(Model model, //
                               @ModelAttribute("FormProduct") FormProduct form) {
        RequestApi requestApi = new RequestApi();
        Product product = new Product(form.getId(), form.getNom(), form.getPrix());
        Product produit = requestApi.addProduct(product);

        Product[] produits = requestApi.getProducts();

        model.addAttribute("products", produits);

        return "Produits";
    }

    @RequestMapping(value="/AddProduct", method= RequestMethod.GET)
    public String formProduit(Model model) {

        FormProduct formProduct = new FormProduct();
        model.addAttribute("FormProduct", formProduct);

        return "CreateProduit";
    }
    //----------------------------------------------------------------------------------------------------

}
