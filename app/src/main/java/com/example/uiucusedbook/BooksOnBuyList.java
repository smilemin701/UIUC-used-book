package com.example.uiucusedbook;

public class BooksOnBuyList {
    private String title;
    private String author;
    private String description;
    private String sellerEmail;

    public BooksOnBuyList(String title, String author, String description, String sellerEmail) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.sellerEmail = sellerEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

}
