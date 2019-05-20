package com.gankki.demo.io.binaryfile;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/20
 */
public class FileInputStreamTest {


	public static void main(String[] args) throws Exception{
		InputStream input = new FileInputStream("E:/gankkscode/gankkidir/hello.txt");
		try{
			// 限定了读取文件最大的字节数，查过1024字节的部分丢失
			byte[] buf = new byte[1024];
			int bytesRead = input.read(buf);
			System.out.println(bytesRead);
			String data = new String(buf, 0, bytesRead, "UTF-8");
			System.out.println(data);

			/**
			 * 不过，这还是假定文件内容长度不超过一个固定的大小1024。如果不确定文件内容的长度，不希望一次性分配过大的byte数组，
			 * 又希望将文件内容全部读入，怎么做呢？可以借助ByteArrayOutputStream。
			 * byte[] buf = new byte[1024];
			 * int off = 0;
			 * int bytesRead = 0;
			 * while((bytesRead=input.read(buf, off, 1024-off ))!=-1){
			 *     off += bytesRead;
			 * }
			 * String data = new String(buf, 0, off, "UTF-8");
			 */
		}finally{
			input.close();
		}
	}
}
