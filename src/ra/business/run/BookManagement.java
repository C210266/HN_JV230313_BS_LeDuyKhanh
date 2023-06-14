package ra.business.run;

import ra.business.config.Config;
import ra.business.controller.BookController;
import ra.business.model.Book;

public class BookManagement {
    private static BookController bookController = new BookController();

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 7) {
            System.out.println("-------------Book---------------");
            System.out.println("1 . Them moi sach");
            System.out.println("2 . Thong tin tat ca sach");
            System.out.println("3 . Sap xep sach theo interest");
            System.out.println("4 . Xoa sach");
            System.out.println("5 . Tim kiem sach ");
            System.out.println("6 . Thay doi thong tin sach theo id (update)");
            System.out.println("7 .Thoat");
            choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    displayAllBook();
                    break;
                case 3:
                    SortBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    updateBook();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Nhap lai lua chon tu 1 --> 7");
            }
        }
    }

    public static void addNewBook() {
        System.out.println("Nhao so luong sach can them moi");
        int n = Config.scanner().nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sach thu : " + (i + 1));
            Book newBook = new Book();
            int bookId = bookController.getNewId();
            System.out.println("BookId la : " + bookId);
            newBook.setBookId(bookId);
            System.out.println("Nhap ten sach");
            newBook.setBookName(Config.scanner().nextLine());
            System.out.println("Nhap ten tac gia");
            newBook.setAuthor(Config.scanner().nextLine());
            System.out.println("Nhap mo ta");
            newBook.setDescrip(Config.scanner().nextLine());
            System.out.println("Nhap gia nhap vao");
            float importPrice = Config.scanner().nextFloat();
            newBook.setImportPrice(importPrice);
            System.out.println("Nhap gia xuat ra");
            float exportPrice = Config.scanner().nextFloat();
            newBook.setExportPrice(exportPrice);

//            interset
            float interest = exportPrice - importPrice;
            newBook.setInterset(interest);
            System.out.println("Loi nhuan se la : " + interest);
            bookController.save(newBook);
        }

    }

    public static void displayAllBook() {
        Book[] listBook = bookController.getAll();
        if (bookController.getSize() == 0) {
            System.out.println("Danh sach sach trong");
        } else {
            for (Book book : listBook) {
                if (book != null) {
                    System.out.println(book);
                }
            }
        }
    }

    public static void SortBook() {
        Book[] listBook = bookController.getAll();

        if (bookController.getSize() == 0) {
            System.out.println("Không có sách nào được sắp xếp theo lợi nhuận.");
        } else {
            for (int i = 0; i < listBook.length - 1; i++) {
                for (int j = i + 1; j < listBook.length; j++) {
                    if (listBook[i] != null && listBook[j] != null && listBook[i].getInterset() >= listBook[j].getInterset()) {
                        Book temp = new Book();
                        temp = listBook[i];
                        listBook[i] = listBook[j];
                        listBook[j] = temp;
                    }
                }
            }
            for (int i = 0; i < listBook.length; i++) {
                if (listBook[i] != null) {
                    System.out.println(listBook[i]);
                }
            }
            System.out.println("Sắp xếp thành công.");
        }


    }

    public static boolean deleteBook() {
        System.out.println("Nhap id book ma ban muon xoa");
        int index = Config.scanner().nextInt();
        Book[] listBook = bookController.getAll();
        for (Book book : listBook) {
            if (book != null) {
                if (book.getBookId() == index) {
                    bookController.delete(index);
                    System.out.println("Xoa thanh cong");
                    return true;
                }
            }

        }
        System.out.println("Ko co book thoa man de xoa");
        return false;

    }

    public static void updateBook() {
        System.out.println("Nhap id Book ma ban muon sua");
        int index = Config.scanner().nextInt();
        Book bookEdit = bookController.findById(index);
        if (bookEdit != null) {
            System.out.println("Nhap ten sach moi");
            bookEdit.setBookName(Config.scanner().nextLine());
            System.out.println("Nhap ten tac gia moi");
            bookEdit.setAuthor(Config.scanner().nextLine());
            System.out.println("Nhap mo ta moi");
            bookEdit.setDescrip(Config.scanner().nextLine());
            System.out.println("Nhap gia thu vao");
            float importPrice = Config.scanner().nextFloat();
            bookEdit.setImportPrice(importPrice);
            System.out.println("Nhap gia ban ra");
            float exportPrice = Config.scanner().nextFloat();
            bookEdit.setExportPrice(exportPrice);
            bookEdit.setInterset(exportPrice - importPrice);
            bookController.save(bookEdit);
        } else {
            System.out.println("Ko ton tai book ma ban muon tim kiem");
        }
    }

    public static void searchBook() {
        System.out.println("Nhập tên sách mà bạn muốn tìm kiếm:");
        String searchText = Config.scanner().nextLine();
        Book[] listBook = bookController.getAll();

        boolean found = false; // Flag to track if any matching book is found

        for (Book book : listBook) {
            if (book != null && book.getBookName().contains(searchText)) {
                System.out.println(book);
                found = true;
            }
        }

        if (found) {
            System.out.println("Tìm kiếm thành công.");
        } else {
            System.out.println("Không tìm thấy sách phù hợp với tìm kiếm của bạn.");
        }
    }

}


