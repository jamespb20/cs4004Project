package org.example;

import java.util.ArrayList;

public class Library {

    private String book;
    private Student student;

    private ArrayList<Student> booksBorrowing;
    private ArrayList<String> damagedBooks;
    private ArrayList<Student> previousOwners;
    private ArrayList<String> books;
    private ArrayList<String> genres;
    private ArrayList<String> matchedGenres;


    public Library() {
        books = new ArrayList<>();
        booksBorrowing = new ArrayList<>();
        previousOwners = new ArrayList<>();
        damagedBooks = new ArrayList<>();
        genres = new ArrayList<>();
        matchedGenres = new ArrayList<>();
    }

    public boolean checkBook(String book, Library library) {
        return !library.getBooks().isEmpty() && library.getBooks().contains(book);
    }

    public boolean bookBorrowing(Student student, String book) {
        this.book = book;
        this.student = student;
        int i = 0;
        do {
            if (damagedBooks.contains(book)){
                System.out.printf("The book %s was found to be damaged by previous owner: %s",book,getPreviousOwner(book));
                return false;
            }
            if (!booksBorrowing.isEmpty() && booksBorrowing.get(i).equals(student)) {
                System.out.println("This book is either already in use or not in this library");
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


    public void bookReturn(Student student) {//Todo: add traceability of students who return damaged books
        if (booksBorrowing.contains(student)) {
            previousOwners.add(student);
            booksBorrowing.remove(student);
            System.out.println("Book has been returned");
        }
    }

    public void setBookDamaged(String book) {
        damagedBooks.add(book);
    }

    public String getPreviousOwner(String book){
        for (Student student: previousOwners) {
            if (student.getBook() == book){
                return student.toString();
            }
        }
        return "book has no previous owners";
    }

    public ArrayList<String> getDamagedBooks() {
        return damagedBooks;
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


    public ArrayList genreAdder(String genre){
        genres.add(genre);
        return genres;
    }

    public boolean genreSearch(String searchedGenre){
        boolean result = false;
        for (int i = 0; i < books.size(); i++) {
            if (genres.get(i).toLowerCase() == searchedGenre.toLowerCase()) {
                matchedGenres.add(books.get(i));
                result = true;
            }
        }
        System.out.println(matchedGenres);
        return result;
    }

}