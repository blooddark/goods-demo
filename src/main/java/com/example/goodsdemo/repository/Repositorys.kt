package com.example.goodsdemo.repository

import com.example.goodsdemo.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface ShopGoodsRepository : JpaRepository<ShopGoods, String>
interface BaseUserRepository : JpaRepository<BaseUser, String>
interface ShopGoodsNormRepository : JpaRepository<ShopGoodsNorm, String>
interface ShopGoodsCategoryRepository : JpaRepository<ShopGoodsCategory, String>
interface ShopStoreRepository : JpaRepository<ShopStore, String>
interface ShopGoodsNormMultiplyRepository : JpaRepository<ShopGoodsNormMultiply, String>