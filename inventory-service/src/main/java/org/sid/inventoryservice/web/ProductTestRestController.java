package org.sid.inventoryservice.web;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductsRepository;
import org.sid.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.util.LambdaSafe;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class ProductTestRestController {
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
    @Value("${inv.params.a}")
    private String a;
    @Value("${inv.params.b}")
    private String b;

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/params")
    Map<String,String> params(){
        return Map.of("p1",p1,"p2",p2,"a",a,"b",b);
    }

    @GetMapping("/productList")
    List<Product> productList(){
        return productsRepository.findAll();
    }

    @GetMapping("/listProduct")
    public List<Product> listProduct(){
        return inventoryService.productList();
    }
}
