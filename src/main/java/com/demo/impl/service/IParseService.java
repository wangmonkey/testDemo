package com.demo.impl.service;

import java.util.Map;

/**
 * Created by wwz on 2018/8/1.
 */
public interface IParseService {

    /**
     * 解析文件
     * @param map 需要解析的值
     * @param regx 解析规则(String, DBConstant.toString)
     * @return 解析后的实体(String, EntityConstant.toString)
     * @throws Exception
     */
    Map<String, Map<String, String>> parse(Map<String, String> map, String regx) throws Exception;

}
