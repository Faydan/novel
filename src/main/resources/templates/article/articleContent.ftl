<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="/static/lib/layui/css/layui.css">
</head>
<body>
<div>
    <a href="${articleContent.preUrl}" class="layui-btn layui-btn-normal layui-btn-sm"><i class="layui-icon"></i>上一章</a>
    <a href="/${articleContent.articleId}" class="layui-btn layui-btn-normal layui-btn-sm">目录</a>
    <a href="${articleContent.nextUrl}" class="layui-btn layui-btn-normal layui-btn-sm">下一章<i class="layui-icon"></i></a>
</div>
<div>
${articleContent.content}
</div>

<div>
    <a href="${articleContent.preUrl}" class="layui-btn layui-btn-normal layui-btn-sm"><i class="layui-icon"></i>上一章</a>
    <a href="/${articleContent.articleId}" class="layui-btn layui-btn-normal layui-btn-sm">目录</a>
    <a href="${articleContent.nextUrl}" class="layui-btn layui-btn-normal layui-btn-sm">下一章<i class="layui-icon"></i></a>
</div>

</body>
<script src="/static/js/jquery-2.2.4.min.js"></script>
<script src="/static/lib/layer/layer.js"></script>
<script src="/static/lib/layui/layui.js"></script>
</html>