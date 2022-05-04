package com.zq.secondarymarket.service.impl;

import com.zq.secondarymarket.entity.News;
import com.zq.secondarymarket.mapper.NewsMapper;
import com.zq.secondarymarket.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    NewsMapper newsMapper;

//   添加html文件
    @Override
    public int addNews(News news) {
        return newsMapper.addNews(news);
    }
}
