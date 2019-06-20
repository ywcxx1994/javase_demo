/**
 * @Company JBINFO
 * @Title: Test.java
 * @Package com.yw.design.structure.adapter
 * @author Yan Wei
 * @date 2018年1月11日 下午12:55:01
 * @version V1.0
 */
package com.yw.design.structure.adapter;

/**
 * @ClassName: Test
 * @Description: 测试类
 * @author Yan Wei
 */
public class Test {
    public static void main(String[] args) {
        adapter();
    }

    private static void adapter() {
        //搞一个中国插排
        ChinaSocket chinaSocket = new ChinaSocket();
        //在德国住下了
        Hotel hotel = new Hotel();
        //使用适配器转换一下
        SocketAdapter adapter = new SocketAdapter(chinaSocket);
        //将适配器插入到插座
        hotel.setDbSocketInterface(adapter);
        hotel.charge();
    }

    /**
     *
     * @Description: 使用德国插排充电
     * @author Yan Wei
     * @date 2018年1月11日 下午1:25:34
     */
    private static void dBRound() {
        //生产出插排实例来
        DBSocketInterface dbSocket = new DBSocket();
        //有家宾馆
        Hotel hotel = new Hotel(dbSocket);
        //使用德国插排充电
        hotel.charge();
    }
}
