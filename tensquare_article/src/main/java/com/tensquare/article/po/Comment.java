package com.tensquare.article.po;

import javax.persistence.Id;
import java.util.Date;

/**
 * 文章评论（mongoDB）
 * @author ye jiacheng
 * @create 2018-09-03
 */
public class Comment {
    @Id
    private String id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }
}
