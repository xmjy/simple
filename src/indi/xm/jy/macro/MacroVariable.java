package indi.xm.jy.macro;

import javax.crypto.Mac;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.macro
 * @ClassName: MacroVariable
 * @Author: albert.fang
 * @Description: 宏变量
 * @Date: 2021/7/6 9:13
 */
public class MacroVariable {

    private static final String MACROVALUE = "我爱北京天安门";

    public static final String ANOTHERMACRO = "hello world" + System.currentTimeMillis();

    public static final Integer INTEGER_NUM = 6;

    public final char c = 'c';
    public final boolean flag = true;
    public final byte b = 1;
    public final short s = 2;
    public final int i = 7;
    public final float f = 7f;
    public final double d = 8d;
    public final long l = 9L;
    private final String str = "我爱北京天安门";
    private final String runningStr = "我爱北京天安门" + System.currentTimeMillis();

    public void testConstantVariable(){
        System.out.println(c);
        System.out.println(flag);
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(f);
        System.out.println(d);
        System.out.println(l);
        System.out.println(str);
        System.out.println(runningStr);
    }

    public final Character ch = 'c';
    public final Boolean bo = true;
    public final Byte by = 1;
    public final Short sh = 2;
    public final Integer in = 7;
    public final Float fl = 7f;
    public final Double dou = 8d;
    public final Long lo = 9L;

    public void warpType(){
        System.out.println(ch);
        System.out.println(bo);
        System.out.println(by);
        System.out.println(sh);
        System.out.println(in);
        System.out.println(fl);
        System.out.println(dou);
        System.out.println(lo);
    }

    /***
    * @Author: albert.fang
    * @Description: 主方法
    * @param args
    * @return void
    */
    public static void main(String[] args) {
        new MacroVariable().warpType();
    }
}
