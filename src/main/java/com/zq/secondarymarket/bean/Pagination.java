package com.zq.secondarymarket.bean;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class Pagination<T> {

    /**
     * 默认当前页
     */
    public static final Integer CURRENT = 1;

    /**
     * 默认每页条数
     */
    public static final Integer PAGE_SIZE = 10;

    /**
     * 当前页
     */
    private Integer current = CURRENT;

    /**
     * 分页条数
     */
    private Integer pageSize = PAGE_SIZE;

    /**
     * 结果总数
     */
    private Long total = 0l;

    /**
     * 分页数据
     */
    private List<T> list;


    public Pagination() {
    }

    public Pagination(List<T> list) {
        this.list = list;
    }

    /**
     * 构造函数
     * 过时：请使用Pagination(Integer current, Integer pageSize, Long total, List<T> list)
     * @param total 总数
     * @param list 分页数据
     */
    @Deprecated
    public Pagination(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    /**
     * 返回分页对象
     * @param current 当前页
     * @param pageSize 分页条数
     * @param total 总数
     * @param list 列表
     */
    public Pagination(Integer current, Integer pageSize, Long total, List<T> list) {
        this.current = current;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }


    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return JSONObject.toJSON(this).toString();
    }
}
