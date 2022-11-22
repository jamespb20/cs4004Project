package org.example;

public class Book {
    private String name;
    private String author;
    private Genre genre;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, Genre genre){
        this.name = name;
        this.genre = genre;


    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book: " + name + "Genre: " + genre;
    }
}
