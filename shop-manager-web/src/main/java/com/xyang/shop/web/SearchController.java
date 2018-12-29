package com.xyang.shop.web;

import com.xyang.shop.search.service.SearchItemService;
import com.xyang.shop.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/12/27 0027.
 */
@Controller
public class SearchController {
    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping("/index/import")
    @ResponseBody
    public BaseResult indexImport() throws Exception {
        System.out.println("111111111");
        BaseResult result = searchItemService.importAllItemToIndex();
        return result;
    }

}
