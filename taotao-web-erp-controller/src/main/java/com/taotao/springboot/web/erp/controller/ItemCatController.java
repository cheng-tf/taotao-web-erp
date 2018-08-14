package com.taotao.springboot.web.erp.controller;

import com.taotao.springboot.item.domain.result.EasyUITreeNode;
import com.taotao.springboot.item.export.ItemCatResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>Title: ItemCatController</p>
 * <p>Description: 商品类目管理Controller</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-06 11:50</p>
 * @author ChengTengfei
 * @version 1.0
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    private static final Logger log = LoggerFactory.getLogger(ItemCatController.class);

    @Autowired
    private ItemCatResource itemCatResource;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(name = "id", defaultValue = "0") long parentId) {
        log.info("查询商品类目列表， parentId = {}", String.valueOf(parentId));
        List<EasyUITreeNode> lists = itemCatResource.getItemCatList(parentId);
        log.info("查询商品类目列表完成");
        return lists;
    }

}
