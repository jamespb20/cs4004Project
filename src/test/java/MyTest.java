import org.example.College;
import org.example.Library;
import org.example.Student;
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
}
