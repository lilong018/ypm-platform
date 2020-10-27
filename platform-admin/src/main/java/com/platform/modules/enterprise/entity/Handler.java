package com.platform.modules.enterprise.entity;

/**
 * @ClassName Handler
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/18 14:56
 **/
public class Handler {
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Handler{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
