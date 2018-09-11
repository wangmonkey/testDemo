package com.demo.impl;

import com.common.constant.*;
import com.demo.impl.service.IGenerateService;
import com.demo.impl.util.LetterTransferUtil;
import com.demo.impl.util.MapUtil;
import com.demo.impl.util.StrUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/8/5.
 */
public class GenerateXMLServiceImpl implements IGenerateService {

    @Override
    public String generate(Map<String, Map<String, String>> map, String packagePath) throws Exception {

        // 获取Java文件需要的map
        Map<String, String> entityMap = map.get(FileType.JAVA.getCode());

        // 获取类的名称
        String clazzName = MapUtil.getKeyByValue(entityMap, EntityConstant.CLAZZ_NAME.toString()).get(0);

        // 获取字段和类属性的映射
        Map<String, String> fieldAttrMap = map.get(FileType.PROPERTIES.getCode());

        // 获取属性的名称
        List<String> attrList = MapUtil.getKeyByValue(entityMap, EntityConstant.ATTR_NAME.toString());

        // 获取Java文件需要的map
        Map<String, String> dbMap = map.get(FileType.XML.getCode());

        // 获取表的名称
        String tableName = MapUtil.getKeyByValue(dbMap, DBConstant.DB_NAME.toString()).get(0);

        // 获取表中字段的名称
        List<String> fieldList = MapUtil.getKeyByValue(dbMap, DBConstant.FIELD_NAME.toString());

        StringBuffer sb = new StringBuffer();

        // 生成XML文件前缀
        String prefix = combineXMLPrefix(clazzName, packagePath);
        sb.append(prefix);

        // 生成XMLResultMap映射
        String resultMap = combineXMLResultMap(fieldAttrMap, clazzName);
        sb.append(resultMap);

        // 生成动态SQL语句
        String sql = combineXMLSQL(clazzName, tableName, fieldList, attrList, fieldAttrMap);
        sb.append(sql);

        // 生成XML文件后缀
        String suffix = combineXMLSuffix();
        sb.append(suffix);

        return sb.toString();
    }

    private String combineXMLSuffix() {
        StringBuffer sb = new StringBuffer();
        sb.append(CommSymConstant.L_ANGLE_BRA.getCode());
        sb.append(CommSymConstant.R_VERTICAL.getCode());
        sb.append(XMLKeywordConstant.MAPPER.getCode());
        sb.append(CommSymConstant.R_ANGLE_BRA.getCode());
        return sb.toString();
    }


    private String combineXMLSQL(String clazzName, String tableName, List<String> fieldList, List<String> attrList, Map<String, String> fieldAttrMap) {

        // 创建insert语句
        String insert = createInsert(clazzName, tableName, fieldList, attrList);

        // 创建delete语句
        String delete = createDelete(clazzName, tableName);

        // 创建update语句
        String update = createUpdate(clazzName, tableName, fieldAttrMap);

        // 创建查询单个语句
        String get = createGet(clazzName, tableName);

        // 创建分页page语句
        String page = createPage(clazzName, tableName);

        return insert+delete+update+get+page;
    }

