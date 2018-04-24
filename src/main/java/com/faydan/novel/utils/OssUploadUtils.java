package com.faydan.novel.utils;

import com.aliyun.oss.OSSClient;
import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.net.URL;

@Slf4j
public class OssUploadUtils {
    private static final String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
    private static final String accessKeyId = "LTAIqk28Y76sRtVQ";
    private static final String accessKeySecret = "95Gjw4otcqgADeixghuOcDU2oqTLrU";

    /**
     * 访问路径
     */
    private static final String accessPath = "https://faydan.oss-cn-beijing.aliyuncs.com/";

    // 上传封面的key
    private static final String coverKey = "novel/cover/";

    // bucketName
    private static final String bucketName = "faydan";

    private static final String suffix = ".jpg";

    /**
     * 默认上传封面
     *
     * @param urlStr 图片的源路径
     * @return 图片路径
     */
    public static String uploadImage(String urlStr) {
        // 创建OSSClient实例
        OSSClient ossClient = null;
        URL url = null;
        String imageName = String.valueOf(System.currentTimeMillis()) + suffix;
        String path = accessPath + coverKey + imageName;
        log.info("图片路径-> {}", path);
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            url = new URL(urlStr);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            ossClient.putObject(bucketName, coverKey + imageName, dataInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}
