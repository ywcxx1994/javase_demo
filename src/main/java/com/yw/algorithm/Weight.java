package com.yw.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author: yanwin
 * @Date: 2020/5/12
 * @Desc:按照权重设置奖品比例实现
 *
 * 参考：https://mp.weixin.qq.com/s/ubVBZO_x0Pzn9hwyka19wg
 */
public class Weight {

    public static class WeightNode {
        /**
         * 奖品
         **/
        private String key;
        /**
         * 奖品权重
         **/
        private Integer weight;
        /**
         * 最低范围
         **/
        private Integer minValue;
        /**
         * 最高范围
         **/
        private Integer maxValue;

        public WeightNode(String key, Integer weight, Integer minValue, Integer maxValue) {
            this.key = key;
            this.weight = weight;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        @Override
        public String toString() {
            return "key:" + this.key + " weight:" + this.weight + " low:" + this.minValue + " height:" + this.maxValue;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public Integer getMinValue() {
            return minValue;
        }

        public void setMinValue(Integer minValue) {
            this.minValue = minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(Integer maxValue) {
            this.maxValue = maxValue;
        }
    }
    /**
     * 存储数据节点
     */
    private List<WeightNode> nodes;

    /**
     * 设置数据与权重
     *
     * @param keys    数据
     * @param weights 权重
     */
    public void addNode(String[] keys, Integer[] weights) {
        if (keys == null || weights == null || keys.length != weights.length) {
            return;
        }
        nodes = new ArrayList<>();
        for (int i = 0; i < keys.length; i++) {
            Integer minValue = 0;
            Integer maxValue = 0;
            if (i == 0) {
                minValue = i;
                maxValue = weights[i];
            } else {
                if (i + 1 <= keys.length) {
                    Integer sum = preSum(weights, i);
                    minValue = sum;
                    maxValue = sum + weights[i];
                }
            }
            nodes.add(new WeightNode(keys[i], weights[i], minValue, maxValue));
        }
    }

    /**
     * 累加权重
     *
     * @param array 数组
     * @param index 索引
     * @return 和
     */
    private Integer preSum(Integer[] array, Integer index) {
        Integer sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < index) {
                sum += array[i];
            }
        }
        return sum;
    }

    /**
     * 根据生成的随机数遍历所有元素，查找到随机数的范围
     *
     * @param randomValue 生成的随机数
     * @return 范围节点
     */
    public WeightNode getElementByRandomValue(Integer randomValue) {
        //左闭右开
        for (WeightNode e : nodes) {
            if (randomValue >= e.getMinValue() && randomValue < e.getMaxValue()) {
                return e;
            }
        }
        return null;
    }

    /**
     * 在权重是顺序的情况下，可以采用二分法加速查询
     *
     * @param randomValue 生成的随机数
     * @return 范围节点
     */
    public WeightNode getElementByRandomValueBinary(Integer randomValue) {
        if (randomValue < 0 || randomValue > getMaxRandomValue() - 1) {
            return null;
        }
        int start = 0, end = nodes.size() - 1;
        int middle = nodes.size() >> 1;
        while (true) {
            if (randomValue <= nodes.get(middle).getMinValue()) {
                end = middle - 1;
            } else if (randomValue > nodes.get(middle).getMaxValue()) {
                start = middle + 1;
            } else {
                return nodes.get(middle);
            }
            middle = (start + end) >> 1;
        }
    }

    /**
     * 权重总和，用于设置生成随机数的最大上限
     *
     * @return 权重总和
     */
    public Integer getMaxRandomValue() {
        if (nodes.size() == 0) {
            return null;
        }
        return nodes.get(nodes.size() - 1).getMaxValue();
    }

    public static void main(String[] args) {
        Weight wr = new Weight();
//        wr.initWeight(new String[]{"谢谢参与", "50 元话费", "200 元京东购物卡", "星球年卡一张"}, new Integer[]{10, 10, 10, 70});
        wr.addNode(new String[]{"谢谢参与", "50 元话费", "200 元京东购物卡", "星球年卡一张"}, new Integer[]{990, 7, 2, 1});
        Random random = new Random();
        HashMap<String, Integer> keyCount = new HashMap<>(16);
        keyCount.put("谢谢参与", 0);
        keyCount.put("50 元话费", 0);
        keyCount.put("200 元京东购物卡", 0);
        keyCount.put("星球年卡一张", 0);
        for (int i = 0; i < 1000; i++) {
            Integer randomValue = random.nextInt(wr.getMaxRandomValue());
            String key = wr.getElementByRandomValue(randomValue).getKey();
            keyCount.put(key, keyCount.get(key) + 1);
        }
        keyCount.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
}
