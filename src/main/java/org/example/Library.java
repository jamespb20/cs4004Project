package org.example;

import java.util.ArrayList;

public class Library {

    private String book;
    private String name;
    private ArrayList<Student> booksBorrowing;
    private ArrayList<String> books;


    public Library() {
        books = new ArrayList<String>();
    }

    public void bookBorrowing(Student student, String book){
        this.book = book;
        student = new Student(this.name,book);

    }

    public ArrayList<Student> getBooksBorrowing() {
        return booksBorrowing;
    }

    public String getBook() {
        return book;
    }

    public void getNewBook(String book){
        books.add(book);
    }

}
