package com.demo.impl.service;

import java.util.Map;

/**
 * Created by wangweizhen on 2018/8/1.
 */
public interface IReadService {

    /**
     * 读取方法：用于读取各种文件，比如txt、xml等
     * @param obj 需要读取的文件
     * @param encode 文件的编码格式
     * @return 返回读取的每一行字符串的集合
     *      Map<DBConstant.DB_NAME.toString(), Map<tableName/fieldName, DBConstant.DB_NAME/FIELD_NAME.toString()>>
     * @throws Exception
     */
    Map<String, Map<String, String>> read(Object obj, String encode) throws Exception;
}
