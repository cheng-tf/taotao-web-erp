package com.taotao.springboot.web.erp.controller;

import com.taotao.springboot.content.domain.result.EasyUITreeNode;
import com.taotao.springboot.content.domain.result.TaotaoResult;
import com.taotao.springboot.content.export.ContentCategoryResource;
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

    @Autowired
    private ContentCategoryResource contentCategoryResource;


    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(
            @RequestParam(value="id", defaultValue="0") long parentId) {
        return contentCategoryResource.getContentCategoryList(parentId);
    }


    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult addContentCategory(long parentId, String name) {
        return contentCategoryResource.addContentCategory(parentId, name);
    }

}



