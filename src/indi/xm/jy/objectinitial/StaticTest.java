package indi.xm.jy.objectinitial;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.init
 * @ClassName: StaticTest
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/7/13 10:18
 */
public class StaticTest{
    // 类的主动引用
    // 引起类的初始化
    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest(){
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
//    static {
//        System.out.println(b);
//    }

}
// 这个的执行过程真的非常有必要理一下。
// 首先给出，单个类对象初始化的先后顺序。
// 1、类变量初始化。（这一步在类加载过程中的准备阶段就完成了）
// 2、对类变量赋值、静态代码块。（按顺序执行）
// 3、对成员变量初始化。
// 4、完成成员变量的初始化、和实例代码块的执行。（按顺序执行）
// 5、构造方法的执行。

// 1、2 属于类的初始化；3、4 属于对象的初始化。

// 执行过程分析。
// 1、main方法的执行属于类的主动引用会进行类的初始化。
// 2、类的准备阶段会将类变量初始化，这里的类变量初始化st为null,b为0。
// 3、类的初始化：通过编辑器收集类变量赋值操作和静态代码块，以源文件顺序执行。
// 4、从上到下的类变量和静态代码块有：类变量st、静态代码块、以及类变量b。
// 5、先对类变量st进行赋值操作，明显的st是通过调用类的构造方法的，调用构造方法也就相当于对象的初始化。
// 6、对象初始化的过程：初始化成员变量，按顺序对成员变量赋值以及执行实例代码块。
// 7、成员变量只有a，这里先对a进行初始化为0，然后按顺序执行成员变量的复制以及实例代码块。
// 8、看源码可以看见实例代码块在成员变量的赋值操作之前；也就是先打印出“2”，然后对a进行赋值操作，这时a = 110。
// 9、对象初始化的最后一步是执行构造方法，所以再次应该打印“3”，再打印“a=110,b=0”（为什么这里等于0，因为还没走到类变量b的赋值操作）
// 10、到这里，类变量st的赋值就完成了。
// 11、接着是执行静态代码块，打印出：“1”
// 12、再接着是对类变量b的赋值操作，b=112。（可是之后没有再对b打印的逻辑了，可以自己在最后加一个静态代码块打印b的值）
// 13、到这里，类的初始化和对象的初始化都完成了，再执行main方法的方法体：打印出：“4”

// 综合上述分析结果：打印顺序依次为：
// 2
// 3
// a=110,b=0
// 1
// 4

