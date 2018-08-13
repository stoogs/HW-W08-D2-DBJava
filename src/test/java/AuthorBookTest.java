import models.Author;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AuthorBookTest {

    Author author;

    @Before
    public void before(){
        author = new Author("Stoo");
    }

    @Test
            public void getName() {
        assertEquals("Stoo", author.getName());
    }
}
