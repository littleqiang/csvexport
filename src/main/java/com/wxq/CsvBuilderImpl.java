package com.wxq;

import com.wxq.context.WriteContext;
import com.wxq.model.HeadModel;
import com.wxq.property.CsvColumnProperty;
import com.wxq.util.CollectionUtils;
import com.wxq.util.TypeUtils;
import net.sf.cglib.beans.BeanMap;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @Description:
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/29
 * @Version: 1.0
 */
public class CsvBuilderImpl implements CsvBuilder {

    private WriteContext context;

    public CsvBuilderImpl(OutputStream os, HeadModel headModel, boolean needHead) {

        context = new WriteContext(os, headModel, needHead);

    }

    /**
     * 将list结果写入csv
     * @param data
     */
    @Override
    public void addCSV(List data){

        context.initCsvHeadProperty();

        addHeader();

        addContent(data, 0);

    }

    /**
     * 添加文件标头信息
     */
    private void addHeader(){

        String headLine = "";

        for (String head : context.getCsvHeadProperty().getHead()) {

            headLine += head + ",";

        }

        String headLineStr = headLine.substring(0, headLine.length() - 1);

        try {

            context.getBufferedWriter().append(headLineStr).append("\r");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 添加内容
     * @param data
     * @param startRow 暂时不用
     */
    private void addContent(List data, int startRow) {

        if (CollectionUtils.isEmpty(data)) {
            return;
        }
        if (context.getCsvHeadProperty() == null || !context.isNeedHead()) {
            startRow = -1;
        }
        for (int i = 0; i < data.size(); i++){

            int n = i + startRow + 1;
            addOneRowToCSV(data.get(i), n);

        }
    }

    /**
     * 添加一行内容
     * @param oneRowData
     * @param n
     */
    private void addOneRowToCSV(Object oneRowData, int n) {

        if (oneRowData instanceof List) {
            addBasicTypeToCSV((List)oneRowData, n);
        } else {
            addJavaObjectToCSV(oneRowData, n);
        }

    }

    /**
     * 通过数组写入csv
     * @param oneRowData
     * @param n
     */
    private void addBasicTypeToCSV(List oneRowData, int n) {

        if (CollectionUtils.isEmpty(oneRowData)) {

            return;

        }

        String lineContent="";

        for (Object o : oneRowData) {

            String cellValue = TypeUtils.formatFieldStringValue(o, context.getDateFormat());

            lineContent+=csvHandlerStr(cellValue)+",";
        }

        String lineContentStr = lineContent.substring(0, lineContent.length() - 1);

        writeOneRow(lineContentStr);

    }

    /**
     * 通过注解的javabean 写入csv
     * @param oneRowData
     * @param n
     */
    private void addJavaObjectToCSV(Object oneRowData, int n) {

        String lineContent="";

        BeanMap beanMap = BeanMap.create(oneRowData);

        for (CsvColumnProperty csvColumnProperty : context.getCsvHeadProperty().getColumnPropertyList()) {

            String cellValue = TypeUtils.getFieldStringValue(beanMap, csvColumnProperty.getField().getName(),
                    csvColumnProperty.getFormat());

            lineContent+=csvHandlerStr(cellValue)+",";
        }

        String lineContentStr = lineContent.substring(0, lineContent.length() - 1);

        writeOneRow(lineContentStr);
    }

    /**
     * 写入一行
     * @param lineContent
     */
    private void writeOneRow(String lineContent){
        try {
            context.getBufferedWriter().append(lineContent).append("\r");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 处理csv特殊字符"," """
     * @param str
     * @return
     */
    private String csvHandlerStr(String str) {
        //csv格式如果有逗号，整体用双引号括起来；如果里面还有双引号就替换成两个双引号，这样导出来的格式就不会有问题了
        String tempDescription = str;
        //如果有逗号
        if (str.contains(",")) {
            //如果还有双引号，先将双引号转义，避免两边加了双引号后转义错误
            if (str.contains("\"")) {
                tempDescription = str.replace("\"", "\"\"");
            }
            //在将逗号转义
            tempDescription = "\"" + tempDescription + "\"";
        }
        return tempDescription;
    }

    /**
     * 关闭
     */
    @Override
    public void finish() {
        try {
            context.getBufferedWriter().close();
            context.getOsw().close();
            context.getOutputStream();
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }
}
