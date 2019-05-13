package com.classloader.test.classloader;

import com.classloader.test.consts.Constants;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/4/28 下午5:31
 */
public class ParticularClassLoader extends ClassLoader implements FileLoader {

    public ParticularClassLoader(ClassLoader parent) {
        super(parent);
    }

    public ParticularClassLoader() {
    }

    @Override
    public Class<?> loadClass(String s) throws ClassNotFoundException {
        try {
            // load Teacher Class by this classloader
            if (Constants.TEACHER_CLASS_NAME.equals(s)) {
                Class resolved = findLoadedClass(s);
                if (resolved != null) {
                    return resolved;
                }

                byte[] classBytes = readClassAsBytes(s);
                return defineClass(s, classBytes, 0, classBytes.length);
            } else {
                // if class is not Teacher, use super loadClass method
                Class cls = super.loadClass(s);
                if (Constants.ROLE_CLASS_NAME.equals(s)) {
                    System.out.println("正在使用ParticularClassLoader加载：[" + s + "]");
                }
                return cls;
            }
        } catch (Exception e) {
            throw new ClassNotFoundException(s);
        }
    }

}
