package com.zy.android_serialization.serializable;

import java.io.Serializable;

public class SBook implements Serializable {
    private static final long serialVersionUID = 5025125370297868534L;
    private String bookName;
    private String author;
    private int publishDate;

    public SBook(String bookName, String author, int publishDate) {
        this.bookName = bookName;
        this.author = author;
        this.publishDate = publishDate;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "SBook{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
