package com.classloader.test;

import com.classloader.test.bean.Role;
import com.classloader.test.classloader.CustomAppClassLoader;
import com.classloader.test.consts.Constants;

import java.lang.reflect.InvocationTargetException;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/4/28 下午5:19
 */
public class CustomAppClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, InterruptedException {

        // 自定义Classloader
        ClassLoader classLoader = new CustomAppClassLoader();
        try {
            Role role = (Role) classLoader.loadClass(Constants.TEACHER_CLASS_NAME).newInstance();
            role.say();

            System.out.println("the role class loader: \t\t" + Role.class.getClassLoader());
            System.out.println("the teacher class loader: \t" + role.getClass().getClassLoader());
            System.out.println("type instanceof Role judge: \t" + (role instanceof Role));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);
        System.out.println("\n-----------------　分割线　-----------------\n");

        try {
            Object role = classLoader.loadClass(Constants.TEACHER_CLASS_NAME).newInstance();
            role.getClass().getMethod("say").invoke(role);

            System.out.println("the role class loader: \t\t" + Role.class.getClassLoader());
            System.out.println("the teacher class loader: \t" + role.getClass().getClassLoader());
            System.out.println("type instanceof Role judge: \t" + (role instanceof Role));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-----------------结束啦老铁-----------------");
        System.out.println("The application is done.");
    }
}
