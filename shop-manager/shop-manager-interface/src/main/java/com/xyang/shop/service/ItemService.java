package com.xyang.shop.service;

import com.xyang.shop.entity.TbItem;
import com.xyang.shop.pojo.EasyUIDataGridResult;
import com.xyang.shop.utils.BaseResult;

/**
 * Created by Administrator on 2018/11/20 0020.
 */
public interface ItemService {

    String getItemById();

    public EasyUIDataGridResult getItemList(int pageNum,int pageSize);

    /**
     *
     * @param item
     * @param desc  商品描述
     * @return
     */
    BaseResult saveItem(TbItem item,String desc);
}
