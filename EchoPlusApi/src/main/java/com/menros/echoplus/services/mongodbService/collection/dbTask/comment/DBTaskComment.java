package com.menros.echoplus.services.mongodbService.collection.dbTask.comment;

import java.util.Date;

public class DBTaskComment {
    private DBTaskCommentUser user;
    private Date date;
    private String comment;

    public DBTaskComment() {
    }

    public DBTaskComment(DBTaskCommentUser user, String comment) {
        this(user, new Date(), comment);
    }

    public DBTaskComment(DBTaskCommentUser user, Date date, String comment) {
        this.user = user;
        this.date = date;
        this.comment = comment;
    }

    public DBTaskCommentUser getUser() {
        return user;
    }

    public void setUser(DBTaskCommentUser user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
