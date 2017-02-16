package framework;

import java.lang.annotation.Retention;

/**
 * 题号注解
 * */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Title {
	String value();
}
