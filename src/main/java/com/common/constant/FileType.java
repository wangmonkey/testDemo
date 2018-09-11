package com.common.constant;

/**
 * Created by Administrator on 2018/8/5.
 */
public enum FileType {

    XML("xml", "XML文件"),
    JAVA("java", "Java文件"),
    PROPERTIES("properties", "Properties文件");

    private String code;

    private String description;

    private FileType(String code, String description) {
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
