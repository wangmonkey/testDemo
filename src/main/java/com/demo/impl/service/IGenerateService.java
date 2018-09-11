package com.demo.impl.service;

import java.util.Map;

/**
 * Created by dell on 2018/8/3.
 */
public interface IGenerateService {

    /**
     * 根据解析后的值生成相应的类以及类中的方法
     * @param map
     * @param path 包路径：com.wwz.XXX
     * @return 如果生成成功则返回true，否则返回false（也可以考虑将返回值设置为“流”，通过输出流同一打印出来）
     */
    String generate(Map<String, Map<String, String>> map, String path) throws Exception;

}
