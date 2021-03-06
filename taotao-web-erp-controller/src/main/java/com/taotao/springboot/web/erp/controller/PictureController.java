package com.taotao.springboot.web.erp.controller;

import com.taotao.springboot.web.erp.common.utils.FastDFSClient;
import com.taotao.springboot.web.erp.common.utils.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(PictureController.class);

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    /**
     * 商品图片上传
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String picUpload(MultipartFile uploadFile) {
        log.info("商品图片上传");
        try {
            // #1 接收文件，并获取扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(",") + 1);
            // #2 上传至FastDFS图片服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
            String url = fastDFSClient.uploadFile(uploadFile.getBytes());
            // #3 获取返回的图片URL
            url = IMAGE_SERVER_URL + url;
            Map<String, Object> result = new HashMap<>();
            result.put("error", 0);
            result.put("url", url);
            // #4 返回JSON数据
            String jsonString = JacksonUtils.objectToJson(result);
            log.info("商品图片上传成功，res={}", jsonString);
            return jsonString;
        } catch (Exception e) {
            log.error("商品图片上传失败, error={}", e);
            Map<String, Object> result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "商品图片上传失败");
            return JacksonUtils.objectToJson(result);
        }
    }

}
