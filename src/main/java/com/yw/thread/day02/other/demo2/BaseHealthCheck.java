/**
 * @Company JBINFO
 * @Title: BaseHealthCheck.java
 * @Package com.yw.thread.day02.other.demo2
 * @author Yan Wei
 * @date 2018年6月6日 上午9:10:42
 * @version V1.0
 */
package com.yw.thread.day02.other.demo2;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: BaseHealthCheck
 * @Description: 所有检查类的基类
 * @author Yan Wei
 */
public abstract class BaseHealthCheck implements Runnable {
    private boolean _serviceUp;
    private String _serviceName;
    private CountDownLatch _latch;

    public BaseHealthCheck(String _serviceName, CountDownLatch _latch) {
        this._serviceName = _serviceName;
        this._latch = _latch;
    }

    /**
     * <p>Description: </p>
     * @author Yan Wei
     * @date 2018年6月6日 上午9:14:13
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

        try {
            this.veriftyService();
            this._serviceUp = true;
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            this._serviceUp = false;
        } finally {
            this._latch.countDown();
        }
    }

    public abstract void veriftyService();

    public String get_serviceName() {
        return _serviceName;
    }

    public void set_serviceName(String _serviceName) {
        this._serviceName = _serviceName;
    }

    public boolean getServiceUp() {
        return this._serviceUp;
    }
}
