package com.zq.secondarymarket.controller;

import com.zq.secondarymarket.bean.Response;
import com.zq.secondarymarket.entity.Product;
import com.zq.secondarymarket.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/product")
public class
productController {
    @Autowired
    private IProductService iProductService;

    // 添加商品
    @RequestMapping("/addProduct")
    public Response addProduct(@RequestParam("productName") String productName,
                               @RequestParam("categoryId") Integer categoryId,
                               @RequestParam("productTitle") String productTitle,
                               @RequestParam("productIntro") String productIntro,
                               @RequestParam("file") MultipartFile file,
//                               @RequestParam("productPicture") String productPicture,
                               @RequestParam("productPrice") double productPrice,
                               @RequestParam("productSellingPrice") double productSellingPrice,
                               @RequestParam("productNum") Integer productNum,
//                               @RequestParam("productSales") Integer productSales,
                               @RequestParam("concatUserId") String concatUserId) {
        Response response = new Response();
        Product product = new Product();
        product.setProductName(productName);
        product.setCategoryId(categoryId);
        product.setProductTitle(productTitle);
        product.setProductIntro(productIntro);
        product.setProductPrice(productPrice);
        product.setProductSellingPrice(productSellingPrice);
        product.setProductNum(productNum);
//        product.setProductSales(productSales);
        product.setConcatUserId(concatUserId);

        // 图片文件
        // 获取图片文件名称
        String fileName = file.getOriginalFilename();
        //为防止文件重名被覆盖，为每个文件都生成不同的名字
        String newFileName = concatUserId + fileName;
        // 图片分类
        String filePath = "";
        if (categoryId == 1) {
            filePath = "shoes/";
        } else if (categoryId == 2) {
            filePath = "clothes/";
        } else if (categoryId == 3) {
            filePath = "food/";
        } else if (categoryId == 4) {
            filePath = "book/";
        } else if (categoryId == 5) {
            filePath = "family/";
        } else if (categoryId == 6) {
            filePath = "phone/";
        } else if (categoryId == 7) {
            filePath = "digitalProduct/";
        } else if (categoryId == 8) {
            filePath = "life/";
        }
        String path = "D:/桌面/store-server-master/public/imgs/" + filePath;
        File dir = new File(path, newFileName);// 创建文件对象
        if (!dir.exists()) {// 判断文件是否存在
            dir.mkdirs();// 如果文件不存在，则创建文件夹
        } else {
            dir.delete();// 如果文件存在，则删除文件
        }
        try {
            file.transferTo(dir);// 文件写入
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setProductPicture("public/imgs/"+filePath + newFileName);

        int result = iProductService.addProduct(product);
        if (result == 1) {
            response.setResultMessage("添加商品成功!");
            response.setResultCode("200");
        } else {
            response.setResultMessage("请不要重复添加!");
            response.setResultCode("404");
        }
        return response;
    }

    // 添加商品图片
    @RequestMapping("/addProductPicture")
    public Response addProductPicture(@RequestParam("file") MultipartFile file,
                                      @RequestParam("concatUserId") String concatUserId) {
        Response response = new Response();
        // 图片文件
        // 获取图片文件名称
        String fileName = file.getOriginalFilename();
        System.out.println("文件名称" + fileName);
        System.out.println("联系人名称" + concatUserId);
        //为防止文件重名被覆盖，为每个文件都生成不同的名字
        String newFileName = concatUserId + fileName;
        // 图片分类
        String filePath = "";
        filePath = "publish/";
        String path = "D:/桌面/store-server-master/public/imgs/" + filePath;
        File dir = new File(path, newFileName);// 创建文件对象
        if (!dir.exists()) {// 判断文件是否存在
            dir.mkdirs();// 如果文件不存在，则创建文件夹
        } else {
            dir.delete();// 如果文件存在，则删除文件
            System.out.println("文件已存在");
        }
        try {
            file.transferTo(dir);// 文件写入
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setResultMessage("添加商品图片成功!");
        response.setResultCode("200");
        return response;
    }

    // 删除商品图片
    @RequestMapping("/deleteProductPicture")
    public Response deleteProductPicture(@RequestParam("file") MultipartFile file,
                                         @RequestParam("concatUserId") String concatUserId) {
        Response response = new Response();
        // 图片文件
        // 获取图片文件名称
        String fileName = file.getOriginalFilename();
        System.out.println("文件名称" + fileName);
        System.out.println("联系人名称" + concatUserId);
        //为防止文件重名被覆盖，为每个文件都生成不同的名字
        String newFileName = concatUserId + fileName;
        // 图片分类
        String filePath = "";
        filePath = "publish/";
        String path = "D:/桌面/store-server-master/public/imgs/" + filePath;
        File dir = new File(path, newFileName);// 创建文件对象
        dir.delete();// 删除path下面的newFileName文件
        response.setResultMessage("删除商品图片成功!");
        response.setResultCode("200");
        return response;
    }
}
