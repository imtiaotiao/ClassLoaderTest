package com.classloader.test.bean;

import java.lang.management.ManagementFactory;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/4/28 下午4:41
 */
public class Student extends Role {

    public static final String FINAL_STATIC_TEST = "测试";

    public static String STATIC_VAR_TEST = initSth();

    static {
        System.out.println("Student: 我静态代码块初始化啦");
    }

    public static void staticMethodTest() {
        ManagementFactory.getOperatingSystemMXBean();
        // do nothing
    }

    private static String initSth() {
        System.out.println("Student: 我静态变量初始化啦");
        return "xxxx";
    }

    @Override
    public void say() {
        System.out.println("Hi, I'm the student role. \n");
    }
}
