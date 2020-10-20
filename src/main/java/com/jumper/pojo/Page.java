package com.jumper.pojo;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Page {

    //当前页码
    private int currentPageNo = 1;
    //总页数
    private int totalCount;
    //页面容量
    private int pageSize=5;
    //上一页
    private int upPageNo;
    //下一页
    private int nextPageNo;

    private int index;

    public Page() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
        this.index = (currentPageNo - 1) * pageSize;
        if (currentPageNo != 1)
            this.upPageNo = currentPageNo - 1;
        else
            this.upPageNo = currentPageNo;
        if (currentPageNo != totalCount)
            this.nextPageNo = currentPageNo + 1;
        else
            this.nextPageNo = currentPageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int count) {
        if (count % pageSize > 0)
            totalCount = count / pageSize + 1;
        else
            totalCount = count / pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getUpPageNo() {
        return upPageNo;
    }

    public void setUpPageNo(int upPageNo) {
        this.upPageNo = upPageNo;
    }

    public int getNextPageNo() {
        return nextPageNo;
    }

    public void setNextPageNo(int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }
}
