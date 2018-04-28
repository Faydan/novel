package com.faydan.novel.fastdfs;

import com.faydan.novel.ApplicationTests;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import java.io.IOException;

/**
 * fastdfs created with IntelliJ IDEA.
 * User:  faydan
 * Email: fei321457749@126.com
 * Date:  2018-04-28
 * Time:  18:23
 * <p>
 * Describe:
 */
public class FastDFSTest extends ApplicationTests {

    private String fastDFSProperties = "fastdfs_client.properties";

    @Test
    public void uploadTest2() throws IOException, MyException {
        byte[] fileBuff = "标题".getBytes();
        ClientGlobal.initByProperties(fastDFSProperties);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();

        StorageClient storageClient = new StorageClient(trackerServer, null);
        NameValuePair nvp [] = new NameValuePair[]{
                new NameValuePair("age", "18"),
                new NameValuePair("sex", "male")
        };

        String fileIds[] = storageClient.upload_file(fileBuff, "txt", nvp);

        System.out.println(fileIds.length);
        System.out.println("组名：" + fileIds[0]);
        System.out.println("路径: " + fileIds[1]);
    }
}
