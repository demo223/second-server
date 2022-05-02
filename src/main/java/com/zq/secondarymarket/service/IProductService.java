package com.zq.secondarymarket.service;

import com.zq.secondarymarket.entity.Product;

public interface IProductService {
  // 添加product
  int addProduct(Product product);

  // 插入图片地址
  int addProductPicture(String productPicture);
}
