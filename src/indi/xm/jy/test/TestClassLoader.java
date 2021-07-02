package indi.xm.jy.test;

import java.lang.reflect.Method;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.test
 * @ClassName: TestClassLoader
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/7/2 15:27
 */
public class TestClassLoader {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println(clazz.getClassLoader());
        System.out.println("******************************");
        Class<?> parentClazz = clazz.getSuperclass();
        Method[] parentMethods = parentClazz.getDeclaredMethods();
        for (Method method : parentMethods) {
            System.out.println(method.getName());
        }
        System.out.println(parentClazz.getClassLoader());
    }
}
