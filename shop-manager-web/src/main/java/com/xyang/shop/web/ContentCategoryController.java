package com.xyang.shop.web;

import com.xyang.shop.pojo.EasyUITreeNode;
import com.xyang.shop.service.ContentCategoryService;
import com.xyang.shop.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/12/10 0010.
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCatList(@RequestParam(defaultValue="0") Long id) {
        return contentCategoryService.getContentCatList(id);
    }


    @ResponseBody
    @RequestMapping("/create")
    public BaseResult insertContentCat(Long parentId,String name){
        System.out.println(1);
        BaseResult baseResult = contentCategoryService.insertContentCat(parentId, name);
        return baseResult;
    }
}
