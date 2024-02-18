package org.sid.inventoryservice.service;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private ProductsRepository productsRepository;
    @Override
    public List<Product> productList() {
        return productsRepository.findAll();
    }
}
