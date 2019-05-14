package com.gankki.demo.test.enumTest;

public interface Food {

    enum FruitEnum implements Food {
        FRUIT, CAKE, BANANA
    }

    enum CoffeeEnum implements Food {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    public static void testMethod() {
        // 不推荐的写法
        for (CoffeeEnum c : CoffeeEnum.values()) {
            System.out.println(c);
        }
        // 推荐写法 这样可以明确枚举所属的分类
        for (Food.FruitEnum f : Food.FruitEnum.values()) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        Food.testMethod();
        // 可以通过接口将相同分类的枚举划分到一起
    }
}
