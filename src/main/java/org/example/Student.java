package org.example;


public class Student {//Student has name and can borrow books
    private String name;
    private String book;

    private Journal journal;

    public Student(String name, String book) {
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

    public String getBook() {
        return book;
    }

    public String getName() {
        return name;
    }

    public void setBook(String book) {
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
