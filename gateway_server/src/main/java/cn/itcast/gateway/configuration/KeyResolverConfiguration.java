package cn.itcast.gateway.configuration;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class KeyResolverConfiguration {
    /**
     * 编写基于请求路径的限流规则
     *  基于路径限流
     *  基于ip限流
     *  基于参数限流
     *  ...
     */
    @Bean
    public KeyResolver pathKeyResolver(){
        //自定义的KeyResolver
        return new KeyResolver() {
            /**
             * ServerWebExchange：
             *  上下文参数
             * @param exchange
             * @return
             */
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                //基于路径限流
                return Mono.just(exchange.getRequest().getPath().toString());
            }
        };
    }

    /**
     * 基于请求参数的限流,对参数userId进行限流，同一id访问次数有限
     */
    //@Bean
    public KeyResolver userKeyResolver(){
        //自定义的KeyResolver
        return new KeyResolver() {
            /**
             * ServerWebExchange：
             *  上下文参数
             * @param exchange
             * @return
             */
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                //基于参数值限流
                return Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
                //基于ip
                //exchange.getRequest().getHeaders().getFirst("X-Forwarded-For");
            }
        };
    }
}
