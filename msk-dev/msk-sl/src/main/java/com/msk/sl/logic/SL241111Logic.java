package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.file.FtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class SL241111Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 读文件
     *
     * @param path
     * @param content
     * @return
     */
    public String readFile(String path, String content) {
        String read;
        FileReader fileread;
        BufferedReader bufread;
        String readStr = "";
        File filename = new File(path + "/SlDistReguChap/1.html");

        try {
            fileread = new FileReader(filename);
            bufread = new BufferedReader(fileread);
            while ((read = bufread.readLine()) != null) {
                readStr = readStr + read + "/r/n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("文件内容是 :" + "/r/n" + readStr);
        return readStr;
    }

    /**
     * 写文件
     *
     * @param newStr
     * @param path
     */
//    public void writeTxtFile(String newStr, String fileName) {
//        File filename = new File(
//                path);
//        RandomAccessFile mm = null;
//        try {
//            if (!filename.exists()) {
//                filename.createNewFile();
//            }
//            mm = new RandomAccessFile(filename, "rw");
//            mm.writeBytes(newStr);
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        } finally {
//            if (mm != null) {
//                try {
//                    mm.close();
//                } catch (IOException e2) {
//                    e2.printStackTrace();
//                }
//            }
//        }
//    }

}
