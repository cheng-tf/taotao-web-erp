package com.taotao.springboot.web.erp.controller;

import com.taotao.springboot.item.domain.result.EasyUITreeNode;
import com.taotao.springboot.item.export.ItemCatResource;
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

    @Autowired
    private ItemCatResource itemCatResource;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(name = "id", defaultValue = "0") long parentId) {
        return itemCatResource.getItemCatList(parentId);
    }

}
