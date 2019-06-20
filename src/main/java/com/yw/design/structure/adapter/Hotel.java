/**
 * @Company JBINFO
 * @Title: Hotel.java
 * @Package com.yw.design.structure.adapter
 * @author Yan Wei
 * @date 2018年1月11日 下午12:52:45
 * @version V1.0
 */
package com.yw.design.structure.adapter;

/**
 * @ClassName: Hotel
 * @Description: 德国宾馆，具有插排
 * @author Yan Wei
 */
public class Hotel {
    private DBSocketInterface dbSocketInterface;


    public void setDbSocketInterface(DBSocketInterface dbSocketInterface) {
        this.dbSocketInterface = dbSocketInterface;
    }

    public Hotel() {
    }

    /**
     *
     * <p>宾馆一初始化就具备插排功能: </p>
     * @author Yan Wei
     * @date 2018年1月11日 下午12:53:52
     * @param dbSocketInterface
     */
    public Hotel(DBSocketInterface dbSocketInterface) {
        this.dbSocketInterface = dbSocketInterface;
    }

    /**
     *
     * @Description:提供供电方法
     * @author Yan Wei
     * @date 2018年1月11日 下午12:54:42
     */
    public void charge() {
        this.dbSocketInterface.dbRound();
    }
}
