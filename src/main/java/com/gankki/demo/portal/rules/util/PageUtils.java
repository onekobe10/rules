package com.gankki.demo.portal.rules.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 靳恒彬
 */
public class PageUtils {

    /**
     * 计算总页数
     *
     * @param totalSize 总条数
     * @param pageSize  每页显示条数
     */
    public static String getTotalPage(int totalSize, int pageSize) {
        if (totalSize < 0 || pageSize < 0) {
            return "不能给定小于0的数";
        }
        if (pageSize == 0) {
            return "pageSize必须大于0";
        }
        int totalPage = totalSize / pageSize;
        int mo = totalSize % pageSize;
        if (mo != 0 || totalPage == 0) {
            totalPage += 1;
        }
        return String.valueOf(totalPage);
    }


    public static List<Integer> listPageNums(int pageNum, int totalPage) {
        List<Integer> list = new ArrayList<Integer>();
        if (totalPage <= 1) {
            list.add(1);
            return list;
        }
        if (totalPage <= 10) {
            for (int i = 1; i <= totalPage; i++) {
                list.add(i);
            }
            return list;
        } else {
            if (totalPage - pageNum < 5) {
                for (int i = totalPage; i > totalPage - 10; i--) {
                    list.add(i);
                }
            } else if (pageNum - 1 < 5) {
                for (int i = 1; i <= 10; i++) {
                    list.add(i);
                }
            } else {
                for (int i = pageNum; i > pageNum - 5; i--) {
                    list.add(i);
                }
                for (int i = pageNum + 1; i <= pageNum + 5; i++) {
                    list.add(i);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

}
