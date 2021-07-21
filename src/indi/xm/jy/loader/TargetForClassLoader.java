package indi.xm.jy.loader;

import java.util.Arrays;
import java.util.List;

/**
 * 3种类加载器的加载目录
 * @ author: albert.fang
 * @ date:2020/8/2 00:05
 */
public class TargetForClassLoader {

    public static void main(String[] args) {
//        bootstrapClassLoader();
//        extClassLoader();
        appClassLoader();
    }

    /**
     * 启动类加载器的职责
     */
    public static void bootstrapClassLoader() {
        String property = System.getProperty("sun.boot.class.path");
        List<String> list = Arrays.asList(property.split(";"));
        list.forEach((t) -> {
            System.out.println("启动类加载器目录:" + t);
        });
    }


    /**
     * 扩展类加载器
     */
    public static void extClassLoader() {
        String property = System.getProperty("java.ext.dirs");
        List<String> list = Arrays.asList(property.split(";"));
        list.forEach((t) -> {
            System.out.println("扩展类加载器" + t);
        });
    }

    /**
     * app 类加载器
     */
    public static void appClassLoader() {
        String property = System.getProperty("java.class.path");
        List<String> list = Arrays.asList(property.split(";"));
        list.forEach((t) -> {
            System.out.println("应用类加载器" + t);
        });
    }
}