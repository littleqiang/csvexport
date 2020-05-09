package com.wxq;

import java.util.List;

/**
 * @Description:
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/29
 * @Version: 1.0
 */
public interface CsvBuilder {

    /**
     * 将list结果写入csv
     * @param data
     */
    void addCSV(List data);

    /**
     * 关闭
     */
    void finish();
}
