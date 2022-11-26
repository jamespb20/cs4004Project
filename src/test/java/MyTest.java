import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {
    @Test
    public void testBookReservation() {//Todo: add bug report for this cause the test was wrong
        College ul = new College();
        Library library = new Library();
        ul.addLibrary(library);
        Student student1 = new Student("Craig");
        Book book1 = new Book("The Communists Manifesto","Karl Marx");
        library.getNewBook(book1);
        library.bookBorrowing(student1, book1);
        Student student2 = new Student("Kevin");
        assertTrue(library.bookBorrowing(student2, book1));

        Student student = new Student("James");
        Book book = new Book("Java 2");
        assertFalse(library.bookBorrowing(student,book));

        /*Library library2 = new Library();
        ul.addLibrary(library2);
        ul.checkBook("The Communists Manifesto",library2);
        assertFalse(ul.checkBook("The Communists Manifesto",library2));*/
    }

    @Test
    public void testUnlimited() {
        College ul = new College();
        Library library = new Library();
        ul.addLibrary(library);
        Student student1 = new Student("Craig");
        Book book1 = new Book("The Communists Manifesto","Karl Marx");
        library.getNewBook(book1);
        library.bookBorrowing(student1, book1);
        assertTrue(library.bookBorrowing(student1, book1));
    }

    @Test
    public void testOtherLibraryBookAcquisition() {
        College ul = new College();
        College lit = new College();
        Library library1 = new Library();
        Library library2 = new Library();
        ul.addLibrary(library1);
        lit.addLibrary(library2);
        ul.addColleges(lit);
        Book book1 = new Book("Introduction to Java programming","Dermot Shiners Kennedy");
        library1.getNewBook(book1);
        assertAll(() -> assertTrue(lit.getBookCollege(library2, book1)),
                () -> assertTrue(ul.checkBook(book1, lit.getLibraries())));
    }

    @Test
    public void testTraceability() {// if a student returns a damaged book they shouldn't be able to borrow another book
        //Todo: do this but for Journals in this test
        College ul = new College();
        Library library = new Library();
        ul.addLibrary(library);
        Student student1 = new Student("Craig");
        Book book1 = new Book("The Communists Manifesto","Karl Marx");
        library.getNewBook(book1);
        library.bookBorrowing(student1, book1);
        library.bookReturn(student1);
        library.setBookDamaged(book1);//Book came back damaged
        Student student2 = new Student("James");
        assertTrue(library.bookBorrowing(student2, book1));
    }

    @Test
    public void testSearch() {  // users should be able to search books by genre
        Library library = new Library();

        Genre horror = new Genre(library.getBooks(),"Horror");
        Genre kids  = new Genre(library.getBooks(),"Kids");
        Genre Scifi = new Genre(library.getBooks(),"Sci-fi");
        Genre Dystopian = new Genre(library.getBooks(),"Dystopian");
        Genre Adventure = new Genre(library.getBooks(),"Adventure");

        Book The_Shining = new Book("The Shining",horror);
        Book Diary_of_a_wimpy_kid = new Book("Diary of a Wimpy Kid",kids);
        Book It = new Book("It",horror);
        Book Nineteen_eighty_four = new Book("1984",Scifi);
        Book Fahrenheit = new Book("Fahrenheit 451",Dystopian);

        library.genreAdder(horror);
        library.genreAdder(kids);
        library.genreAdder(Scifi);
        library.genreAdder(Dystopian);
        library.genreAdder(Adventure);



        library.getNewBook(The_Shining);
        library.getNewBook(Diary_of_a_wimpy_kid);
        library.getNewBook(It);
        library.getNewBook(Nineteen_eighty_four);
        library.getNewBook(Fahrenheit);

        assertEquals(library.getBooksOfGenre(horror),The_Shining);
        assertTrue(library.genreSearch(horror));

        assertAll(() -> assertTrue(library.genreSearch(horror)),
                () -> assertTrue(library.checkGenre(The_Shining, horror)),
                () -> assertNull(library.getBooksOfGenre(Adventure)));
    }

    @Test
    public void testMissing() {
        Library library = new Library();
        Student james = new Student("James");
        Book book1 = new Book("Ninja: Get Good: My Ultimate Guide to Gaming");
        Book book2 = new Book("Official Fortnite Battle Royale Survival Guide");
        library.getNewBook(book1);
        library.getNewBook(book2);
        library.bookBorrowing(james, book1);
        library.bookMissing(james, book1);
        assertTrue(library.bookBorrowing(james, book2));
    }


    @Test
    public void testSubscriptionofJournalsofMarginalInterest() {
        Journal coolguys = new Journal("Cool guy");
        coolguys.setOtherUniAccess(true);
        coolguys.setTopic("Cool");
        //assertTrue(coolguys.cancelSubscription("Uncool"));
    }

    @Test
    public void testJournalSubscription(){
        Library library = new Library();
        Student student = new Student("Kevin");
        Student student1 = new Student("Craig");
        Journal journal1 = new Journal("Journal1",2021);
        Journal journal2 = new Journal("Journal2",2022);
        Journal journal3 = new Journal("Journal3",2023);

        library.addJournal(journal1);
        library.addJournal(journal2);

        assertAll(() -> assertTrue(library.journalSubscription(student,journal2)),
                () -> assertEquals(library.getJournalSubscriptions() != null,library.getJournalSubscriptions() != null),
                () -> assertTrue(library.cancelJournalSubscription(student)),
                () -> assertFalse(library.cancelJournalSubscription(student1)),
                () -> assertFalse(library.journalSubscription(student1,journal3)));


    }

    @Test
    public void testJournalBoundToVolumes() {
        Library library = new Library();
        Journal journal1 = new Journal("Journal1",2021);
        Journal journal2 = new Journal("Journal2",2022);
        Journal journal3 = new Journal("Journal3",2023);

        library.addJournal(journal1);
        library.addJournal(journal3);
        library.addJournal(journal2);

        System.out.println(library.getJournals().toString());

        assertTrue(library.checkJournal(journal2,library));

    }

    @Test
    public void testBookIndexes() {
        College ul = new College();
        Library library = new Library();
        Shelves cool = new Shelves("cool");
        //library.addShelftoLibrary(cool);
    }

    @Test
    public void testCollegeChecker(){
        College ul = new College();
        Library l = new Library();
        Book book1 = new Book("Self help book 73");
        Book book2 = new Book("Green eggs and ham");
        l.getNewBook(book1);
        l.getNewBook(book2);
        ul.addLibrary(l);
        assertTrue(ul.checkWhichCollege(l, book2));
    }
}
