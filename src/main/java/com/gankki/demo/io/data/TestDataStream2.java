package com.gankki.demo.io.data;

import java.io.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/25
 */
public class TestDataStream2 {

	public static void main(String[] args) {
		// 使用DataInputStream,DataOutputStream写入文件且从文件中读取数据。
		try {
			// Data Stream写到输入流中
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(
					"E:/gankkscode/gankkidir/hello7.txt"));
			dos.write("世界".getBytes()); // 按UTF8编码(我的系统默认编码方式)写入
			//dos.write("世界".getBytes("GBK"));  //指定其他编码方式
			dos.writeChars("世界"); // 按照Unicode写入
			// 按照UTF-8写入(UTF8编码长度可变，开头2字节是由writeUTF函数写入的长度信息，方便readUTF函数读取)
			dos.writeUTF("世界");
			dos.flush();
			dos.close();

			// Data Stream 读取
			DataInputStream dis = new DataInputStream(new FileInputStream(
					"E:/gankkscode/gankkidir/hello7.txt"));
			// 读取字节
			byte[] b = new byte[6];
			dis.read(b);
			System.out.println(new String(b, 0, 6));

			// 读取字符
			char[] c = new char[2];
			for (int i = 0; i < 2; i++) {
				c[i] = dis.readChar();
			}
			System.out.println(new String(c, 0, 2));

			// 读取UTF
			System.out.println(dis.readUTF());

			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
