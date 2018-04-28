package com.faydan.novel.tag.base;



import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseFreemarker created with IntelliJ IDEA.
 * User:  faydan
 * Email: fei321457749@126.com
 * Date:  2018-04-25
 * Time:  19:09
 * <p>
 * Describe: freemarker 标准基类
 */
@SuppressWarnings("deprecation")
public abstract class BaseFreemarkerTag implements TemplateMethodModel {

    @SuppressWarnings("rawtypes")
    public Object exec(List jsonParam) throws TemplateModelException {

        if(jsonParam!=null && !jsonParam.isEmpty()){
            String param = (String)jsonParam.get(0);
            if(param!=null){
                if(!param.startsWith("{")){
                    param="{"+param+"}";
                }
                JSONObject jsonObject  =JSONObject.fromObject(param);
                return this.exec(jsonObject);
            }else{
                return this.exec(new HashMap());
            }
        }else{
            return this.exec(new HashMap());
        }
    }

    @SuppressWarnings("rawtypes")
    protected abstract Object exec(Map params) throws TemplateModelException;

}
