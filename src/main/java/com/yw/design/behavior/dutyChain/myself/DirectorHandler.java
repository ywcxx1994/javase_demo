package com.yw.design.behavior.dutyChain.myself;
/**
 * 第二级领导
 * @author 18765
 *
 */
public class DirectorHandler extends Handler{
	
	@Override
	public void handler(Request request) {
		if(request.getDays()>10) {
			if(this.getHandler() != null) {
				this.getHandler().handler(request);
			}
		}else if(request.getDays()<7 && request.getDays()>3){
			System.out.println("部门经理批准了你的"+request.getDays()+"天假期");
		}
	}
	
}
