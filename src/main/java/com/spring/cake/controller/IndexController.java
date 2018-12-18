package com.spring.cake.controller;

import com.bilibili.yl.entity.ResultEntity;
import com.bilibili.yl.enums.ResultEnum;
import com.spring.cake.model.GoodsEntity;
import com.spring.cake.model.TypeEntity;
import com.spring.cake.service.GoodsService;
import com.spring.cake.service.GoodsTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class IndexController {
    @Resource(name = "goodsServiceImpl")
    private GoodsService goodsService;
    @Resource(name = "goodsTypeServiceImpl")
    private GoodsTypeService goodsTypeService;

   /* @RequestMapping("user/index")
    public String index() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<GoodsEntity> goodsList = goodsService.showAllGoods();
        List<TypeEntity> typeList = goodsTypeService.showAllType();
        System.out.println(goodsList);
        System.out.println(typeList);
        modelAndView.addObject("goodsList", goodsList);
        modelAndView.addObject("typeList", typeList);
        return modelAndView;
    }*/

    @RequestMapping("user/goods")
    public ResultEntity<List<GoodsEntity>> index() {
        ResultEntity<List<GoodsEntity>> resultEntity= new ResultEntity<>();

        List<GoodsEntity> goodsList = goodsService.showAllGoods();
        List<TypeEntity> typeList = goodsTypeService.showAllType();
        System.out.println(goodsList);
        System.out.println(typeList);

        try {
            resultEntity.setCodeAndMsg(ResultEnum.DATA_ALREADY_EXISTED);
            resultEntity.setData(goodsList);
        } catch (Exception e) {
            resultEntity.setCodeAndMsg(ResultEnum.DATA_IS_WRONG);
            e.printStackTrace();
        }
        return resultEntity;
    }


}
