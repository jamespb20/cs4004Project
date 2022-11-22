package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Library {
    private ArrayList<Student> Borrowing;
    private ArrayList<Book> damagedBooks;
    private ArrayList<Student> previousOwnersBooks;

    //private ArrayList<Student> previousOwnersJournals;
    private ArrayList<Book> books;
    private ArrayList<Genre> genres;
    private ArrayList<Genre> matchedGenres;
    private ArrayList<Student> bannedUsers;
    private ArrayList<Shelves> shelves;
    private ArrayList<Journal> Journals;
    private ArrayList<Student> journalSubscriptions;


    public Library() {
        books = new ArrayList<>();
        Borrowing = new ArrayList<>();
        previousOwnersBooks = new ArrayList<>();
        damagedBooks = new ArrayList<>();
        genres = new ArrayList<>();
        matchedGenres = new ArrayList<>();
        bannedUsers = new ArrayList<>();
        shelves = new ArrayList<>();
        Journals = new ArrayList<>();
        journalSubscriptions = new ArrayList<>();
    }

    public boolean checkBook(Book book, Library library) {
        return !library.getBooks().isEmpty() && library.getBooks().contains(book);
    }

    public boolean checkJournal(Journal journal, Library library) {
        return !library.getJournals().isEmpty() && library.getJournals().contains(journal);
    }

    public void addJournal(Journal journal) {
        Journals.add(journal);
        Collections.sort(Journals);
    }




    /*public void journalReturn(Student student){
        if (Borrowing.contains(student)){
            previousOwnersJournals.add(student);
            Borrowing.remove(student);
            System.out.println("Journal has been returned");
        }
    }*/

    public void bookReturn(Student student) {
        if (Borrowing.contains(student)) {
            previousOwnersBooks.add(student);
            Borrowing.remove(student);
            student.setBook(null);
            System.out.println("Book has been returned");
        }
    }

    public void bookMissing(Student student, Book book) {
        if (Borrowing.contains(student)) {
            for (int i = 0; i < books.size(); i++) { //removes book from inventory
                if (books.get(i) == book) {
                    books.remove(i);
                }
            }
            bannedUsers.add(student);
            System.out.println("You have been banned from using the library for not returning books");
        }
    }

    public String getPreviousOwner(Book book) {
        for (Student student : previousOwnersBooks) {
            if (student.getBook() == book) {
                return student.toString();
            }
        }
        return "book has no previous owners";
    }

    public void setBookDamaged(Book book) {
        damagedBooks.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Student> getJournalSubscriptions() {
        return journalSubscriptions;
    }

    public void getNewBook(Book book) {
        books.add(book);
    }

    public ArrayList<Journal> getJournals() {
        return Journals;
    }

    public void genreAdder(Genre genre) {
        genres.add(genre);
    }

    public boolean genreSearch(Genre searchedGenre) {
        for (int i = 0; i < genres.size(); i++) {
            if (genres.get(i).equals(searchedGenre)) {
                matchedGenres.add(searchedGenre);
            }
        }
        return matchedGenres.size() > 0;
    }

    public boolean checkGenre(Book book, Genre genre) {
        return getBooks().contains(book) && book.getGenre().equals(genre);
    }

    public Book getBooksOfGenre(Genre genre){
        for (Book b:books){
            if (b.getGenre() == genre){
                return b;
            }
        }return null;
    }

//    public ArrayList<Genre> getMatchedGenres() {
//        return matchedGenres;
//    }
//
//    public ArrayList<Shelves> getShelves() {
//        return shelves;
//    }
//
//    public void addShelfToLibrary(Shelves shelf) {
//
//        shelves.add(shelf);
//    }

    public boolean journalSubscription(Student student, Journal journal) {
        if (Journals.contains(journal)) {
            journalSubscriptions.add(student);
            return true;
        } else {
            System.out.println("Library doesn't have this journals subscription");
            return false;
        }
    }

    public boolean cancelJournalSubscription(Student student) {
        if (journalSubscriptions.contains(student)) {
            journalSubscriptions.remove(student);
            return true;
        } else {
            System.out.println("This student is not subscribed to any journal subscriptions");
            return false;
        }
    }

    public boolean bookBorrowing(Student student, Book book) {
        int i = 0;
        do {
            if (books.contains(book)) {
                if (bannedUsers.contains(student)) {
                    System.out.println("You have been banned from using the library for not returning books");
                    return true;
                }
                if (damagedBooks.contains(book)) {
                    System.out.printf("The book %s was found to be damaged by previous owner: %s", book, getPreviousOwner(book));
                    return true;
                }
                if (!Borrowing.isEmpty() && Borrowing.get(i).equals(student)) {
                    System.out.println("This book is either already in use or not in this library");
                    return true;
                } else {
                    if (student.getBook() == null || student.getBook() != book) {
                        student.setBook(book);
                        Borrowing.add(student);
                        System.out.println("Book has been borrowed");
                        return true;
                    }
                }
            }
            i++;
        } while (i < Borrowing.size());
        return false;
    }
}