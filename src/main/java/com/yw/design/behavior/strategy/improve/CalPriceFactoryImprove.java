/**
* @Company JBINFO   
* @Title: CalPriceFactoryImprove.java 
* @Package com.yw.design.behavior.strategy.improve 
* @author Yan Wei   
* @date 2018年3月26日 上午11:03:08 
* @version V1.0   
*/ 
package com.yw.design.behavior.strategy.improve;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.Customer;
import com.yw.design.behavior.strategy.improve.anno.OnceValidRegion;
import com.yw.design.behavior.strategy.improve.anno.TotalValidRegion;

/** 
* @ClassName: CalPriceFactoryImprove 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class CalPriceFactoryImprove {
	//这里是一个常量，表示我们扫描策略的包
	private static final  String CAL_PRICE_PACKAGE="com.yw.design.behavior.strategy.improve.stra";
	// 我们加载策略时的类加载器，我们任何类运行时信息必须来自该类加载器
	private ClassLoader classLoader = this.getClass().getClassLoader();
	// 策略列表
	private List<Class<? extends CalPrice>> calPriceList;
	//根据客户的总金额产生相应的策略
	public CalPrice createCalPrice(Customer customer){
		 //变化点:为了支持优先级排序，我们采用可排序的MAP支持,这个Map是为了储存我们当前策略的运行时类信息
		SortedMap<Integer, Class<? extends CalPrice>> classMap = 
				new TreeMap<Integer, Class<? extends CalPrice>>();
		calPriceList.forEach(obj ->{
			Annotation annotation = this.handleAnnotation(obj);
			//处理第一个策略
			if(annotation instanceof TotalValidRegion) {
				TotalValidRegion anno = (TotalValidRegion)annotation;
				//判断总金额是否在注解的区间
				if(customer.getTotalAmount()>anno.value().min() &&
						customer.getTotalAmount()<anno.value().max()) {
					classMap.put(anno.value().order(), obj);
				}
			}
			//处理第二种策略
			if(annotation instanceof OnceValidRegion) {
				OnceValidRegion anno = (OnceValidRegion)annotation;
				//判断单次金额是否在注解的区间
				if(customer.getAmount()>anno.value().min() &&
						customer.getAmount()<anno.value().max()) {
					classMap.put(anno.value().order(), obj);
				}
			}
			
		});
		return CalPriceProxy.getProxy(classMap);
	}
	//处理注解，我们传入一个策略类，返回它的注解
	public Annotation handleAnnotation(Class<? extends CalPrice>  clazz) {
		if(clazz ==null) {
			return null;
		}
		Annotation[] annos = clazz.getDeclaredAnnotations();
		for (Annotation annotation : annos) {
			//变化点：这里稍微改动了下,如果是TotalValidRegion,OnceValidRegion这两种注解则返回
			if(annotation instanceof TotalValidRegion) {
				return (TotalValidRegion)annotation;
			}
			if(annotation instanceof OnceValidRegion) {
				return (OnceValidRegion)annotation;
			}
		}
		return null;
	}
	//以下不需要改变
	 //获取扫描的包下面所有的class文件,返回文件数组对象
    private File[] getResources(){
        try {
            File file = new File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class")) {//我们只扫描class文件
                        return true;
                    }
                    return false;
                }
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }
    
	//工厂初始化
	private void init() {
		calPriceList = new ArrayList<Class<? extends CalPrice>>();
		File[] files = this.getResources();//获取到包下所有的class文件
		Class<CalPrice> calPriceClazz=null;
		try {
			//使用相同的加载器加载策略接口
			calPriceClazz = (Class<CalPrice>)classLoader.loadClass(CalPrice.class.getName());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("\"未找到策略接口\"");
		}
		for (int i = 0; i < files.length; i++) {
			try {
				//载入包下的类
				Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE+"."+files[i].getName().replace(".class", ""));
				if(CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClazz) {
					//加入到策略列表
					calPriceList.add((Class<? extends CalPrice>)clazz);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 构造方法初始化init()方法
	 */
	private CalPriceFactoryImprove() {
		this.init();
	}
	private static class CalPriceFactoryInstances{
		private static CalPriceFactoryImprove instance =  new CalPriceFactoryImprove();
	}
	
	public static CalPriceFactoryImprove getInstance(){
        return CalPriceFactoryInstances.instance;
    }
}
