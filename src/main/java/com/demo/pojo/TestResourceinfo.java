package com.demo.pojo;

import java.util.Objects;

public class TestResourceinfo {
    int id;
    int resourceid;
    String jarFilePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResourceid() {
        return resourceid;
    }

    public void setResourceid(int resourceid) {
        this.resourceid = resourceid;
    }

    public String getJarFilePath() {
        return jarFilePath;
    }

    public void setJarFilePath(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestResourceinfo)) return false;
        TestResourceinfo that = (TestResourceinfo) o;
        return id == that.id &&
                resourceid == that.resourceid &&
                Objects.equals(jarFilePath, that.jarFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceid, jarFilePath);
    }
}
