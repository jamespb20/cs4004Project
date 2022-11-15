import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {
    @Test
    public void testBookReservation() {
        College ul = new College();
        Library library = new Library();
        ul.addLibrary(library);
        Student student1 = new Student("Craig");
        library.getNewBook("The Communists Manifesto");
        library.bookBorrowing(student1, "The Communists Manifesto");
        Student student2 = new Student("Kevin");
        assertFalse(library.bookBorrowing(student2, "The Communists Manifesto"));

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
        library.getNewBook("The Communists Manifesto");
        library.bookBorrowing(student1, "The Communists Manifesto");
        library.bookReturn(student1);
        assertFalse(library.bookBorrowing(student1, "The Communists Manifesto"));
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
        library1.getNewBook("Introduction to Java programming");
        assertTrue(lit.getBookCollege(library2, "Introduction to Java programming"));
    }

    @Test
    public void testTraceability(){// if a student returns a damaged book they shouldn't be able to borrow another book
        College ul = new College();
        Library library = new Library();
        ul.addLibrary(library);
        Student student1 = new Student("Craig");
        library.getNewBook("book1");
        library.bookBorrowing(student1,"book1");
        library.bookReturn(student1);
        library.setBookDamaged("book1");//Book came back damaged
        Student student2 = new Student("James");
        assertFalse(library.bookBorrowing(student2,"book1"));
    }
    @Test
    public void testSearch(){  // users should be able to search books by genre
        Library library = new Library();
        library.getNewBook("The Shining");
        library.getNewBook("Diary of a Wimpy Kid");
        library.getNewBook("It");
        library.getNewBook("1984");
        library.getNewBook("Fahrenheit 451");
        library.genreAdder("Horror");
        library.genreAdder("Kids");
        library.genreAdder("Horror");
        library.genreAdder("Sci-Fi");
        library.genreAdder("Dystopian");
        assertTrue(library.genreSearch("Horror"));
    }
    @Test
    public void testMissing(){
        Library library = new Library();
        Student james = new Student("James");
        library.getNewBook("Ninja: Get Good: My Ultimate Guide to Gaming");
        library.getNewBook("Official Fortnite Battle Royale Survival Guide");
        library.bookBorrowing(james, "Ninja: Get Good: My Ultimate Guide to Gaming");
        library.bookMissing(james, "Ninja: Get Good: My Ultimate Guide to Gaming");
        assertFalse(library.bookBorrowing(james, "Official Fortnite Battle Royale Survival Guide"));
    }


    @Test
    public void testSubscriptionofJournalsofMarginalInterest(){
        Journal coolguys = new Journal("Cool guy");
        coolguys.setOtherUniAccess(true);
        coolguys.setTopic("Cool");
        assertTrue(coolguys.cancelSubscription("Uncool"));
    }

    @Test
    public void testJournalBoundToVolumes(){
        Journal coolpeople = new Journal("Sick Guys");
        coolpeople.setJournalinVolume(true);
        assertFalse(coolpeople.searchVolumes("Sick Guys"));
    }

    @Test
    public void testBookIndexes(){
        College ul = new College();
        Library library = new Library();
        Shelves cool = new Shelves("cool");
        library.addShelftoLibrary(cool);
    }




}
