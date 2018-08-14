package com.taotao.springboot.web.erp.controller;

import com.taotao.springboot.search.domain.result.TaotaoResult;
import com.taotao.springboot.search.export.SearchResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(IndexManagerController.class);

    @Autowired
    private SearchResource searchResource;

    @RequestMapping("/index/import")
    @ResponseBody
    public TaotaoResult importIndex() {
        log.info("导入商品数据至索引库");
        TaotaoResult result = searchResource.importItemsToIndex();
        log.info("ElasticSearch完成商品索引库的构建");
        return result;
    }

}
