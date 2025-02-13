package edu.eci.cvds.tdd.library.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Class represent a Book for testing
 */
public class BookTest {

    @Test
    public void ShoudBeEqualsForConstructMethodEquals(){
        Book book1 = new Book("Harry Potter", "J.K. Rowling", "1234");
        Book book2 = new Book("Harry Potter", "J.K. Rowling", "1234");
        assertEquals(book1, book2);
    }

    @Test
    public void ShouldGetNameEquals(){
        Book book = new Book("Colombia", "Tomas", "231312");
        assertEquals(book.getTittle(), "Colombia");
    }

    @Test
    public void ShouldGetIsbnEquals(){
        Book book = new Book("Aypr", "Escuela Ing", "312321");
        assertEquals(book.getIsbn(), "312321");
    }

    @Test
    public void ShouldGetNameFalse(){
        Book book = new Book("Poob", "ECI", "4");
        assertNotEquals(book.getTittle(), "POOB");
    }

    @Test
    public void shouldReturnAuthorWhenAuthorIsNotNull() {
        Book book = new Book("Title", "Author", "1234");
        assertEquals("Author", book.getAuthor());
    }

    @Test
    public void shouldReturnEmptyStringWhenAuthorIsEmpty() {
        Book book = new Book("Title", "", "1234");
        assertEquals("", book.getAuthor());
    }

    @Test
    public void shouldReturnNullWhenAuthorIsNull() {
        Book book = new Book("Title", null, "1234");
        assertNull(book.getAuthor());
    }

    @Test
    public void equalsShouldReturnTrueForSameIsbn() {
        Book book1 = new Book("Title1", "Author1", "1234");
        Book book2 = new Book("Title2", "Author2", "1234");
        assertTrue(book1.equals(book2));
    }

    @Test
    public void equalsShouldReturnFalseForDifferentIsbn() {
        Book book1 = new Book("Title1", "Author1", "1234");
        Book book2 = new Book("Title2", "Author2", "5678");
        assertFalse(book1.equals(book2));
    }

    @Test
    public void equalsShouldReturnFalseForNullObject() {
        Book book = new Book("Title", "Author", "1234");
        assertFalse(book.equals(null));
    }

    @Test
    public void equalsShouldReturnFalseForDifferentClassObject() {
        Book book = new Book("Title", "Author", "1234");
        String notABook = "Not a Book";
        assertFalse(book.equals(notABook));
    }

    @Test
    public void equalsShouldReturnFalseWhenIsbnIsNull() {
        Book book1 = new Book("Title1", "Author1", null);
        Book book2 = new Book("Title2", "Author2", "1234");
        assertFalse(book1.equals(book2));
    }

    @Test
    public void equalsShouldReturnTrueForSameObject() {
        Book book = new Book("Title", "Author", "1234");
        assertTrue(book.equals(book));
    }
}
