package com.wxq;


import com.wxq.annotation.CSVColumnNum;
import com.wxq.model.BaseCsvRowModel;

/**
 * @Description:
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/29
 * @Version: 1.0
 */
public class CsvPropertyIndexModel2 extends BaseCsvRowModel {

    @CSVColumnNum(value = 1)
    private String name;

    @CSVColumnNum(value = 3)
    private String age;

    @CSVColumnNum(value = 2)
    private String email;

    @CSVColumnNum(value = 4)
    private String address;

    @CSVColumnNum(value = 5)
    private String sax;

    @CSVColumnNum(value = 6)
    private String heigh;

    @CSVColumnNum(value = 7)
    private String last;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSax() {
        return sax;
    }

    public void setSax(String sax) {
        this.sax = sax;
    }

    public String getHeigh() {
        return heigh;
    }

    public void setHeigh(String heigh) {
        this.heigh = heigh;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
