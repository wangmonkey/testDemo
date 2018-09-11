package com.demo.impl;

import com.demo.impl.service.IGenerateService;

import java.util.Map;

/**
 * Created by Administrator on 2018/8/12.
 */
public class GenerateTemplateServiceImpl implements IGenerateService {

    @Override
    public String generate(Map<String, Map<String, String>> map, String path) throws Exception {

        String restPackageName = null;
        String servicePackageName = null;
        String entityName = null;

        StringBuffer sb = new StringBuffer();
        sb = createRest(sb, restPackageName, entityName);
        sb = createService(sb, servicePackageName, entityName);

        return sb.toString();
    }

    /**
     * 创建Rest层
     * @param sb 用于拼接字符串
     * @param packagePath 包路径
     * @param entityName 实体类名称
     * @return
     */
    private StringBuffer createRest(StringBuffer sb, String packagePath, String entityName) {

        sb.append("package " + packagePath + ";\n\n");

        return sb;
    }

    /**
     * 创建Service接口及其实现层
     * @param sb 用于拼接字符串
     * @param packagePath 包路径
     * @param entityName 实体类名称
     * @return
     */
    private StringBuffer createService(StringBuffer sb, String packagePath, String entityName) {

        sb.append("package " + packagePath + ";\n\n");

        return sb;
    }
}
