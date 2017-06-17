package creational;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by govind.bhone on 6/6/2017.
 */
/*
it is creational design pattern .factory is best way to create objects
but if sometimes object creation takes more memory and it is heavy operation
(getting db inital values ) so takes time .

so to create second object then we can fetch the data from first object to second object
to avoid lot of time consuming process .

so we do it using object cloning
 */

class Book {
    private int bookId;
    private String bookName;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


}

class BookShop implements Cloneable{
    private String shopName;
    private List<Book> books = new ArrayList<Book>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadData() {
        for (int i = 0; i < 10; i++) {
            Book b = new Book();
            b.setBookId(i);
            b.setBookName("book" + i);
            getBooks().add(b);
        }
    }

    /*
    Default clonning mechanism provides us shallow copying it means we are not creating new object
     we are actually have two references to point to same object and if change one object it affect second object

     so need to change clone method for deep clonning

     */
/*    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    @Override
    protected BookShop clone() throws CloneNotSupportedException {
        BookShop shop= new BookShop();

        for(Book b : getBooks()){
            shop.getBooks().add(b);
        }

        return shop ;
    }
}

class ProtoTypeDesignPattern {
    public static void main(String args[]) throws CloneNotSupportedException {
        BookShop bs = new BookShop();
        bs.setShopName("novelty");
        bs.loadData();

        BookShop bs1 = bs.clone();
        bs.getBooks().remove(2);
        bs1.setShopName("novelty1");
        System.out.println(bs);
        System.out.println(bs1);



    }
}
