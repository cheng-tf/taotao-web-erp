package com.taotao.springboot.web.erp.controller;

import com.taotao.springboot.content.domain.result.EasyUITreeNode;
import com.taotao.springboot.content.domain.result.TaotaoResult;
import com.taotao.springboot.content.export.ContentCategoryResource;
import com.taotao.springboot.web.erp.common.utils.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>Title: ContentCategoryController</p>
 * <p>Description: 内容类目管理Controller</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-06 11:53</p>
 * @author ChengTengfei
 * @version 1.0
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    private static final Logger log = LoggerFactory.getLogger(ContentCategoryController.class);

    @Autowired
    private ContentCategoryResource contentCategoryResource;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(
            @RequestParam(value="id", defaultValue="0") long parentId) {
        log.info("根据父类目ID查询内容类目列表, parentId={}", String.valueOf(parentId));
        List<EasyUITreeNode> result = contentCategoryResource.getContentCategoryList(parentId);
        log.info("根据父类目ID查询内容类目列表, result={}", JacksonUtils.objectToJson(result));
        return result;
    }

    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult addContentCategory(long parentId, String name) {
        log.info("添加内容类目，parentId={} and name={}", String.valueOf(parentId), name);
        TaotaoResult result = contentCategoryResource.addContentCategory(parentId, name);
        log.info("添加内容类目，res={}", JacksonUtils.objectToJson(result));
        return result;
    }

}



