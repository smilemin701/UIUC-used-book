package com.example.uiucusedbook;

public class Transaction {

    String Title;
    String Author;
    String Button;

    public Transaction(String title, String author, String button) {
        Title = title;
        Author = author;
        Button = button;
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

