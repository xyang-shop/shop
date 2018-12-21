package com.xyang.shop.web;

import com.xyang.shop.entity.TbContent;
import com.xyang.shop.service.ContentService;
import com.xyang.shop.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/12/11 0011.
 */
@Controller
@RequestMapping("/content")
public class ContentContoller {

    @Autowired
    private ContentService contentService;

    @ResponseBody
    @RequestMapping("/save")
    public BaseResult insertContent(TbContent content){
        BaseResult baseResult = contentService.insertContent(content);
        return baseResult;
    }

    @ResponseBody
    @RequestMapping("/query/list")
    public List<TbContent> getContentList(long categoryId){
        List<TbContent> list = contentService.getContentList(categoryId);
        return list;
    }
}
