package cn.itcast.product.service.Impl;

import cn.itcast.product.dao.ProductDao;
import cn.itcast.product.entity.Product;
import cn.itcast.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(Long id) {
        Optional<Product> product=productDao.findById(id);
        if (product !=null &&product.isPresent()){
            return product.get();
        }
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }
}
