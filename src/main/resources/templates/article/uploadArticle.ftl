<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>上传</title>
    <link rel="stylesheet" href="/static/lib/layui/css/layui.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>上传小说</legend>
</fieldset>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">小说id</label>
            <div class="layui-input-inline">
                <input type="text" name="articleId" lay-verify="required" placeholder="请输入小说id" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">小说分类</label>
            <div class="layui-input-inline">
                <select title="分类" name="classifyId" lay-verify="required" lay-search="">
                    <option value="">搜索分类</option>
                    <#list classifyList as classify>
                        <option value="${classify.id}">${classify.name}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <button class="layui-btn" lay-submit="" lay-filter="uploadArticle">立即提交</button>
        </div>
    </div>
</form>
</body>
<script src="/static/js/jquery-2.2.4.min.js"></script>
<script src="/static/lib/layer/layer.js"></script>
<script src="/static/lib/layui/layui.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
                ,layer = layui.layer;

        //监听提交
        form.on('submit(uploadArticle)', function(data){
            var stringify = JSON.stringify(data.field);
            var parse = JSON.parse(stringify);
            var articleId = parse.articleId;
            var classifyId = parse.classifyId;
            // layer.alert(articleId + "/" + classifyId);
            var url = "/" + classifyId + "/" + articleId;
            $.post(url, function (data) {
                var index = layer.load(0, {shade: false});
                if (data) {
                    window.location.href = "/";
                } else {
                    layer.msg("上传失败", {icon: 2})
                }
            });
            return false;
        });
    });
</script>
</html>