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
public class ShopStore {
    @Id
    @GeneratedValue
    private String id;
    private String baseUserId;
    private String type;
    private String state;
    private String title;
    private String img;
    private String url;
    private Integer sort;
    private Integer view;
    private String advertise;
    private String address;
    private java.sql.Timestamp time;
    private Integer isDelete;
}
