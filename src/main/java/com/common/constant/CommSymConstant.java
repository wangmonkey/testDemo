package com.common.constant;

/**
 * Created by Administrator on 2018/8/5.
 */
public enum CommSymConstant {

    L_PARENTHESIS("(", "左小括号"),
    R_PARENTHESIS(")", "右小括号"),
    L_BRACES("{", "左大括号"),
    R_BRACES("}", "右大括号"),
    L_ANGLE_BRA("<", "左尖括号"),
    R_ANGLE_BRA(">", "右尖括号"),
    L_VERTICAL("\\", "反斜竖"),
    R_VERTICAL("/", "斜竖"),
    WELL("#", "井号"),
    DOUBLE_QUOTS("\"", "双引号(en)"),
    DOT(".", "句点(en)"),
    SEMICOLON(";", "分号"),
    EQUAL_SIGN("=", "等号"),
    TAB_SYB("\t", "Tab符"),
    NEWLINE("\r\n", "换行符"),
    SPACE(" ", "空格");

    private String code;

    private String description;

    private CommSymConstant(String code, String description) {
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
