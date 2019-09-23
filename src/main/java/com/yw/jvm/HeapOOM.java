package com.yw.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18765 on 2019/9/23 20:55
 */
public class HeapOOM {
    static class OOMObject{
        byte[] bytes = new byte[1024*1024];
    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
