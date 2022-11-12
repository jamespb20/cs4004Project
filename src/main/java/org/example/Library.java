package org.example;

import java.util.ArrayList;

public class Library {

    private String book;
    private Student student;

    private ArrayList<Student> booksBorrowing;
    private ArrayList<String> books;


    public Library() {
        books = new ArrayList<>();
        booksBorrowing = new ArrayList<>();
    }

    public boolean checkBook(String book, Library library){
        return !library.getBooks().isEmpty() && library.getBooks().contains(book);
    }

    public boolean bookBorrowing(Student student, String book) {
        this.book = book;
        this.student = student;
        int i = 0;
        do {
            if (!booksBorrowing.isEmpty() && booksBorrowing.get(i).equals(student)) {
                System.out.println("This book is already in use");
                return false;
            } else {
                if (student.getBook() == null || student.getBook() != book) {
                    student.setBook(book);
                    booksBorrowing.add(student);
                } else {
                    System.out.println("You have previously borrowed this book");
                    return false;
                }
            }
            i++;
        } while (i < booksBorrowing.size());
        return true;
    }


    public void bookReturn(Student student) {
        if (booksBorrowing.contains(student)){
            booksBorrowing.remove(student);
            System.out.println("Book has been returned");
        }
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

    public void getNewBook(String book) {
        books.add(book);
    }
}