    private String combineXMLResultMap(Map<String, String> map, String clazzName) throws Exception {
        /**
         * xml文件的格式
         \t <resultMap type="Resource" id="ResourceResultMap">
         \t\t   <result property="id" column="ID"/>
         \t </resultMap>
         */
        if (StrUtil.isNullStr(clazzName)) {
            throw new Exception("The clazzName is empty!!!");
        }

        // StringBuffer(线程安全)
        StringBuffer sb = new StringBuffer();

        // \t <resultMap type="Resource" id="ResourceMap">
        sb.append(CommSymConstant.TAB_SYB.getCode());
        sb.append(CommSymConstant.L_ANGLE_BRA.getCode());
        sb.append(XMLKeywordConstant.RESULT_MAP.getCode());
        sb.append(CommSymConstant.SPACE.getCode());

        // type="Resource"
        sb.append(XMLKeywordConstant.TYPE.getCode());
        sb.append(CommSymConstant.EQUAL_SIGN.getCode());
        sb.append(CommSymConstant.DOUBLE_QUOTS.getCode());
        sb.append(clazzName);
        sb.append(CommSymConstant.DOUBLE_QUOTS.getCode());
        sb.append(CommSymConstant.SPACE.getCode());

        // id="ResourceMap"
        sb.append(XMLKeywordConstant.ID.getCode());
        sb.append(CommSymConstant.EQUAL_SIGN.getCode());
        sb.append(CommSymConstant.DOUBLE_QUOTS.getCode());
        sb.append(clazzName);
        sb.append(LetterTransferUtil.toOnlyFirstUpper(XMLKeywordConstant.RESULT_MAP.getCode()));
        sb.append(CommSymConstant.DOUBLE_QUOTS.getCode());

        // >
        sb.append(CommSymConstant.R_ANGLE_BRA.getCode());
        sb.append(CommSymConstant.NEWLINE.getCode());



        // 结果映射：<result property="id" column="ID"/>
        int i = 0;
        for (String key:map.keySet()) {
            // \t\t
            sb.append(CommSymConstant.TAB_SYB.getCode());
            sb.append(CommSymConstant.TAB_SYB.getCode());

            // <result
            sb.append(CommSymConstant.L_ANGLE_BRA.getCode());
            sb.append(XMLKeywordConstant.RESULT.getCode());

            // property="id"
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append(XMLKeywordConstant.COLUMN.getCode());
            sb.append(CommSymConstant.EQUAL_SIGN.getCode());
            sb.append(CommSymConstant.DOUBLE_QUOTS.getCode());
            sb.append(key);
            sb.append(CommSymConstant.DOUBLE_QUOTS.getCode());

            // column="ID"
            sb.append(CommSymConstant.SPACE.getCode());
            sb.append(XMLKeywordConstant.PROPERTY.getCode());
            sb.append(CommSymConstant.EQUAL_SIGN.getCode());
            sb.append(CommSymConstant.DOUBLE_QUOTS.getCode());
            sb.append(map.get(key));
            sb.append(CommSymConstant.DOUBLE_QUOTS.getCode());

            // />
            sb.append(CommSymConstant.R_VERTICAL.getCode());
            sb.append(CommSymConstant.R_ANGLE_BRA.getCode());
            if (i != map.keySet().size()-1) {
                i++;    // 当遍历到最后一个值时，不用换行
                sb.append(CommSymConstant.NEWLINE.getCode());
            }
        }

        sb.append(CommSymConstant.NEWLINE.getCode());
        // </resultMap>
        sb.append(CommSymConstant.TAB_SYB.getCode());
        sb.append(CommSymConstant.L_ANGLE_BRA.getCode());
        sb.append(CommSymConstant.R_VERTICAL.getCode());
        sb.append(XMLKeywordConstant.RESULT_MAP.getCode());
        sb.append(CommSymConstant.R_ANGLE_BRA.getCode());
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append(CommSymConstant.NEWLINE.getCode());
        return sb.toString();
    }


    /**
     * 生成xml文件的前缀
     *
     * @param clazzName
     * @param packagePath
     * @return
     */
    private String combineXMLPrefix(String clazzName, String packagePath) throws Exception {

        if (StrUtil.isNullStr(clazzName)) {
            throw new Exception("The clazzName is empty!!!");
        }

        if (StrUtil.isNullStr(packagePath)) {
            throw new Exception("The packagePath is empty!!!");
        }

        // StringBuffer(线程安全)public class Clazz {
        StringBuffer sb = new StringBuffer();
        String ve = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
        String docType = "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >\n";
        String namespace = "<mapper namespace=\"" + packagePath + "." + clazzName + "\">";
        sb.append(ve);
        sb.append(docType);
        sb.append(namespace);
        sb.append(CommSymConstant.NEWLINE.getCode());
        return sb.toString();
    }

