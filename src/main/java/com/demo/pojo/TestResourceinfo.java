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


    /**
     * o.getClass()==TestResourceinfo.class 要比 o instanceof TestResourceinfo更合适
     * 因为假设SubTestResourceinfo是TestResourceinfo子类，Object o=new SubTestResourceinfo();
     * 那么o instanceof TestResourceinfo也会返回true,父类对象.equals(子类对象)一定返回false
     * equals方法通常比较的是同一个实例的两个对象是
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o!=null && o.getClass()==TestResourceinfo.class)) {
            TestResourceinfo testResourceinfo = (TestResourceinfo) o;
            return this.id == testResourceinfo.id &&
                    this.resourceid == testResourceinfo.resourceid &&
                    Objects.equals(jarFilePath, testResourceinfo.jarFilePath);
        }
        return false;
    }


    /**
     *o.getClass()==TestResourceinfo.class 要比 o instanceof TestResourceinfo更合适
     * @param o
     * @return
     */
    public boolean equals2(Object o) {
        if (this == o) return true;
        if ((o!=null && o instanceof TestResourceinfo)) {
            TestResourceinfo testResourceinfo = (TestResourceinfo) o;
            return this.id == testResourceinfo.id &&
                    this.resourceid == testResourceinfo.resourceid &&
                    Objects.equals(jarFilePath, testResourceinfo.jarFilePath);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceid, jarFilePath);
    }
}
