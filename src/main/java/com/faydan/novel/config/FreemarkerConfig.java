package com.faydan.novel.config;

import com.faydan.novel.annotation.FreemarkerComponent;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.Map;

/**
 * FreemarkerConfig created with IntelliJ IDEA.
 * User:  faydan
 * Email: fei321457749@126.com
 * Date:  2018-04-26
 * Time:  14:04
 * <p>
 * Describe:
 */
public class FreemarkerConfig extends FreeMarkerConfigurer implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        Map<String, Object> map = applicationContext.getBeansWithAnnotation(FreemarkerComponent.class);
        Configuration configuration = this.getConfiguration();
        for (String key : map.keySet()) {
            configuration.setSharedVariable(key, map.get(key));
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
