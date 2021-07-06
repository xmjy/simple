package indi.xm.jy.macro;

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

    public static void main(String[] args) {
        System.out.println(MACROVALUE);
        System.out.println(ANOTHERMACRO);
    }
}
