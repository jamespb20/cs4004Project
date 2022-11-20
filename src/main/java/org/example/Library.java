package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Library {

    private String book;
    private Student student;

    private ArrayList<Student> Borrowing;
    private ArrayList<String> damagedBooks;
    private ArrayList<Student> previousOwnersBooks;

    //private ArrayList<Student> previousOwnersJournals;
    private ArrayList<String> books;
    private ArrayList<String> genres;
    private ArrayList<String> matchedGenres;
    private ArrayList<Student> bannedUsers;
    private  ArrayList<Shelves> shelves;
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

    public boolean checkBook(String book, Library library) {
        return !library.getBooks().isEmpty() && library.getBooks().contains(book);
    }

    public boolean checkJournal(Journal journal,Library library){
        return !library.getJournals().isEmpty() && library.getJournals().contains(journal);
    }

    public void addJournal(Journal journal){
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

    public void bookMissing(Student student, String book){
        if (Borrowing.contains(student)){
            for (int i = 0; i < books.size(); i++) { //removes book from inventory
                if (books.get(i) == book){
                    books.remove(i);
                }
            }
            bannedUsers.add(student);
            System.out.println("You have been banned from using the library for not returning books");
        }
    }
    public String getPreviousOwner(String book){
        for (Student student: previousOwnersBooks) {
            if (student.getBook() == book){
                return student.toString();
            }
        }
        return "book has no previous owners";
    }

    public ArrayList<Student> getBanned() {
        return bannedUsers;
    }

    public void setBookDamaged(String book) {
        damagedBooks.add(book);
    }

    public ArrayList<String> getDamagedBooks() {
        return damagedBooks;
    }

    public ArrayList<Student> getBorrowing() {
        return Borrowing;
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    public ArrayList<Student> getJournalSubscriptions() {
        return journalSubscriptions;
    }

    public void getNewBook(String book) {
        books.add(book);
    }

    public ArrayList<Journal> getJournals() {
        return Journals;
    }

    public void genreAdder(String genre){
        genres.add(genre);
    }

    public boolean genreSearch(String searchedGenre){
        for (int i = 0; i < books.size(); i++) {
            if (genres.get(i) == searchedGenre) {
                matchedGenres.add(books.get(i));
            }
        }
        if (matchedGenres.size() > 0){
            return true;
        }else{
            return false;
        }
    }


    public ArrayList<Shelves> getShelves(){
        return shelves;
    }

    public void addShelftoLibrary(Shelves shelf){

        shelves.add(shelf);
    }

    public boolean journalSubscription(Student student,Journal journal){
        if (Journals.contains(journal)){
            journalSubscriptions.add(student);
            return true;
        }else {
            System.out.println("Library doesn't have this journals subscription");
            return false;
        }
    }

    public boolean cancelJournalSubscription(Student student){
        if (journalSubscriptions.contains(student)){
             journalSubscriptions.remove(student);
             return true;
        }else {
            System.out.println("This student is not subscribed to any journal subscriptions");
            return false;
        }
    }

    /*public boolean journalBorrowing(Student student, Journal journal){DON'T THINK THIS IS NEEDED
        int i = 0;
        do {
            if (!Borrowing.isEmpty() && Borrowing.get(i).equals(student)){
                System.out.println("This book is either already in use or not in this library");
                return true;
            } else if (student.getJournal() == null || student.getJournal() != journal){
                student.setJournal(journal);
                Borrowing.add(student);
                return true;
            }
            i++;
        } while (i<Borrowing.size());
        return false;
    }*/
    public boolean bookBorrowing(Student student, String book) {
        int i = 0;
        do {
            if (bannedUsers.contains(student)){
                System.out.println("You have been banned from using the library for not returning books");
                return true;
            }
            if (damagedBooks.contains(book)){
                System.out.printf("The book %s was found to be damaged by previous owner: %s",book,getPreviousOwner(book));
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
            i++;
        } while (i < Borrowing.size());
        return false;
    }

}