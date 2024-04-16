package com.github.jianlu8023.utils.generator.utils;

import org.slf4j.*;
import org.springframework.beans.*;
import org.springframework.context.*;

import java.io.*;
import java.lang.annotation.*;
import java.util.*;


public class SpringContextUtils implements ApplicationContextAware, Closeable {

    private static final Logger L = LoggerFactory.getLogger(SpringContextUtils.class);

    /**
     * 上下文对象
     */
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        L.debug("当前上下文对象为空，进行设置山下文");
        this.applicationContext = applicationContext;
    }

    private void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicationContext未注入,请在applicationContext.xml中定义SpringContextHolder");
        }
    }

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    private ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 清除applicationContext静态变量.
     */
    public void cleanApplicationContext() {
        applicationContext = null;
    }


    public Object getBean(String clazz) throws BeansException {
        return getApplicationContext().getBean(clazz);
    }

    public <T> T getBean(String s, Class<T> clazz) throws BeansException {
        return getApplicationContext().getBean(s, clazz);
    }

    public Object getBean(String s, Object... objects) throws BeansException {
        return getApplicationContext().getBean(s, objects);
    }

    public <T> T getBean(Class<T> tClass) throws BeansException {
        return getApplicationContext().getBean(tClass);
    }

    public <T> T getBean(Class<T> clazz, Object... objects) throws BeansException {
        return getApplicationContext().getBean(clazz, objects);
    }

    /**
     * getBeans
     * <p>
     * 获取某一类型的bean集合
     * <p>
     * create time: 2024/3/19 上午11:58
     * <p>
     * create by: ght
     *
     * @param clazz :
     * @return Map<String, T>
     */
    @SuppressWarnings("unused")
    public <T> Map<String, T> getBeans(Class<T> clazz) {
        return getApplicationContext().getBeansOfType(clazz);
    }

    public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> clazz) throws BeansException {
        return getApplicationContext().getBeansWithAnnotation(clazz);
    }

    /**
     * 获取配置文件配置项的值
     *
     * @param key 配置项key
     */
    @SuppressWarnings("unused")
    private String getEnvironmentProperty(String key) {
        return getApplicationContext().getEnvironment().getProperty(key);
    }

    /**
     * 获取spring.profiles.active
     */
    @SuppressWarnings("unused")
    private String[] getActiveProfile() {
        return getApplicationContext().getEnvironment().getActiveProfiles();
    }

    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     *
     * <p> As noted in {@link AutoCloseable#close()}, cases where the
     * close may fail require careful attention. It is strongly advised
     * to relinquish the underlying resources and to internally
     * <em>mark</em> the {@code Closeable} as closed, prior to throwing
     * the {@code IOException}.
     */
    @Override
    public void close() {
        cleanApplicationContext();
    }
}
