package cn.itcast.order.controller;

import cn.itcast.order.command.OrderCommand;
import cn.itcast.order.entity.Product;
import cn.itcast.order.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    /**
     * @LoadBalanced:是ribbon提供的负载均衡注解
     */
    @Autowired
    RestTemplate restTemplate;
    /**
     * 注入discoveryClient
     * spring cloud提供的可以获取元数据的工具类
     *  调用方法获取服务的元数据信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;
    /**
     * 参数商品id
     * 通过订单系统，调用商品服务根据id查询商品信息
     *  1、需要配置商品对象
     *  2、需要调用商品服务
     *  使用java中的urlconnection/httpclient/okhttp
     *  这里使用spring提供的restTemplate
     */
    //不知道为什么，feign中restTemplate.getForObject方法会报错
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
        //以服务名获取所有元数据
        List<ServiceInstance> instances=discoveryClient.getInstances("service-product");
        ServiceInstance serviceInstance=instances.get(0);
        //如何调用商品服务
        Product product=null;
        product=restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/1",Product.class);
        return product;
    }


    /**
     * 基于ribbon的形式调用远程微服务
     * 1、使用@LoadBalanced声明RestTemplate
     * 2、使用服务名称代替IP地址
     * @param id
     * @return
     */
    @RequestMapping(value = "/newbuy/{id}",method = RequestMethod.GET)
    public Product findByIdNew(@PathVariable Long id){
        //如何调用商品服务
        Product product=null;
        product=restTemplate.getForObject("http://service-product/product/1",Product.class);
        return product;
    }


    //使用feign发送消息

    @Autowired
    private ProductFeignClient productFeignClient;

    @RequestMapping(value = "/useFeignBuy/{id}",method = RequestMethod.GET)
    public Product findByIdUserFeign(@PathVariable Long id){
        //如何调用商品服务
        Product product=null;
        product=productFeignClient.fingProductById(id);
        return product;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getOrder(@PathVariable Long id){
        return "订单id是"+id;
    }

    /**
     * 使用OrderCommand中的线程池发送
     * @param id
     * @return
     */
    @RequestMapping(value = "/useHystrixBuy/{id}",method = RequestMethod.GET)
    public Product findByIdUserHystrix(@PathVariable Long id){
        System.out.println("==="+id);
        //如何调用商品服务
        Product product=null;
        product=new OrderCommand(restTemplate,id).execute();
        return product;
    }


}
