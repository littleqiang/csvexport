package com.wxq;


import com.wxq.annotation.CSVProperty;
import com.wxq.model.BaseCsvRowModel;

import java.util.Date;

/**
 * @Description:
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/29
 * @Version: 1.0
 */
public class CsvPropertyIndexModel extends BaseCsvRowModel {

    @CSVProperty(value = "姓名" ,index = 3)
    private String name;

    @CSVProperty(value = "年龄",index = 1)
    private String age;

    @CSVProperty(value = "邮箱",index = 2)
    private String email;

    @CSVProperty(value = "地址",index = 0)
    private String address;

    @CSVProperty(value = "性别",index = 4)
    private String sax;

    @CSVProperty(value = "高度",index = 5)
    private String heigh;

    @CSVProperty(value = "生日", index = 6, format = "yyyy-MM-dd")
    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
