package com.panda.annotationdemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 原文链接：https://blog.csdn.net/jianjiacuncao/article/details/79814351
 * 1、RetentionPolicy.Source:注解可保留源文件，当Java文件编译成class文件的时候，注解被遗弃；
 * 2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时被遗弃，这是默认的声明周期
 * 3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在。
 * 这三个声明周期分别对应于：Java源文件（.java文件）->.class文件->内存中的字节码。
 * 首先要明确生命周期长度SOURCE<CLASS<RUNTIME,所以前者能作用的地方后者一定也能作用。一般如果需要在运行时去动态获取注解信息，那只能用RUNTIME注解；如果要在编译时进行一些预处理操作，比如生成一些辅助代码（如 ButterKnife），就用 CLASS注解；如果只是做一些检查性的操作，比如** @Override**和 @SuppressWarnings，则可选用 SOURCE 注解。
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Jiecha {

}
