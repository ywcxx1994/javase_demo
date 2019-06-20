package com.yw.collection;

import java.util.ArrayList;
import java.util.TreeSet;

public class TreeSetDemo {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> ts = new TreeSet<>();
//	        ts.
        for (int i = 0; i < nums1.length; i++) {
            ts.add(nums1[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (ts.contains(nums2[i])) {
                res.add(nums2[i]);
                ts.remove(nums2[i]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
