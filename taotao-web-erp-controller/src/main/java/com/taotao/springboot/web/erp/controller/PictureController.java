package com.taotao.springboot.web.erp.controller;

import com.taotao.springboot.web.erp.common.utils.FastDFSClient;
import com.taotao.springboot.web.erp.common.utils.JacksonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: PictureController</p>
 * <p>Description: 图片上传Controller</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-06 11:57</p>
 * @author ChengTengfei
 * @version 1.0
 */
@Controller
@RequestMapping("/pic")
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping("/upload")
    @ResponseBody
    public String picUpload(MultipartFile uploadFile) {
        try {
            // 接收上传的文件
            // 获取扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(",") + 1);
            //上传到图片服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
            String url = fastDFSClient.uploadFile(uploadFile.getBytes());
            url = IMAGE_SERVER_URL + url;
            // 响应上传图片的URL
            Map<String, Object> result = new HashMap<>();
            result.put("error", 0);
            result.put("url", url);
            // 返回JSON数据
            return JacksonUtils.objectToJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return JacksonUtils.objectToJson(result);
        }
    }

}