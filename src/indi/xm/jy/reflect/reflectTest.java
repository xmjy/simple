package indi.xm.jy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ProjectName: work-schedule
 * @Package: com.taimei.work.schedule.generator
 * @ClassName: reflectTest
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/6/27 19:24
 */
public class reflectTest {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<reflect> clazz = reflect.class;
        Constructor<reflect> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        reflect reflect = constructor.newInstance("aaa");

        PerfectSingleton instance = PerfectSingleton.getInstance();
        System.out.println(instance.hashCode());

        Class<PerfectSingleton> perfect = PerfectSingleton.class;
        Constructor<PerfectSingleton> con = perfect.getDeclaredConstructor();
        con.setAccessible(true);
        PerfectSingleton perfectSingleton = con.newInstance();
        System.out.println(perfectSingleton.hashCode());

        PerfectSingleton perfectSingleton1 = con.newInstance();
        System.out.println(perfectSingleton1.hashCode());

    }
}
