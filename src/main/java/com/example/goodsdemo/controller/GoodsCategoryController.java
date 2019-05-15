package com.example.goodsdemo.controller;

import com.example.goodsdemo.entity.ShopGoodsCategory;
import com.example.goodsdemo.service.ShopGoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类
 * @author 崔诗新
 * @date 2019-3-21
 */
@RestController
@RequestMapping("/api/shop/goods/category")
public class GoodsCategoryController {
    private final ShopGoodsCategoryService shopGoodsCategoryService;

    @Autowired
    public GoodsCategoryController(ShopGoodsCategoryService shopGoodsCategoryService) {
        this.shopGoodsCategoryService = shopGoodsCategoryService;
    }

    /**
     * 获取类别和规格信息
     * @return
     */
    @GetMapping
    List<ShopGoodsCategory> getCategories() {
        return shopGoodsCategoryService.getCategories();
    }
}
