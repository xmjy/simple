package indi.xm.jy.loader;


import indi.xm.jy.entity.Fxm;
import indi.xm.jy.loader.FileClassLoader;
import org.junit.Test;
import sun.nio.ch.Net;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.test
 * @ClassName: TestCustomClassLoader
 * @Author: albert.fang
 * @Description: 测试自定义类加载器
 * @Date: 2021/7/2 10:29
 */
public class TestCustomClassLoader {
    public static void main(String[] args) throws Exception {
//        testFileClassLoader();
        testFileClassLoader02();
//        testFileClassLoader03();
//        testNetClassLoader();
    }

    @Test
    public void testAAA(){
        String s = "id, personCode, personNumber, personName, personAge, personWorkYears, sourceId, jobs,\n" +
                "    `rank`, department, enterprise_id, jobSeq_1_id, jobSeq_2_id, jobSeq_3_id, personType,\n" +
                "    seqCode, `password`, activity_id, stauts, toolsAllScore, toolsAllWeightScore, email,\n" +
                "    mobilePhone, noticeWay, noticeType, noticeType2, personSex, personDegree, isNew,\n" +
                "    expectedBeginDate, expectedEndDate, allReportPdfPath, messageExt, replayMessage,\n" +
                "    createuserid, createTime, ischarge, personIDNubmer, islogin, isChargeDate, major,\n" +
                "    applyjob, colleges, cameraDate, jumpTimes, statementDate, customized, usercode, isZhidingAnswer,\n" +
                "    isAddCV, `status`, testStatus, updateTestStatusDate, telephone, return_Status, sendWay,\n" +
                "    return_EnterpriseId, updateInfoDate, majorCode, industryCode, expectIndustryCode";
        String[] split = s.split(",");
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            String trim = s1.trim();
            sb.append("a.").append(trim).append(", ");
        }
        System.out.println(sb.substring(0,sb.length() - 1));
    }

    /**
     * jvm 中class对象是由class对象和类加载器共同决定的
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void testLoader() throws ClassNotFoundException {
        Class<?> fxm = Class.forName("indi.xm.jy.Fxm");
        System.out.println(fxm.getClassLoader());
        FileClassLoader customLoader = new FileClassLoader("E:\\IdeaProjects\\simple\\out\\production\\simple");
        Class<?> fxm02 = customLoader.findClass("indi.xm.jy.Fxm");
        System.out.println(fxm02.getClassLoader());
        Class<Fxm> fxm03 = Fxm.class;
        System.out.println(fxm03.getClassLoader());
        Fxm fxmObject = new Fxm();
        Class<? extends Fxm> fxm04 = fxmObject.getClass();
        System.out.println(fxm04.getClassLoader());
        System.out.println(fxm == fxm02);
        System.out.println(fxm == fxm03);
        System.out.println(fxm == fxm04);
    }

    // 测试自定义fileclassloadar类加载器
    private static void testFileClassLoader() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        FileClassLoader fileClassLoader = new FileClassLoader("E:\\IdeaProjects\\simple\\out\\production\\simple");
        Class<?> clazz = fileClassLoader.loadClass("indi.xm.jy.Fxm");
        Method[] methods = clazz.getDeclaredMethods();
        Object o = clazz.newInstance();

        for (Method method : methods) {
            method.setAccessible(true);
            if ("truthWord".equals(method.getName())){
                System.out.println(method.invoke(o));
            }
            else {
                method.invoke(null, (Object) new String[2]);
            }
            System.out.println(method.getName());
        }
        System.out.println(clazz.getClassLoader());
    }

    // 加载其工程的class字节码文件进来，获取 类 对象的相关属性
    private static void testFileClassLoader02() throws Exception{
        FileClassLoader fileClassLoader = new FileClassLoader("E:\\IdeaProjects\\formal\\ZhidingHr\\zhidinghr-web\\target\\classes");
        Class<?> clazz = fileClassLoader.loadClass("com.job.zhidinghr.common.activity.ActivityEntity");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println(clazz.getClassLoader());
    }

    // 访问其他可访问电脑上的class文件
    private static void testFileClassLoader03() throws Exception{
        FileClassLoader fileClassLoader = new FileClassLoader("\\10.100.3.154\\home\\albert.fang");
        Class<?> clazz = fileClassLoader.findClass("ActivityEntity");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    // 测试网络类加载器
    private static void testNetClassLoader() throws Exception{
        NetClassLoader netClassLoader = new NetClassLoader("\\10.100.3.154\\home\\albert.fang");
        Class<?> clazz = netClassLoader.loadClass("ActivityEntity");
        System.out.println(clazz.getClassLoader());
    }
}
