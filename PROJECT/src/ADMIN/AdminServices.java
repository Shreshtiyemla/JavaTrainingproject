package ADMIN;
import DATABASE.Database;

//import java.util.ArrayList;
import java.util.*;
import Book.Book;
import USER.User;

import static DATABASE.Database.usersList;

public class AdminServices {
    public AdminServices(){

    }
    public boolean validateCredentials(String username, String password) {
        Admin admin = new Admin();
        String uname=admin.getUserName();
        String pwd=admin.getPassword();
        return uname.equals(username) && pwd.equals(password);
    }
    public void loginAdmin() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter username : ");
        String username=sc.next();
        System.out.print("Enter password : ");
        String password=sc.next();
        if (validateCredentials(username, password)) {
            System.out.println("Admin login successful.");
            System.out.println();
            boolean logout=false;
            do {
                System.out.println("1.DisplayUsersList\n2.Adding a Book\n3.View All The Books\n4.View BookDetails\n5.UpdateBookscount\n6.Delete of Books\n7.LogOut");
                System.out.print("Enter Your Choice:");
                int num = sc.nextInt();
                System.out.println();
                switch (num) {
                    case 1:
                        displayUsers();
                        break;
                    case 2:
                        addBooks();
                        break;
                    case 3:
                        ViewBooks();
                        break;
                    case 4:
                        ViewBookDetails();
                        break;
                    case 5:
                        updateBooks();
                        break;
                    case 6:
                        deleteBooks();
                        break;
                    case 7:
                        logout=true;
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            }while(!logout);
        } else{
            System.out.println("Invalid username or password.");
        }
    }
    public void displayUsers() {
        System.out.println("List of Users:");
        usersList.stream()
                .map(User::getUserName)
                .forEach(username -> System.out.println("Username: " + username));
        System.out.println();
    }
    Scanner sc = new Scanner(System.in);
    public void addBooks(){
        ArrayList<Book> books = Database.bookArrayList;
        System.out.print("Enter bookId:");
        int bookId = sc.nextInt();
        System.out.print("Enter a Book Name:");
        String bookName = sc.next();
        System.out.print("Enter Author Name:");
        String AuthorName = sc.next();
        System.out.print("EnterCategory:");
        String categoryName = sc.next();
        System.out.print("Enter price:");
        int bookPrice = sc.nextInt();
        System.out.print("Enter Count:");
        int bookCount = sc.nextInt();
        Book bk1 = new Book(bookId, bookName, AuthorName, categoryName, bookPrice, bookCount);
        books.add(bk1);
        System.out.println("Successfully Added Book");
    }
    public void ViewBooks(){
        ArrayList<Book> booksArrayList = Database.bookArrayList;
        System.out.println("View All the books");
        booksArrayList.forEach(book->{
            System.out.println("BookName :" +book.getBookName());
            System.out.println("BookId :" + book.getBookId());
            System.out.println("BookAuthor :" + book.getAuthor());
            System.out.println("Category :" +book.getCategory());
            System.out.println("Price :" +book.getPrice());
            System.out.println("Quantity :" +book.getcount());
            System.out.println();
        });
    }
    public void ViewBookDetails(){
        ArrayList<Book> books = Database.bookArrayList;
        System.out.println("Enter BookName to get the Details:");
        String name = sc.next();
        books.stream()
                .filter(book -> book.getBookName().equals(name))
                .forEach(Book::getDetails);
    }
    public void updateBooks(){
        ArrayList<Book> books = Database.bookArrayList;
        System.out.println("Enter book id you want to edit");
        int bookId = sc.nextInt();
        Book bookObj= books.stream().filter(book -> book.getBookId()==bookId).findFirst().orElse(null);
        if(bookObj!=null){
            System.out.print("Enter book name : ");
            String bookName = sc.next();
            System.out.print("Enter price : ");
            int price=sc.nextInt();
            System.out.print("Enter quantity : ");
            int quantity=sc.nextInt();
            bookObj.setBookName(bookName);
            bookObj.setPrice(price);
            bookObj.setCount(quantity);
        } else {
            System.out.println("Book id not Available");
        }
    }
    public void deleteBooks(){
        ArrayList<Book> books = Database.bookArrayList;
        System.out.print("Enter Book Name:");
        String bookName = sc.next();
        boolean foundBookName=false;
        for (Book book1 : books) {
            if(book1.getBookName().equals(bookName)){
                books.remove(book1);
                foundBookName=true;
                System.out.println("Book deleted successfully");
                break;
            }
        }
        if(!foundBookName){
            System.out.println("Book not Available. Cannot delete it");
        }
    }
}
