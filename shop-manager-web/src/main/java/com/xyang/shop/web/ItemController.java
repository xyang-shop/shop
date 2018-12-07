package com.xyang.shop.web;

import com.xyang.shop.entity.TbItem;
import com.xyang.shop.pojo.EasyUIDataGridResult;
import com.xyang.shop.service.ItemService;
import com.xyang.shop.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2018/11/26 0026.
 */
@Controller
public class ItemController {

    @Autowired
    public ItemService itemService;

    @RequestMapping("/item")
    public ModelAndView selectItem(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    /**
     * @PathVariable绑定URI模板变量值
     * @PathVariable是用来获得请求url中的动态参数的
     * @param page 参数
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }


    @ResponseBody
    @RequestMapping("/item/list")
    public EasyUIDataGridResult getItemList(Integer page,Integer rows){
        EasyUIDataGridResult result = itemService.getItemList(page,rows);
        return itemService.getItemList(page,rows);
    }

    @RequestMapping("/item/save")
    @ResponseBody
    public BaseResult saveItem(TbItem item, String desc){
        BaseResult result = itemService.saveItem(item, desc);
        return result;
    }
}
