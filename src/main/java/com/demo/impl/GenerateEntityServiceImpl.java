package com.demo.impl;

import com.common.constant.CommSymConstant;
import com.common.constant.EntityConstant;
import com.common.constant.FileType;
import com.common.constant.KeywordConstant;
import com.demo.impl.service.IGenerateService;
import com.demo.impl.util.ArrayUtil;
import com.demo.impl.util.LetterTransferUtil;
import com.demo.impl.util.MapUtil;
import com.demo.impl.util.StrUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/5.
 */
public class GenerateEntityServiceImpl implements IGenerateService {

    @Override
    public String generate(Map<String, Map<String, String>> map, String path) throws Exception {

        // 获取Java文件需要的map数据
        Map<String, String> entityMap = map.get(FileType.JAVA.getCode());

        // 获取类的名称
        String clazzName = MapUtil.getKeyByValue(entityMap, EntityConstant.CLAZZ_NAME.toString()).get(0);

        // 获取属性的名称
        List<String> attrList = MapUtil.getKeyByValue(entityMap, EntityConstant.ATTR_NAME.toString());

        StringBuffer sb = new StringBuffer();

        // 拼接包
        String combinePackage = combinePackage(path, clazzName);
        sb.append(combinePackage);
        sb.append(CommSymConstant.NEWLINE.getCode());

        // 拼接类
        String combineClazz = combineClazz(clazzName);
        sb.append(combineClazz);
        sb.append(CommSymConstant.NEWLINE.getCode());

        // 拼接属性
        String combineAtrr = combineAtrr(attrList);
        sb.append(combineAtrr);

        // 生成getter和setter方法
        String getterAndSetter = generateGetterAndSetter(attrList);
        sb.append(getterAndSetter);
        sb.append(CommSymConstant.NEWLINE.getCode());

        // 类名的结束符号
        sb.append(CommSymConstant.R_BRACES.getCode());

        return sb.toString();
    }

    private String combinePackage(String path, String entityName) {
        StringBuffer sb = new StringBuffer();
        sb.append(KeywordConstant.PACKAGE.getCode());
        sb.append(CommSymConstant.SPACE.getCode());
        sb.append(path);
        sb.append(CommSymConstant.DOT.getCode());
        sb.append(entityName);
        sb.append(CommSymConstant.SEMICOLON.getCode());
        sb.append(CommSymConstant.NEWLINE.getCode());
        return sb.toString();
    }

    /**
     * 拼接成类格式，格式为：public class ClazzName {
     * @param clazzName
     * @return
     * @throws Exception
     */
    private String combineClazz(String clazzName) throws Exception {

        if (StrUtil.isNullStr(clazzName)) {
            throw new Exception("The clazzName is empty!!!");
        }

        // StringBuffer(线程安全)public class Clazz {
        StringBuffer clazzSB = new StringBuffer();
        clazzSB.append(KeywordConstant.PUBLIC.getCode());
        clazzSB.append(CommSymConstant.SPACE.getCode());
        clazzSB.append(KeywordConstant.CLAZZ.getCode());
        clazzSB.append(CommSymConstant.SPACE.getCode());
        clazzSB.append(clazzName);
        clazzSB.append(CommSymConstant.SPACE.getCode());
        clazzSB.append(CommSymConstant.L_BRACES.getCode());
        clazzSB.append(CommSymConstant.NEWLINE.getCode());
        return clazzSB.toString();
    }

    /**
     * 拼接属性，格式为：（\t）private String name;
     * @param attrList 所有属性的名称集合
     * @return
     * @throws Exception
     */
    private String combineAtrr(List<String> attrList) throws Exception {

        if (ArrayUtil.isEmptyArray(attrList)) {
            throw new Exception("There are empty elements in the attrList!!!");
        }

        StringBuffer attrSB = new StringBuffer();
        for (int i = 0; i < attrList.size(); i++) {
            attrSB.append(CommSymConstant.TAB_SYB.getCode());
            attrSB.append(KeywordConstant.PUBLIC.getCode());
            attrSB.append(CommSymConstant.SPACE.getCode());
            attrSB.append(KeywordConstant.STRING.getCode());
            attrSB.append(CommSymConstant.SPACE.getCode());
            attrSB.append(attrList.get(i));
            attrSB.append(CommSymConstant.SEMICOLON.getCode());
            attrSB.append(CommSymConstant.NEWLINE.getCode());
        }

        return attrSB.toString();
    }

    /**
     * 为每个属性生成getter和setter方法方法
     * @param attrList
     * @return
     */
    private String generateGetterAndSetter(List<String> attrList) {

        /**
         * 方法的格式：
         \n\r
         \t public String getName() {
         \t\t   return name;
         \t }

         \t public void setName(String name) {
         \t\t this.name = name;
         \t }
         */

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < attrList.size(); i++) {
            // getter
            sb.append(CommSymConstant.NEWLINE.getCode());
            sb.append(CommSymConstant.TAB_SYB.getCode());

            // public String getName() {
            sb.append(KeywordConstant.PUBLIC.getCode());// public
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append("get" + LetterTransferUtil.toOnlyFirstUpper(attrList.get(i)));//getName
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append(CommSymConstant.L_PARENTHESIS.getCode());//(
            sb.append(CommSymConstant.R_PARENTHESIS.getCode());//)
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append(CommSymConstant.L_BRACES.getCode());//{

            sb.append(CommSymConstant.NEWLINE.getCode());
            sb.append(CommSymConstant.TAB_SYB.getCode());
            sb.append(CommSymConstant.TAB_SYB.getCode());

            // return name;
            sb.append(KeywordConstant.RETURN.getCode());
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append(attrList.get(i));
            sb.append(CommSymConstant.SEMICOLON.getCode());
            sb.append(CommSymConstant.NEWLINE.getCode());
            sb.append(CommSymConstant.TAB_SYB.getCode());
            sb.append(CommSymConstant.R_BRACES.getCode());

            sb.append(CommSymConstant.NEWLINE.getCode());

            // setter
            sb.append(CommSymConstant.NEWLINE.getCode());
            sb.append(CommSymConstant.TAB_SYB.getCode());

            // public void setName(String name) {
            sb.append(KeywordConstant.PUBLIC.getCode());
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append(KeywordConstant.VOID.getCode());
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append("set" + LetterTransferUtil.toOnlyFirstUpper(attrList.get(i)));
            sb.append(CommSymConstant.L_PARENTHESIS.getCode());//(
            sb.append(KeywordConstant.STRING.getCode());//String
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append(attrList.get(i));// name
            sb.append(CommSymConstant.R_PARENTHESIS.getCode());//)
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append(CommSymConstant.L_BRACES.getCode());//{

            sb.append(CommSymConstant.NEWLINE.getCode());
            sb.append(CommSymConstant.TAB_SYB.getCode());
            sb.append(CommSymConstant.TAB_SYB.getCode());

            // this.name = name;
            sb.append(KeywordConstant.THIS.getCode());//this
            sb.append(CommSymConstant.DOT.getCode());//.
            sb.append(attrList.get(i)); // name
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append(CommSymConstant.EQUAL_SIGN.getCode());//=
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append(attrList.get(i));// name
            sb.append(CommSymConstant.SEMICOLON.getCode()); //;

            sb.append(CommSymConstant.NEWLINE.getCode());
            sb.append(CommSymConstant.TAB_SYB.getCode());
            sb.append(CommSymConstant.R_BRACES.getCode());//}
            sb.append(CommSymConstant.NEWLINE.getCode());
        }

        return sb.toString();

    }


}
