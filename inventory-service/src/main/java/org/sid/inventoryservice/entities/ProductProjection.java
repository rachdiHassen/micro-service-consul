package org.sid.inventoryservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name ="fullProducts",types = Product.class)
public interface ProductProjection {
    String getName();
    double getPrice();
    int getQuantity();
}
