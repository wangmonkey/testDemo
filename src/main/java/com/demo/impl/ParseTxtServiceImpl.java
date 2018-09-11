package com.demo.impl;

import com.common.constant.DBConstant;
import com.common.constant.EntityConstant;
import com.common.constant.FileType;
import com.demo.impl.service.IParseService;
import com.demo.impl.util.LetterTransferUtil;
import com.demo.impl.util.MapUtil;
import com.demo.impl.util.StrUtil;

import java.util.*;

/**
 * Created by dell on 2018/8/1.
 */
public class ParseTxtServiceImpl implements IParseService {

    @Override
    public Map<String, Map<String, String>> parse(Map<String, String> dbMap, String regx) throws Exception {

        // 获取数据库名称
        String dbName = MapUtil.getKeyByValue(dbMap, DBConstant.DB_NAME.toString()).get(0);

        // 获取字段名称
        List<String> fields = MapUtil.getKeyByValue(dbMap, DBConstant.FIELD_NAME.toString());

        // 按照规则解析数据库名称
        String clazzName = parseDBName(dbName, regx);

        // 按照规则解析字段名称
        List<String> fieldNames = parseFieldNames(fields, regx);

        // 获取实体类属性
        Map<String, String> entityMap = new TreeMap<>();
        entityMap.put(clazzName, EntityConstant.CLAZZ_NAME.toString());
        for (String fieldName:fieldNames) {
            entityMap.put(fieldName, EntityConstant.ATTR_NAME.toString());
        }

        // 获取数据库与实体类之间的属性映射（不包含表名和实体类名称的映射）
        Map<String, String> fieldAttrMap = getFieldAttrMap(fields, regx);

        Map<String, Map<String, String>> map = new TreeMap<>();
        map.put(FileType.JAVA.getCode(), entityMap);
        map.put(FileType.XML.getCode(), dbMap);
        map.put(FileType.PROPERTIES.getCode(), fieldAttrMap);
        return map;
    }

    // 解析数据库名
    private String parseDBName(String dbName, String regx) {

        // 去除表名的前缀“U_”
        if (dbName.length() >=2 && "U_".equalsIgnoreCase(dbName.substring(0,2))) {
            dbName = dbName.substring(2);
        }

        StringBuilder dbNameBuilder = new StringBuilder();
        if (StrUtil.isNullStr(regx)) {
            return LetterTransferUtil.toFirstUpper(dbName);
        }

        String[] dbNameArr = dbName.split(regx);

        for (int i = 0; i <dbNameArr.length ; i++) {
            // 将单词首字母转化成大写，并放入字符串缓冲池
            dbNameBuilder.append(LetterTransferUtil.toFirstUpper(dbNameArr[i]));
        }

        return dbNameBuilder.toString();
    }

    // 解析字段
    private List<String> parseFieldNames(List<String> fields, String regx) {

        if (StrUtil.isNullStr(regx)) {
            return fields;
        }

        String temp = "";
        List<String> fieldNames = new ArrayList<>();    // 用于存储并返回解析后的值

        // 遍历所有字段
        for (String field:fields) {
            String fieldName = "";
            String[] nameArr = field.split(regx);   // 拆分字段
            StringBuilder fieldBuilder = new StringBuilder();  // 存储拆分解析后的字符串
            // 遍历拆分后的字段的每一部分
            for (int i = 0; i < nameArr.length; i++) {
                if (i == 0) {
                    temp = nameArr[i].toLowerCase();
                    fieldBuilder.append(temp);
                } else {
                    temp = LetterTransferUtil.toFirstUpper(nameArr[i]);
                    fieldBuilder.append(temp);
                }
            }
            fieldName = fieldBuilder.toString();
            fieldNames.add(fieldName);
        }

        return fieldNames;
    }

    // 解析字段
    private Map<String, String> getFieldAttrMap(List<String> fields, String regx) {

        String temp = "";
        Map<String, String> map = new TreeMap<>();    // 用于存储并返回解析后的键值对值

        // 遍历所有字段
        for (String field:fields) {
            String attrName = "";
            if (!StrUtil.isNullStr(regx)) {
                String[] nameArr = field.split(regx);   // 拆分字段
                StringBuilder fieldBuilder = new StringBuilder();  // 存储拆分解析后的字符串
                // 遍历拆分后的字段的每一部分
                for (int i = 0; i < nameArr.length; i++) {
                    if (i == 0) {
                        temp = nameArr[i].toLowerCase();
                        fieldBuilder.append(temp);
                    } else {
                        temp = LetterTransferUtil.toFirstUpper(nameArr[i]);
                        fieldBuilder.append(temp);
                    }
                }
                attrName = fieldBuilder.toString();
            } else {
                attrName = field;
            }
            map.put(field, attrName);
        }

        return map;
    }
}
