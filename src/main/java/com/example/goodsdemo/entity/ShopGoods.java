package com.example.goodsdemo.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author 崔诗新Eddy
 * @date 2019-3-20
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopGoods {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UserIdentityGenerator")
//    @GenericGenerator(name = "UserIdentityGenerator", strategy = "com.example.goodsdemo.entity.UserIdentityGenerator")
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String shopStoreId;
    private String categoryId;
    private String state;
    private String title;
    private String img;
    private String url;
    private Integer sort;
    private String content;
    private String price;
    private Integer stock;
    private Integer sale;
    private Integer view;
    @Builder.Default
    private java.sql.Timestamp time = new Timestamp(System.currentTimeMillis());
    private Integer isDelete;
    @Transient
    private List<ShopGoodsNorm> norm;
    @Transient
    private List<ShopGoodsNormMultiply> normMultiplyList;
    @Transient
    private String category;
}
