package com.gankki.demo.test.stream.dupkey;

import lombok.Data;

/**
 * 
 * @author liuhao
 * @date 2020/2/18 
 */
@Data
public class Entity {
    private String key;
    private Integer value;

    public Entity(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
