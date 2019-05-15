package com.example.goodsdemo.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

/**
 * @author 崔诗新Eddy
 * @date 2019-3-20
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopGoodsNorm {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String goodsId;
    private String name;
    private String attr;
}