    // 创建insert语句
    private String createInsert(String clazzName, String tableName, List<String> fieldList, List<String> attrList) {

        /**
         * 插入语句格式：
         \t <insert id="addResource" parameterType="Resource">
         \t insert into U_RESOURCE(ID, NAME)
         \t values(#{id},#{name})
         \t </insert>
         */

        StringBuffer sb = new StringBuffer();

        sb.append("\t<insert id=\"" + "add" + clazzName + "\" parameterType=\"" + clazzName + "\">");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\tinsert into " + tableName + "(");

        for (int i=0; i<fieldList.size(); i++) {
            // ID, NAME
            if (i != fieldList.size()-1) {
                sb.append(fieldList.get(i) + ", ");
            } else {
                sb.append(fieldList.get(i));
            }
        }

        sb.append(")\r\n");
        sb.append("\tvalues(");

        for (int i=0; i<attrList.size(); i++) {
            // #{id},#{name}
            if (i != attrList.size()-1) {
                sb.append("#{" + attrList.get(i) + "}, ");
            } else {
                sb.append("#{" + attrList.get(i) + "}");
            }
        }

        sb.append(")\r\n");
        sb.append("\t</insert>");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append(CommSymConstant.NEWLINE.getCode());
        return sb.toString();
    }

    // 创建delete语句
    private String createDelete(String clazzName, String tableName) {
        /**
         * 格式：
         \t <delete id="deleteResourceById" parameterType="Resource">
         \t delete from U_RESOURCE where ID = #{id}
         \t </delete>
         */
        StringBuffer sb = new StringBuffer();
        sb.append("\t<delete id=\"delete" + clazzName + "ById\" parameterType=\"" + clazzName + "\">");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\tdelete from " + tableName + " where ID = #{id}");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\t</delete>");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append(CommSymConstant.NEWLINE.getCode());
        return sb.toString();
    }

    // 创建update语句
    private String createUpdate(String clazzName, String tableName, Map<String, String> map) {
        /**
         * 格式：
         \t <update id="modifyResource" parameterType="Resource">
         \t update U_RESOURCE
         \t <trim prefix="set" suffixOverrides=",">
         \t \t <if test="name!=null">NAME=#{name},</if>
         \t </trim>
         \t where ID=#{id}
         \t </update>
         */
        StringBuffer sb = new StringBuffer();
        sb.append("\t<update id=\"modify" + clazzName + "\" parameterType=\"" + clazzName + "\">");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\tupdate " + tableName);
        sb.append("\t<trim prefix=\"set\" suffixOverrides=\",\">");
        for (String key:map.keySet()) {
            // sb.append("\t \t<if test="name!=null">NAME=#{name},</if>");
            if (XMLKeywordConstant.ID.getCode().equalsIgnoreCase(key)) {
                continue;   // 如果是ID，则跳过（即不允许修改）
            }
            sb.append(CommSymConstant.NEWLINE.getCode());
            sb.append("\t \t<if test=\"" + map.get(key) + "!=null\">" +key+ "=#{" +map.get(key)+ "},</if>");
        }
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\t</trim>");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\twhere ID=#{id}");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\t</update>");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append(CommSymConstant.NEWLINE.getCode());
        return sb.toString();
    }

    // 创建查询单个语句
    private String createGet(String clazzName, String tableName) {
        /**
         * 格式：
         \t <select id="findResourceById" parameterType="Resource" resultMap="ResourceMap">
         \t select * from U_RESOURCE where ID=#{id}
         \t </select>
         */
        StringBuffer sb = new StringBuffer();
        sb.append("\t<select id=\"find" + clazzName + "ById\" parameterType=\"" + clazzName + "\" resultMap=\"" + clazzName + "ResultMap\">");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\tselect * from " + tableName + " where ID=#{id}");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\t</select>");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append(CommSymConstant.NEWLINE.getCode());
        return sb.toString();
    }

    // 创建分页page语句
    private String createPage(String clazzName, String tableName) {
        /**
         * 格式：
         \t <select id="pageQueryResourceByMapCount" parameterType="Map" resultType="Integer">
         \t select count(*) from U_RESOURCE where 1=1
         \t <if test="name != null"> and NAME like #{name}||'%'</if> 此句可以不写
         \t </select>
         \t <select id="pageQueryResourceByMap" parameterType="Map"
         \t resultMap="ResourceMap">
         \t select * from U_RESOURCE where 1=1
         \t <if test="sort !=null ">
         \t order by ${sort}
         \t </if>
         \t <if test="order !=null ">
         \t ${order}
         \t </if>
         \t <if test="name!=null"> and NAME=#{name} </if> 此句可以不写
         \t </select>
         */
        StringBuffer sb = new StringBuffer();
        sb.append("\t<select id=\"pageQuery" + clazzName + "ByMapCount\" parameterType=\"Map\" resultType=\"Integer\">");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\tselect count(*) from " + tableName + " where 1=1");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\t</select>");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\t<select id=\"pageQuery" + clazzName + "ByMap\" parameterType=\"Map\" resultMap=\"" + clazzName + "ResultMap\">");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\tselect * from " + tableName + " where 1=1");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\t\t<if test=\"sort !=null \">order by ${sort}</if>");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\t\t<if test=\"order !=null \">${order}</if>");
        sb.append(CommSymConstant.NEWLINE.getCode());
        sb.append("\t</select>");
        sb.append(CommSymConstant.NEWLINE.getCode());
        return sb.toString();
    }
}
