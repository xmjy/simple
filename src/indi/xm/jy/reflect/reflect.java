package indi.xm.jy.reflect;

/**
 * @ProjectName: work-schedule
 * @Package: com.taimei.work.schedule.generator
 * @ClassName: reflect
 * @Author: albert.fang
 * @Description: 反射test类
 * @Date: 2022/6/27 19:23
 */
public class reflect {

    private reflect(){
        System.out.println("无参创建成功");
    }

    private reflect(String a){
        System.out.println("输入：" + a);
    }
}
