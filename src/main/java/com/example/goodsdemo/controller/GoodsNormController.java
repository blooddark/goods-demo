package com.example.goodsdemo.controller;

import com.example.goodsdemo.entity.ShopGoodsNorm;
import com.example.goodsdemo.repository.ShopGoodsNormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品规格
 * @author 崔诗新
 * @date 2019-3-21
 */
@RestController
@RequestMapping("/api/shop/goods/norm/")
public class GoodsNormController {
    private final ShopGoodsNormRepository shopGoodsNormRepository;

    @Autowired
    public GoodsNormController(ShopGoodsNormRepository shopGoodsNormRepository) {
        this.shopGoodsNormRepository = shopGoodsNormRepository;
    }

    /**
     * 根据商品id查询规格信息
     * @param id 商品id
     * @return
     */
    @GetMapping("{id}")
    public List<ShopGoodsNorm> getNorms(@PathVariable String id){
        ShopGoodsNorm shopGoodsNorm = ShopGoodsNorm.builder().goodsId(id).build();
        return shopGoodsNormRepository.findAll(Example.of(shopGoodsNorm));
    }
}
