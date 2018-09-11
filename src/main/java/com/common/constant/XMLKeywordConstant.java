package com.common.constant;

/**
 * Created by Administrator on 2018/8/5.
 */
public enum XMLKeywordConstant {

    MAPPER("mapper", "mapper标示"),
    NAMESPACE("namespace", "命名空间"),

    RESULT_MAP("resultMap", "结果映射"),
    TYPE("type", "类型"),
    ID("id", "唯一标示"),
    RESULT("result", "结果"),
    PROPERTY("property", "属性"),
    COLUMN("column", "列名"),

    PARAMETER_TYPE("parameterType", "参数类型"),

    TRIM("trim", "修减"),
    PREFIX("prefix", "前缀"),
    SUFFIX_OVERRIDES("suffixOverrides", "可忽略的后缀"),
    TEST("test", "判断"),

    SQL("sql", "公共sql"),
    ASSOCIATION("association", "单关联"),
    COLLECTION("collection", "多关联");

    private String code;

    private String description;

    private XMLKeywordConstant(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
