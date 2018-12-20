package com.spring.cake.controller;

import com.spring.cake.model.GoodsEntity;
import com.spring.cake.model.TypeEntity;
import com.spring.cake.service.GoodsService;
import com.spring.cake.service.GoodsTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
        modelAndView.addObject("goodsList", goodsList);
        modelAndView.addObject("typeList", typeList);

        TypeEntity type = new TypeEntity();
        /*
         * 分类查询，蛋糕
         */
        type.setTypeId(1);
        List<GoodsEntity> listByCake = goodsService.showByType(type);
        System.out.println(listByCake.size()); //这就表示查出来了，我帮你看看样式
        modelAndView.addObject("cakeList", listByCake);
        /*
         * 分类查询，吐司
         */
        type.setTypeId(2);
        List<GoodsEntity> listByToast = goodsService.showByType(type);
        System.out.println(listByToast.size());
        modelAndView.addObject("toastList", listByToast);

        type.setTypeId(4);
        List<GoodsEntity> snacksList = goodsService.showByType(type);
        System.out.println(listByToast.size());
        modelAndView.addObject("snacksList", snacksList);
        return modelAndView;
    }


    @RequestMapping("user/register")
    public String register() {
        return "register";
    }

}
