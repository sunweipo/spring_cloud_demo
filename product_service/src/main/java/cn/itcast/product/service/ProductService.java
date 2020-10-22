package cn.itcast.product.service;

import cn.itcast.product.entity.Product;

public interface ProductService {
    Product getProductById(Long id);
    void saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);

}

