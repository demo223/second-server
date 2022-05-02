package com.zq.secondarymarket.mapper;

import com.zq.secondarymarket.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductMapper {
  // 添加product
  int addProduct(Product product);
   
  // 插入图片地址
  int addProductPicture(String productImage);
}
