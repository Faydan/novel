package com.faydan.novel.tag;

import com.faydan.novel.annotation.FreemarkerComponent;
import com.faydan.novel.service.ClassifyService;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import javax.annotation.Resource;
import java.util.List;

/**
 * TestTag created with IntelliJ IDEA.
 * User:  faydan
 * Email: fei321457749@126.com
 * Date:  2018-04-26
 * Time:  14:11
 * <p>
 * Describe:
 */
@FreemarkerComponent("testTag")
public class TestTag implements TemplateMethodModelEx {

    @Resource
    private ClassifyService classifyService;
    @Override
    public Object exec(List list) throws TemplateModelException {
        return classifyService.findListByLevel(0);
    }
}
