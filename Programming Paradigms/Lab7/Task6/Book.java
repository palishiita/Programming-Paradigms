package Lab7.Task6;

import java.util.ArrayList;

public class Book {

    private String name;
    private ArrayList<Author> author;
    private double price;
    private int qty;

    public Book(String book_name, ArrayList<Author> book_author, double book_price) {
        name = book_name;
        author = book_author;
        price = book_price;
        qty = 0;
    }

    public Book(String book_name, ArrayList<Author> book_author, double book_price, int book_qty) {
        name = book_name;
        author = book_author;
        price = book_price;
        qty = book_qty;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Author> getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(ArrayList<Author> author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book: " + "name: " + name + ", author: " + author + ", price: " + price + ", qty:" + qty;
    }
}
