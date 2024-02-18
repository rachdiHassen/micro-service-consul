package org.sid.orderservice.web;

import org.sid.orderservice.model.Product;
import org.sid.orderservice.service.InventoryRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    InventoryRestClientService inventoryRestClientService;

    @GetMapping("/listProduct")
    public List<Product> listProduct(){
        return inventoryRestClientService.allProducts();
    }
}
