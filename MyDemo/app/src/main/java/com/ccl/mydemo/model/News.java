package com.ccl.mydemo.model;

import java.util.Date;

/**
 * Created by CCL on 2016/12/10.
 */

public class News {
    private Integer contentNumber;

    private String contentType;

    private String newsTitle;

    private String content;

    private String author;

    private Date publishTime;

    private Date updateTime;

    public Integer getContentNumber() {
        return contentNumber;
    }

    public void setContentNumber(Integer contentNumber) {
        this.contentNumber = contentNumber;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
