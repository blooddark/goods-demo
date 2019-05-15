package com.example.goodsdemo.service;

import com.example.goodsdemo.entity.ShopGoodsCategory;
import com.example.goodsdemo.repository.ShopGoodsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类
 * @author 崔诗新
 * @date 2019-3-21
 */
@Service
public class ShopGoodsCategoryService {
    private final ShopGoodsCategoryRepository shopGoodsCategoryRepository;

    @Autowired
    public ShopGoodsCategoryService(ShopGoodsCategoryRepository shopGoodsCategoryRepository) {
        this.shopGoodsCategoryRepository = shopGoodsCategoryRepository;
    }

    public List<ShopGoodsCategory> getCategories() {
        return shopGoodsCategoryRepository.findAll();
    }
}
