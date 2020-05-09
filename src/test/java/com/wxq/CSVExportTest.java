package com.wxq;

import com.wxq.model.HeadModel;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/29
 * @Version: 1.0
 */
public class CSVExportTest {

    /**
     * 数组方式写入csv
     * @throws IOException
     */
    @Test
    public void exportCsv() throws IOException {

        String[] header={"姓名","年龄","邮箱","地址","性别","高度","生日"};

        Long start=new Date().getTime();

        OutputStream out = new FileOutputStream("/Users/wangxuqiang/Downloads/CSVExport1.csv");

        HeadModel headModel=new HeadModel(Arrays.asList(header));
        headModel.setFormat("yyyy-MM-dd");
        CsvWriter writer = CsvFactory.getWriter(out,headModel);

        writer.writerByList(getData3());

        writer.finish();

        out.close();

        System.out.println(new Date().getTime() - start);
    }

    private List<List<Object>> getData3() {

        List<List<Object>> lists = new ArrayList<>();

        for (int i = 0; i < 1000000; i++){
            List<Object> objects = new ArrayList<>();
            objects.add("小明"+i);
            objects.add(20);
            objects.add("qqqq@163.com");
            objects.add("f\"ff,f'f");
            objects.add(0.223);
            objects.add(100L);
            objects.add(new Date());

            lists.add(objects);
        }

        return lists;
    }

    /**
     * javabean注解写入csv
     * @throws IOException
     */
    @Test
    public void exportCsv2() throws IOException {

        Long start=new Date().getTime();
        OutputStream out = new FileOutputStream("/Users/wangxuqiang/Downloads/CSVExport3.csv");

        HeadModel headModel=new HeadModel(CsvPropertyIndexModel.class);
        CsvWriter writer = CsvFactory.getWriter(out,headModel);

        writer.writer(getData());

        writer.finish();

        out.close();

        System.out.println(new Date().getTime() - start);
    }

    private static List<CsvPropertyIndexModel> getData() {
        List<CsvPropertyIndexModel> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {  //一百万数据量
            CsvPropertyIndexModel client = new CsvPropertyIndexModel();
            client.setName("小明"+i);
            client.setAge("20");
            client.setEmail("qqqq@163.com");
            client.setAddress("f\"ff,f'f");
            client.setSax("男");
            client.setHeigh("100");
            client.setBirthday(new Date());
            list.add(client);
        }
        return list;
    }

    private static List<CsvPropertyIndexModel2> getData2() {
        List<CsvPropertyIndexModel2> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {  //一百万数据量
            CsvPropertyIndexModel2 client = new CsvPropertyIndexModel2();
            client.setName("小明"+i);
            client.setAge("20");
            client.setEmail("qqqq@163.com");
            client.setAddress("f\"ff,f'f");
            client.setSax("男");
            client.setHeigh("100");
            client.setLast("11");
            list.add(client);
        }
        return list;
    }

}
