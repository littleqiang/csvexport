package com.wxq;


import com.wxq.model.BaseCsvRowModel;
import com.wxq.model.HeadModel;

import java.io.OutputStream;
import java.util.List;

/**
 * @Description:
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/29
 * @Version: 1.0
 */
public class CsvWriter {

    private CsvBuilder csvBuilder;

    public CsvWriter(OutputStream os, HeadModel headModel, boolean needHead) {

        csvBuilder = new CsvBuilderImpl(os, headModel, needHead);

    }

    /**
     * 通过javabean注解方式写csv
     * @param data
     * @return
     */
    public CsvWriter writer(List<? extends BaseCsvRowModel> data){

        csvBuilder.addCSV(data);

        return this;
    }

    /**
     * 通过数组集合方式写csv
     * @param data
     * @return
     */
    public CsvWriter writerByList(List<List<Object>> data){

        csvBuilder.addCSV(data);

        return this;
    }

    public void finish() {
        csvBuilder.finish();
    }
}
