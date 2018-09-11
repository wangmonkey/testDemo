package com.common.constant;

/**
 * Created by Administrator on 2018/8/5.
 */
public enum KeywordConstant {
    // 访问控制
    PUBLIC("public", "公开"),
    PROTECTED("protected", "保护"),
    DEFAULT("", "默认"),
    PRIVATE("private", "私有"),

    // 类,方法和变量修饰符abstract extends    final    implements    interface    native static    strictfp    synchronized    transient    volatile
    CLAZZ("class", "class"),
    NEW("new", "new"),



    // 程序控制break    continue    do    while    if    else    for    instanceof    switch case    default
    RETURN("return", "return"),



    // 异常处理
    TRY("try", "try"),
            CATCH("cathch", "catch"),
    THROW("throw", "throw"),
            THROWS("throws", "throws"),

    // 包相关
    IMPORT("import", "import"),
    PACKAGE("package", "package"),

   // 基本类型
   // byte：Java中最小的数据类型，在内存中占8位(bit)，即1个字节，取值范围-128~127，默认值0
    BYTE("byte", "字节"),
    // short：短整型，在内存中占16位，即2个字节，取值范围-32768~32717，默认值0
    SHORT("short", "短整型"),
    // int：整型，用于存储整数，在内在中占32位，即4个字节，取值范围-2147483648~2147483647，默认值0
    INT("int", "整型"),
    // long：长整型，在内存中占64位，即8个字节-2^63~2^63-1，默认值0L
    LONG("long", "长整型"),
    // float：浮点型，在内存中占32位，即4个字节，用于存储带小数点的数字（与double的区别在于float类型有效小数点只有6~7位），默认值0
    FLOAT("float", "单精度"),
    // double：双精度浮点型，用于存储带有小数点的数字，在内存中占64位，即8个字节，默认值0
    DOUBLE("double", "双精度"),
    // char：字符型，用于存储单个字符，占16位，即2个字节，取值范围0~65535，默认值为空
    CHAR("char", "字符"),
    // boolean：布尔类型，占1个字节，用于判断真或假（仅有两个值，即true、false），默认值false
    BOOLEAN("boolean", "字符串"),

    STRING("String", "字符串"),

    OBJECT("Object", "对象"),

    //变量引用
    SUPER("super", "super"),
    THIS("this", "this"),
    VOID("void", "void");
            //保留字goto    const
    private String code;

    private String description;

    private KeywordConstant(String code, String description) {
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
