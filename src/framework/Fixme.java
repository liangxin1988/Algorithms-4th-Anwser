package framework;

import java.lang.annotation.Retention;

/**
 * 用来表示未做题目的注解。通过注解可以打印未做题目名单便于查缺补漏
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Fixme {
    //关于未做题目的说明
    String info() default "";
}
