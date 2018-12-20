package com.spring.cake.controller;

import com.spring.cake.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource(name = "goodsServiceImpl")
    private GoodsService goodsService;




}
