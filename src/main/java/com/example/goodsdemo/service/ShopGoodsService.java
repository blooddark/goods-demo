package com.example.goodsdemo.service;

import com.example.goodsdemo.entity.ShopGoods;
import com.example.goodsdemo.entity.ShopGoodsNorm;
import com.example.goodsdemo.entity.ShopGoodsNormMultiply;
import com.example.goodsdemo.repository.ShopGoodsCategoryRepository;
import com.example.goodsdemo.repository.ShopGoodsNormMultiplyRepository;
import com.example.goodsdemo.repository.ShopGoodsNormRepository;
import com.example.goodsdemo.repository.ShopGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 崔诗新
 * @date 2019-3-20
 */
@Service
public class ShopGoodsService {
    private final ShopGoodsRepository shopGoodsRepository;
    private final ShopGoodsNormRepository shopGoodsNormRepository;
    private final ShopGoodsCategoryRepository shopGoodsCategoryRepository;
    private final ShopGoodsNormMultiplyRepository shopGoodsNormMultiplyRepository;

    @Autowired
    public ShopGoodsService(ShopGoodsRepository shopGoodsRepository, ShopGoodsNormRepository shopGoodsNormRepository, ShopGoodsCategoryRepository shopGoodsCategoryRepository, ShopGoodsNormMultiplyRepository shopGoodsNormMultiplyRepository) {
        this.shopGoodsRepository = shopGoodsRepository;
        this.shopGoodsNormRepository = shopGoodsNormRepository;
        this.shopGoodsCategoryRepository = shopGoodsCategoryRepository;
        this.shopGoodsNormMultiplyRepository = shopGoodsNormMultiplyRepository;
    }

    /**
     * 添加商品
     * @param shopGoods 要添加的商品
     */
    public void addGoods(ShopGoods shopGoods){
        shopGoods = shopGoodsRepository.save(shopGoods);
        List<ShopGoodsNorm> normList = shopGoods.getNorm();
        for (ShopGoodsNorm shopGoodsNorm : normList) {
            shopGoodsNorm.setGoodsId(shopGoods.getId());
        }
        shopGoodsNormRepository.saveAll(normList);
        List<ShopGoodsNormMultiply> normMultiplyList = shopGoods.getNormMultiplyList();
        for (ShopGoodsNormMultiply shopGoodsNormMultiply : normMultiplyList) {
            shopGoodsNormMultiply.setGoodsId(shopGoods.getId());
        }
        shopGoodsNormMultiplyRepository.saveAll(normMultiplyList);
    }

    /**
     * 通过Id获取商品
     * @param id 商品id
     * @return 获取的商品
     */
    public ShopGoods getGoodsById(String id){
        ShopGoods shopGoods = shopGoodsRepository.findById(id).get();
        fullGoods(shopGoods);
        return shopGoods;
    }

    /**
     * 获取商品列表
     * @return 商品列表
     */
    public List<ShopGoods> getGoods(){
        List<ShopGoods> shopGoodsList = shopGoodsRepository.findAll();
        for (ShopGoods shopGoods : shopGoodsList) {
            fullGoods(shopGoods);
        }
        return shopGoodsList;
    }

    /**
     * 填充商品的其他信息
     * @param shopGoods 要填充的商品
     */
    private void fullGoods(ShopGoods shopGoods){
        shopGoods.setCategory(shopGoodsCategoryRepository.getOne(shopGoods.getCategoryId()).getName());
        ShopGoodsNorm shopGoodsNorm = new ShopGoodsNorm();
        shopGoodsNorm.setGoodsId(shopGoods.getId());
        List<ShopGoodsNorm> normList = new ArrayList<>(shopGoodsNormRepository.findAll(Example.of(shopGoodsNorm)));
        shopGoods.setNorm(normList);
        ShopGoodsNormMultiply shopGoodsNormMultiply = new ShopGoodsNormMultiply();
        shopGoodsNormMultiply.setGoodsId(shopGoods.getId());
        List<ShopGoodsNormMultiply> multiplyList = new ArrayList<>(shopGoodsNormMultiplyRepository.findAll(Example.of(shopGoodsNormMultiply)));
        shopGoods.setNormMultiplyList(multiplyList);
    }
}
