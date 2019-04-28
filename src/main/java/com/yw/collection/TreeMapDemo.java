package com.yw.collection;

import java.util.ArrayList;
import java.util.TreeMap;

public class TreeMapDemo {
	public int[] intersection(int[] nums1, int[] nums2) {
       TreeMap<Integer, Integer> tm = new TreeMap<>();
       for (int i = 0; i < nums1.length; i++) {
    	   if(tm.containsKey(nums1[i])) { 
    		   tm.put(nums1[i], tm.get(nums1[i])+1);
    	   }else {
    		   tm.put(nums1[i], 1);
    	   }
       }
       ArrayList<Integer> res = new ArrayList<>();
       for (int i = 0; i < nums2.length; i++) {
    	   if(tm.containsKey(nums2[i])) {
    		   res.add(nums2[i]);
    		   tm.put(nums2[i], tm.get(nums2[i])-1);
    		   if(tm.get(nums2[i]) == 0) {
    			   tm.remove(nums2[i]);
    		   }
    	   }
       }
       int[] arr = new int[res.size()];
       for (int i = 0; i < res.size(); i++) {
			arr[i] = res.get(i);
		}
       return arr;     
   }
}
