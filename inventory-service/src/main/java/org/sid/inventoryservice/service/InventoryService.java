package org.sid.inventoryservice.service;

import org.sid.inventoryservice.entities.Product;

import java.util.List;

public interface InventoryService {
    List<Product> productList();
}
