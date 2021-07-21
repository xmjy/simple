package indi.xm.jy.init;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.init
 * @ClassName: Initialize
 * @Author: albert.fang
 * @Description: 加载 -> 验证 -> 准备 -> 解析 -> 初始化：这里就是初始化
 * @Date: 2021/7/12 11:28
 */
public class Initialize {
    static String initString = "23";

    static {
        initString = "54";
        initInteger =  6;
    }

    static int initInteger = 1;

    public static void main(String[] args) {
        String a1 = "a";
        String b1 = "b";
        String a =  a1 + b1;
        System.out.println(a == "ab");
        System.out.println(initInteger);
        System.out.println(initString);
    }
}
