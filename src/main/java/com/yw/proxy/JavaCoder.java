package com.yw.proxy;

import com.yw.proxy.mybatisInterceptor.MethodName;

@MethodName({"code"})
public class JavaCoder implements Coder{

	@Override
	public String code() {
		System.out.println("java coder");
		return "use java coding";
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年1月16日 下午6:21:50 
	* @return 
	* @see com.yw.proxy.Coder#jiaban() 
	*/ 
	@Override
	public String jiaban() {
		System.out.println("fuck add work");
		return "fuck";
	}
	
}
