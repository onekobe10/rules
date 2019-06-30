package com.gankki.demo.designpattern.flyweight.section2;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class Client {

	public static void main(String[] args) {
		//初始化对象池
		for(int i=0;i<4;i++){
			String subject = "科目" + i;
			//初始化地址
			for(int j=0;j<30;j++){
				String key = subject + "考试地点"+j;
				SignInfoFactory.getSignInfo(key);
			}
		}
		SignInfo signInfo = SignInfoFactory.getSignInfo("科目1考试地点1");
	}

		
}
