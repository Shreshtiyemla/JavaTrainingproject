package DATABASE;

import java.util.ArrayList;
import java.util.stream.Stream;

import Book.Book;
import USER.User;

public class Database {
    public static ArrayList<Book> bookArrayList = new ArrayList<Book>();
    public static  ArrayList<User> usersList=new ArrayList<>();
     public Database(){
         Book b1 = new Book(1, "FairyTales", "Ms.Shailaja", "Story", 300, 10);
         Book b2 = new Book(2, "EnglishIV", "MS Swaminathan", "English", 250, 7);
         Book b3 = new Book(3, "BioChemicals", "Bose", "Physics", 500, 3);
         Book b4 = new Book(4, "CealCode", "RobertHook", "Software", 450, 2);
         Book b5 = new Book(5, "Python", "AbdulBari", "Software", 250, 15);
         Book b6 = new Book(5, "AtomsAndMolecules", "Gangling", "Physics", 350, 5);
         bookArrayList.add(b1);
         bookArrayList.add(b2);
         bookArrayList.add(b3);
         bookArrayList.add(b4);
         bookArrayList.add(b5);
         bookArrayList.add(b6);
         User u1=new User("Shreshti","123",12345678);
         User u2=new User("Deepthi","1234",12345678);
         User u3=new User("Soumika","123",12345678);
         User u4=new User("Rishitha","123",12345678);
         User u5=new User("Prasanna","123",12345678);
         User u6=new User("Sannitha","123",12345678);
         usersList.add(u1);
         usersList.add(u2);
         usersList.add(u3);
         usersList.add(u4);
         usersList.add(u5);
         usersList.add(u6);
    }

}
