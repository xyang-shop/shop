import com.xyang.shop.utils.FastDFSClientUtil;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * Created by Administrator on 2018/12/5 0005.
 */
public class testUpload {

    @Test
    public void testFdfs() throws Exception{
        // 1.先创建一个配置文件——fast_dfs.conf，配置文件的内容就是指定TrackerServer的地址

        // 2.使用全局方法加载配置文件
        ClientGlobal.init("E:/code/xyangShop/shopCode/shop-manager-web/src/main/resources/fast_dfs.conf");
        // 3.创建一个TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        // 4.通过TrackerClient对象获得TrackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        // 5.创建StorageServer的引用，null就可以了
        StorageServer storageServer = null;
        // 6.创建一个StorageClient对象，其需要两个参数，一个是TrackerServer，一个是StorageServer
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7.使用StorageClient对象上传文件(图片)
        // 参数1：文件名，参数名：扩展名，不能包含"."，参数3：文件的元数据，保存文件的原始名、大小、尺寸等，如果没有可为null
        String[] strings = storageClient.upload_file("E:/code/fdfs_test/1.jpg", "jpg", null);
        for (String string : strings) {
            System.out.println(string);
        }

    }

    @Test
    public void testFdfsClient() throws Exception{
        FastDFSClientUtil fastDFSClient = new FastDFSClientUtil("E:/code/xyangShop/shopCode/shop-manager-web/src/main/resources/fast_dfs.conf");
        String string = fastDFSClient.uploadFile("E:/code/fdfs_test/2.png");
        // 注意，你再上传一遍，刚才你上传的那个图片就已经丢了，它已经存在服务器上了，你再也访问不到了
        System.out.println(string);
    }
}
