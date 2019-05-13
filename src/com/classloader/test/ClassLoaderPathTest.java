package com.classloader.test;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/4/28 下午6:29
 */
public class ClassLoaderPathTest {

    public static void main(String[] args) throws InterruptedException {

        URLClassLoader appClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        URLClassLoader extClassLoader = (URLClassLoader) appClassLoader.getParent();
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();

        // BootstrapClassLoader加载class路径
        System.out.println("BootstrapClassLoader加载class路径: \n");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.getPath());
        }

        System.out.println("-----------------　分割线　-----------------");
        System.out.println("BootstrapClassLoader: " + bootstrapClassLoader);
        System.out.println("" + System.getProperty("sun.boot.class.path"));

        // ExtClassLoader加载路径
        System.out.println("ExtensionClassLoader加载class路径: \n");
        urls = extClassLoader.getURLs();
        for (URL url : urls) {
            System.out.println(url.getPath());
        }

        System.out.println("-----------------　分割线　-----------------");
        System.out.println("ExtensionClassLoader: " + extClassLoader);
        System.out.println("");

        // AppClassLoader加载路径
        appClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        System.out.println("SystemClassLoader加载class路径: \n");
        urls = appClassLoader.getURLs();
        for (URL url : urls) {
            System.out.println(url.getPath());
        }
        System.out.println("-----------------　分割线　-----------------");
        System.out.println("SystemClassLoader: " + appClassLoader);
        System.out.println("");

        // 演示classpath命令的值
//        System.out.println("-classpath的值: " + System.getProperty("java.class.path"));

        // 演示Student加载类(1. 默认  2. 扔到jre/classes 3. 使用-Xbootclasspath参数)
//        System.out.println("Student ClassLoader: " + Student.class.getClassLoader());

        Thread.sleep(1000);
        System.out.println("-----------------结束啦老铁-----------------");
        System.out.println("The application is done.");
    }

    // java com.classloader.test.ClassLoaderPathTest
    // java -Xbootclasspath/a:/data/code/ClassloaderTest/out/production/ClassloaderTest com.classloader.test.ClassLoaderPathTest

}
