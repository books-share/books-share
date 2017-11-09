package com.team4.share_books.entities;

/**
 * Created by john on 17/11/8.
 */

public class BorrowEntity {
    private String bookname;
    private String bookauthor;
    private String date;

    public BorrowEntity(String bookname, String bookauthor, String date) {
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.date = date;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
