package com.example.goodsdemo.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * @author 崔诗新Eddy
 * @date 2019-3-20
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopGoodsNormMultiply {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String goodsId;
    private String attrJson;
    private Double price;
    private Integer stock;
}
