package com.classloader.test;

import com.classloader.test.bean.Role;
import com.classloader.test.classloader.CustomAppClassLoader;
import com.classloader.test.classloader.ParticularClassLoader;
import com.classloader.test.consts.Constants;

import java.lang.reflect.InvocationTargetException;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/5/5 下午4:50
 */
public class ClassLoaderNameSpaceTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException, NoSuchMethodException, InvocationTargetException {

        // 自定义Classloader，通过反射调用方法
        ClassLoader classLoader = new CustomAppClassLoader();
        Object role = classLoader.loadClass(Constants.TEACHER_CLASS_NAME).newInstance();
        role.getClass().getMethod("say").invoke(role);

        // 显示加载java.lang.Object
        classLoader.loadClass("java.lang.Object");

        System.out.println("the app loader: \t\t\t\t" + ClassLoader.getSystemClassLoader());
        System.out.println("the teacher class loader: \t\t" + role.getClass().getClassLoader());
        System.out.println("type instanceof Role judge: \t" + (role instanceof Role));

        Thread.sleep(1000);
        System.out.println("-----------------结束啦老铁-----------------");
        System.out.println("The application is done.");
    }
}
