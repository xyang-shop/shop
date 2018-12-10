package com.xyang.shop.service;

import com.xyang.shop.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by Administrator on 2018/12/10 0010.
 */
public interface ContentCategoryService {

    List<EasyUITreeNode> getContentCatList(Long parentId);
}
