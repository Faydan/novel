package com.faydan.novel.tag;

import com.faydan.novel.entity.Classify;
import com.faydan.novel.repository.ClassifyRepository;
import com.faydan.novel.service.ClassifyService;
import com.faydan.novel.tag.base.BaseFreemarkerTag;
import freemarker.template.TemplateModelException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassifyTag created with IntelliJ IDEA.
 * User:  faydan
 * Email: fei321457749@126.com
 * Date:  2018-04-25
 * Time:  19:11
 * <p>
 * Describe:
 */
@Service
public class ClassifyTag extends BaseFreemarkerTag {

    @Resource
    private ClassifyRepository classifyRepository;

    @SuppressWarnings("rawtypes")
    @Override
    public Object exec(Map param) {
        return 1;
    }
}
