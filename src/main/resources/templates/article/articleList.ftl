<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="/static/lib/layui/css/layui.css">
</head>
<body>
<div class="layui-row layui-col-space1">
    <#list articleLists as articleList>
        <div class="layui-col-md3">
            <div class="grid-demo grid-demo-bg1"><a href="/article/${articleList.articleId}/${articleList.contentNumber}">${articleList.title}</a></div>
        </div>
    </#list>
</div>
</body>
<script src="/static/js/jquery-2.2.4.min.js"></script>
<script src="/static/lib/layer/layer.js"></script>
<script src="/static/lib/layui/layui.js"></script>
</html>