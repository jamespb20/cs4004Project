package org.example;


import java.util.ArrayList;

public class  Shelves {

    private String name;
    private ArrayList<String> books;

    public Shelves(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public void addToBooks (String book){

        books.add(book);
    }

}
