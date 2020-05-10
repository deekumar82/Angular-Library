package com.booksystem.demobooksyetem.dao;

import javax.persistence.*;

@Entity
@Table(name = "book_details")
 public class BookDaoModel{

    public BookDaoModel(Integer id, String bookName, String authorName, String publisherName, Integer price) {
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name= "book_name")
    private String bookName;
    private String authorName;
    private String publisherName;
    private Integer price;


    public BookDaoModel(String bookName, String authorName, String publisherName, Integer price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.price = price;
    }

    public BookDaoModel() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDaoModel{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", price=" + price +
                '}';
    }
}