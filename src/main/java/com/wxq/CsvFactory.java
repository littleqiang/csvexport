package com.wxq;

import com.wxq.model.HeadModel;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Description:
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/30
 * @Version: 1.0
 */
public class CsvFactory {

    public static List<Object> read(InputStream in) {

        return null;

    }

    /**
     * 获取csvWriter
     * @param os
     * @param headModel {@link HeadModel}
     * @return
     */
    public static CsvWriter getWriter(OutputStream os, HeadModel headModel) {

        return new CsvWriter(os, headModel, true);

    }
}
