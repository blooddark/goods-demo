package com.example.goodsdemo.controller;

import com.example.goodsdemo.entity.ShopGoods;
import com.example.goodsdemo.service.ShopGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品
 * @author 崔诗新
 * @date 2019-3-20
 */
@RestController
@RequestMapping("/api/shop/goods/")
public class GoodsController {
    private final ShopGoodsService shopGoodsService;

    @Autowired
    public GoodsController(ShopGoodsService shopGoodsService) {
        this.shopGoodsService = shopGoodsService;
    }

    @PostMapping("add")
    public void addGoods(@RequestBody ShopGoods shopGoods){
        shopGoodsService.addGoods(shopGoods);
    }

    @GetMapping("get/{id}")
    public ShopGoods getGoods(@PathVariable String id){
        return shopGoodsService.getGoodsById(id);
    }
}
