package com.classloader.test.bean;

import java.io.Serializable;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/4/28 下午4:42
 */
public class Teacher extends Role implements Serializable {

    class Inner {
        int a;
    }

    public void  test() {
        Inner inner = new Inner();
    }

    @Override
    public void say() {
        // 隐式加载java.lang.Object
        Object obj = new Object();

        // 隐式加载java.lang.Integer
//        Class classz = Integer.class;

        // 隐式加载com.classloader.test.bean.Student
//        String s = Student.FINAL_STATIC_TEST;


        // 名字空间类型共享，可直接操作类型
        String roleClassName = Role.getClassName();

        System.out.println("Hi, I'm the teacher role. \n");
    }

}
