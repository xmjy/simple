package indi.xm.jy.test;

import org.junit.Test;

import java.io.File;

public class OtherTest {

    @Test
    public void renameTest() throws Exception {
        File file = new File("D:\\study\\玩转数据结构 从入门到进阶");
        if (file.isDirectory()) {
            for (File listFile : file.listFiles()) {
                if (listFile.isDirectory() && !listFile.getName().equals("datastructure")){
                    for (File single : listFile.listFiles()) {
                        String name = single.getAbsolutePath();
                        if (!name.endsWith(".mp4")){
                            if (!single.delete()) {
                                throw new Exception("删除失败");
                            }
                            continue;
                        }
                        String replace = name.replace("【猿人部落-www.97yrbl.com】", "");
                        if (!single.renameTo(new File(replace))) {
                            throw new Exception("重命名失败");
                        }
                    }
                }
            }
        }
    }
}
