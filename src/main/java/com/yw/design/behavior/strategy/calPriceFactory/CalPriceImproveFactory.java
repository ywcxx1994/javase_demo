package com.yw.design.behavior.strategy.calPriceFactory;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.yw.design.behavior.strategy.CalPrice;
import com.yw.design.behavior.strategy.Customer;
import com.yw.design.behavior.strategy.anno.TotalValidRegion;


public class CalPriceImproveFactory {
    //这里是一个常量，表示我们扫描策略的包
    private static final String CAL_PRICE_PACKAGE = "com.yw.design.behavior.strategy.impl";
    ////我们加载策略时的类加载器，我们任何类运行时信息必须来自该类加载器
    private ClassLoader classLoader = this.getClass().getClassLoader();
    //策略列表
    private List<Class<? extends CalPrice>> calPriceList;

    // 处理注解，我们传入一个策略类，返回它的注解
    private TotalValidRegion handleAnnotation(Class<? extends CalPrice> clazz) {
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (Annotation annotation : annotations) {
            if (annotation instanceof TotalValidRegion) {
                return (TotalValidRegion) annotation;
            }
        }

        return null;

    }

    //获取扫描的包下面所有的class文件,返回文件数组对象
    private File[] getResources() {
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
        Class<CalPrice> calPriceClazz = null;
        try {
            //使用相同的加载器加载策略接口
            calPriceClazz = (Class<CalPrice>) classLoader.loadClass(CalPrice.class.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("\"未找到策略接口\"");
        }
        for (int i = 0; i < files.length; i++) {
            try {
                //载入包下的类
                Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE + "." + files[i].getName().replace(".class", ""));
                if (CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClazz) {
                    //加入到策略列表
                    calPriceList.add((Class<? extends CalPrice>) clazz);
                }

            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //根据客户的总金额产生相应的策略对象。
    public CalPrice createCalPrice(Customer customer) {
        if (customer == null) {
            throw new RuntimeException("fuck you ,costomer is not null");
        }
        for (int i = 0; i < calPriceList.size(); i++) {
            Class<? extends CalPrice> clazz = calPriceList.get(i);
            TotalValidRegion totalValidRegion = this.handleAnnotation(clazz);
            if (customer.getTotalAmount() < totalValidRegion.max() &&
                    customer.getTotalAmount() > totalValidRegion.min()) {
                try {
                    return clazz.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 构造方法初始化init()方法
     */
    private CalPriceImproveFactory() {
        this.init();
    }

    private static class CalPriceFactoryInstance {
        private static CalPriceImproveFactory instance = new CalPriceImproveFactory();
    }

    public static CalPriceImproveFactory getInstance() {
        return CalPriceFactoryInstance.instance;
    }

}
