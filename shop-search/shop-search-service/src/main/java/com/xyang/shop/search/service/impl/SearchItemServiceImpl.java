package com.xyang.shop.search.service.impl;

import com.xyang.shop.pojo.SearchItem;
import com.xyang.shop.search.mapper.ItemMapper;
import com.xyang.shop.search.service.SearchItemService;
import com.xyang.shop.utils.BaseResult;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/12/25 0025.
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {

    @Autowired
    private SolrServer solrServer;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public BaseResult importAllItemToIndex() throws Exception {
        // 1、查询所有商品数据。
        List<SearchItem> itemList = itemMapper.getItemList();
        // 2、创建一个SolrServer对象。
        for (SearchItem searchItem : itemList) {
            // 3、为每个商品创建一个SolrInputDocument对象。
            SolrInputDocument document = new SolrInputDocument();
            // 4、为文档添加域
            document.addField("id", searchItem.getId());
            document.addField("item_title", searchItem.getTitle());
            document.addField("item_sell_point", searchItem.getSellPoint());
            document.addField("item_price", searchItem.getPrice());
            document.addField("item_image", searchItem.getImage());
            document.addField("item_category_name", searchItem.getCategoryName());
            document.addField("item_desc", searchItem.getItemDesc());
            // 5、向索引库中添加文档。
            solrServer.add(document);
        }
        // 提交
        solrServer.commit();
        // 6、返回BaseResult，当你纠结返回值是什么的时候，你就可以使用BaseResult。
        return BaseResult.ok();

    }
}
