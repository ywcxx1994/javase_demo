package com.yw.design.behavior.dutyChain.myself;

public class FirstLeaderHandler extends Handler{
	

	@Override
	public void handler(Request request) {
		if(request.getDays()<3) {
			System.out.println("一级领导批准了你的"+request.getDays()+"天假期");
		}else {
			if(this.getHandler()!=null) {
				this.getHandler().handler(request);
			}
		}
	}

}
