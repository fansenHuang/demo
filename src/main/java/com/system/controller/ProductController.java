package com.system.controller;

import com.core.util.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 商品管理控制器
 *里面包含商品的上架，下架，增加，删除
 */
@Controller
@RequestMapping("/good")
public class ProductController {


    @RequestMapping("/test")
    public ResponseResult<Void> Test(){
        return new ResponseResult<>();
    }





}
