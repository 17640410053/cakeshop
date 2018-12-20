package com.spring.cake.service.impl;

import com.spring.cake.model.GoodsEntity;
import com.spring.cake.model.TypeEntity;
import com.spring.cake.repository.GoodsRepository;
import com.spring.cake.service.GoodsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsServiceImpl")
public class GoodsServiceImpl implements GoodsService {

    @Resource(name = "goodsRepository")
    private GoodsRepository goodsRepository;

    @Override
    public List<GoodsEntity> showAllGoods() {
        return goodsRepository.findAll();
    }

    @Override
    public List<GoodsEntity> showByType(TypeEntity typeEntity) {
        Pageable pageable = PageRequest.of(0, 5);
        return goodsRepository.findByTypeByTypeId(typeEntity, pageable).getContent(); //厉害呢，这样就可以只查5条了，试试
    }

    @Override
    public List<GoodsEntity> showOrderByPrice(String name) {
//        return goodsRepository.findByNameLikeAndOrderByPriceAsc(name);
        return null;
    }


}
