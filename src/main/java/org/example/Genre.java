package org.example;

import java.util.ArrayList;

public class Genre {
    private ArrayList<Book> genres;
    private String name;

    public Genre(ArrayList<Book> genres, String name) {
        this.genres = genres;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre: " + name;
    }
}
