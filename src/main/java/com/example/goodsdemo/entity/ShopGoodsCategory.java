package com.example.goodsdemo.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
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
public class ShopGoodsCategory {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String norm;
}
