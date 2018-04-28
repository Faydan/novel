<#include "../layout/layout.ftl" />
<@header title="列表" />
<div class="container gallery-container">
    <div class="tz-gallery">
        <div class="row">
            <#if articleList ??>
                <#list articleList as article>
                    <div class="col-sm-6 col-md-2">
                        <div class="thumbnail">
                            <a class="lightbox" href="/${article.id}">
                                <img src="${article.cover}?x-oss-process=style/imgSize" alt="Park">
                            </a>
                            <div class="caption">
                                <h3 style="line-height: 0">${article.title}</h3>
                            <#--<p>${article.info}</p>-->
                            </div>
                        </div>
                    </div>
                </#list>
            </#if>
        </div>
    </div>
</div>
<@footer />