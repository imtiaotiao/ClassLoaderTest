package com.classloader.test;

import com.classloader.test.classloader.ParticularClassLoader;
import com.classloader.test.consts.Constants;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/5/6 下午5:56
 */
public class CustomClassUnloadTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        // 对Teacher使用特定Classloader
        ClassLoader classLoader = new ParticularClassLoader();
        Class classz = classLoader.loadClass(Constants.TEACHER_CLASS_NAME);
        Object teacher = classz.newInstance();

        // 给Teacher Class实例增加一个弱引用
        WeakReference weakCar = new WeakReference(classz);

        // 清除所有相关的引用
        teacher = null;
        classz = null;
        classLoader = null;

        System.out.println(weakCar.get());

        // 通知JVM执行一次gc，但gc时机不可控
        System.gc();

        // 若类型已经释放，则获取到的对象为null
        System.out.println(weakCar.get());
    }

}
