package org.example;


public class Student {//Student has name and can borrow books
    private String name;
    private Book book;

    private Journal journal;

    public Student(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
