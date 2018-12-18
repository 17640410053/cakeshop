package com.spring.cake.controller;

import com.spring.cake.model.GoodsEntity;
import com.spring.cake.model.TypeEntity;
import com.spring.cake.service.GoodsService;
import com.spring.cake.service.GoodsTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HrefController {

    @Resource(name = "goodsServiceImpl")
    private GoodsService goodsService;
    @Resource(name = "goodsTypeServiceImpl")
    private GoodsTypeService goodsTypeService;


    @RequestMapping("user/login")
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<GoodsEntity> goodsList = goodsService.showAllGoods();
        List<TypeEntity> typeList = goodsTypeService.showAllType();
        //放到modelandview里
        modelAndView.addObject("goodsList",goodsList);
        modelAndView.addObject("typeList",typeList);
        return modelAndView;
    }

    /*  @RequestMapping("index")
    public String index(HttpServletRequest request) {
        List<GoodsEntity> goodsList = goodsService.showAllGoods();
        List<TypeEntity> typeList = goodsTypeService.showAllType();
        request.setAttribute("goodsList", goodsList);
        request.setAttribute("typeList", typeList);
        return "index";
    }*/

    @RequestMapping("user/register")
    public String register() {
        return "register";
    }

}
