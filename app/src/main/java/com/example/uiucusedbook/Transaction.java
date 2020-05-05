package com.example.uiucusedbook;

public class Transaction {

    String Title;
    String Author;
    String Button;
    String bookId;

    public Transaction(String title, String author, String button, String bookId) {
        Title = title;
        Author = author;
        Button = button;
        this.bookId = bookId;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }
    public String getButton() {
        return Button;
    }
}

