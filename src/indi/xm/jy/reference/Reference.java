package indi.xm.jy.reference;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.reference
 * @ClassName: Reference
 * @Author: albert.fang
 * @Description: 引用
 * @Date: 2021/7/23 15:36
 */
public class Reference {
    public static int b = 6;

    public static int d = 6;

    static {
        System.out.println(b);
        System.out.println("Reference 静态代码块");
    }
}
