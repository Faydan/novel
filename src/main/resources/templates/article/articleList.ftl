<#include "../layout/layout.ftl">
<@header title="列表" />
<div class="layui-row layui-col-space1">
    <#list articleLists as articleList>
        <div class="col-sm-6 col-md-3" style="padding-bottom: 20px">
            <div class="grid-demo grid-demo-bg1"><a href="/${articleList.articleId}/${articleList.contentNumber}">${articleList.title}</a></div>
        </div>
    </#list>
</div>
<@footer />