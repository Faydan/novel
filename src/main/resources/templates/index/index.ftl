<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="/static/lib/layui/css/layui.css">
</head>
<body>
<div class="layui-row">
    <div class="layui-col-md1 layui-col-md-offset2">
        <div class="grid-demo grid-demo-bg1"><a href="">网站首页</a></div>
    </div>
    <#list classifyList as classify>
        <div class="layui-col-md1">
            <div class="grid-demo grid-demo-bg1"><a href="">${classify.name}</a></div>
        </div>
    </#list>
</div>

<div class="layui-row layui-col-space5">
    <#list articleList as article>
        <div class="layui-col-md1">
            <div class="grid-demo grid-demo-bg1">
                <p><a href="/article/${article.id}"><img src="${article.cover}" alt="封面"></a></p>
                <p>${article.title}</p>
                <p>作者: ${article.author}</p>
                <p>简介: ${article.info}</p>
            </div>
        </div>
    </#list>
</div>

</body>
<script src="/static/js/jquery-2.2.4.min.js"></script>
<script src="/static/lib/layer/layer.js"></script>
<script src="/static/lib/layui/layui.js"></script>

</html>