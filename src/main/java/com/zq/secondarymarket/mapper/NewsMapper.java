package com.zq.secondarymarket.mapper;

import com.zq.secondarymarket.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NewsMapper {
    int addNews(News news);
}
