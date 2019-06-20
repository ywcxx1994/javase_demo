package com.yw.structure.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 利用最大堆，解决数组中出现频次最高的k个元素的问题
 *
 * @author 18765
 */
public class Solution {
    class FreQ implements Comparable<FreQ> {

        public int num, freq;

        public FreQ(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(FreQ another) {
            //这里定义队列存储元素的优先级
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            }
            return 0;
        }
    }

    //统计前k个元素出现的频次最高的
    public List<Integer> topKFrequent(int[] nums, int k) {
        //利用这个map，统计各个数组出现的频次
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (tm.containsKey(nums[i])) {
                tm.put(nums[i], tm.get(nums[i]) + 1);
            } else {
                tm.put(nums[i], 1);
            }
        }
        //利用最大堆构造一个优先队列，优先队列中存放的栈顶元素是出现频次最低的元素。
        PriorityQueue<FreQ> pq = new PriorityQueue<>();
        //遍历map
        for (int key : tm.keySet()) {
            //如果优先队列存储的元素小于第k个，那么构建一个freq，添加到优先队列中。
            if (pq.getSize() < k) {
                FreQ fq = new FreQ(key, tm.get(key));
                pq.enqueue(fq);
            }
            //如果当前遍历的大于优先队列中队首的元素，那么优先队列弹栈，从新入栈当前元素
            else if (tm.get(key) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new FreQ(key, tm.get(key)));
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.dequeue().num);
        }
        return result;
    }
}