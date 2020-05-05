package com.example.uiucusedbook;

public class Transaction {

    String Title;
    String Author;

    public Transaction(String title, String author) {
        Title = title;
        Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }
}

