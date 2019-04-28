/**
* @Company JBINFO   
* @Title: MyInterceptor.java 
* @Package com.yw.proxy.mybatisInterceptor 
* @author Yan Wei   
* @date 2018年1月17日 下午12:53:01 
* @version V1.0   
*/ 
package com.yw.proxy.mybatisInterceptor;

/** 
* @ClassName: MyInterceptor 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class MyInterceptor implements Interceptor {

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	 * @throws Exception 
	* @date 2018年1月17日 下午12:53:01  
	* @see com.yw.proxy.mybatisInterceptor.Interceptor#interceptor() 
	*/
	@Override
	public Object interceptor(Invocation invocation) throws Exception {
		System.out.println("自定义业务逻辑开始");
		return invocation.process();
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年1月17日 下午2:45:14 
	* @param target
	* @return 
	* @see com.yw.proxy.mybatisInterceptor.Interceptor#register(java.lang.Object) 
	*/ 
	@Override
	public Object register(Object target) {
		return Plugin.warp(target, this);
	}

}
