package com.taotao.springboot.web.erp.controller;

import com.taotao.springboot.content.domain.pojo.TbContent;
import com.taotao.springboot.content.domain.result.EasyUIDataGridResult;
import com.taotao.springboot.content.domain.result.TaotaoResult;
import com.taotao.springboot.content.export.ContentResource;
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

    @Autowired
    private ContentResource contentResource;

    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult addContent(TbContent content) {
        return  contentResource.addContent(content);
    }

    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIDataGridResult getContentList(long categoryId, int page, int rows) {
        return  contentResource.getContentList(categoryId, page, rows);
    }

}