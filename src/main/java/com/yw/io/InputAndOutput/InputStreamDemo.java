package com.yw.io.InputAndOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\18765\\Documents\\WeChat Files\\struggle_yw\\Video\\1e07e5b9cc8cc2d986a8f819f04e76a7.mp4");
        FileOutputStream fos = new FileOutputStream("D:\\下雪.mp4");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            fos.write(buf);
        }
        fis.close();
        fos.close();
    }

    private static void writer() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\hah.txt");
        fos.write("sdfasdf".getBytes());
    }

    private static void read() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\hah.txt");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }
    }
}
