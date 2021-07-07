package indi.xm.jy.loader;

import java.io.*;
import java.net.URL;

/**
 * @ProjectName: simple
 * @Package: indi.xm.jy.loader
 * @ClassName: NetClassLoader
 * @Author: albert.fang
 * @Description: 网络类加载器：动态替换class字节码文件
 * @Date: 2021/7/2 14:13
 */
public class NetClassLoader extends ClassLoader {

    private String netDir;

    public NetClassLoader(String netDir){
        this.netDir = netDir;
    }

    private byte[] getByteDatas(String name){
        String path = getPath(name);
        try {
            URL url = new URL(path);
            InputStream is = url.openStream();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int readNum;
            while ((readNum = is.read(buffer)) != -1){
                os.write(buffer,0,readNum);
            }
            return os.toByteArray();
        } catch (IOException e) {
            //
        }
        return null;
    }

    private String getPath(String name){
        return netDir + File.separatorChar + name.replace('.',File.separatorChar) + ".class";
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] byteDatas = getByteDatas(name);
        if ( byteDatas != null ){
            return defineClass(name,byteDatas,0,byteDatas.length);
        }
        return null;
    }
}
