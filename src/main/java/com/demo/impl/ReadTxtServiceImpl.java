package com.demo.impl;

import com.common.constant.DBConstant;
import com.demo.impl.service.IReadService;
import com.demo.impl.util.StrUtil;

import java.io.*;
import java.util.*;

/**
 * Created by wwz on 2018/8/1.
 */
public class ReadTxtServiceImpl implements IReadService {

    @Override
    public Map<String, Map<String, String>> read(Object obj, String encode) throws Exception {

        if (null == obj) {
            throw new Exception("The path is empty, please input again!");
        }

        // 根据文件路径读取
        String filePath = (String) obj;

        // 遍历所有文件
        Map<String, Map<String, String>> map = readAllFiles(filePath, encode);

        return map;
    }


    private Map<String, String> readFile(String filePath, String encode) throws Exception {
        // 将文件名作为表名（比如user.txt所对应的表名为user）
        File file = new File(filePath);

        // 判断文件是否存在
        if (!file.exists()) {
            System.out.println("Path:"+filePath);
            throw new Exception("The file don't exist! Please check it! ");
        }

        if (StrUtil.isEquateNullStr(file.getName())) {
            throw new Exception("The file'name don't exist! Please check it! ");
        }

        String fileName = file.getName();
        String[] strings = fileName.split("\\.");
        String dbName = strings[0];

        // 判断文件编码，默认值为GBK
        if (StrUtil.isEquateNullStr(encode)) {
            encode = getEnCode(filePath);
        }

        // 用于存放每一行读取的字符串
        Map<String, String> map = new TreeMap<>();
        // 使用文件名作为数据库名
        map.put(dbName, DBConstant.DB_NAME.toString());

        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), encode);
            BufferedReader br = new BufferedReader(isr);

            String temp = null;

            // 一行一行地读取文件
            while ((temp = br.readLine()) != null) {
                temp = temp.trim(); // 去除每行的前后空格
                if (!StrUtil.isNullStr(temp)) {
                    map.put(temp.toUpperCase(), DBConstant.FIELD_NAME.toString());
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("There is an exception while reading file!!! The exception is " + e.getLocalizedMessage());
        }
        return map;
    }

    private Map<String, Map<String, String>> readAllFiles(String filepath, String encode) throws Exception {

        // 用于存放每个文件对应的map
        Map<String, Map<String, String>> map = new TreeMap<>();

        try {
            File file = new File(filepath);

            if (!file.exists()) {
                throw new FileNotFoundException("The file doesn't exist!!!");
            }

            if (!file.isDirectory()) {
                System.out.println("absolutepath=" + file.getAbsolutePath());
                String fileNames = file.getName();
                String[] fileNameArr = fileNames.split("\\.");
                int fileLength = fileNameArr.length - 2;
                String fileName = fileNameArr[fileLength];
                Map<String, String> fileMap = readFile(filepath, encode);
                map.put(fileName, fileMap);
            } else if (file.isDirectory()) {
                System.out.println("This is a directory!!!");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\." + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("absolutepath=" + file.getAbsolutePath());
                        Map<String, String> fileMap = readFile(filepath + "\\" + filelist[i], encode);
                        // 获取文件名并作为key
                        String fileNames = readfile.getName();
                        String[] fileNameArr = fileNames.split("\\.");
                        int fileLength = fileNameArr.length - 2;
                        String fileName = fileNameArr[fileLength];
                        map.put(fileName, fileMap);
                    } else if (readfile.isDirectory()) {
                        throw new Exception("The File includes other directories!!!!");
                        /*Map<String, Map<String, String>> files = readAllFiles(filepath + "\\" + filelist[i], encode);
                        map.putAll(files);*/
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IOException("readAllFiles() has an exception!!! The file doesn't exist!!!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("readAllFiles() has an exception!!! The exception is " + e.getMessage());
        }
        return map;
    }

    /**
     * 获取文件编码格式
     * @param fileName
     * @return 文件编码格式
     * @throws IOException
     */
    private String getEnCode(String fileName) throws IOException {

        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();

        String code = null;

        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16";
                break;
            default:
                code = "GBK";
        }
        return code;
    }


    /**
     * 迭代遍历文件夹下所有文件
     *
     * @param path
     */
    public Map<String, DBConstant> readFile(Object path, String encode) throws Exception {

        File file = new File((String) path);
        if (!file.exists()) {
            System.out.println("文件不存在!");
            return null;
        }
        File[] files = file.listFiles();
        if (files.length == 0) {
            System.out.println("文件夹是空的!");
            return null;
        }

        for (File file2 : files) {
            if (file2.isDirectory()) {
                System.out.println("文件夹:" + file2.getAbsolutePath());
                readFile(file2.getAbsolutePath(), encode);
            } else {
                System.out.println("文件:" + file2.getAbsolutePath());
            }
        }

        return null;
    }
}
