package com.yw.classLoader.myself;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 *  自定义类加载器
 * @author YanWin
 * @date 2019年1月15日 上午11:14:45
 */
public class WinClassloader extends ClassLoader{
	
	private String classpath;
	
	public WinClassloader(String classPath) {
		this.classpath = classPath;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] byteArray = this.getByteArray(name);
		return defineClass(byteArray, 0, byteArray.length);
	}
	private byte[] getByteArray(String className) {
		 String path=classpath + File.separatorChar +
                 className.replace('.',File.separatorChar)+".class";
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		
		try {
			is = new FileInputStream(path);
			baos = new ByteArrayOutputStream();
			byte[] buffer = new  byte[1024];
			int len=0;
			while((len = is.read(buffer))!= -1) {
				baos.write(buffer, 0, len);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(is !=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}if(baos !=null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		WinClassloader cl = new WinClassloader("D:\\cn\\yanwei\\demo\\domain");
		try {
			//不同类加载器加载相同全限定名的类，jvm认为这是不同的类
			Class clazz = cl.findClass("Student");
			Class clazz2 = cl.getClass().getClassLoader().loadClass("cn.yanwei.demo.domain.Student");
			System.out.println(clazz.toString());
			System.out.println(clazz.getClassLoader());
			System.out.println(clazz2.toString());
			System.out.println(clazz2.getClassLoader());
			System.out.println(clazz == clazz2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
