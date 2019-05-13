package com.classloader.test;

import com.classloader.test.bean.Role;
import com.classloader.test.classloader.ParticularClassLoader;
import com.classloader.test.consts.Constants;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/5/7 上午10:51
 */
public class ClassLoaderParallelTest {

    public static void main(String[] args) {
        // 对Teacher使用特定Classloader
        ClassLoader classLoader = new ParticularClassLoader();

        // 使用多个线程并发执行
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; ++i) {
            service.execute(() -> {
                try {
                    Role role = (Role) classLoader.loadClass(Constants.TEACHER_CLASS_NAME).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();
    }

}
