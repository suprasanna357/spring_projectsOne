package library;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    // Add Book
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

  
    public List<Book> getAllBooks() {
        return books;
    }

   
    public Book getBookById(int bookId) {

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }

        throw new BookNotFoundException(
                "Book not found with ID: " + bookId);
    }

    public Book updateAvailability(int bookId, boolean available) {

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                book.setAvailable(available);
                return book;
            }
        }

        throw new BookNotFoundException(
                "Book not found with ID: " + bookId);
    }

    public String deleteBook(int bookId) {

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                books.remove(book);
                return "Book deleted successfully";
            }
        }

        throw new BookNotFoundException(
                "Book not found with ID: " + bookId);
    }
}