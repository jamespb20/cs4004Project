import org.example.College;
import org.example.Library;
import org.example.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    public void testBookReservation() {
        College ul = new College();
        Library library = new Library();
        ul.addLibrary(library);
        Student student1 = new Student("Craig");
        library.bookBorrowing(student1, "The Communists Manifesto");
        library.getNewBook("The Communists Manifesto");

        College ul2 = new College();
        Library library2 = new Library();
        ul2.addLibrary(library2);
        assertFalse(ul.checkBook("The Communists Manifesto", library2));
    }

}
