public class Main {

    private String truthWord(){
        return "大帅比，你好呀";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 查看当前系统 类路径中包含的路径条目
        System.out.println(System.getProperty("java.class.path"));
        // 用加载当前类的类加载器加载TestBean
        Class<?> clazz = Class.forName("indi.xm.jy.macro.MacroVariable");
        // 查看加载TestBean的类加载器
        System.out.println();

    }
}
