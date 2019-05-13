package com.classloader.test.classloader;

import com.classloader.test.consts.Constants;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/4/28 下午5:29
 */
public class CustomAppClassLoader extends ClassLoader implements FileLoader {

    public CustomAppClassLoader(ClassLoader parent) {
        super(parent);
    }

    public CustomAppClassLoader() {
    }

    @Override
    public Class<?> loadClass(String s) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(s)) {
            try {
                // try to load all Custom Class by this classloader
                Class resolved = findLoadedClass(s);
                if (resolved != null) {
                    if (Constants.OBJECT_CLASS_NAME.equals(s)) {
                        System.out.println("正在使用CustomAppClassLoader加载: [" + s + "]，找到缓存");
                    }
                    return resolved;
                } else {
                    if (Constants.OBJECT_CLASS_NAME.equals(s)) {
                        System.out.println("正在使用CustomAppClassLoader加载: [" + s + "]，未找到");
                    }
                }

                byte[] classBytes = readClassAsBytes(s);
                return defineClass(s, classBytes, 0, classBytes.length);
            } catch (Exception e) {
                // if can't load class, use super loadClass method
                return super.loadClass(s);
            }
        }
    }

}
