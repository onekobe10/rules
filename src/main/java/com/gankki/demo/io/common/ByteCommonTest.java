package com.gankki.demo.io.common;

import java.io.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/22
 */
public class ByteCommonTest {

	/**
	 * 拷贝输入流的内容到输出流
	 * @param input
	 * @param output
	 * @throws IOException
	 */
	public static void copy(InputStream input,
							OutputStream output) throws IOException {
		byte[] buf = new byte[4096];
		int bytesRead = 0;
		while((bytesRead = input.read(buf))!=-1){
			output.write(buf, 0, bytesRead);
		}
	}

	/**
	 * 将文件读入字节数组
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static byte[] readFileToByteArray(String fileName) throws IOException{
		InputStream input = new FileInputStream(fileName);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try{
			copy(input, output);
			return output.toByteArray();
		}finally{
			input.close();
		}
	}

	/**
	 * 将字节数组写到文件
	 * @param fileName
	 * @param data
	 * @throws IOException
	 */
	public static void writeByteArrayToFile(String fileName,
											byte[] data) throws IOException{
		OutputStream output = new FileOutputStream(fileName);
		try{
			output.write(data);
		}finally{
			output.close();
		}
	}

	/**
	 * Apache有一个类库Commons IO，里面提供了很多简单易用的方法，实际开发中，可以考虑使用。
	 *
	 *
	 */
}
