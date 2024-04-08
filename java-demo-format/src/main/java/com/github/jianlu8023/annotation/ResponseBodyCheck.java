package com.github.jianlu8023.annotation;

import org.springframework.web.bind.annotation.*;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ResponseBody
public @interface ResponseBodyCheck {
}
