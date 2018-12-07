package com.xyang.shop.web;

import com.xyang.shop.utils.FastDFSClientUtil;
import com.xyang.shop.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/5 0005.
 */

@Controller
public class PictureController {

    //@Value("${IMAGE_SERVER_URL}")是为了注入我们在配置文件resource.properties中配置的图片访问前缀。

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    /**
     * 使用@ResponseBody注解返回java对象时，Content-Type响应头的值默认为application/json;charset=UTF-8，
     * 而要解决浏览器兼容性问题，则需要返回字符串，并且Content-Type响应头的值要为text/plan;charset=UTF-8。
     * public static final String TEXT_PLAIN_VALUE = "text/plain";
     * @param uploadFile
     * @return
     */
    @RequestMapping(value = "/pic/upload")
    @ResponseBody
    public String uploadPic(MultipartFile uploadFile) {
        try {
            // 首先接收页面上传的文件
            byte[] content = uploadFile.getBytes();
            // 取出文件的扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            // 把这个文件内容上传到图片服务器
            FastDFSClientUtil fastDFSClient = new FastDFSClientUtil("classpath:resource/fast_dfs.conf");
            String url = fastDFSClient.uploadFile(content, ext);
            // 从配置文件中取图片服务器的url
            // 创建返回结果对象
            Map result = new HashMap();
            result.put("error", 0);
            result.put("url", IMAGE_SERVER_URL + url);
            // 返回结果
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return JsonUtils.objectToJson(result);
        }
    }

}
