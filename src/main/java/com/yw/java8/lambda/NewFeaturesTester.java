/**
 * @Company JBINFO
 * @Title: NewFeaturesTester.java
 * @Package com.yw.java8.lambda
 * @author Yan Wei
 * @date 2018年2月5日 下午5:00:54
 * @version V1.0
 */
package com.yw.java8.lambda;

/**
 * @ClassName: NewFeaturesTester
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class NewFeaturesTester {
    public static void main(String args[]) {
        NewFeaturesTester tester = new NewFeaturesTester();

        // 带有类型声明的表达式
        MathOperation addition = (int a, int b) -> a + b;

        // 没有类型声明的表达式
        MathOperation subtraction = (a, b) -> a - b;

        // 带有大括号、带有返回语句的表达式
        MathOperation multiplication = (a, b) -> {
            return a * b;
        };
        // 没有大括号和return语句的表达式
        MathOperation division = (a, b) -> a / b;

        // 输出结果
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

//          // 没有括号的表达式            
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 有括号的表达式
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        // 调用sayMessage方法输出结果
        greetService1.sayMessage("Shiyanlou");
        greetService2.sayMessage("Classmate");
    }

    // 下面是定义的一些接口和方法

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}

