package cn.itcast.test;

import cn.itcast.bean.EnableUserBean;
import cn.itcast.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableUserBean
public class TestApplication {
    public static void main(String args[]){
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(TestApplication.class);
        User user=ac.getBean(User.class);
        System.out.println("==="+user);
    }
}
