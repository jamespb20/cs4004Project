package org.example;


public class Student {//Student has name and can borrow books
    private String name;
    private String book;
    private String prevBook;

    public Student(String name, String book) {
        this.name = name;
        this.book = book;

    }

    public Student(String name) {
        this.name = name;
    }

    public String getBook() {
        return book;
    }

    public String getName() {
        return name;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
