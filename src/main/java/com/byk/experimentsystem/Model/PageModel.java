package com.byk.experimentsystem.Model;

import java.util.List;

public class PageModel {
    Integer pageNum;
    Integer pageSize;
    Integer total;
    List list;

    public List getList() {

        return list;
    }

    public void setList(List list) {

        this.list = list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


}
