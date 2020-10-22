package cn.itcast.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义的zuul过滤器
 *  继承抽象类
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 定义过滤器类型
     *  pre
     *  routing
     *  post
     *  error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 指定过滤器的执行顺序
     *  返回值越小，执行顺序越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 当前过滤器是否生效
     *  true:使用此过滤器
     *  false：不使用
     *  可以根据参数灵活判断是否使用
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 执行过滤器中的业务逻辑
     * 身份认证：
     *  1、所有的请求需要带一个参数：access-token
     *  2、获取request请求获取参数 access-token
     *  3、判断token是否为空
     *      token==null身份验证失败
     *      token！=null执行后续操作
     *  在zuul网关中，通过RequestContext的上下文对象，可以获取request对象
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //System.out.println("===执行了过滤器");
        //1、获取RequestContext的上下文对象
        RequestContext requestContext=RequestContext.getCurrentContext();
        //2、从RequestContext获取request
        HttpServletRequest request=requestContext.getRequest();
        //3、获取请求参数access-token
        String token=request.getParameter("access-token");
        //4、进行判断
        if (token==null){
            //拦截请求，返回认证失败
            requestContext.setSendZuulResponse(false);//拦截请求
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
