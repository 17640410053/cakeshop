package com.spring.cake.service.impl;

import com.spring.cake.model.TypeEntity;
import com.spring.cake.repository.GoodsTypeRepository;
import com.spring.cake.service.GoodsTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsTypeServiceImpl")
public class GoodsTypeServiceImpl implements GoodsTypeService {


    @Resource(name = "goodsTypeRepository")
    private GoodsTypeRepository goodsTypeRepository;

    @Override
    public List<TypeEntity> showAllType() {
        return  goodsTypeRepository.findAll();
    }
}
