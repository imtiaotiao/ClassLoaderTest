package com.classloader.test;

import com.classloader.test.bean.Student;
import com.classloader.test.classloader.CustomAppClassLoader;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/5/10 下午2:27
 */
public class ClassInitializationTest {

    static {
        // 执行main方法主类，JVM先初始化
        System.out.println("ClassInitializationTest: 我是入口类我先初始化");
    }

    public static void main(String[] args) throws Throwable {
        // 1. 引用常量
//        System.out.println(Student.FINAL_STATIC_TEST);

        // 2. 引用静态变量
//        System.out.println(Student.STATIC_VAR_TEST);

        // 3. 调用静态方法
//        Student.staticMethodTest();

        // 4. 实例化对象
//        Student student = new Student();

        // 5. 通过反射的方式显示加载
//        Class.forName("com.classloader.test.bean.Student");
//        Class.forName("com.classloader.test.bean.Student", false, ClassLoaderPathTest.class.getClassLoader());

        // 6. 通过自定义classloader显示加载
//        CustomAppClassLoader classLoader = new CustomAppClassLoader();
//        Class classz = classLoader.loadClass("com.classloader.test.bean.Student");
//        classz.newInstance();

        // 7. java.lang.MethodHandle动态语言支持
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle handle = lookup.findStatic(Student.class, "staticMethodTest", MethodType.methodType(void.class));
        handle.invoke();
    }
}
