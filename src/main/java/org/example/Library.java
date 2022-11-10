package org.example;

import java.util.ArrayList;

public class Library {

    private String book;
    private Student student;
    private String name;
    private ArrayList<Student> booksBorrowing;
    private ArrayList<String> books;


    public Library() {
        books = new ArrayList<>();
        booksBorrowing = new ArrayList<>();
    }

    public void bookBorrowing(Student student, String book){
        this.book = book;
        this.student = student;
        int i= 0;
        do {
            if (!booksBorrowing.isEmpty() && booksBorrowing.get(i).equals(student)) {
                System.out.printf("This book is already in use by %S", student.getName());
            } else {
                student = new Student(this.name, book);
                booksBorrowing.add(student);
            }
            i++;
        }while (i<booksBorrowing.size());
    }



    public ArrayList<Student> getBooksBorrowing() {
        return booksBorrowing;
    }

    public ArrayList<String> getBooks() {
        return books;
    }


    public String getBook() {
        return book;
    }

    public void getNewBook(String book){
        books.add(book);
    }
}
