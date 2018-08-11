package com.taotao.springboot.web.erp.controller;

import com.taotao.springboot.web.erp.common.utils.JacksonUtils;
import com.taotao.springboot.item.domain.pojo.TbItem;
import com.taotao.springboot.item.domain.result.EasyUIDataGridResult;
import com.taotao.springboot.item.domain.result.TaotaoResult;
import com.taotao.springboot.item.export.ItemResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Title: ItemController</p>
 * <p>Description: 商品管理Controller</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-06 11:47</p>
 * @author ChengTengfei
 * @version 1.0
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemResource itemResource;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable long itemId) {
        return itemResource.getItemById(itemId);
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        log.info("Call itemService.getItemList start page={} and rows={}", page, rows);
        log.debug("Call itemService.getItemList start page={} and rows={}", page, rows);
        EasyUIDataGridResult result = itemResource.getItemList(page, rows);
        log.info("Call itemService.getItemList end res={}", JacksonUtils.objectToJson(result));
        log.debug("Call itemService.getItemList end res={}",JacksonUtils.objectToJson(result));
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult addItem(TbItem item, String desc) {
        return itemResource.addItem(item, desc);
    }

}

