package cn.itcast.product.controller;

import cn.itcast.product.entity.Product;
import cn.itcast.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findbyId(@PathVariable("id") Long id){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==="+id);
        Product product=productService.getProductById(id);
        product.setPrice(2333);
        return product;
    }

    @PostMapping(value = "")
    public String save(Product product){
        productService.saveProduct(product);
        return "保存成功";
    }
}
