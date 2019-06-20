package com.yw.design.behavior.dutyChain.myself;

/**
 * 总经理角色，权限最大。
 *
 * @author 18765
 */
public class ManagerHandler extends Handler {

    @Override
    public void handler(Request request) {
        if (request.getDays() > 10) {
            System.out.println("请假时间大于10天，不予批准！");
        } else {
            System.out.println("总经理同意你的" + request.getDays() + "天假期");
        }
    }

}
