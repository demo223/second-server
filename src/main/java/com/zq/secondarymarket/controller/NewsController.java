package com.zq.secondarymarket.controller;


import com.zq.secondarymarket.bean.Response;
import com.zq.secondarymarket.entity.News;
import com.zq.secondarymarket.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private INewsService iNewsService;

    @RequestMapping("/addNews")
    public Response addNews(@RequestParam("htmlStr") String htmlStr, @RequestParam("updateUserId") String updateUserId) {
        Response response = new Response();
        News news = new News();
        news.setHtmlStr(htmlStr);
        news.setUpdateUserId(updateUserId);
        // 将htmlStr写入文件夹中
        FileWriter fw = null;
		try {
			//创建字符输出流对象，负责向文件内写入
			fw = new FileWriter("D:\\桌面\\store-server-master\\public\\docs\\news.html");
			//将str里面的内容读取到fw所指定的文件中
			fw.write(htmlStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
        int result = iNewsService.addNews(news);
        if (result == 1) {
            response.setResultMessage("网站公告发布成功!");
            response.setResultCode("200");
        } else {
            response.setResultMessage("网站公告发布失败!");
            response.setResultCode("404");
        }
        return response;
    }
}
