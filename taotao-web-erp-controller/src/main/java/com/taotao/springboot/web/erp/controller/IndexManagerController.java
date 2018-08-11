package com.taotao.springboot.web.erp.controller;

import com.taotao.springboot.search.domain.result.TaotaoResult;
import com.taotao.springboot.search.export.SearchResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Title: IndexManagerController</p>
 * <p>Description: 索引库维护Controller</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-06 11:56</p>
 * @author ChengTengfei
 * @version 1.0
 */
@Controller
public class IndexManagerController {

    @Autowired
    private SearchResource searchResource;

    @RequestMapping("/index/import")
    @ResponseBody
    public TaotaoResult importIndex() {
        return searchResource.importItemsToIndex();
    }

}
