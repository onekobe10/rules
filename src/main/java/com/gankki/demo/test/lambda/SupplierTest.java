package com.gankki.demo.test.lambda;

import java.util.HashMap;
import java.util.function.Supplier;
import java.util.Map;
/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/26
 */
public class SupplierTest {

	public static void main(String[] args){
		Supplier<Map> supplier = HashMap::new;
	}

}
