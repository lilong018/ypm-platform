/**
 * Copyright (c) 2018 有票么 All rights reserved.
 *
 *
 *
 * 版权所有，侵权必究！
 */

package com.platform.commons.dynamic.datasource.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default "";
}
