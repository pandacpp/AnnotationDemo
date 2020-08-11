package com.panda.annotationdemo;

import org.junit.Test;

import java.lang.reflect.Method;


public class TestTool {

    @Test
    public void main() {
        NoBug testobj = new NoBug();
        Class clazz = testobj.getClass();
        //返回Method对象的一个数组，这些对象反映此Class对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        Method[] method = clazz.getDeclaredMethods();
        //用来记录测试产生的 log 信息
        StringBuilder log = new StringBuilder();
        // 记录异常的次数
        int errornum = 0;

        for (Method m : method) {
        // 只有被 @Jiecha 标注过的方法才进行测试，A.isAnnotationPresent(B.class);B类型的注解是否在A类上
            if (m.isAnnotationPresent(Jiecha.class)) {
                try {
                    //java代码中，常常将一个类的成员变量设置为private
                    //在类的外面获取此类的私有成员变量的value时，需要注意：设置setAccessible
                    m.setAccessible(true);
                    m.invoke(testobj, null);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    //e.printStackTrace();
                    errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    //记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }


        log.append(clazz.getSimpleName());
        log.append(" has  ");
        log.append(errornum);
        log.append(" error.");

        // 生成测试报告
        System.out.println(log.toString());

    }

}