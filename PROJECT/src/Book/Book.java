package Book;

import java.util.List;

public class Book {
    private int BookId;
    private String BookName;
    private String Author;
    private String Category;
    private double Price;
    private int Count;


    public int getBookId(){

        return BookId;
    }
    public void setBookId(int bookId){
        this.BookId = BookId;
    }
    public String getBookName(){

        return BookName;
    }
    public void setBookName(String bookName){
        this.BookName = BookName;
    }
    public String getAuthor(){

        return Author;
    }
    public void setAuthor(String Author){
        this.Author = Author;
    }
    public String getCategory(){
        return Category;
    }
    public void setCategory(String Category){
        this.Category = Category;
    }

    public double getPrice(){

        return Price;
    }
    public void setPrice(double Price){
        this.Price=Price;
    }
    public int getcount(){

        return Count;
    }
    public void setCount(int Count){
        this.Count = Count;
    }
    public Book(int BookId,String BookName,String Author,String Category,double Price, int Count){
        this.BookId = BookId;
        this.BookName=BookName;
        this.Author = Author;
        this.Category=Category;
        this.Price=Price;
        this.Count=Count;
    }

    public void getDetails() {
        System.out.println("BookName :" +BookName);
        System.out.println("BookId :" + BookId);
        System.out.println("BookAuthor :" + Author);
        System.out.println("Category :" +Category);
        System.out.println("Price :" +Price);
        System.out.println("Quantity :" +Count);
    }
}
