package cn.itcast;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestPC {
    public static void main(String args[]){
/*        SynContainer synContainer=new SynContainer();
        new Producer(synContainer).start();
        new Consumer(synContainer).start();*/
        Map<String,String> map=new HashMap<>();
        map.put(null,"hello");
        System.out.println("==="+map.get(null));

        Map<String,String> map2=new ConcurrentHashMap<>();
        map2.put(null,"hello2");
        System.out.println("==="+map2.get(null));
    }
}
