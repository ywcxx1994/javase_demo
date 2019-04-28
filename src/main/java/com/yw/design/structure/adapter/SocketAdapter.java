/**
* @Company JBINFO   
* @Title: SocketAdapter.java 
* @Package com.yw.design.structure.adapter 
* @author Yan Wei   
* @date 2018年1月11日 下午12:59:28 
* @version V1.0   
*/ 
package com.yw.design.structure.adapter;

/** 
* @ClassName: SocketAdapter 
* @Description:
1    必须符合德国标准的接口，否则的话还是没办法插到德国插座中；
2    在调用上面实现的德标接口进行充电时，提供一种机制，将这个调用转到对中国接口的调用 。

* @author Yan Wei  
*/
public class SocketAdapter implements DBSocketInterface{
	/**
	 * 持有中国插排的引用
	 */
	private ChinaSocket chinaSocket;
	
	/**
	 * 
	* <p>插排适配器，必须实现原有接口，用现在接口适配插排 </p> 
	* @author Yan Wei   
	* @date 2018年1月11日 下午1:00:56 
	* @param chinaSocket
	 */
	public SocketAdapter(ChinaSocket chinaSocket) {
		this.chinaSocket = chinaSocket;
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年1月11日 下午12:59:44  
	* @see com.yw.design.structure.adapter.DBSocketInterface#dbRound() 
	*/ 
	@Override
	public void dbRound() {
		// TODO Auto-generated method stub
		chinaSocket.dbRound();
	}

}
