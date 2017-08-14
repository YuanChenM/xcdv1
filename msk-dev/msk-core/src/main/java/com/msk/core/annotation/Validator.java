package com.msk.core.annotation;

import java.lang.annotation.*;

/**
 * Validator 注解
 * 
 * @author jiang_nan
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validator {
    String validatorClass();

    ValidatorLevel level() default ValidatorLevel.EXCEPTION;
}
