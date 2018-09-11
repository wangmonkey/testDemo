package com.demo.impl.service;

/**
 * Created by dell on 2018/8/1.
 */
public interface IWriteService {

    /**
     * 写入
     * @param content 写入的内容
     * @param fileType 文件类型
     * @param fileName 文件名称
     * @throws Exception
     */
    boolean write(String content, String fileName, String fileType);
}
