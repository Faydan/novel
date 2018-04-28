

$.post("/list/articleList", {}, function (data) {
    if (data.result == 1) {
        var  classifyId = data.classifyId;
        var liHtml = "";
        if (classifyId == 0) {
            liHtml += ('<li class="active"><a href="/">首页</a></li>');
            var classifyList = data.classifyList;
            $.each(classifyList, function (i, classify) {
                liHtml += ('<li><a href="/list/' + classify.id + '">'+ classify.name +'</a></li>');
            })
        } else {
            liHtml += ('<li><a href="/">首页</a></li>');
            var classifyList = data.classifyList;
            $.each(classifyList, function (i, classify) {
                var active = "";
                console.log(classifyId);
                console.log(classify.id);
                if (classifyId == classify.id) {
                    active = 'class="active"';
                    console.log(active);
                }
                liHtml += ('<li><a '+ active +' href="/list/' + classify.id + '">'+ classify.name +'</a></li>');
            })
        }
        $("#classify").html(liHtml);

    } else {
        layer.msg(data.msg, {icon: 2})
    }
});