import org.example.College;
import org.example.Library;
import org.example.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MyTest {
    @Test
    public void testBookReservation(){
        College ul = new College();
        Library library = new Library();
        ul.addLibrary(library);
        Student student1 = new Student("Craig");
        library.getNewBook("The Communists Manifesto");
        library.bookBorrowing(student1,"The Communists Manifesto");
        Student student2 = new Student("Kevin");
        assertFalse( library.bookBorrowing(student2,"The Communists Manifesto"));

        /*Library library2 = new Library();
        ul.addLibrary(library2);
        ul.checkBook("The Communists Manifesto",library2);
        assertFalse(ul.checkBook("The Communists Manifesto",library2));*/
    }

    @Test
    public void testUnlimited(){
        College ul = new College();
        Library library = new Library();
        ul.addLibrary(library);
        Student student1 = new Student("Craig");
        library.getNewBook("The Communists Manifesto");
        library.bookBorrowing(student1,"The Communists Manifesto");
        library.bookReturn(student1);
        assertFalse(library.bookBorrowing(student1,"The Communists Manifesto"));
    }
}
