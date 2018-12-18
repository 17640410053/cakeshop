package com.spring.cake.service.impl;

import com.spring.cake.model.GoodsEntity;
import com.spring.cake.repository.GoodsRepository;
import com.spring.cake.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsServiceImpl")
public class GoodsServiceImpl implements GoodsService {

    @Resource(name="goodsRepository")
    private GoodsRepository goodsRepository;

    @Override
    public List<GoodsEntity> showAllGoods() {
        return  goodsRepository.findAll();
    }
}
