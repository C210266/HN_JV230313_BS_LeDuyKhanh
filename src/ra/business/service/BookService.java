package ra.business.service;

import ra.business.model.Book;

public class BookService {
    private Book[] listBook = new Book[100];
    private int size;

    public BookService() {
        Book book = new Book(1, "Hanh trinh cua ke nghi nhieu", "Giang", "Hayyyy", 12.5, 22.5, 10, true);
        listBook[0] = book;
        size++;
    }

    public Book[] getAll() {
        return listBook;
    }

    public int getSize() {
        return size;
    }

    public Book findById(int id) {
        for (Book book : listBook) {
            if (book != null) {
                if (book.getBookId() == id) {
                    return book;
                }
            }
        }
        return null;
    }

    public boolean save(Book book) {
        // add
        if (findById(book.getBookId()) == null) {
            if (size == listBook.length) {
                System.err.println("Danh sách sach quá số lương, vui lòng đăng kí sau");
                return false;
            } else {
                for (int i = 0; i < listBook.length; i++) {
                    if (listBook[i] == null) {
                        listBook[i] = book;
                        break;
                    }
                }
                System.out.println("Thêm mới thành công");
                size++;
                return true;
            }
        } else {
            // update
            for (int i = 0; i < listBook.length; i++) {
                if (listBook[i] != null && listBook[i].getBookId() == book.getBookId()) {
                    listBook[i] = book;
                    break;
                }
            }
            System.out.println("Cập nhật thành công");
            return true;
        }
    }

    public boolean delete(int id) {
        if (findById(id) != null) {
            for (int i = 0; i < listBook.length; i++) {
                if (listBook[i] != null && listBook[i].getBookId() == id) {
                    listBook[i] = null;
                    break;
                }
            }
            size--;
            System.out.println("Xoa thanh cong");
            return true;
        }
        System.out.println("Khong tim thay sach can xoa");
        return false;
    }

    public int getNewId() {
        int max = 0;
        for (Book book : listBook) {
            if (book != null) {
                if (book.getBookId() >= max) {
                    max = book.getBookId();
                }
            }
        }
        return max + 1;
    }
}
