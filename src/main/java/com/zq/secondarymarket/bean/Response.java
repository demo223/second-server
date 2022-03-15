package com.zq.secondarymarket.bean;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * json 返回对象
 */
public class Response {

    //返回的HTTP结果状态码
    // 200-请求成功 500-代码错误 404-请求URL错误 405-请求方法错误
    private String resultCode;

    //返回的信息
    private String resultMessage = "";

    //返回的数据（单个对象）
    private Object bean;

    //返回的数据（集合对象的数据）
    private List<?> beans;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public List<?> getBeans() {
        return beans;
    }

    public void setBeans(List<?> beans) {
        this.beans = beans;
    }

    @Override
    public String toString() {
        return JSONObject.toJSON(this).toString();
    }

    public static String buildResponse(Object result){
        Response response = new Response();
        if(result instanceof List<?>){
            response.setBeans((List<?>) result);
        }else{
            response.setBean(result);
        }
        return response.toString();
    }
}
