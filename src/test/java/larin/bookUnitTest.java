package larin;

import allclasses.larin.Book;
import org.junit.Assert;
import org.junit.Test;

public class bookUnitTest {

    @Test
    public void borrowBook_BookIsNotBorrowed_ReturnsTrue()
    {
        Book testBook = new Book("Test", true);
        boolean expected = true;
        Assert.assertEquals(expected, testBook.borrowBook());
    }

    @Test
    public void borrowBook_BookIsBorrowed_ReturnsFalse()
    {
        Book testBook = new Book("Test", false);
        boolean expected = false;
        Assert.assertEquals(expected, testBook.borrowBook());
    }

    @Test
    public void borrowBook_BookBorrowedTwoTime_ReturnsFalse()
    {
        Book testBook = new Book("Test", true);
        boolean expected = false;
        testBook.borrowBook();
        Assert.assertEquals(expected, testBook.borrowBook());
    }

    @Test
    public void returnBook_BookIsNotReturned_ReturnsTrue()
    {
        Book testBook = new Book("Test", false);
        boolean expected = true;
        Assert.assertEquals(expected, testBook.returnBook());
    }

    @Test
    public void returnBook_BookIsReturned_ReturnsFalse()
    {
        Book testBook = new Book("Test", true);
        boolean expected = false;
        Assert.assertEquals(expected, testBook.returnBook());
    }

    @Test
    public void returnBook_BookReturnedTwoTime_ReturnsFalse()
    {
        Book testBook = new Book("Test", false);
        boolean expected = false;
        testBook.returnBook();
        Assert.assertEquals(expected, testBook.returnBook());
    }
}
