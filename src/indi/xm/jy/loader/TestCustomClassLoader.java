package indi.xm.jy.loader;

import indi.xm.jy.loader.FileClassLoader;
import sun.nio.ch.Net;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.test
 * @ClassName: TestCustomClassLoader
 * @Author: albert.fang
 * @Description: 测试自定义类加载器
 * @Date: 2021/7/2 10:29
 */
public class TestCustomClassLoader {
    public static void main(String[] args) throws Exception {
//        testFileClassLoader();
        testFileClassLoader02();
//        testFileClassLoader03();
//        testNetClassLoader();
    }


    // 测试自定义fileclassloadar类加载器
    private static void testFileClassLoader() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        FileClassLoader fileClassLoader = new FileClassLoader("E:\\IdeaProjects\\simple\\out\\production\\simple");
        Class<?> clazz = fileClassLoader.loadClass("indi.xm.jy.Fxm");
        Method[] methods = clazz.getDeclaredMethods();
        Object o = clazz.newInstance();

        for (Method method : methods) {
            method.setAccessible(true);
            if ("truthWord".equals(method.getName())){
                System.out.println(method.invoke(o));
            }
            else {
                method.invoke(null, (Object) new String[2]);
            }
            System.out.println(method.getName());
        }
        System.out.println(clazz.getClassLoader());
    }

    // 加载其工程的class字节码文件进来，获取 类 对象的相关属性
    private static void testFileClassLoader02() throws Exception{
        FileClassLoader fileClassLoader = new FileClassLoader("E:\\IdeaProjects\\formal\\ZhidingHr\\zhidinghr-web\\target\\classes");
        Class<?> clazz = fileClassLoader.loadClass("com.job.zhidinghr.common.activity.ActivityEntity");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println(clazz.getClassLoader());
    }

    // 访问其他可访问电脑上的class文件
    private static void testFileClassLoader03() throws Exception{
        FileClassLoader fileClassLoader = new FileClassLoader("\\10.100.3.154\\home\\albert.fang");
        Class<?> clazz = fileClassLoader.findClass("ActivityEntity");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    // 测试网络类加载器
    private static void testNetClassLoader() throws Exception{
        NetClassLoader netClassLoader = new NetClassLoader("\\10.100.3.154\\home\\albert.fang");
        Class<?> clazz = netClassLoader.loadClass("ActivityEntity");
        System.out.println(clazz.getClassLoader());
    }
}
