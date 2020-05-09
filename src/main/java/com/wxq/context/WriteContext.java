package com.wxq.context;

import com.wxq.model.HeadModel;
import com.wxq.property.CsvHeadProperty;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * @Description: 上下文
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/30
 * @Version: 1.0
 */
public class WriteContext {

    private CsvHeadProperty csvHeadProperty;

    private OutputStream outputStream;

    private BufferedWriter bufferedWriter;

    private OutputStreamWriter osw;

    private HeadModel headModel;

    /**
     * 暂时不用
     */
    private boolean needHead = Boolean.TRUE;

    public WriteContext(OutputStream outputStream, HeadModel headModel, boolean needHead) {
        this.outputStream = outputStream;
        this.headModel = headModel;
        this.needHead = needHead;
        initBufferWriter();
    }

    public void initCsvHeadProperty() {
        this.csvHeadProperty = new CsvHeadProperty(headModel.getClazz(), headModel.getHead());
    }

    public OutputStreamWriter getOsw() {
        return osw;
    }

    public void setOsw(OutputStreamWriter osw) {
        this.osw = osw;
    }

    /**
     * 初始化bufferwriter
     * 设置字符
     */
    public void initBufferWriter() {

        this.osw = new OutputStreamWriter(this.outputStream,Charset.forName("UTF-8"));

        this.bufferedWriter = new BufferedWriter(this.osw);

        try {

            this.bufferedWriter.write("\ufeff");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CsvHeadProperty getCsvHeadProperty() {
        return csvHeadProperty;
    }

    public void setCsvHeadProperty(CsvHeadProperty csvHeadProperty) {
        this.csvHeadProperty = csvHeadProperty;
    }

    public boolean isNeedHead() {

        return needHead;
    }

    public void setNeedHead(boolean needHead) {
        this.needHead = needHead;
    }

    public OutputStream getOutputStream() {

        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public String getDateFormat() {
        return this.headModel.getFormat();
    }
}
