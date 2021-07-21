package indi.xm.jy.objectinitial;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.objectinitial
 * @ClassName: Glyph
 * @Author: albert.fang
 * @Description: 图类
 * @Date: 2021/7/21 16:54
 */
class Glyph {
    void draw(){
        System.out.println("Glyph.draw()");
    }

    Glyph(){
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph{
    private int radius = 1;

    RoundGlyph(int r){
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(),radius = " + radius);
    }

    @Override
    void draw(){
        System.out.println("RoundGlyph.draw()，radius = " +radius);
    }
}

public class Draw{
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
// 执行分析
// 这是有继承关系的对象初始化，有继承关系的对象初始化步骤
// 1、父类类初始化
// 2、子类类初始化
// 3、父类、子类的成员变量初始化，基础类型为0或false，引用为null。
// 4、父类对象初始化
// 5、子类对象初始化

// 这里提一下什么叫做类初始化，什么叫做对象初始化。

// 类初始化：
// 在类加载的过程中：加载 -> 验证 -> 准备 -> 解析 -> 初始化；这最后一步就是累的初始化。
// 可是这里的类初始化和类加载过程中的那个初始化有点不一样。
// 这里的类初始化指的是五个阶段中的 准备阶段 + 初始化阶段。（很拗，理解起来很拗）
// 为什么说这里的类初始化 = 准备阶段 + 初始化阶段。
// 我们来看看这里的类初始化所干的事就好了：
// 1、将类变量初始化，基础类型为0，false，引用类型为null。（这一步不就是类加载过程中的准备过程干的？）
// 2、将类变量赋值操作和静态代码块按顺序执行。（这不就是类加载过程初始化过程干的？）

// 对象初始化：
// 1、成员变量赋值操作、实例代码块顺序执行。
// 2、再走构造方法。

// 奇怪的是，这5个步骤的执行过程就是对象初始化，可是，下面又分为类初始化和对象初始化。
// 哎，不知道怎么说，很拗，先这样拗口理解吧，反正知道不是一个东西就好了。后面有机会再看官方说明。
