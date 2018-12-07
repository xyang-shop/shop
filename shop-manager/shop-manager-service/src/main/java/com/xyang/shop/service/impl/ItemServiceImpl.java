package com.xyang.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyang.shop.dao.TbItemDescMapper;
import com.xyang.shop.dao.TbItemMapper;
import com.xyang.shop.entity.TbItem;
import com.xyang.shop.entity.TbItemDesc;
import com.xyang.shop.entity.TbItemExample;
import com.xyang.shop.pojo.EasyUIDataGridResult;
import com.xyang.shop.service.ItemService;
import com.xyang.shop.utils.BaseResult;
import com.xyang.shop.utils.IDUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/11/20 0020.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Override
    public String getItemById() {
        TbItemExample itemExample = new TbItemExample();
        itemExample.createCriteria().andIdEqualTo(536563L);
        TbItem ibItem = tbItemMapper.selectbyid(536563L);
        return ibItem.toString();
    }

    @Override
    public EasyUIDataGridResult getItemList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TbItemExample itemExample = new TbItemExample();
        List<TbItem> list = tbItemMapper.selectByExample(itemExample);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public BaseResult saveItem(TbItem item, String desc) {
        long id = IDUtils.genItemId();
        item.setId(id);
        // 商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        // 插入到商品表
        tbItemMapper.insert(item);
        // 商品描述
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(id);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        // 插入商品描述
        itemDescMapper.insert(itemDesc);
        return BaseResult.ok();
    }

}
