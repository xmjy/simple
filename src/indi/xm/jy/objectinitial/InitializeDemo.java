package indi.xm.jy.objectinitial;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.objectinitial
 * @ClassName: InitializeDemo
 * @Author: albert.fang
 * @Description: 初始化demo
 * @Date: 2021/7/21 16:08
 */
public class InitializeDemo {
    private static int k = 1;
    private static  InitializeDemo t1 = new InitializeDemo("t1");
    private static  InitializeDemo t2 = new InitializeDemo("t2");
    private static int i = print("i");
    private static int n = 99;

    static {
        print("静态块");
    }

    private int j = print("j");

    {
        print("构造块");
    }

    public InitializeDemo(String str) {
        System.out.println((k++) + ":" +str + "  i=" + i + "  n=" +n);
        ++i;
        ++n;
    }

    public static int print(String str){
        System.out.println((k++) + ":" +str + "  i=" + i + "  n=" +n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {
        InitializeDemo init = new InitializeDemo("init");
        System.out.println("最后结果：i= " +i + ", n= "  +n + ", k= " +k +", j= " + init.j);
    }
}
// 具体不分析了，和StaticTest中的步骤一样，一步一步走下去就好了。
// 我的执行过程看同个文件夹下的analysis.jpg
// 最后的一个j的值弄错了，多加了1，最后走构造方法是不会加的j的，j只有在print的时候才会改变。
