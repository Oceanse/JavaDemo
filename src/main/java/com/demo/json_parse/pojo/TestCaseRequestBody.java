package com.demo.json_parse.pojo;

import java.util.Map;

public class TestCaseRequestBody {
    private String packageName;
    private String ClassName;
    private String methodName;
    private String name;
    private Map<String,String> parameters;
    private String id;

    public String getConfigurationData() {
        return configurationData;
    }

    public void setConfigurationData(String configurationData) {
        this.configurationData = configurationData;
    }

    private String configurationData;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestCaseRequestBody{" +
                "packageName='" + packageName + '\'' +
                ", ClassName='" + ClassName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", name='" + name + '\'' +
                ", parameters=" + parameters +
                ", id='" + id + '\'' +
                ", configurationData='" + configurationData + '\'' +
                '}';
    }
}
