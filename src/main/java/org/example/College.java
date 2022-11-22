package org.example;

import java.util.ArrayList;

public class College {
    private ArrayList<Library> libraries;

    public College() {
        libraries = new ArrayList<>();
    }

    public void addLibrary(Library library) {
        libraries.add(library);
    }

    public boolean checkBook(Book book, ArrayList<Library> library) {
        for (Library lib: libraries) {
            if (!library.isEmpty() && lib.getBooks().contains(book)){
                return true;
            }
        }return false;

    }

    public void addColleges(College college) {
        //groups colleges under UWON Agreement
        //adds all libraries from passed college to Arraylist "libraries"
        //in turn gives the passed college access to the add colleges libraries
        libraries.addAll(college.getLibraries());
        college.getLibraries().addAll(libraries);
    }

    public boolean getBookCollege(Library library, Book book) {
        boolean bool = true;
        for (Library i : libraries) {
            if (library.checkBook(book, i)) {
                bool = true;
                break;
            }
            if (!library.checkBook(book, i)) {
                bool = false;

            }
        }
        return bool;
    }

    public ArrayList<Library> getLibraries() {
        return libraries;
    }
}
