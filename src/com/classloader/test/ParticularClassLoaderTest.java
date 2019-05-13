package com.classloader.test;

import com.classloader.test.bean.Role;
import com.classloader.test.bean.Student;
import com.classloader.test.bean.Teacher;
import com.classloader.test.classloader.CustomAppClassLoader;
import com.classloader.test.classloader.ParticularClassLoader;
import com.classloader.test.consts.Constants;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/4/28 下午4:41
 */
public class ParticularClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        // 可以将Student及Role全包路径放在jre/classes下，看看它的ClassLoader是谁
//        System.out.println(Student.class.getClassLoader());

        // 对Teacher使用特定Classloader
        ClassLoader classLoader = new ParticularClassLoader();
        Object classz = classLoader.loadClass(Constants.TEACHER_CLASS_NAME).newInstance();

        Role role = (Role) classz;
        role.say();

        System.out.println("the role class loader: \t\t" + Role.class.getClassLoader());
        System.out.println("the teacher class loader: \t" + role.getClass().getClassLoader());
        System.out.println("type instanceof Role judge: \t" + (role instanceof Role));

        // 试试看这里的结果
//         System.out.println("type instanceof Teacher judge: \t" + (role instanceof Teacher));

        Thread.sleep(1000);
        System.out.println("-----------------结束啦老铁-----------------");
        System.out.println("The application is done.");
    }
}
