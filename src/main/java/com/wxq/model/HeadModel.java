package com.wxq.model;

import java.util.List;

/**
 * @Description: 标题头
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/30
 * @Version: 1.0
 */
public class HeadModel {

    private Class<? extends BaseCsvRowModel> clazz;

    private List<String> head;

    private String format;

    public HeadModel(Class<? extends BaseCsvRowModel> clazz) {
        this.clazz = clazz;
    }

    public HeadModel(List<String> head) {
        this.head = head;
    }

    public Class<? extends BaseCsvRowModel> getClazz() {

        return clazz;
    }

    public void setClazz(Class<? extends BaseCsvRowModel> clazz) {
        this.clazz = clazz;
    }

    public List<String> getHead() {
        return head;
    }

    public void setHead(List<String> head) {
        this.head = head;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
