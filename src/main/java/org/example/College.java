package org.example;

import java.util.ArrayList;

public class College {
    private ArrayList<Library> libraries;

    public College() {
        libraries = new ArrayList<>();
    }

    public void addLibrary(Library library){
        libraries.add(library);
    }

    public boolean checkBook(String book, Library library){
        if (library.getBook().contains(book)){
            return true;
        }else return false;
    }
}
