package com.xyang.shop.content.service.impl;

import com.xyang.shop.dao.TbContentCategoryMapper;
import com.xyang.shop.entity.TbContentCategory;
import com.xyang.shop.entity.TbContentCategoryExample;
import com.xyang.shop.pojo.EasyUITreeNode;
import com.xyang.shop.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/10 0010.
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService{

    @Autowired
    private TbContentCategoryMapper categoryMapper;

    @Override
    public List<EasyUITreeNode> getContentCatList(Long parentId) {
        System.out.println(22);
        // 根据parentId查询子节点列表
        TbContentCategoryExample example = new TbContentCategoryExample();
        // 设置查询条件
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        // 执行查询
        List<TbContentCategory> list = categoryMapper.selectByExample(example);
        // 返回结果为List
        List<EasyUITreeNode> resultList = new ArrayList<EasyUITreeNode>();
        for (TbContentCategory tbContentCategory : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            // 添加到列表
            resultList.add(node);
        }
        return resultList;
    }
}
