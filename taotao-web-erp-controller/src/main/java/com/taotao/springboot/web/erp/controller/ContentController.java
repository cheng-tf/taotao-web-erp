package com.taotao.springboot.web.erp.controller;

import com.taotao.springboot.content.domain.pojo.TbContent;
import com.taotao.springboot.content.domain.result.EasyUIDataGridResult;
import com.taotao.springboot.content.domain.result.TaotaoResult;
import com.taotao.springboot.content.export.ContentResource;
import com.taotao.springboot.web.erp.common.utils.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Title: ContentController</p>
 * <p>Description: 内容管理Controller</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-06 11:51</p>
 * @author ChengTengfei
 * @version 1.0
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    private static final Logger log = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    private ContentResource contentResource;

    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult addContent(TbContent content) {
        log.info("添加内容，content={}", JacksonUtils.objectToJson(content));
        TaotaoResult result = contentResource.addContent(content);
        log.info("添加内容，res={}", JacksonUtils.objectToJson(result));
        return  result;
    }

    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIDataGridResult getContentList(long categoryId, int page, int rows) {
        log.info("根据内容类目ID查询内容列表, categoryId={}", String.valueOf(categoryId));
        EasyUIDataGridResult result = contentResource.getContentList(categoryId, page, rows);
        log.info("根据内容类目ID查询内容列表，res={}", JacksonUtils.objectToJson(result));
        return  result;
    }

}