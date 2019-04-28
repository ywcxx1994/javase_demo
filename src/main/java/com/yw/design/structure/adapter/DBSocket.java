/**
* @Company JBINFO   
* @Title: DBSocket.java 
* @Package com.yw.design.structure.adapter 
* @author Yan Wei   
* @date 2018年1月11日 下午12:51:16 
* @version V1.0   
*/ 
package com.yw.design.structure.adapter;

/** 
* @ClassName: DBSocket 
* @Description: 德国的插排 
* @author Yan Wei  
*/
public class DBSocket implements DBSocketInterface{

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年1月11日 下午12:51:42  
	* @see com.yw.design.structure.adapter.DBSocketInterface#dbRound() 
	*/ 
	@Override
	public void dbRound() {
		System.out.println("使用德国插排充电");
	}

}
