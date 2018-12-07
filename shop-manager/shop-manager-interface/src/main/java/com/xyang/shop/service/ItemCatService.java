package com.xyang.shop.service;

import com.xyang.shop.pojo.EasyUIDataGridResult;
import com.xyang.shop.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by Administrator on 2018/11/20 0020.
 */
public interface ItemCatService {

    List<EasyUITreeNode> getItemCatList(Long id);
}
