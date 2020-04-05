package com.gankki.demo.test.maptest;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author liuhao
 * @date 2020/4/4
 */
public class MapTest {

    public static void main(String[] args){
        HashMap<Integer,Integer> map = new HashMap<>();
        System.out.println(map.containsKey(null));
        System.out.println(map.get(null));

        map.put(null,null);//当key为空时，key的hash值为0
        System.out.println(map.containsKey(null));
        System.out.println(map.get(null));

        map.put(null,123);
        System.out.println(map.containsKey(null));
        System.out.println(map.get(null));

        ConcurrentHashMap<Integer,Integer> cmap = new ConcurrentHashMap<>();
        cmap.put(1, 1);
        cmap.remove(1);
        System.out.println(cmap.get(1));
        System.out.println(cmap.get(2));
        System.out.println(cmap.containsKey(1));
        System.out.println(cmap.containsKey(null));
        System.out.println(cmap.get(null));

        cmap.put(null,123);
        cmap.put(123,null);

    }

}
