package cn.itcast.order.feign;

import cn.itcast.order.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientCallBack implements ProductFeignClient {
    @Override
    public Product fingProductById(Long id) {
        Product product=new Product();
        product.setProductName("触发降级熔断");
        return product;
    }
}
