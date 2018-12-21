package com.xyang.shop.service;

import com.xyang.shop.entity.TbContent;
import com.xyang.shop.utils.BaseResult;

import java.util.List;

/**
 * Created by Administrator on 2018/12/11 0011.
 */
public interface ContentService {

    BaseResult insertContent(TbContent content);

    List<TbContent> getContentList(long cid);
}
