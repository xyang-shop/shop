package com.xyang.shop.web;

import com.xyang.shop.entity.TbItem;
import com.xyang.shop.pojo.EasyUITreeNode;
import com.xyang.shop.service.ItemCatService;
import com.xyang.shop.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/12/4 0004.
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    /**
     * RequestParam 传递参数和接受不一致
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/item/cat/list")
    public List<EasyUITreeNode> getItemCatList(@RequestParam(name="id",defaultValue = "0") long id){
        List<EasyUITreeNode> itemCatList = itemCatService.getItemCatList(id);
        return itemCatList;
    }

}
