package com.gankki.demo.note150.exception;

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

class Human {

    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            }
            //  里氏代换原则 能使用父类的地方一定能使用子类
            catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        // 父类型抛出的异常子类型也可以捕获
        catch (Sneeze s) {
            System.out.println("Caught Sneeze");
            return;
        } finally {
            System.out.println("Hello World!");
        }
    }
}
