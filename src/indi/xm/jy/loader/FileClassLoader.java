package indi.xm.jy.loader;

import java.io.*;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.loader
 * @ClassName: FileClassLoader
 * @Author: albert.fang
 * @Description: 文件类加载器：指定class字节码文件绝对路径以及全限定名，加载Class对象
 * @Date: 2021/7/1 17:32
 */
public class FileClassLoader extends ClassLoader {

    /**
     * 存放class文件的前缀路径
     */
    private String rootDir;

    public FileClassLoader(String rootDir){
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] byteDatas = getByteDatas(name);
        if (byteDatas != null){
            return defineClass(name,byteDatas,0,byteDatas.length);
        }
        return null;
    }

    /**
     *
     *
     * @param name 类的全限定名
     * @return
     */
    private byte[] getByteDatas(String name){
        String path = getPath(name);
        try {
            FileInputStream fis = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int readNum;
            while ((readNum = fis.read(buffer)) != -1) {
                baos.write(buffer,0,readNum);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            //
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回class文件绝对路径
     *
     * @param name 类的全限定名
     * @return
     */
    private String getPath(String name){
        return rootDir + File.separatorChar + name.replace('.',File.separatorChar) + ".class";
    }
}
