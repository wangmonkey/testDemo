package com.demo.impl;

import com.common.constant.CommSymConstant;
import com.demo.impl.service.IWriteService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by Administrator on 2018/8/5.
 */
public class WriteServiceImpl implements IWriteService {

    @Override
    public boolean write(String content, String fileName, String fileType) {

        File file = new File(fileName + CommSymConstant.DOT.getCode() + fileType);
        if (file.exists()) {
            file = new File(fileName + Calendar.getInstance().get(Calendar.MILLISECOND) + CommSymConstant.DOT.getCode() + fileType);
        }

        System.out.println("文件的绝对路径是：" + file.getAbsolutePath());
        //向指定文件中写入文字
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            //使用缓冲区比不使用缓冲区效果更好，因为每趟磁盘操作都比内存操作要花费更多时间。
            //通过BufferedWriter和FileWriter的连接，BufferedWriter可以暂存一堆数据，然后到满时再实际写入磁盘
            //这样就可以减少对磁盘操作的次数。如果想要强制把缓冲区立即写入,只要调用writer.flush();这个方法就可以要求缓冲区马上把内容写下去
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // 写入
            bufferedWriter.write(content);
            // 关闭流
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
