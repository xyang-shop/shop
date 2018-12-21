package com.xyang.shop.content.service.impl;

import com.xyang.shop.content.jedis.JedisClient;
import com.xyang.shop.dao.TbContentMapper;
import com.xyang.shop.entity.TbContent;
import com.xyang.shop.entity.TbContentExample;
import com.xyang.shop.service.ContentService;
import com.xyang.shop.utils.BaseResult;
import com.xyang.shop.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/12/11 0011.
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Value("${CONTENT_KEY}")
    private String CONTENT_KEY;

    @Autowired
    private TbContentMapper contentMapper;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public BaseResult insertContent(TbContent content) {
        // 补全pojo的属性
        content.setCreated(new Date());
        content.setUpdated(new Date());
        // 向内容表中插入数据
        contentMapper.insert(content);
        return BaseResult.ok();
    }

    @Override
    public List<TbContent> getContentList(long cid) {
        // 查询数据库之前，先查询缓存，并且添加缓存不能影响正常业务逻辑

        String json = jedisClient.hget(CONTENT_KEY, cid + "");
        // 判断是否命中缓存，判断json字符串是否为null或""
        if (StringUtils.isNotBlank(json)) {
            // 把这个json转换成List集合
            List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
            return list;
        }else{
            TbContentExample example = new TbContentExample();
            TbContentExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryIdEqualTo(cid);
            List<TbContent> list = contentMapper.selectByExample(example);
            jedisClient.hset(CONTENT_KEY, cid + "", JsonUtils.objectToJson(list));
            return list;
        }
    }
}
