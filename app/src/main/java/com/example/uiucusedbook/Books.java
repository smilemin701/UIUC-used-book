package com.example.uiucusedbook;

public class Books {

    String booksID;
    String booksTitle;
    String booksDescription;
    String booksAuthor;

    public Books(String booksID, String booksTitle, String booksAuthor, String booksDescription) {
        this.booksID = booksID;
        this.booksTitle = booksTitle;
        this.booksDescription = booksDescription;
        this.booksAuthor = booksAuthor;
    }

    public String getBooksID() {
        return booksID;
    }

    public String getBooksTitle() {
        return booksTitle;
    }

    public String getBooksDescription() {
        return booksDescription;
    }

    public String getBooksAuthor() {
        return booksAuthor;
    }
}
