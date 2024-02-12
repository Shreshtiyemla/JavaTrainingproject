package USER;
import Book.Book;
import DATABASE.Database;
import java.util.*;
import ADMIN.Admin;
import org.w3c.dom.ls.LSOutput;

import static DATABASE.Database.bookArrayList;

public class UserServices {

    public void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER USERNAME : ");
        String username = sc.next();
        ArrayList<User> usersList = Database.usersList;
        if (!usersList.isEmpty()) {
            boolean userNameExists = usersList.stream().anyMatch(obj -> obj.getUserName().equals(username));
            if (userNameExists) {
                System.out.println("USERNAME ALREADY EXISTS!!!");
            } else {
                System.out.print("PASSWORD : ");
                String password = sc.next();
                System.out.print("Enter Phone Number:");
                int PhNo = sc.nextInt();
                User userobj = new User(username, password, PhNo);
                usersList.add(userobj);
                System.out.println("YOUR ACCOUNT CREATED SUCCESSFULLY\n");
            }
        } else {
            System.out.print("PASSWORD : ");
            String password = sc.next();
            System.out.print("Enter Phone Number:");
            int PhNo = sc.nextInt();
            User userobj = new User(username, password, PhNo);
            usersList.add(userobj);
        }
    }

    public void loginUser() {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> userArrayList = Database.usersList;
        System.out.print("Enter username : ");
            String userName = sc.next();
            boolean userNameExists = userArrayList.stream().anyMatch(obj -> (obj.getUserName()).equalsIgnoreCase(userName));
            if (userNameExists) {
                System.out.print("PASSWORD : ");
                String password = sc.next();

                User userObj = userArrayList.stream().filter(user -> user.getUserName().equals(userName) && user.getPassword().equals(password)).findFirst().orElse(null);
                if (userObj != null) {
                    System.out.println("USER login successful.");
                    boolean logout = false;
                    do {
                        System.out.println("1.BookCategory\n2.DisplayBooks\n3.CheckAvailability\n4.PlaceOrder\n5.Logout");
                        int num = sc.nextInt();
                        switch (num) {
                            case 1:
                                BookCategory();
                                break;
                            case 2:
                                DisplayBooks();
                                break;
                            case 3:
                                checkAvailabilityOfBooks();
                                break;
                            case 4:
                                PlaceTheOrder();
                                break;
                            case 5:
                                logout = true;
                                break;
                            default:
                                System.out.println("Invalid Input");
                        }
                    } while (!logout);

                }  else{
                    System.out.println("INCORRECT PASSWORD");
                }
            } else {
                System.out.println("USERNAME DOESN'T EXIST");
            }
    }
    public static void BookCategory() {
        boolean category = false;
      Scanner sc = new Scanner(System.in);
        do {
            System.out.println("ChOOSE CATEGORY:\n1.software\t2.history\t3.english\t4.science\t5.story\t6.Exit");
            Integer c = sc.nextInt();
            switch (c) {
                case 1:
                    bookArrayList.stream().filter(book -> book.getCategory().equalsIgnoreCase("software"))
                            .forEach(book->book.getDetails());
                    break;
                case 2:
                    bookArrayList.stream().filter(book -> book.getCategory().equalsIgnoreCase("history"))
                            .forEach(book->book.getDetails());
                    break;
                case 3:
                    bookArrayList.stream().filter(book -> book.getCategory().equalsIgnoreCase("english"))
                            .forEach(book->book.getDetails());
                    break;
                case 4:
                    bookArrayList.stream().filter(book -> book.getCategory().equalsIgnoreCase("science"))
                            .forEach(book->book.getDetails());
                    break;
                case 5:
                    bookArrayList.stream().filter(book -> book.getCategory().equalsIgnoreCase("story"))
                            .forEach(book->book.getDetails());
                    break;
                case 6:
                    category = true;
                    System.out.println("YOU ARE EXITED FROM CATEGORY VISE SEARCH..");
                    break;
                default:
                    System.out.println("INVALID CHOICE");

            }
        } while (!category);
    }
        public void DisplayBooks () {
            ArrayList<Book> booksArrayList = bookArrayList;
            System.out.println("View All the books");
            booksArrayList.forEach(book -> {
                System.out.println("BookName :" + book.getBookName());
                System.out.println("BookId :" + book.getBookId());
                System.out.println("BookAuthor :" + book.getAuthor());
                System.out.println("Category :" + book.getCategory());
                System.out.println("Price :" + book.getPrice());
                System.out.println("Quantity :" + book.getcount());
                System.out.println();
            });
        }
        public void checkAvailabilityOfBooks () {
           Scanner sc = new Scanner(System.in);
            System.out.println("Check if the book Exists");
            for (Book bookObj : bookArrayList) {
                System.out.println(bookObj.getBookName());
            }
            System.out.print("Enter book Name:");
            String bookname1 = sc.next();
            for (Book bookObj1 : bookArrayList) {
                if (bookObj1.getBookName().equals(bookname1)) {
                    System.out.println("Book is Present in the Cart.");
                    System.out.println("Enter the number of copies you want:");
                    int no_of_copies = sc.nextInt();
                    if (bookObj1.getcount() >= (no_of_copies)) {
                        System.out.println("Okay!! The books are available.You can Place the Order:");
                    } else {
                        System.out.println("Sorry!!! Out Of stock");
                    }
                }
            }
        }
        public void PlaceTheOrder () {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter CreditCard Details");
            System.out.print("Enter card Number : ");
            String cardNumber = sc.next();
            System.out.print("Enter expiry date : ");
            String expiryDate = sc.next();
            System.out.print("Enter CVV : ");
            int cvv = sc.nextInt();
            CreditCardDetails c = new CreditCardDetails(cardNumber,expiryDate,cvv);
            System.out.println("Your Order has been Placed Successfully");
            System.out.println("Thank You For Shopping.Please Reach us Out for any Queries in the Delivery");
        }
    }


