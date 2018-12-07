package com.xyang.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyang.shop.dao.TbItemCatMapper;
import com.xyang.shop.dao.TbItemMapper;
import com.xyang.shop.entity.TbItem;
import com.xyang.shop.entity.TbItemCat;
import com.xyang.shop.entity.TbItemCatExample;
import com.xyang.shop.entity.TbItemExample;
import com.xyang.shop.pojo.EasyUIDataGridResult;
import com.xyang.shop.pojo.EasyUITreeNode;
import com.xyang.shop.service.ItemCatService;
import com.xyang.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/11/20 0020.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemcatMapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(Long id) {

        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria c = example.createCriteria();
        c.andParentIdEqualTo(id);
        List<TbItemCat> list = tbItemcatMapper.selectByExample(example);

        List<EasyUITreeNode> resultList = new ArrayList<EasyUITreeNode>();
        for(TbItemCat itemcat : list){
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(itemcat.getId());
            node.setText(itemcat.getName());
            node.setState(itemcat.getIsParent()?"closed":"open");

            resultList.add(node);
        }
        return resultList;
    }
}
