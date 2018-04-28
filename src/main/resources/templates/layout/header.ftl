<#macro header title="">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <#--<link rel="Shortcut icon" href="../images/favicon.ico">-->
    <link rel="stylesheet" href="/static/lib/bootstrap/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/lib/bootstrap/css/bootstrap-combined.min.css">
    <link rel="stylesheet" href="/static/css/baguetteBox.min.css">
    <link rel="stylesheet" href="/static/css/thumbnail-gallery.css">
    <title>${title}</title>
    <style>
        .articleTitle {
            line-height: 20px;
            display: inline-block;
            *display: inline;
            *zoom: 1;
            width: 100px;
            height: 20px;
            overflow: hidden;
            -ms-text-overflow: ellipsis;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
    </style>
</head>
<body>

<div class="htmleaf-container">
    <div class="container gallery-container">
        <div class="tz-gallery">
            <div class="row">
                <div class="container-fluid">
                    <div class="row-fluid">
                        <div class="span12">
                            <ul class="breadcrumb">
                                <li class="active">
                                    <a href="/uploadArticle">上传</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <ul class="nav nav-tabs" id="classify">
                    <li class="active"><a href="/">首页</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

</#macro>