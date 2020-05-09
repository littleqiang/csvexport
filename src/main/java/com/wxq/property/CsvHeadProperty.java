package com.wxq.property;

import com.wxq.annotation.CSVColumnNum;
import com.wxq.annotation.CSVProperty;
import com.wxq.model.BaseCsvRowModel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: csv文件头部信息
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/30
 * @Version: 1.0
 */
public class CsvHeadProperty {

    /**
     * 需要写入的对象类型
     */
    private Class<? extends BaseCsvRowModel> headClazz;

    /**
     * 标题头部集合
     */
    private List<String> head = new ArrayList<>();

    private List<CsvColumnProperty> columnPropertyList = new ArrayList<>();

    public CsvHeadProperty(Class<? extends BaseCsvRowModel> headClazz, List<String> head) {
        this.headClazz = headClazz;
        this.head = head;
        initColumnProperties();
    }

    public Class getHeadClazz() {
        return headClazz;
    }

    public void setHeadClazz(Class headClazz) {
        this.headClazz = headClazz;
    }

    public List<String> getHead() {
        return head;
    }

    public void setHead(List<String> head) {
        this.head = head;
    }

    public List<CsvColumnProperty> getColumnPropertyList() {
        return columnPropertyList;
    }

    public void setColumnPropertyList(List<CsvColumnProperty> columnPropertyList) {
        this.columnPropertyList = columnPropertyList;
    }

    private void initColumnProperties() {
        if (this.headClazz != null) {
            List<Field> fieldList = new ArrayList<Field>();
            Class tempClass = this.headClazz;

            while (tempClass != null) {
                fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));

                tempClass = tempClass.getSuperclass();
            }
            List<String> headList = new ArrayList<>();
            for (Field f : fieldList) {
                initOneColumnProperty(f);
            }
            //对列排序
            Collections.sort(columnPropertyList);
            if (head == null || head.size() == 0) {
                for (CsvColumnProperty csvColumnProperty : columnPropertyList) {
                    headList.add(csvColumnProperty.getHead());
                }
                this.head = headList;
            }
        }
    }

    private void initOneColumnProperty(Field f) {
        CSVProperty p = f.getAnnotation(CSVProperty.class);
        CsvColumnProperty csvHeadProperty = null;
        if (p != null) {
            csvHeadProperty = new CsvColumnProperty();
            csvHeadProperty.setField(f);
            csvHeadProperty.setHead(p.value());
            csvHeadProperty.setIndex(p.index());
            csvHeadProperty.setFormat(p.format());
        } else {
            CSVColumnNum columnNum = f.getAnnotation(CSVColumnNum.class);
            if (columnNum != null) {
                csvHeadProperty = new CsvColumnProperty();
                csvHeadProperty.setField(f);
                csvHeadProperty.setHead(f.getName());
                csvHeadProperty.setIndex(columnNum.value());
                csvHeadProperty.setFormat(columnNum.format());
            }
        }
        if (csvHeadProperty != null) {
            this.columnPropertyList.add(csvHeadProperty);
        }

    }
}
