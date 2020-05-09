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
public @interface CSVProperty {

    /**
     * @return
     */
    String value() default "";


    /**
     * @return
     */
    int index() default 99999;

    /**
     *
     * @return
     */
    String format() default "";

}
