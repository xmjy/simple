package indi.xm.jy.test;


import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.compile
 * @ClassName: JavaCompileTest
 * @Author: albert.fang
 * @Description: java 编译
 * @Date: 2021/7/7 16:04
 */
public class JavaCompileTest {

    private final String jfn_prefix = "E:\\IdeaProjects\\simple\\src\\";

    @Test
    public void testCompile(){
        String fullyQualifyName = "indi.xm.jy.TestBean";
        String jsn = jfn_prefix + fullyQualifyName.replace('.', File.separatorChar);
        String jn = jsn + ".java";
        String cn = jsn + ".class";
        javaCompile(jn);
    }

    public void javaCompile(String jfn){
        try {
            Process exec = Runtime.getRuntime().exec("javac " + jfn);
            exec.waitFor();
            exec.exitValue();
            if (exec.exitValue() == 0) {
                System.out.println("正常退出");
            }else {
                System.out.println("编译异常");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
