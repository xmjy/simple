package indi.xm.jy.reference;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.reference
 * @ClassName: DirectReference
 * @Author: albert.fang
 * @Description: 直接引用
 * @Date: 2021/7/23 15:35
 */
public class DirectReference extends Reference{
    public static int a = 8;

    public static final int b = 66;

    public static final Integer c = 77;

    static {
        System.out.println(a);
        System.out.println("DirectReference 静态代码块");
    }

    // 1、执行此类的main方法，可以初始化此类
    public static void main(String[] args) {

    }

}
