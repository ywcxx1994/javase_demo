package com.yw.design.behavior.dutyChain.myself;
/**
 * 顶级处理抽象方法的角色
 * @author 18765
 *
 */
public abstract class Handler {
	
	public Handler handler;//持有下一个目标对象。
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public abstract void handler(Request request);
}
