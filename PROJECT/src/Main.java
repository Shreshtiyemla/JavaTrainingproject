import ADMIN.Admin;

import java.util.Scanner;
import ADMIN.AdminServices;
import DATABASE.Database;
import USER.UserServices;
public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------");
        System.out.println("         ***ONLINE_BOOK_STORE***            ");
        System.out.println("--------------------------------------------");
        Database d=new Database();
        boolean wantToExit = false;
        do {
            System.out.println("1.ADMIN\n2.USER \n3.EXIT");
            System.out.print("Enter Your Choice: ");
            Scanner sc = new Scanner(System.in);
            int person = sc.nextInt();
            switch (person) {
                case 1:
                    System.out.println("--------------------------------------------");
                    System.out.println("               ADMIN LOGIN                  ");
                    System.out.println("--------------------------------------------");
                    AdminServices admin = new AdminServices();
                    admin.loginAdmin();
                    break;
                case 2:
                    System.out.println("--------------------------------------------");
                    System.out.println("               USERPROCESS                  ");
                    System.out.println("--------------------------------------------");
                    UserServices user = new UserServices();
                    System.out.println("1.Register\n2.Login");
                    int choice = sc.nextInt();
                    switch(choice){
                        case 1:
                            System.out.println("--------------------------------------------");
                            System.out.println("              USER REGISTRATION             ");
                            System.out.println("--------------------------------------------");
                            user.registerUser();
                            break;
                        case 2:
                            System.out.println("--------------------------------------------");
                            System.out.println("               USER LOGIN                  ");
                            System.out.println("--------------------------------------------");
                            user.loginUser();
                            break;
                    }
                    break;
                case 3:
                    wantToExit=true;
                    break;
            }
        }while(!wantToExit);
    }
}