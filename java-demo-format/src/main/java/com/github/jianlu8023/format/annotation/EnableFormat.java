package com.github.jianlu8023.utils.format.annotation;

import com.github.jianlu8023.utils.format.config.*;
import org.springframework.context.annotation.*;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(value = {FormatAutoConfiguration.class})
@Inherited
public @interface EnableFormat {
}
