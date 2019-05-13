package com.classloader.test.bean;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/4/28 下午4:42
 */
public abstract class Role {

    static {
        System.out.println("Role: 我静态代码块初始化啦");
    }

    public static String getClassName() {
        String name = Role.class.getName();
        return name;
    }

    public abstract void say();

}
