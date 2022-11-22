package org.example;


public class Student {//Student has name and can borrow books
    private String name;
    private Book book;

    private Journal journal;

    public Student(String name, Book book) {
        this.name = name;
        this.book = book;

    }

    public Student(String name, Journal journal){
        this.name = name;
        this.journal = journal;
    }

    public Student(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public String getName() {
        return name;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public String toString(){
        return getName() + getBook();
    }
}
