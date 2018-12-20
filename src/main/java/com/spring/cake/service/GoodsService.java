package com.spring.cake.service;

import com.spring.cake.model.GoodsEntity;
import com.spring.cake.model.TypeEntity;

import java.util.List;

public interface GoodsService {
    List<GoodsEntity> showAllGoods();

    List<GoodsEntity> showByType(TypeEntity typeEntity);

    List<GoodsEntity> showOrderByPrice(String name);

}
