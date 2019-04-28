package com.yw.io.RaderAndWrite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTxtDemo {
	public static void main(String[] args) throws IOException {
//		bufferDemo();
	}


	private static void copyDemo() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("D:\\demo.txt");
		FileWriter fw = new FileWriter("D:\\java\\a.txt");
		int len = 0;
		char[] buf  = new char[2];
		while((len = fr.read(buf))!= -1) {
			fw.write(buf, 0, len);
		}
		fr.close();
		fw.close();
	}
	
	
	public static void bufferDemo() throws IOException { 
		FileReader fr = new FileReader("D:\\java\\a.txt");
		BufferedReader br = new BufferedReader(fr);
		String read = null;
		while((read = br.readLine()) !=null) {
			System.out.println(read);
		}
		/*System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());*/
		br.close();
	}
}
