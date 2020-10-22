package cn.itcast.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 *  实现globalfilter,ordered接口
 */
@Component
public class LoginFilter implements GlobalFilter, Ordered {
    /**
     * 真正执行过滤器中的业务逻辑
     *  对请求中的access-token进行判断
     *      如果存在此参数，代表认证成功，反之失败
     *  ServerWebExchange相当于请求和响应的上下文（zuul中是requestContext对象）
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("===执行了自定义的全局过滤器");
        //1、获取请求参数
        String token=exchange.getRequest().getQueryParams().getFirst("access-token");
        //2、判断
        if (token==null){
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();//请求结束
        }
        return chain.filter(exchange);//继续向下执行
    }
    /**
     * 为了指定过滤器的执行顺序，返回值越小，执行优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
