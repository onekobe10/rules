package com.gankki.demo.portal.rules.util;

import java.util.UUID;

/**
 * ��̬���32ID
 *
 * @author congyuzi
 */
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
