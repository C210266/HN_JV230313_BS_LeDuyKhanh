package ra.business.controller;

import ra.business.model.Book;
import ra.business.service.BookService;

public class BookController {
    private BookService bookService = new BookService();

    public Book[] getAll() {
        return bookService.getAll();
    }

    public int getSize() {
        return bookService.getSize();
    }

    public boolean save(Book book) {
        return bookService.save(book);
    }

    public Book findById(int id) {
        return bookService.findById(id);
    }

    public boolean delete(int id) {
        return bookService.delete(id);
    }

    public int getNewId() {
        return bookService.getNewId();
    }
}
