package com.zy.android_serialization.serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class PBook implements Parcelable {
    private String bookName;
    private String author;
    private int publishDate;

    public PBook(String bookName, String author, int publishDate) {
        this.bookName = bookName;
        this.author = author;
        this.publishDate = publishDate;
    }

    protected PBook(Parcel in) {
        // 如果元素数据是list类型的时候需要： lits = new ArrayList<?> in.readList(list);
        // 否则会出现空指针异常.并且读出和写入的数据类型必须相同.
        // 如果不想对部分关键字进行序列化,可以使用transient关键字来修饰以及static修饰.
        bookName = in.readString();
        author = in.readString();
        publishDate = in.readInt();
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
        return "PBook{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }

    public static final Creator<PBook> CREATOR = new Creator<PBook>() {
        @Override
        public PBook createFromParcel(Parcel in) {
            return new PBook(in);
        }

        @Override
        public PBook[] newArray(int size) {
            return new PBook[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookName);
        dest.writeString(author);
        dest.writeInt(publishDate);
    }
}
