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

    /**
     * 根据商品ID查询商品基本信息
     */
    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable long itemId) {
        log.info("根据商品ID查询商品基本信息，itemId={}", String.valueOf(itemId));
        TbItem item = itemResource.getItemById(itemId);
        log.info("根据商品ID查询商品基本信息，res={}", JacksonUtils.objectToJson(item));
        return item;
    }

    /**
     * 查询商品列表（分页）
     */
    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        log.info("查询商品列表，page={} and rows={}", String.valueOf(page), String.valueOf(rows));
        EasyUIDataGridResult result = itemResource.getItemList(page, rows);
        log.info("查询商品列表，res={}", JacksonUtils.objectToJson(result));
        return result;
    }

    /**
     * 添加商品
     * @param item  商品基本信息
     * @param desc  商品描述
     */
    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult addItem(TbItem item, String desc) {
        log.info("添加商品，item={}", JacksonUtils.objectToJson(item));
        TaotaoResult result = itemResource.addItem(item, desc);
        log.info("添加商品，res={}", JacksonUtils.objectToJson(result));
        return result;
    }

}

