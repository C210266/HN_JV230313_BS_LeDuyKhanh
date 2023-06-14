package ra.business.model;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descrip;
    private double importPrice;
    private double exportPrice;
    private float interset;
    private boolean bookStatus = true;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String descrip, double importPrice, double exportPrice, float interset, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descrip = descrip;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interset = interset;
        this.bookStatus = bookStatus;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterset() {
        return interset;
    }

    public void setInterset(float interset) {
        this.interset = interset;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", descrip='" + descrip + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interset=" + interset +
                ", bookStatus=" + bookStatus +
                '}';
    }
}
