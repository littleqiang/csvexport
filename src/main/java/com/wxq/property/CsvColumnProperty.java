package com.wxq.property;

import java.lang.reflect.Field;

/**
 * @Description: csv列
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/30
 * @Version: 1.0
 */
public class CsvColumnProperty implements Comparable<CsvColumnProperty> {

    /**
     * 对象中对应列的信息
     */
    private Field field;

    /**
     * 列排序索引
     */
    private int index = 99999;

    /**
     * 列名
     */
    private String head;

    /**
     * 日期格式
     */
    private String format;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public int compareTo(CsvColumnProperty o) {
        int x = this.index;
        int y = o.getIndex();
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}
