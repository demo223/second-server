package com.zq.secondarymarket.service.impl;

import com.zq.secondarymarket.entity.Product;
import com.zq.secondarymarket.mapper.ProductMapper;
import com.zq.secondarymarket.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
  @Autowired
  ProductMapper productMapper;

  // 添加product
  @Override
  public int addProduct(Product product) {
    return productMapper.addProduct(product);
  }

  // 插入图片地址
  @Override
  public int addProductPicture(String productPicture) {
    return productMapper.addProductPicture(productPicture);
  }
}
