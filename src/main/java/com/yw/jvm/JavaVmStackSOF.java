package com.yw.jvm;

/**
 * 模拟栈内存溢出
 * Created by 18765 on 2019/9/23 21:16
 */
public class JavaVmStackSOF {
    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        this.stackLeak();
    }

    public static void main(String[] args) {
        JavaVmStackSOF javaVmStackSOF = new JavaVmStackSOF();
        try {
            javaVmStackSOF.stackLeak();
        }catch (Exception e){
            System.out.println(javaVmStackSOF.stackLength);
            throw e;
        }

    }
}
