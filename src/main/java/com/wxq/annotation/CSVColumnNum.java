package com.wxq.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/30
 * @Version: 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CSVColumnNum {

    /**
     * col num
     * @return
     */
    int value();

    /**
     *
     * @return
     */
    String format() default "";

}
