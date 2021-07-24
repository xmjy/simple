package indi.xm.jy.test;

import indi.xm.jy.reference.DirectReference;
import org.junit.Test;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.reference
 * @ClassName: ReferenceTest
 * @Author: albert.fang
 * @Description: 引用测试
 * @Date: 2021/7/23 15:38
 */
public class ReferenceTest {

//    public static int c = 10;
//
//    static {
//        System.out.println(c);
//        System.out.println("ReferenceTest 静态代码块");
//    }

    // new
    @Test
    public void newObject() {
        DirectReference directReference = new DirectReference();
    }

    // getstatic
    @Test
    public void getStatic(){
        int a = DirectReference.a;
    }

    // putstatic
    @Test
    public void putStatic(){
        DirectReference.a = 12;
    }

    // invokestatic
    @Test
    public void invokeStatic(){
        DirectReference.print();
    }

    // 3、通过反射的类可以初始化
    @Test
    public void reflectTest() throws IllegalAccessException, InstantiationException {
        Class<DirectReference> directReferenceClass = DirectReference.class;
        DirectReference directReference = directReferenceClass.newInstance();
    }

    // 4、调用此类的类变量，可以初始化此类
    @Test
    public void referenceStaticFiled(){
        System.out.println(DirectReference.a);
    }

    // 1、通过数组引用来引用类，不会触发此类的初始化
    @Test
    public void arrayReference(){
        DirectReference[] directReferences = new DirectReference[10];
    }

    // 2、调用常量不会初始化
    @Test
    public void referenceConstant(){
        System.out.println(DirectReference.b);
    }

    // 3、通过子类调用父类的静态变量、子类不会初始化
    @Test
    public void invokeParentStaticFiled(){
        System.out.println(DirectReference.d);
    }
}
