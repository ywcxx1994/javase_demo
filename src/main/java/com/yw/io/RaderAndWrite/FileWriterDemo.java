package com.yw.io.RaderAndWrite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		FileWriterDemo.read3();
	}
	private static void read3() throws IOException {
		FileReader fr = new FileReader("D:\\demo.txt");
			char[] buf = new char[3];
			int temp = 0;
			while((temp = fr.read(buf)) != -1) {
				System.out.println(new String(buf,0,temp));
			}
		}
	private static void read2() throws IOException {
		FileReader fr = new FileReader("D:\\\\demo.txt");
//		int first = fr.read();
//		System.out.println(first);
//		int second = fr.read();
//		System.out.println(second);
		int temp=0;
		while((temp = fr.read())!=-1) {
			System.out.println((char)temp);
		}
		fr.close();

	}
	/**
	 * 读取数据
	 */
	private static void read() {
		FileReader fr = null;
		try {
			fr = new FileReader("D:\\demo.txt");
			int a;
			while((a=fr.read())>0) {
				System.out.print((char)a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 向指定文件写数据
	 */
	private static void fileWriter() {
		FileWriter fw = null;
		try {
			//创建一个文本文件。如果没有创建，有覆盖。
			fw = new FileWriter("D:\\demo.txt");
			//true代表续写
//			fw = new FileWriter("D:\\demo.txt",true);
			fw.write("dsafsadfas\r\nasdf");
			fw.write("hehe");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			//如果路径不对，fw创建不出来，调用fw.close()方法会空指针。
			if (fw != null) {
				try {
					//close方法包含flush()方法。调用flush()方法才可以将缓冲区的数据持久化
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
